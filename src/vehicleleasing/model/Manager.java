package vehicleleasing.model;

/**
 * @author lszzz
 * @create 2020/5/28
 */
public class Manager {
	private String username;
	private String password;
	public Manager() {}
	public Manager(String username,String password) {
		this.username=username;
		this.password=password;
	}
	public void setUsername(String username) {
		this.username=username;
	}
	public String getUsername() {
		return username;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getPassword() {
		return password;
	}

}