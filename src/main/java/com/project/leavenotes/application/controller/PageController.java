package com.project.leavenotes.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author sumit
 * 
 *         Configured Page Controller for Initial Page Display
 */

@Controller
public class PageController {
	
	// ------------------- Display root page -----------------------------------------
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    String home() {
        return "index";
    }
	
	// ------------------- Display page as per html page names -----------------------------------------

	@RequestMapping(value = "/partials/{page}", method = RequestMethod.GET)
    String partialHandler(@PathVariable("page") final String page) {
        return page;
    }

}
