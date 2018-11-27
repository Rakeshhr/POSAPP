package com.cruds.pos.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cruds.pos.entity.Establishment;
import com.cruds.pos.entity.Floor;
import com.cruds.pos.entity.FloorTable;
import com.cruds.pos.entity.L1Menu;
import com.cruds.pos.entity.L2Menu;
import com.cruds.pos.entity.MenuMaster;
import com.cruds.pos.entity.Tax;
import com.cruds.pos.entity.User;
import com.cruds.pos.formbean.EstablishFormBean;
import com.cruds.pos.formbean.FloorFormBean;

import com.cruds.pos.formbean.L1FormBean;
import com.cruds.pos.formbean.L2FormBean;
import com.cruds.pos.formbean.TableFormBean;
import com.cruds.pos.service.EstablishmentService;
import com.cruds.pos.service.FloorService;
import com.cruds.pos.formbean.L3FormBean;

import com.cruds.pos.service.L1MenuService;
import com.cruds.pos.service.MenuMasterService;
import com.cruds.pos.service.TaxService;
import com.cruds.pos.service.UserService;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;



@Controller
public class HomeController {
	@Autowired
	FloorService floorService;
	
	@Autowired
	EstablishmentService establishmentService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	TaxService taxService;
	
	@Autowired
	MenuMasterService menuMasterService;
	
	@Autowired
	L1MenuService l1menuservice;

	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public ModelAndView showStudentForm()
	{
		ModelAndView mv = new ModelAndView("users", "user", new User());
		mv.addObject("USERLIST", userService.getAllUser());
		return mv;		
	}
	
	@RequestMapping(value="/createuser", method = RequestMethod.POST)
	public String createUserPage(@ModelAttribute("user") User user)
	{
		userService.create(user);
		return "redirect:home.html";
	}
	
	@RequestMapping(value="/taxes", method=RequestMethod.GET)
	public ModelAndView addTaxesget()
	{
		ModelAndView mv = new ModelAndView("taxes", "taxes", new Tax());
		mv.addObject("TAXLIST", taxService.getAllActiveTax());
		return mv;		
	}
	
	@RequestMapping(value="/taxes", method=RequestMethod.POST)
	public ModelAndView addTaxespost(@RequestParam("form_check") String check)
	{
		ModelAndView mv = new ModelAndView("taxes", "taxes", new Tax());
		System.out.println(check);
	    if(check.equals("checked"))
		{
			mv.addObject("TAXLIST", taxService.getAllTax1());	
		}
	    else if(check.equals("unchecked"))
		{
			mv.addObject("TAXLIST", taxService.getAllActiveTax());	
		}
		return mv;		
	}
	
	@RequestMapping(value="/addTax", method = RequestMethod.POST)
	public String addTaxespost(@RequestParam("taxname") String taxname,@RequestParam("taxrate") Double taxrate )
	{
		LocalDate startDate = LocalDate.now();	
		Tax tax=new Tax(taxname,taxrate,startDate);
		taxService.addTax(tax);
		return "redirect:home.html";
	}
	
