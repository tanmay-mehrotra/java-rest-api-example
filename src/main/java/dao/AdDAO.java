package dao;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import entity.Ad;

public class AdDAO extends CommonDAO<Ad, Integer>{
	
	@Resource(name = "ad_db")
	DataSource ds;
	
	public AdDAO(){
		super(Ad.class);
	}
	
	public Ad getAdAlgorithmically(){
		NamedParameterJdbcTemplate jdbc = new NamedParameterJdbcTemplate(ds);
		String sql =
				" SELECT ad_id                  " +
				" FROM IMPRESSIONS              " +
				" WHERE id = (                  " +
				" 	SELECT impression_id        " +
				" 	FROM clicks                 " +     
				" 	GROUP BY impression_id      " +   
 				" 	HAVING COUNT(*) = (         " +
				"		SELECT COUNT(*) AS c    " + 
 				"		FROM clicks             " + 
				"		GROUP BY impression_id  " +
				"		ORDER BY c DESC         " + 
				"		LIMIT 1)                " +
				"	)                           ";
		
		Map<String,Integer> params = new HashMap<>();
		Integer adIdWithMaxClicks = jdbc.queryForObject(sql, params, Integer.class);
		return get(adIdWithMaxClicks);
	}
}