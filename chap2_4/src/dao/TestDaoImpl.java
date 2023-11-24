package dao;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pojo.UserForm;
import service.UserServiceImpl;

@Repository
public class TestDaoImpl implements TestDao {
	 @Autowired
	//浣跨敤閰嶇疆绫讳腑鐨凧DBC妯℃澘
	private JdbcTemplate jdbcTemplate;
    /**
	 * 鏇存柊鏂规硶锛屽寘鎷坊鍔犮�佷慨鏀广�佸垹闄�
	 * param涓簊ql涓殑鍙傛暟锛屽閫氶厤绗�?
	 */
	@Override
	public int register(String sql, Object[] param) {
		return jdbcTemplate.update(sql, param);  
	}

	@Override
	public List<UserForm> query(String sql, Object[] param, RowMapper<?> rowMapper) {
		// TODO Auto-generated method stub
		RowMapper<UserForm> rowMapper1 = new BeanPropertyRowMapper<UserForm>(UserForm.class);
		return jdbcTemplate.query(sql, param,rowMapper1);
	}

	@Override
	public void inMoney(String in,double money)throws EmptyResultDataAccessException {
		// TODO Auto-generated method stub
		String sql = "update  userm set money=? where uname=?";
		String sql1="select money from userm where uname=?";
		Double currentMoney = jdbcTemplate.queryForObject(sql1, Double.class, in);
		jdbcTemplate.update(sql, currentMoney + money, in);
	}

	@Override
	public void outMoney(String out,double money)throws EmptyResultDataAccessException {
		// TODO Auto-generated method stub
		String sql = "update  userm set money=? where uname=?";
		String sql1="select money from userm where uname=?";
		Double currentMoney = jdbcTemplate.queryForObject(sql1, Double.class, out);
		jdbcTemplate.update(sql, currentMoney - money, out);
	}

	
}
