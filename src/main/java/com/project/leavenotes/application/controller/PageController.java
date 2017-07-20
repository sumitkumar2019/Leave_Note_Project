package com.project.leavenotes.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    String home() {
        return "index";
    }
	@RequestMapping(value = "/partials/{page}", method = RequestMethod.GET)
    String partialHandler(@PathVariable("page") final String page) {
        return page;
    }

}
