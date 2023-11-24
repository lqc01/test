package service;
import pojo.UserForm;
public interface UserService {
	boolean login(UserForm user);
	boolean register(UserForm user);
	public boolean transfer(UserForm user);
}
