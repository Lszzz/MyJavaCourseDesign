package vehicleleasing.dao;

import vehicleleasing.dbutil.Conn;
import vehicleleasing.model.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
/**
 * @author lszzz
 * @create 2020/5/31
 */
public class VehicleDao {
	private Connection con;
	private List<Vehicle> vehicleList ;


	//增加车辆
	public boolean insert(Vehicle vehicle) {
		boolean flag=true;
		PreparedStatement pst=null;
		try {
			con= Conn.getConnection();
			String sql="insert into  vehicle(number,type,price_daily,status) values (?,?,?,?)";
			pst=con.prepareStatement(sql);
			//传入
			pst.setString(1,vehicle.getNumber() );
			pst.setString(2, vehicle.getType());
			pst.setInt(3, vehicle.getPrice_daily());
			pst.setBoolean(4,vehicle.getStatus());

			//执行
			pst.executeUpdate();
			System.out.println("添加成功");
		}catch(SQLException e) {
			flag=false;
			e.printStackTrace();
		}
		return flag;
	}

	public Vehicle selectByNumber(String number) {
		PreparedStatement pst=null;
		ResultSet rs=null;
		Vehicle tmp=null;
		try {
			con=Conn.getConnection();
			String sql="select *from vehicle where number=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, number);
			rs=pst.executeQuery();
			if(rs==null)
			{
				return null;
			}
			while(rs.next())
			{
				String numbers=rs.getString(1);
				String type=rs.getString(2);
				int price=rs.getInt(3);
				boolean status=rs.getBoolean(4);
				tmp=new Vehicle(numbers,type,price,status);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return tmp;
	}

	//显示所有车辆信息
	public List<Vehicle> showAllVehicle() {
		vehicleList=new ArrayList<Vehicle>();
		Connection con = null;
		PreparedStatement pst=null;
		ResultSet rs = null;
		try{
			con = Conn.getConnection();
			String sql = "select * from vehicle";
			pst =  con.prepareStatement(sql);
			rs = pst.executeQuery(sql);
			while(rs.next()){

				//加入Vehicle list 用于Gui显示
				String number=rs.getString("number");
				String type=rs.getString("type");
				int price_daily=rs.getInt("price_daily");
				boolean status=rs.getBoolean("status");
				Vehicle temp=new Vehicle(number,type,price_daily,status);
				vehicleList.add(temp);

				System.out.println(number+" "+type+" "+price_daily+" "+status);
			}
		}catch (Exception e) {

		}
		return vehicleList;
	}
	//显示空闲车辆        返回  车辆List 用于显示
	public List<Vehicle> showFreeVehicle() {
		vehicleList=new ArrayList<Vehicle>();
		Connection con = null;
		PreparedStatement pst=null;
		ResultSet rs = null;
		try{
			con = Conn.getConnection();
			String sql = "select * from vehicle where status=false";
			pst =  con.prepareStatement(sql);
			rs = pst.executeQuery(sql);
			while(rs.next()){

				//加入Vehicle list 用于Gui显示
				String number=rs.getString("number");
				String type=rs.getString("type");
				int price_daily=rs.getInt("price_daily");
				boolean status=rs.getBoolean("status");
				Vehicle temp=new Vehicle(number,type,price_daily,status);
				vehicleList.add(temp);

				System.out.println(number+" "+type+" "+price_daily+" "+status);
			}
		}catch (Exception e) {

		}
		return vehicleList;
	}


	//根据车牌号删除
	public boolean delete(String number) {
		PreparedStatement pst=null;
		boolean flag=true;
		try {
			con=Conn.getConnection();
			String sql="delete from  vehicle where number=?";
			pst=con.prepareStatement(sql);
			pst.setString(1,number);

			//执行
			pst.executeUpdate();
			System.out.println("删除成功");

		}catch(SQLException e) {
			e.printStackTrace();
			flag=true;
		}
		return flag;
	}

	// 状态置true
	public void updateT(String number) {
		PreparedStatement pst=null;
		try {
			con=Conn.getConnection();
			String sql="update  vehicle set status=1 where number=?";
			System.out.println("开始");
			pst=con.prepareStatement(sql);
			pst.setString(1,number);

			//执行
			pst.executeUpdate();
			System.out.println("置1成功");

		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	//置false
	public void updateF(String number) {
		PreparedStatement pst=null;
		try {
			con=Conn.getConnection();
			String sql="update vehicle set status=0 where number=?";
			pst=con.prepareStatement(sql);
			pst.setString(1,number);

			//执行
			pst.executeUpdate();
			System.out.println("置0成功");

		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

