package vehicleleasing.dao;

import vehicleleasing.dbutil.Conn;
import vehicleleasing.model.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author lszzz
 * @create 2020/5/28
 */
public class ManagerDao {
	private Connection con;
	public ManagerDao() {}
	//注册插入管理员
	public void insert(Manager manager) {
		PreparedStatement pst=null;
		try {
			con= Conn.getConnection();
			String sql="insert into  manager(username,password) values (?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, manager.getUsername());
			pst.setString(2, manager.getPassword());
			pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
	}
	//按用户名查询管理员信息
	public Manager selectByUsername(String username) {
		PreparedStatement pst=null;
		Connection con = null;
		ResultSet rs = null;
		Manager manager=null;
		try {
			con=Conn.getConnection();
			System.out.println(con+"qdwdq");
			String sql="select * from manager where username=?";
			pst=con.prepareStatement(sql);
			pst.setString(1,username);
			rs = pst.executeQuery();
			if(rs.next()) {
				String name=rs.getString("username");
				System.out.println(name+"123");
				String password=rs.getString("password");
				manager=new Manager(name,password);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//如果返回的manager为空说明没有查寻到
		return manager;
	}
}