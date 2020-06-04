package vehicleleasing.model;

import java.util.Date;

/**
 * @author lszzz
 * @create 2020/5/28
 */
public class Order{
	private int id;
	private String number;
	private Date start;
	private Date end;
	public Order() {}
	public Order(int id,String number,Date start,Date end) {
		this.id=id;
		this.number=number;
		this.start=start;
		this.end=end;
	}
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setNumber(String number) {
		this.number=number;
	}
	public String getNumber() {
		return number;
	}
	public void setStart(Date start) {
		this.start=start;
	}
	public Date getStart() {
		return start;
	}
	public void setEnd(Date end) {
		this.end=end;
	}
	public Date getEnd() {
		return end;
	}
}

