package com.cruds.pos.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cruds.pos.db.EstablishmentDAOHbrlmpl;
import com.cruds.pos.entity.Establishment;
import com.cruds.pos.entity.Floor;
import com.cruds.pos.entity.FloorTable;
import com.cruds.pos.entity.KOT;
import com.cruds.pos.entity.KOTItem;
import com.cruds.pos.entity.L3Menu;
import com.cruds.pos.entity.MenuMaster;
import com.cruds.pos.entity.TableSitting;
import com.cruds.pos.formbean.FloorFormBean;
import com.cruds.pos.formbean.L1FormBean;
import com.cruds.pos.formbean.L2FormBean;
import com.cruds.pos.formbean.TableFormBean;
import com.cruds.pos.service.EstablishmentService;
import com.cruds.pos.service.FloorService;
import com.cruds.pos.service.KotService;
import com.cruds.pos.service.L1MenuService;
import com.fasterxml.jackson.databind.util.JSONPObject;

@Controller
public class PosHomeController {

	@Autowired
	EstablishmentService establishmentService;

	@Autowired
	L1MenuService l1menuservice;

	@Autowired
	FloorService floorService;

	@Autowired
	KotService kotService;

	@RequestMapping(value = "/testajax", method = RequestMethod.GET)
	public ModelAndView testajax()
	{
		ModelAndView mv = new ModelAndView("testajax", "TableFormBean", new Establishment());
		Map<Long, String> estMap = establishmentService.getAllEstablishment().stream().collect(Collectors.toMap(Establishment :: getId, Establishment :: getName));
		mv.addObject("ESTABLISHMENTMAP",estMap);
		return mv;	
	}
	@RequestMapping(value = "/posfloor", method = RequestMethod.POST)
	public ModelAndView ajaxtest(@RequestParam("estid") Long estid,HttpSession session)
	{
		session.setAttribute("estid", estid);
		List<Establishment> est = floorService.getmenumastername(estid);
		for(Establishment e : est)
		{
			System.out.println(e.getMenuMaster());
			session.setAttribute("menumastername", e.getMenuMaster());
		}
		ModelAndView mv = new ModelAndView("posfloor", "FloorFormBean", new FloorFormBean());
		Map<Long, String> mmMap = floorService.getAllfloor(estid).stream().collect(Collectors.toMap(Floor :: getId, Floor :: getName));
		mv.addObject("FLOORLIST",mmMap);
		return mv;
	}
	@RequestMapping(value = "/postable", method = RequestMethod.POST)
	public ModelAndView postable(@RequestParam("floorid") Long floorid,HttpSession session)
	{
		session.setAttribute("floorid", floorid);
		ModelAndView mv = new ModelAndView("postable", "TableFormBean", new TableFormBean());
		mv.addObject("TABLELIST",floorService.getAlltable(floorid));
		return mv;
	}
	@RequestMapping(value = "/tableopen", method = RequestMethod.POST)
	public ModelAndView tableopen(HttpSession session)
	{
		Long floorid = (Long) session.getAttribute("floorid");
		ModelAndView mv = new ModelAndView("postable", "TableFormBean", new TableFormBean());
		mv.addObject("TABLELIST",floorService.getAllOpenTable(floorid));
		return mv;
	}
	@RequestMapping(value = "/tableactive", method = RequestMethod.POST)
	public ModelAndView tableactive(HttpSession session)
	{
		Long floorid = (Long) session.getAttribute("floorid");
		ModelAndView mv = new ModelAndView("postable", "TableFormBean", new TableFormBean());
		mv.addObject("TABLELIST",floorService.getAllActiveTable(floorid));
		return mv;
	}
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public ModelAndView order(HttpSession session,@RequestParam("floortableid") Long floortableid,@RequestParam("floortablestatus") String floortablestatus)
	{
		String menumastername =  session.getAttribute("menumastername").toString();
		session.setAttribute("floortableid", floortableid);
		session.setAttribute("floortablestatus", floortablestatus);
		Long menumasterId = floorService.getmenumasterid(menumastername);
		System.out.println(menumasterId);
		session.setAttribute("menumasterId", menumasterId);
		ModelAndView mv = new ModelAndView("posorder", "L1Menu", new L1FormBean());
		mv.addObject("L1MenuList",l1menuservice.getAllL1menuList(menumasterId));
		return mv;
	}

