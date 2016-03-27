package com.movieSearch.dao;

import java.util.List;
import com.movieSearch.model.movie;

import org.springframework.dao.DataAccessException;

public interface MovieDao {
	List getMovieListByTitle(String title) throws DataAccessException;
	
	List searchMovie (String keyword) throws DataAccessException;
	
	movie getMovie (String title) throws DataAccessException;
}
