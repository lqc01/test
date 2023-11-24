package dao;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import pojo.UserForm;

public interface TestDao {
	public int register(String sql, Object[] param);
	public List<UserForm> query(String sql, Object[] param,RowMapper<?> rowMapper);
    public void inMoney(String in,double money);
    public void outMoney(String out,double money);
}
