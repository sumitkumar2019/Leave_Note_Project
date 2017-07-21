package com.project.leavenotes.application;
import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sumit
 * 
 *         Configured H2 In memory Database and registered console for
 *         connecting to H2 database
 */
@Configuration
public class WebConfiguration {
   
	// H2 In-memory database configured
	@Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}
