package com.movieSearch.controller;
import com.movieSearch.model.*;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


public class movieSearch implements Controller {
	
	private MovieInterface movie;
	
	public void setMovie (MovieInterface movie) {
		this.movie = movie;	
	}
	
	@RequestMapping("/index.html")
    public String handlesearchMovie() {
        return "test"; // forward to view test.jsp
    }
	
	@SuppressWarnings("unchecked")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String keyword = request.getParameter("keyword");
		if (keyword != null) {
			if (!StringUtils.hasLength(keyword)) {
				return new ModelAndView("Error", "message", "Please enter a keyword to search for, then press the search button.");
			}
			
			@SuppressWarnings("rawtypes")
			PagedListHolder movieList = new PagedListHolder(this.movie.searchMovieList(keyword.toLowerCase()));
			movieList.setPageSize(4);
			request.getSession().setAttribute("movieSearch_movies", movieList);
			return new ModelAndView("SearchMovies", "movieList", movieList);
		}
		
		else {
			String page = request.getParameter("page");
			PagedListHolder movieList = (PagedListHolder)request.getSession().getAttribute("movieSearch_movies");
			return new ModelAndView ("SearchMovies", "movieList",movieList);
		}
		
	}
	
}

