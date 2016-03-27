package com.movieSearch.dao;

import java.util.List;
import com.movieSearch.model.movie;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MovieDao {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public MovieDao() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		
	}
	
	@SupressWarnings("unchecked")
	
	public movie searchMovie(movie movie) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			movie = (movie)session.selectOne("movie.getAll", movie);
			return movie;
		}
		finally {
			session.close();
		}
	}
}