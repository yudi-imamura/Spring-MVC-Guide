package org.SpringMVC.introduction.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author Yudi Imamura
 * @version 1.0
 * @since 27-08-2018 This Class is used to deploy Spring MVC within this project
 *        and find the way in which the Controllers classes to the Servlet.
 **/

@EnableWebMvc
@ComponentScan(basePackages = { "org.SpringMVC.introduction.controllers" })
public class AppWebConfiguration {

	/**
	 * @return InternarlResourceViewResolver object this object have a path of the
	 *         views to find them.
	 **/
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

}
