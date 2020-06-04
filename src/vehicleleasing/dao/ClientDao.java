package vehicleleasing.dao;

import vehicleleasing.dbutil.Conn;
import vehicleleasing.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lszzz
 * @create 2020/5/31
 */
public class ClientDao {
	private Connection con;
	private List<Client> clientList;

	//查询所有客户  返回List<Client>
	public List<Client> ShowClient(){
		clientList = new ArrayList<Client>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			con = Conn.getConnection();
			String sql = "select * from client";
			pst =  con.prepareStatement(sql);
			rs = pst.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				int age = rs.getInt("age");
				Long phone = rs.getLong("phone");
				Client temp = new Client(id, name, gender, age, phone);
				clientList.add(temp);

				System.out.println(id+" "+name+" "+gender+" "+age+" "+phone);
			}
			System.out.println("wanche");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return clientList;
	}

	//按id查询查询客户    若查询为空返回null，查询成功返回client对象
	public Client selectById(int id) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Client client = null;
		try {
			con = Conn.getConnection();
			String sql = "select * from client where id=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				int cid = rs.getInt("id");
				String cname = rs.getString("name");
				String cgender = rs.getString("gender");
				int cage = rs.getInt("age");
				Long cphone = rs.getLong("phone");
				client = new Client(cid, cname, cgender, cage, cphone);

				System.out.println(cid+" "+cname+" "+cgender+" "+cage+" "+cphone);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return client;
	}

	//增加客户
	public void insert(Client client) {
		PreparedStatement pst = null;
		try {
			con = Conn.getConnection();
			String sql = "insert into client(id,name,gender,age,phone) values (?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, client.getId());
			pst.setString(2, client.getName());
			pst.setString(3, client.getGender());
			pst.setInt(4, client.getAge());
			pst.setLong(5, client.getPhone());
			pst.executeUpdate();

			System.out.println("添加成功");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//按id删除客户
	public boolean delete(int id) {
		PreparedStatement pst = null;
		boolean flag=true;
		try {
			con = Conn.getConnection();
			String sql = "delete from client where id=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();

			System.out.println("删除成功");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag=false;
			}
			return flag;
		}
	}
}