	@RequestMapping(value="/inactive", method=RequestMethod.POST)
	public String inactive(@RequestParam("form_id") int id)
	{
		System.out.println(id);
		LocalDate endDate = LocalDate.now();	
		taxService.setInactive(id, endDate);
		return "redirect:taxes.html";
	}
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET) 
	public String menuget() {  
	    return "menu"; 
	}
	
	@RequestMapping(value="/menu", method=RequestMethod.POST)
	public String menupost(@RequestParam("Add Menu Master") String menumaster)
	{
		if(menumaster.equals("Add Menu Master"))
		{
		return "menumaster";
		}
		else
		{
		return "menu";
		}
	}
	
	@RequestMapping(value="/menumaster", method=RequestMethod.GET)
	public ModelAndView menumasterget()
	{
		ModelAndView mv = new ModelAndView("menumaster", "menumaster", new MenuMaster());
		mv.addObject("MENUMASTERLIST",menuMasterService.getAllMenu());
		return mv;		
	}
	
	@RequestMapping(value="/menumaster", method=RequestMethod.POST)
	public String menumasterpost(@RequestParam("menumaster") String menumaster)
	{
	
		MenuMaster menu = new MenuMaster(menumaster);
		menuMasterService.createmenumaster(menu);
		return "redirect:menumaster.html";
		
	}
	@RequestMapping(value="/l1menu", method=RequestMethod.GET)
	public ModelAndView l1menuget()
	{	
			ModelAndView mv = new ModelAndView("l1menu", "l1FormBean", new L1FormBean());
		    Map<Long, String> mmMap = menuMasterService.getAllMenu().stream().collect(Collectors.toMap(MenuMaster :: getId, MenuMaster :: getName));
			
			mv.addObject("MENUMASTERMAP",mmMap);
			
		    Map<Long, String> taxMap = taxService.getAllTaxList().stream().collect(Collectors.toMap(Tax :: getId, Tax :: getName));

			mv.addObject("TAXMAP",taxMap);
			
			return mv;
		  
	}
	@RequestMapping(value="/l1menupost", method=RequestMethod.POST)
	public ModelAndView l1menuhelper(@RequestParam("mmId") Long mmId,HttpSession session,RedirectAttributes redirectAttributes)
	{
		System.out.println(mmId);
		session.setAttribute("mmId", mmId);
		ModelAndView mv = new ModelAndView("l1menu", "l1FormBean", new L1FormBean());
		mv.addObject("L1MENULIST", l1menuservice.getAllL1menulist(mmId));
		Map<Long, String> mmMap = menuMasterService.getAllMenu().stream().collect(Collectors.toMap(MenuMaster :: getId, MenuMaster :: getName));
		mv.addObject("MENUMASTERMAP",mmMap);
		Map<Long, String> taxMap = taxService.getAllTaxList().stream().collect(Collectors.toMap(Tax :: getId, Tax :: getName));
		mv.addObject("TAXMAP",taxMap);
		return mv;
	}
	@RequestMapping(value="/l1menu", method=RequestMethod.POST)
	public String l1menupost(@ModelAttribute("l1FormBean") L1FormBean l1FormBean,HttpSession session)
	{
		Long mmId = (Long) session.getAttribute("mmId");
		l1menuservice.createL1menu(l1FormBean,mmId);
		session.removeAttribute("mmId");
		return "redirect:l1menu.html";	
	}
	
	@RequestMapping(value="/l2menu", method=RequestMethod.GET)
	public ModelAndView l2menuget()
	{	
			ModelAndView mv = new ModelAndView("l2menu", "l2FormBean", new L2FormBean());
		    Map<Long, String> mmMap = menuMasterService.getAllMenu().stream().collect(Collectors.toMap(MenuMaster :: getId, MenuMaster :: getName));
			
			mv.addObject("MENUMASTERMAP",mmMap);
			
		    Map<Long, String> taxMap = taxService.getAllTaxList().stream().collect(Collectors.toMap(Tax :: getId, Tax :: getName));

			mv.addObject("TAXMAP",taxMap);
	
			return mv;
		
	}
	@RequestMapping(value="/l2menuhelper", method=RequestMethod.POST)
	public String l2menuhelper(@RequestParam("btnLink1") Long l1menuid,HttpSession session,RedirectAttributes redirectAttributes)
	{
		System.out.println(l1menuid);
		session.setAttribute("l1menuid", l1menuid);
		redirectAttributes.addFlashAttribute("L2MENULIST", l1menuservice.getAllL2menuList(l1menuid));
		return "redirect:l2menu.html";
	}
	@RequestMapping(value="/l2menupost", method=RequestMethod.POST)
	public ModelAndView l2menuhandler(@RequestParam("mmId") Long mmid)
	{
		ModelAndView mv = new ModelAndView("l2menu", "l2FormBean", new L2FormBean());
		Map<Long, String> l1menumap = l1menuservice.getAllL1menuList(mmid).stream().collect(Collectors.toMap(L1Menu :: getId, L1Menu :: getName));
		//System.out.println(id);
		mv.addObject("L1MENULIST", l1menumap);
		Map<Long, String> mmMap = menuMasterService.getAllMenu().stream().collect(Collectors.toMap(MenuMaster :: getId, MenuMaster :: getName));
		
		mv.addObject("MENUMASTERMAP",mmMap);
		
	    Map<Long, String> taxMap = taxService.getAllTaxList().stream().collect(Collectors.toMap(Tax :: getId, Tax :: getName));

		mv.addObject("TAXMAP",taxMap);
		return mv;
	}
	@RequestMapping(value="/l2menu", method=RequestMethod.POST)
	public ModelAndView l2menupost(@ModelAttribute("l2FormBean") L2FormBean l2FormBean,HttpSession session)
	{
		System.out.println(l2FormBean);
		Long l1menuid = (Long) session.getAttribute("l1menuid");
		l1menuservice.createl2menu(l2FormBean,l1menuid);	
		ModelAndView mv = new ModelAndView("l2menu", "l2FormBean", new L2FormBean());
		Map<Long, String> mmMap = menuMasterService.getAllMenu().stream().collect(Collectors.toMap(MenuMaster :: getId, MenuMaster :: getName));		
		mv.addObject("MENUMASTERMAP",mmMap);
		mv.addObject("L2MENULIST", l1menuservice.getAllL2menuList(l1menuid));
		return mv;		
	}
	
	@RequestMapping(value="/establishment", method=RequestMethod.GET)
	public ModelAndView cretaeEstablish()
	{	
			ModelAndView mv = new ModelAndView("establishment", "EstablishFormBean", new EstablishFormBean());
		    Map<Long, String> mmMap = menuMasterService.getAllMenu().stream().collect(Collectors.toMap(MenuMaster :: getId, MenuMaster :: getName));	
			mv.addObject("MENUMASTERMAP",mmMap);
			return mv;
	}
	
	@RequestMapping(value="/establishment", method=RequestMethod.POST)
	public String establishmentupost(@ModelAttribute("EstablishFormBean") EstablishFormBean establishFormBean)
	{
		//System.out.println(l1FormBean.getMmId());
		//System.out.println(l1FormBean.getTaxId());
		//System.out.println(l1FormBean.getL1MenuName());
		//MenuMaster menu=new MenuMaster(menumaster);
		establishmentService.createEstablishment(establishFormBean.getName(), establishFormBean.getmId());
		return "redirect:establishment.html";
		
		
	}

	
	@RequestMapping(value="/floor", method=RequestMethod.GET)
	public ModelAndView cretaeFloor()
	{	
			ModelAndView mv = new ModelAndView("floor", "FloorFormBean", new FloorFormBean());
		    Map<Long, String> estMap = establishmentService.getAllEstablishment().stream().collect(Collectors.toMap(Establishment :: getId, Establishment :: getName));	
			mv.addObject("ESTABLISHMENTMAP",estMap);
			//mv.addObject("FLOORLIST", floorService.getAllfloor());
			return mv;
	}
	
	@RequestMapping(value="/floor", method=RequestMethod.POST)
	public String postfloor(@ModelAttribute("FloorFormBean") FloorFormBean floorFormBean)
	{
		//System.out.println(floorFormBean.getName());
		//System.out.println(floorFormBean.getEstId());
		//System.out.println(l1FormBean.getL1MenuName());
		//MenuMaster menu=new MenuMaster(menumaster);
		floorService.createFloor(floorFormBean.getName(),floorFormBean.getEstId());
		return "redirect:floor.html";
		
	}
	
	/*@RequestMapping(value="/table", method=RequestMethod.GET)
	public ModelAndView cretaetable()
	{	
			ModelAndView mv = new ModelAndView("table", "TableFormBean", new TableFormBean());
			
		    Map<Long, String> estMap = establishmentService.getAllEstablishment().stream().collect(Collectors.toMap(Establishment :: getId, Establishment :: getName));	
			mv.addObject("ESTABLISHMENTMAP",estMap);
			 Map<Long, String> mmMap = floorService.getAllfloor().stream().collect(Collectors.toMap(Floor :: getId, Floor :: getName));	
			mv.addObject("FLOORLIST",mmMap);
			mv.addObject("FLOORLIST", floorService.getAllfloor());
			return mv;
	}*/
	
	
	@RequestMapping(value="/l3menu", method=RequestMethod.GET)
	public ModelAndView l3menuget()
	{	
			ModelAndView mv = new ModelAndView("l3menu", "l3FormBean", new L3FormBean());
		    Map<Long, String> mmMap = menuMasterService.getAllMenu().stream().collect(Collectors.toMap(MenuMaster :: getId, MenuMaster :: getName));		
			mv.addObject("MENUMASTERMAP",mmMap);
			mv.addObject("L3MENULIST", l1menuservice.getAllL3menuList());
			return mv;
		
	}
	@RequestMapping(value="/l3menupost1", method=RequestMethod.POST)
	public ModelAndView l3menuhandler1(@RequestParam("mmId") Long mmid)
	{
		ModelAndView mv = new ModelAndView("l3menu", "l3FormBean", new L3FormBean());
		Map<Long, String> l1menumap = l1menuservice.getAllL1menuList(mmid).stream().collect(Collectors.toMap(L1Menu :: getId, L1Menu :: getName));
		System.out.println(mmid);
		mv.addObject("L1MENULIST",l1menumap );
		Map<Long, String> mmMap = menuMasterService.getAllMenu().stream().collect(Collectors.toMap(MenuMaster :: getId, MenuMaster :: getName));
		
		mv.addObject("MENUMASTERMAP",mmMap);
		
	    Map<Long, String> taxMap = taxService.getAllTaxList().stream().collect(Collectors.toMap(Tax :: getId, Tax :: getName));

		mv.addObject("TAXMAP",taxMap);
		return mv;
	}
	
	@RequestMapping(value="/l3menupost2", method=RequestMethod.POST)
	public ModelAndView l3menuhandler2(@RequestParam("l1mmId") Long l1mmid)
	{
		System.out.println(l1mmid);
		ModelAndView mv = new ModelAndView("l3menu", "l3FormBean", new L3FormBean());
		Map<Long, String> l2menumap = l1menuservice.getAllL2menuList(l1mmid).stream().collect(Collectors.toMap(L2Menu :: getId, L2Menu :: getName));
		
		mv.addObject("L2MENULIST",l2menumap );
		
		Map<Long, String> mmMap = menuMasterService.getAllMenu().stream().collect(Collectors.toMap(MenuMaster :: getId, MenuMaster :: getName));
		
		mv.addObject("MENUMASTERMAP",mmMap);
		
	    Map<Long, String> taxMap = taxService.getAllTaxList().stream().collect(Collectors.toMap(Tax :: getId, Tax :: getName));

		mv.addObject("TAXMAP",taxMap);
		return mv;
	}
	@RequestMapping(value="/l3menupost3", method=RequestMethod.POST)
	public ModelAndView l3menuhandler3(@RequestParam("l2mmId") Long l2mmid,HttpSession session)
	{
		session.setAttribute("l2mmId", l2mmid);
		ModelAndView mv = new ModelAndView("l3menu", "l3FormBean", new L3FormBean());
		Map<Long, String> l2menumap = l1menuservice.getAllL2menuList(l2mmid).stream().collect(Collectors.toMap(L2Menu :: getId, L2Menu :: getName));		
		mv.addObject("L2MENULIST",l2menumap );
		Map<Long, String> mmMap = menuMasterService.getAllMenu().stream().collect(Collectors.toMap(MenuMaster :: getId, MenuMaster :: getName));
		
		mv.addObject("MENUMASTERMAP",mmMap);
		
	    Map<Long, String> taxMap = taxService.getAllTaxList().stream().collect(Collectors.toMap(Tax :: getId, Tax :: getName));

		mv.addObject("TAXMAP",taxMap);
		return mv;
	}
	@RequestMapping(value="/l3menu", method=RequestMethod.POST)
	public ModelAndView l3menupost(@ModelAttribute("l3FormBean") L3FormBean l3FormBean,HttpSession session)
	{
		Long l2mmid = (Long) session.getAttribute("l2mmId");
		l1menuservice.createl3menu(l3FormBean,l2mmid);
		ModelAndView mv = new ModelAndView("l3menu", "l3FormBean", new L3FormBean());
		Map<Long, String> mmMap = menuMasterService.getAllMenu().stream().collect(Collectors.toMap(MenuMaster :: getId, MenuMaster :: getName));		
		mv.addObject("MENUMASTERMAP",mmMap);
		return mv;
		
		
	}
	
	
	
	@RequestMapping(value="/table", method=RequestMethod.GET)
	public ModelAndView createtableget()
	{	
			ModelAndView mv = new ModelAndView("table", "TableFormBean", new TableFormBean());
		    Map<Long, String> estMap = establishmentService.getAllEstablishment().stream().collect(Collectors.toMap(Establishment :: getId, Establishment :: getName));
			
			mv.addObject("ESTABLISHMENTMAP",estMap);
		   
			return mv;
		
	}
	
	@RequestMapping(value="/tablepost", method=RequestMethod.POST)
	public ModelAndView tablehandler(@RequestParam("mId") Long mId)
	{
		
		System.out.println(mId);
		ModelAndView mv = new ModelAndView("table", "TableFormBean", new TableFormBean());
		Map<Long, String> floormap = floorService.getAllfloor(mId).stream().collect(Collectors.toMap(Floor :: getId, Floor :: getName));
		System.out.println(mId);
		mv.addObject("FLOORLIST",floormap );
		
		return mv;
	}
	
	@RequestMapping(value="/table", method=RequestMethod.POST)
	public ModelAndView tablepost(@ModelAttribute("TableFormBean") TableFormBean tableFormBean)
	{
		System.out.println(tableFormBean.getMaxNo());
		System.out.println(tableFormBean.getTableName());
		System.out.println(tableFormBean.getTableId());
		
    floorService.createFloorTable(tableFormBean.getTableName(), tableFormBean.getTableId(), tableFormBean.getMaxNo());
		
    ModelAndView mv = new ModelAndView("table", "TableFormBean", new TableFormBean());
	
	

		
		return  mv;
		
	}
	
	
}
