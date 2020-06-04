package vehicleleasing.view;

import vehicleleasing.dao.OrderDao;
import vehicleleasing.dao.VehicleDao;
import vehicleleasing.model.Client;
import vehicleleasing.model.Order;
import vehicleleasing.model.Vehicle;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class LeasingCarView extends JFrame {

	private JPanel contentPane;
	private JTable freeCarTable;
	private JTextField carIdTxt;
	private JTextField carModelTxt;
	private JTextField beginTimeTxt;
	private JTextField contactWayTxt;
	private JTextField userIDTxt;
	private JTextField userNameTxt;
	private JTextField genderTxt;
	private JTextField ageTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					LeasingCarView frame = new LeasingCarView();
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
	public LeasingCarView() {
		setTitle("\u79DF\u8F66");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 593, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblNewLabel = new JLabel("\u7A7A\u95F2\u8F66\u8F86");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 14));

		JLabel lblNewLabel_1 = new JLabel("\u8F66\u724C\u53F7");

		JLabel lblNewLabel_2 = new JLabel("\u8F66\u578B");

		JLabel lblNewLabel_3 = new JLabel("\u5F00\u59CB\u65F6\u95F4");

		carIdTxt = new JTextField();
		carIdTxt.setColumns(10);

		carModelTxt = new JTextField();
		carModelTxt.setColumns(10);

		beginTimeTxt = new JTextField();
		beginTimeTxt.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\u8054\u7CFB\u65B9\u5F0F");

		contactWayTxt = new JTextField();
		contactWayTxt.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("ID");

		JLabel lblNewLabel_6 = new JLabel("\u59D3\u540D");

		JLabel lblNewLabel_7 = new JLabel("\u6027\u522B");

		JLabel lblNewLabel_8 = new JLabel("\u5E74\u9F84");

		userIDTxt = new JTextField();
		userIDTxt.setColumns(10);

		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);

		genderTxt = new JTextField();
		genderTxt.setColumns(10);

		ageTxt = new JTextField();
		ageTxt.setColumns(10);

		JButton addBut = new JButton("\u6DFB\u52A0\u79DF\u8F66\u4FE1\u606F");
		addBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addOrderInfo(e);
			}
		});
		addBut.setFont(new Font("宋体", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap(249, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addGap(232))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(20)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(contactWayTxt, 157, 157, 157))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(beginTimeTxt, 157, 157, 157))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(carModelTxt, 157, 157, 157))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(carIdTxt)))
												.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(ageTxt)
														.addComponent(genderTxt, Alignment.LEADING)
														.addComponent(userNameTxt, Alignment.LEADING)
														.addComponent(userIDTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)))
								.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(134)
								.addComponent(addBut, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
								.addGap(96))
		);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
								.addGap(32)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_1)
										.addComponent(carIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_5)
										.addComponent(userIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_2)
										.addComponent(carModelTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_6)
										.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_3)
										.addComponent(beginTimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_7)
										.addComponent(genderTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_4)
										.addComponent(contactWayTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_8)
										.addComponent(ageTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
								.addComponent(addBut)
								.addGap(46))
		);

		freeCarTable = new JTable();
		freeCarTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				fillTxt(e);
			}
		});
		freeCarTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"\u8F66\u724C\u53F7", "\u8F66\u578B", "\u65E5\u79DF\u4EF7\u683C", "\u79DF\u8D41\u72B6\u6001"
				}
		) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false
			};
			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(freeCarTable);
		contentPane.setLayout(gl_contentPane);
		this.fillFreeCarTable();
	}
	private  void fillTxt(MouseEvent e) {
		// TODO Auto-generated method stub

		int row=freeCarTable.getSelectedRow();
		String carId=(String)freeCarTable.getValueAt(row, 0);
		String model=(String)freeCarTable.getValueAt(row, 1);
		carIdTxt.setText(carId);
		carModelTxt.setText(model);


	}

	private void addOrderInfo(ActionEvent e) {
		// TODO Auto-generated method stub

		if(userIDTxt.getText().contentEquals("")||userNameTxt.getText().contentEquals("")||contactWayTxt.getText().contentEquals("")||genderTxt.getText().contentEquals("")||userIDTxt.getText().contentEquals("")||carIdTxt.getText().contentEquals("")||ageTxt.getText().contentEquals("")||beginTimeTxt.getText().contentEquals(""))
		{
			JOptionPane.showMessageDialog(null, "输入框不能为空");
		}
		else {
			Integer id=Integer.valueOf(userIDTxt.getText());
			String name=userNameTxt.getText();
			Long phone=Long.valueOf(contactWayTxt.getText());
			String gender=genderTxt.getText();
			Integer age=Integer.valueOf(ageTxt.getText());
			String carId=carIdTxt.getText();
			String tmpDate=beginTimeTxt.getText();

			DateFormat a=new SimpleDateFormat("yyyy-MM-dd");
			Date date=null;
			try {
				date = a.parse(tmpDate);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Client client=new Client(id,name,gender,age,phone);
			Order order=new Order(id,carId,date,null);
			OrderDao od=new OrderDao();
			boolean flag=od.insert(order, client);
			if(flag)
			{
				JOptionPane.showMessageDialog(null, "录入成功！");
				this.fillFreeCarTable();
				carIdTxt.setText("");
				carModelTxt.setText("");
				beginTimeTxt.setText("");
				contactWayTxt.setText("");
				userIDTxt.setText("");
				userNameTxt.setText("");
				genderTxt.setText("");
				ageTxt.setText("");
			}
			else {
				JOptionPane.showMessageDialog(null, "录入失败！");
			}
		}
	}

	private void fillFreeCarTable()
	{
		DefaultTableModel dtm=(DefaultTableModel) freeCarTable.getModel();
		dtm.setRowCount(0);
		VehicleDao vo=new VehicleDao();
		ArrayList<Vehicle> s=(ArrayList<Vehicle>) vo.showFreeVehicle();
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
