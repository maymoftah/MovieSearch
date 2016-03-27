package com.movieSearch.model;

import java.util.List;

public interface MovieInterface {

	movie getMovie(String title);
	movie getMovie1(String genre, String title);
	List searchMovieList(String keywords);
	List getMovieList();
}
