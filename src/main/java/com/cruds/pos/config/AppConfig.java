package com.cruds.pos.config;



import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.cruds.pos.entity.Bill;
import com.cruds.pos.entity.BillItem;
import com.cruds.pos.entity.BillTax;
import com.cruds.pos.entity.FormBeanTax;
import com.cruds.pos.entity.KOT;
import com.cruds.pos.entity.KOTItem;
import com.cruds.pos.entity.L1Menu;
import com.cruds.pos.entity.L2Menu;
import com.cruds.pos.entity.L3Menu;
import com.cruds.pos.entity.MenuMaster;
import com.cruds.pos.entity.Payment;
import com.cruds.pos.entity.TableSitting;
import com.cruds.pos.entity.Tax;
import com.cruds.pos.entity.User;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.cruds.pos.*")
public class AppConfig extends WebMvcConfigurerAdapter{
	
	
    @Bean
    public DataSource getDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/posdemo");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());
        Properties properties = new Properties();
        properties.put("hibernate.show_sql","true");
        properties.put("hibernate.hbm2ddl.auto","update");
        factoryBean.setPackagesToScan("com.cruds.pos.entity");
        factoryBean.setHibernateProperties(properties);
        factoryBean.setAnnotatedClasses(User.class);
        factoryBean.setAnnotatedClasses(Tax.class);
        factoryBean.setAnnotatedClasses(FormBeanTax.class);
        factoryBean.setAnnotatedClasses(MenuMaster.class);
        factoryBean.setAnnotatedClasses(L1Menu.class);
        factoryBean.setAnnotatedClasses(L2Menu.class);
        factoryBean.setAnnotatedClasses(L3Menu.class);
        factoryBean.setAnnotatedClasses(Bill.class);
        factoryBean.setAnnotatedClasses(BillItem.class);
        factoryBean.setAnnotatedClasses(BillTax.class);
        factoryBean.setAnnotatedClasses(KOT.class);
        factoryBean.setAnnotatedClasses(KOTItem.class);
        factoryBean.setAnnotatedClasses(TableSitting.class);
        factoryBean.setAnnotatedClasses(Payment.class);
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }	

	/**
     * Configure TilesConfigurer.
     */
    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/views/**/tiles.xml"});
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }
    
  
    
	@Bean
	public ThreadPoolTaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
		pool.setCorePoolSize(1);
		pool.setMaxPoolSize(1);
		pool.setWaitForTasksToCompleteOnShutdown(true);
		return pool;
	}	
	
    /**
     * Configure ViewResolvers to deliver preferred views.
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
    }
     
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver=new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        resolver.setMaxUploadSize(10240000); //10 MB
        return resolver;
    }     
    
    /**
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
     
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }	
	
	
}
