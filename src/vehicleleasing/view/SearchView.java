package vehicleleasing.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import vehicleleasing.dao.ClientDao;
import vehicleleasing.dao.OrderDao;
import vehicleleasing.dao.VehicleDao;
import vehicleleasing.model.Client;
import vehicleleasing.model.Vehicle;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


public class SearchView extends JFrame {

	private JPanel contentPane;
	private JTable clientTable;
	private JTable carTable;
	private JTextField carIdTxt;
	private JTable resTable1;
	private JTextField userIdTxt;
	private JTable resTable2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchView frame = new SearchView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchView() {
		setTitle("\u67E5\u8BE2\u754C\u9762");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 557, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u67E5\u8BE2");
		lblNewLabel.setFont(new Font("????", Font.BOLD, 17));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
												.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
												.addGap(122))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
												.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
								.addContainerGap())
		);

		JPanel clientPanel = new JPanel();
		clientPanel.setToolTipText("");
		tabbedPane.addTab("客户信息", null, clientPanel, null);

		JLabel lblNewLabel_1 = new JLabel("\u5BA2\u6237\u4FE1\u606F");
		lblNewLabel_1.setFont(new Font("????", Font.BOLD, 15));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_clientPanel = new GroupLayout(clientPanel);
		gl_clientPanel.setHorizontalGroup(
				gl_clientPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_clientPanel.createSequentialGroup()
								.addGap(205)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
						.addGroup(gl_clientPanel.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
								.addGap(20))
		);
		gl_clientPanel.setVerticalGroup(
				gl_clientPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_clientPanel.createSequentialGroup()
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(12, Short.MAX_VALUE))
		);

		clientTable = new JTable();
		clientTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u8054\u7CFB\u65B9\u5F0F"
				}
		) {
			boolean[] columnEditables = new boolean[] {
					true, true, true, false, true
			};
			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(clientTable);
		clientPanel.setLayout(gl_clientPanel);

		JPanel carPanel = new JPanel();
		tabbedPane.addTab("车辆信息", null, carPanel, null);

		JLabel lblNewLabel_2 = new JLabel("\u8F66\u8F86\u4FE1\u606F");
		lblNewLabel_2.setFont(new Font("????", Font.BOLD, 15));

		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_carPanel = new GroupLayout(carPanel);
		gl_carPanel.setHorizontalGroup(
				gl_carPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_carPanel.createSequentialGroup()
								.addGroup(gl_carPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_carPanel.createSequentialGroup()
												.addGap(198)
												.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_carPanel.createSequentialGroup()
												.addGap(18)
												.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_carPanel.setVerticalGroup(
				gl_carPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_carPanel.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblNewLabel_2)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(26, Short.MAX_VALUE))
		);

		carTable = new JTable();
		carTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"\u8F66\u724C\u53F7", "\u8F66\u578B", "\u65E5\u79DF\u4EF7\u683C", "\u79DF\u8D41\u72B6\u6001"
				}
		) {
			boolean[] columnEditables = new boolean[] {
					false, false, true, false
			};
			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(carTable);
		carPanel.setLayout(gl_carPanel);

		JPanel searchPanel = new JPanel();
		tabbedPane.addTab("订单查询", null, searchPanel, null);

		JLabel lblNewLabel_3 = new JLabel("\u4FE1\u606F\u6761\u4EF6\u67E5\u8BE2");
		lblNewLabel_3.setFont(new Font("????", Font.BOLD, 15));

		JLabel lblNewLabel_4 = new JLabel("\u8F66\u724C\u53F7\uFF1A");
		lblNewLabel_4.setFont(new Font("????", Font.BOLD, 13));

		carIdTxt = new JTextField();
		carIdTxt.setColumns(10);

		JScrollPane scrollPane_2 = new JScrollPane();

		JButton carIdSearch = new JButton("\u641C\u7D22");
		carIdSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				carIdSearch(e);
			}
		});

		JLabel lblNewLabel_5 = new JLabel("\u5BA2\u6237ID\uFF1A");
		lblNewLabel_5.setFont(new Font("????", Font.BOLD, 13));

		userIdTxt = new JTextField();
		userIdTxt.setColumns(10);

		JButton btnNewButton_1 = new JButton("\u641C\u7D22");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientIdSearch(e);
			}
		});

		JScrollPane scrollPane_3 = new JScrollPane();
		GroupLayout gl_searchPanel = new GroupLayout(searchPanel);
		gl_searchPanel.setHorizontalGroup(
				gl_searchPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_searchPanel.createSequentialGroup()
								.addContainerGap(193, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addGap(176))
						.addGroup(Alignment.LEADING, gl_searchPanel.createSequentialGroup()
								.addGap(83)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(carIdTxt, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(173, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_searchPanel.createSequentialGroup()
								.addContainerGap()
								.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
								.addContainerGap())
						.addGroup(Alignment.LEADING, gl_searchPanel.createSequentialGroup()
								.addGap(195)
								.addComponent(carIdSearch, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(216, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_searchPanel.createSequentialGroup()
								.addGap(185)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(226, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_searchPanel.createSequentialGroup()
								.addGap(83)
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(userIdTxt, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(174, Short.MAX_VALUE))
						.addGroup(gl_searchPanel.createSequentialGroup()
								.addContainerGap()
								.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
								.addContainerGap())
		);
		gl_searchPanel.setVerticalGroup(
				gl_searchPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_searchPanel.createSequentialGroup()
								.addGap(29)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addGap(15)
								.addGroup(gl_searchPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_4)
										.addComponent(carIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(14)
								.addComponent(carIdSearch)
								.addGap(18)
								.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
								.addGap(30)
								.addGroup(gl_searchPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_5)
										.addComponent(userIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnNewButton_1)
								.addGap(18)
								.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(20, Short.MAX_VALUE))
		);

		resTable2 = new JTable();
		resTable2.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"\u5BA2\u6237ID", "\u59D3\u540D", "\u8054\u7CFB\u65B9\u5F0F", "\u8F66\u724C\u53F7", "\u5F00\u59CB\u65F6\u95F4", "\u7ED3\u675F\u65F6\u95F4"
				}
		) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, true, false
			};
			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_3.setViewportView(resTable2);

		resTable1 = new JTable();
		resTable1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"\u5BA2\u6237ID", "\u59D3\u540D", "\u8054\u7CFB\u65B9\u5F0F", "\u8F66\u724C\u53F7", "\u5F00\u59CB\u65F6\u95F4", "\u7ED3\u675F\u65F6\u95F4"
				}
		) {
			boolean[] columnEditables = new boolean[] {
					false, false, true, true, false, false
			};
			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_2.setViewportView(resTable1);
		searchPanel.setLayout(gl_searchPanel);
		contentPane.setLayout(gl_contentPane);
		this.fillTableInClient();
		this.fillTableInCar();
	}
	//按照用户编号进行查询
	private void clientIdSearch(ActionEvent e) {
		// TODO Auto-generated method stub
		OrderDao od=new OrderDao();
		String id=userIdTxt.getText();
		ResultSet rs=null;
		DefaultTableModel dtm=(DefaultTableModel) resTable2.getModel();
		if(id.contentEquals(""))
		{
			JOptionPane.showMessageDialog(null, "输入框不能为空");
		}
		else {
			Integer tmp=Integer.valueOf(id);

			rs=od.selectAllById(tmp);
			if(rs==null)
			{
				JOptionPane.showMessageDialog(null, "无此项订单！");
			}
			try {
				boolean flag=false;
				while(rs.next())
				{
					flag=true;
					Vector a=new Vector();
					a.add(rs.getInt(1));
					a.add(rs.getString(2));
					a.add(rs.getInt(3));
					a.add(rs.getString(4));
					a.add(rs.getDate(5));
					a.add(rs.getDate(6));
					dtm.addRow(a);
				}
				if(!flag)
				{
					JOptionPane.showMessageDialog(null, "无此项订单！");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "查询成功！");
				}
			}catch(SQLException e1)
			{
				e1.printStackTrace();
			}
		}
	}

	//按照车牌号搜索；
	private void carIdSearch(ActionEvent e) {
		// TODO Auto-generated method stub
		OrderDao od=new OrderDao();
		String number=carIdTxt.getText();
		ResultSet rs=null;
		DefaultTableModel dtm=(DefaultTableModel) resTable1.getModel();
		if(number.contentEquals(""))
		{
			JOptionPane.showMessageDialog(null, "输入框不能为空");
		}
		else {

			rs=od.selectAllByNumber(number);
			if(rs==null)
			{
				JOptionPane.showMessageDialog(null, "无此项订单！");
			}
			try {
				boolean flag=false;
				while(rs.next())
				{
					flag=true;
					Vector a=new Vector();
					a.add(rs.getInt(1));
					a.add(rs.getString(2));
					a.add(rs.getInt(3));
					a.add(rs.getString(4));
					a.add(rs.getDate(5));
					a.add(rs.getDate(6));
					dtm.addRow(a);
				}
				if(!flag)
				{
					JOptionPane.showMessageDialog(null, "无此项订单！");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "查询成功！");
				}
			}catch(SQLException e1)
			{
				e1.printStackTrace();
			}
		}
	}

	private void fillTableInClient() {
		DefaultTableModel dtm=(DefaultTableModel) clientTable.getModel();
		ClientDao cd=new ClientDao();
		ArrayList<Client> s=(ArrayList<Client>) cd.ShowClient();
		System.out.println(s.size());
		while(!s.isEmpty())
		{
			//vector里只能存放对象
			Vector v=new Vector();
			Client tmp=s.get(0);
			Integer Id=tmp.getId();
			String name=tmp.getName();
			String gender=tmp.getGender();
			Integer age=tmp.getAge();
			Long phone=tmp.getPhone();
			v.add(Id);
			v.add(name);
			v.add(gender);
			v.add(age);
			v.add(phone);
			dtm.addRow(v);
			s.remove(0);
		}

	}

	private void fillTableInCar() {
		DefaultTableModel dtm=(DefaultTableModel) carTable.getModel();
		VehicleDao vo=new VehicleDao();
		ArrayList <Vehicle> s=(ArrayList<Vehicle>) vo.showAllVehicle();
		System.out.println(s.size());
		while(!s.isEmpty())
		{
			//vector里只能存放对象
			Vector v=new Vector();
			Vehicle tmp=s.get(0);
			v.add(tmp.getNumber());
			v.add(tmp.getType());
			v.add(tmp.getPrice_daily());
			v.add(tmp.getStatus());
			System.out.println(tmp.getNumber()+" "+tmp.getStatus());
			dtm.addRow(v);
			s.remove(0);

		}

	}

}
