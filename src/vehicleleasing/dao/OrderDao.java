package vehicleleasing.dao;

import vehicleleasing.dbutil.Conn;
import vehicleleasing.model.Client;
import vehicleleasing.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author lszzz
 * @create 2020/5/31
 */
public class OrderDao {
	private Connection con;
	public OrderDao() {}
	//按车牌号查找租车信息
	public ResultSet selectAllByNumber(String number) {
		PreparedStatement pst=null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con= Conn.getConnection();
			String sql="select s1.id,s1.name,s1.phone,s2.number"
					+ ",s2.start_date,"
					+ "s2.end_time from client as s1,orders as s2,"
					+ "vehicle as s3 where s1.id=s2.id and s2.number=? and s2.number=s3.number";
			pst=con.prepareStatement(sql);
			pst.setString(1,number);
			rs=pst.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	//按ID查找租车信息
	public ResultSet selectAllById(int id) {
		PreparedStatement pst=null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con=Conn.getConnection();
			String sql="select s1.id,s1.name,s1.phone,s2.number"
					+ ",s2.start_date,"
					+ "s2.end_time from client as s1,orders as s2,"
					+ "vehicle as s3 where s1.id=s2.id and s1.id=? and s2.number=s3.number";
			pst=con.prepareStatement(sql);
			pst.setInt(1,id);
			rs=pst.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	//按车牌号查找租车信息
	public Order selectByNumber(String number) {
		Order order=null;
		PreparedStatement pst=null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con=Conn.getConnection();
			String sql="select * from orders where number=?";
			pst=con.prepareStatement(sql);
			pst.setString(1,number);
			rs=pst.executeQuery();
			if(rs==null)
			{
				return null;
			}
			if(rs.next()) {
				int id=rs.getInt("id");
				String onumber=rs.getString("number");
				System.out.println(onumber+"12312");
				Date start=new java.util.Date(rs.getDate("start_date").getTime());
				Date end=null;
				order=new Order(id,onumber,start,end);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return order;
	}
	//按ID查找租车信息
	public List<Order> selectById(int id) {
		List<Order> orderList=new ArrayList<Order>();
		PreparedStatement pst=null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con=Conn.getConnection();
			String sql="select * from orders where id=?";
			pst=con.prepareStatement(sql);
			pst.setInt(1,id);
			rs=pst.executeQuery();
			while(rs.next()) {
				int cid=rs.getInt("id");
				String onumber=rs.getString("onumber");
				Date start=new java.util.Date(rs.getDate("start_date").getTime());
				Date end=new java.util.Date(rs.getDate("end_date").getTime());
				Order order=new Order(cid,onumber,start,end);
				orderList.add(order);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return orderList;
	}
	//租车,插入订单信息
	public boolean insert(Order order, Client client) {
		PreparedStatement pst=null;
		ClientDao cd=new ClientDao();
		VehicleDao vo=new VehicleDao();
		boolean flag=true;
		try {
			con=Conn.getConnection();
			int id=client.getId();
			Client tmp=cd.selectById(id);
			if(tmp==null) {
				String sql="insert into client(id,name,gender,age,phone) values(?,?,?,?,?)";
				pst=con.prepareStatement(sql);
				pst.setInt(1,client.getId());
				pst.setString(2, client.getName());
				pst.setString(3,client.getGender());
				pst.setInt(4, client.getAge());
				pst.setLong(5, client.getPhone());
				pst.executeUpdate();
			}
			String sql1="insert into  orders(id,number,start_date) values (?,?,?)";
			pst=null;
			pst=con.prepareStatement(sql1);
			pst.setInt(1,order.getId());
			pst.setString(2, order.getNumber());
			pst.setDate(3,new java.sql.Date(order.getStart().getTime()));
			pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			flag=false;
		}
		if(flag)
		{
			vo.updateT(order.getNumber());
		}
		return  flag;
	}
	//还车,删除相应租赁信息
	public boolean delete(String number) {
		PreparedStatement pst=null;
		boolean flag=true;
		try {
			con=Conn.getConnection();
			String sql="delete from orders where number=?";
			pst=con.prepareStatement(sql);
			//pst.setInt(1,order.getId());
			pst.setString(1,number);
			pst.execute();
		}catch(SQLException e) {
			e.printStackTrace();
			flag=false;
		}
		return flag;

	}
}