	@RequestMapping(value = "/l2menulist", method = RequestMethod.POST)
	public ModelAndView l2menulist(@RequestParam("l1menuid") Long l1menuid,HttpSession session,@RequestParam("l2menuname") String l2menuname)
	{
		System.out.println(l2menuname);
		session.setAttribute("l2menuname", l2menuname);
		Long menumasterId = (Long) session.getAttribute("menumasterId");
		session.setAttribute("l1menuid", l1menuid);
		ModelAndView mv = new ModelAndView("posorder", "L2Menu", new L2FormBean());
		mv.addObject("L1MenuList",l1menuservice.getAllL1menuList(menumasterId));
		mv.addObject("L2MenuList",l1menuservice.getAllL2menuList(l1menuid));
		System.out.println(l1menuservice.getAllL2menuList(l1menuid));
		return mv;
	}

	@RequestMapping(value = "/l3menulist", method = RequestMethod.POST)
	public ModelAndView l3menulist(@RequestParam("l2menuid") Long l2menuid,HttpSession session)
	{
		Long menumasterId = (Long) session.getAttribute("menumasterId");
		Long l1menuid = (Long) session.getAttribute("l1menuid");
		ModelAndView mv = new ModelAndView("posorder", "L2Menu", new L2FormBean());
		mv.addObject("L1MenuList",l1menuservice.getAllL1menuList(menumasterId));
		mv.addObject("L2MenuList",l1menuservice.getAllL2menuList(l1menuid));
		mv.addObject("L3MenuList",l1menuservice.getAllL3menuList(l2menuid));
		System.out.println(l1menuservice.getAllL3menuList(l2menuid));
		return mv;
	}

	@RequestMapping(value = "/datatable", method = RequestMethod.POST)
	public ModelAndView datatable(@RequestParam("datatableid") Long[] datatableid ,HttpSession session,@RequestParam("PAX") int PAX,@RequestParam("STEWARD") String STEWARD)
	{
		String floortablestatus = (String) session.getAttribute("floortablestatus");
		System.out.println(floortablestatus);
		Long estid = (Long) session.getAttribute("estid"); 
		Long floorid = (Long) session.getAttribute("floorid");
		Long floortableid = (Long) session.getAttribute("floortableid");
		List<KOTItem> listkotitem = new ArrayList<>() ;
		String l2menuname = (String) session.getAttribute("l2menuname");
		KOT kot = new KOT();
		for(int i=0;i<datatableid.length;i++){
			List<L3Menu> l3menu = l1menuservice.getL3menuListByid(datatableid[i]);
			for(L3Menu l:l3menu)
			{
				Double taxrate = l.getTax().getRate();
				l.getL2Menu().getL1Menu().getId();
				KOTItem kotitem = new KOTItem(l.getId(), l.getName(), l.getPrice(), l2menuname,taxrate);
				listkotitem.add(kotitem);
			}
		}
		System.out.println(listkotitem);
		if(floortablestatus.equals("open"))
		{
			floorService.changetorunningstatus(floortableid);
			TableSitting tablesitting = new TableSitting(estid, floorid, floortableid, PAX, STEWARD);		
			kotService.createKot(kot,tablesitting,listkotitem);
		}
//		else if(floortablestatus.equals("running"))
//		{
//			
//		}
		ModelAndView mv = new ModelAndView("postable", "TableFormBean", new TableFormBean());
		mv.addObject("TABLELIST",floorService.getAlltable(floorid));
		return mv;

	}
}
