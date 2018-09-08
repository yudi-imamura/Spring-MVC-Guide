package org.SpringMVC.introduction.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**@author Yudi Imamura	
 * @version 1.0
 * @since 27-08-2018
 * We can configurate used in Java file or XML file. In this case is JAVA.
 * This Class implements a servlet configuration and mapping url in this project to receive requests from application server
 * **/
public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	/**@return Configuration Class of array
	 * {@link } 
	 * this method maps a configuration class from array within a servlet
	 * **/
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{AppWebConfiguration.class};
	}

	/**@return String of array of the a url in controller class	
	 * this method maps a url within a servlet
	 * **/
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
