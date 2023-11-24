package service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import dao.TestDao;
import pojo.UserForm;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	public TestDao testDao;
	String out;

	public boolean login(UserForm user) {
		String loginSql = "select * from userm where uname=? and upass=?";
		Object param0[] = { user.getUname(), user.getUpass() };
		out = user.getUname();
		List<UserForm> list = testDao.query(loginSql, param0, null);
		if (list.size() == 0)
			return false;
		return true;
	}

	@Override
	public boolean register(UserForm user) {
		String loginSql = "insert into userm values(null,?,?,?,?)";
		Object param[] = { user.getUname(), user.getUpass(), user.getReupass(), user.getMoney() };
		int i = testDao.register(loginSql, param);
		if (i > 0)
			return true;
		return false;
	}

	@Override
	public boolean transfer(UserForm user) {
		try {
			String in = user.getUname();
			Double money = Double.valueOf(user.getMoney());
			testDao.inMoney(in, money);
			testDao.outMoney(out, money);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}
}
