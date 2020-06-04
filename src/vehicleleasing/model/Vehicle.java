package vehicleleasing.model;

/**
 * @author lszzz
 * @create 2020/5/28
 */
public class Vehicle {
	private String number;
	private String type;
	private int price_daily;
	private boolean status;
	public Vehicle() {

	}
	public Vehicle(String number,String type,int price_daily,boolean status) {
		this.number=number;
		this.type=type;
		this.price_daily=price_daily;
		this.status=status;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice_daily() {
		return price_daily;
	}
	public void setPrice_daily(int price_daily) {
		this.price_daily = price_daily;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean getStatus()
	{
		return status;
	}

}
