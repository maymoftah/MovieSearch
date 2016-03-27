package com.movieSearch.controller;
import com.movieSearch.model.*;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class movieSearch {
	
	@RequestMapping(value = "/searchMovies", method = RequestMethod.GET)
	public ModelAndView movieSearch(@ModelAttribute("movie") movie movie) {
		ModelAndView model = new ModelAndView();
		model.addObject("movie", movie);
		model.setViewName("Search");
		
		return model;
	}
	@RequestMapping(value="/movieByTitle", method = RequestMethod.POST)
	public ModelAndView searchByTitle (@ModelAttribute("movie") movie movie) {
		ModelAndView model = new ModelAndView();
		model.addObject("movie", movie);
		model.setViewName("movieList");
		return model;
	}
	
	
	
	
}

