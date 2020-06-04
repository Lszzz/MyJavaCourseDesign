package vehicleleasing.model;

/**
 * @author lszzz
 * @create 2020/5/31
 */
public class Client {
	private int id;
	private String name;
	private String gender;
	private int age;
	private long phone;
	public Client() {

	}
	public Client(int id, String name, String gender, int age, long phone) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public int getAge() {
		return age;
	}
	public long getPhone() {
		return phone;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
}
