package vehicleleasing.view;

import vehicleleasing.dao.VehicleDao;
import vehicleleasing.model.Vehicle;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AddCarView extends JFrame {
	private JPanel contentPane;
	private JTextField carIdTxt;
	private JTextField carModelTxt;
	private JTextField paymentTxt;
	private JTextField statusTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					AddCarView frame = new AddCarView();
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
	public AddCarView() {
		setTitle("\u6DFB\u52A0");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 462, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u6DFB\u52A0\u65B0\u8F66");
		lblNewLabel.setFont(new Font("????", Font.BOLD, 16));

		JLabel lblNewLabel_1 = new JLabel("\u8F66\u724C\u53F7");

		JLabel lblNewLabel_2 = new JLabel("\u8F66\u578B");

		JLabel lblNewLabel_3 = new JLabel("\u65E5\u79DF\u91D1");

		JLabel lblNewLabel_4 = new JLabel("租用状态");

		carIdTxt = new JTextField();
		carIdTxt.setColumns(10);

		carModelTxt = new JTextField();
		carModelTxt.setColumns(10);

		paymentTxt = new JTextField();
		paymentTxt.setColumns(10);

		statusTxt = new JTextField();
		statusTxt.setColumns(10);

		JButton addBut = new JButton("从输入框中添加");
		addBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addNewOrder(e);
			}
		});

		JButton addFromFileBut = new JButton("从文件中添加");
		addFromFileBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();             //设置选择器
				chooser.setMultiSelectionEnabled(true);             //设为多选
				int returnVal = chooser.showOpenDialog(addFromFileBut);        //是否打开文件选择框
				System.out.println("returnVal="+returnVal);

				if (returnVal == JFileChooser.APPROVE_OPTION) {          //如果符合文件类型

					String filepath = chooser.getSelectedFile().getAbsolutePath();      //获取绝对路径
					try {
						FileReader reader=new FileReader(filepath);
						BufferedReader br=new BufferedReader(reader);
						String s=null;
						byte []b=null;
						int cnt=0;
						while((s=br.readLine())!=null)
						{
							cnt++;
							//此处有点小问题，因为本来是在eclipse上开发的，移植到idea时编码发生改变，idea默认utf-8与eclipse的GBK冲突，当改变项目编码时又由于
							//控制台默认输出的是utf-8所以存在一定的问题，因而使用idea会出现乱码问题，因为此种情况在开发中不会遇到，因而不再费心改正；
							//此处的charsetName是指采取什么编码格式进行解码；
							String info=new String(s.getBytes(),"utf-8");
							String number=null;
							String type=null;
							Integer price=null;
							Boolean status=null;
							String regex="([0-9A-Za-z]{5})\\s(.*)\\s([\\d]{0,})\\s([0,1]{1})";
							Pattern p=Pattern.compile(regex);
							Matcher matcher=p.matcher(info);
							if(matcher.find())
							{
								number=matcher.group(1);
								type=matcher.group(2);
								price=Integer.valueOf(matcher.group(3));
								status=Boolean.valueOf(matcher.group(4));
								System.out.println(matcher.group(0));
							}
							Vehicle tmp=new Vehicle(number,type,price,status);
							VehicleDao vo=new VehicleDao();
							boolean flag=vo.insert(tmp);
							if(flag) {
							}
							else
							{
								JOptionPane.showMessageDialog(null,"输入信息有误，添加失败！");
								break;
							}

						}
						String times=cnt+"条";
						JOptionPane.showMessageDialog(null,"成功添加"+times+"信息");
					} catch (FileNotFoundException fileNotFoundException) {
						fileNotFoundException.printStackTrace();
					} catch (IOException ioException) {
						ioException.printStackTrace();
					}



					System.out.println("You chose to open this file: "+ chooser.getSelectedFile().getName());  //输出相对路径

				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(57)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
												.addGap(30)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
														.addComponent(statusTxt)
														.addComponent(paymentTxt)
														.addComponent(carModelTxt)
														.addComponent(carIdTxt, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(183)
												.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(126, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addContainerGap(153, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(addBut, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(addFromFileBut, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
								.addGap(138))
		);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(22)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_1)
										.addComponent(carIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(44)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_2)
										.addComponent(carModelTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(42)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_3)
										.addComponent(paymentTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(43)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_4)
										.addComponent(statusTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
								.addComponent(addFromFileBut)
								.addGap(27)
								.addComponent(addBut)
								.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	//添加新车
	private void addNewOrder(ActionEvent e) {
		// TODO Auto-generated method stub
		if(carIdTxt.getText().equals("")||carModelTxt.getText().equals("")||paymentTxt.getText().equals("")||statusTxt.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "输入信息不能为空！");
		}
		else {
			String id=carIdTxt.getText();
			String model=carModelTxt.getText();
			Integer payment=Integer.valueOf(paymentTxt.getText());
			boolean status=false?true:statusTxt.getText().contentEquals("true");
			Vehicle a=new Vehicle(id,model,payment,status);
			VehicleDao vo=new VehicleDao();
			boolean flag=vo.insert(a);
			if(flag) {
				JOptionPane.showMessageDialog(null,"添加成功！");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"输入信息有误，添加失败！");
			}

		}
	}
}
