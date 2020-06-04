package vehicleleasing.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vehicleleasing.dao.OrderDao;
import vehicleleasing.dao.VehicleDao;
import vehicleleasing.model.Order;
import vehicleleasing.model.Vehicle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ReturnCarView extends JFrame {

	private JPanel contentPane;
	private JTextField carIdTxt;
	private JTextField useTimeTxt;
	private JTextField paymentTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ReturnCarView frame = new ReturnCarView();
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
	public ReturnCarView() {
		setTitle("\u8FD8\u8F66");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 415, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u8FD8\u8F66");
		lblNewLabel.setFont(new Font("????", Font.BOLD, 16));

		JLabel lblNewLabel_1 = new JLabel("\u8F66\u724C\u53F7");

		carIdTxt = new JTextField();
		carIdTxt.setColumns(10);

		JButton searchBut = new JButton("\u67E5\u8BE2\u76F8\u5173\u4FE1\u606F");
		searchBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectInfo(e);
			}
		});

		JLabel lblNewLabel_2 = new JLabel("\u4F7F\u7528\u65F6\u957F");

		useTimeTxt = new JTextField();
		useTimeTxt.setEditable(false);
		useTimeTxt.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\u5E94\u4ED8\u91D1\u989D");

		paymentTxt = new JTextField();
		paymentTxt.setEditable(false);
		paymentTxt.setColumns(10);

		JButton returnBut = new JButton("\u8FD8\u8F66");
		returnBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				returnBackCar(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(136)
								.addComponent(searchBut, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(212, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
												.addGap(53)
												.addComponent(lblNewLabel_1)
												.addGap(18)
												.addComponent(carIdTxt, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
												.addGap(45)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(paymentTxt, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(useTimeTxt)))))
								.addContainerGap(145, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addContainerGap(226, Short.MAX_VALUE)
								.addComponent(returnBut, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(148))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addContainerGap(248, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addGap(147))
		);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addGap(40)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_1)
										.addComponent(carIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(26)
								.addComponent(searchBut)
								.addGap(41)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_2)
										.addComponent(useTimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(33)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_3)
										.addComponent(paymentTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(44)
								.addComponent(returnBut)
								.addContainerGap(140, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private void returnBackCar(ActionEvent e) {
		// TODO Auto-generated method stub
		String carId=carIdTxt.getText();
		if(carId.contentEquals(""))
		{
			JOptionPane.showMessageDialog(null, "车牌号不能为空！");
		}
		else
		{
			OrderDao od=new OrderDao();
			boolean flag=od.delete(carId);
			if(flag) {
				JOptionPane.showMessageDialog(null, "还车成功");
				VehicleDao vo=new VehicleDao();
				vo.updateF(carId);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "还车失败！");
			}
		}
	}

	//根据车牌号查询费用等相关信息
	private void selectInfo(ActionEvent e) {
		// TODO Auto-generated method stub

		String carId=carIdTxt.getText();
		OrderDao od=new OrderDao();
		VehicleDao vo=new VehicleDao();
		Order order=od.selectByNumber(carId);
		Vehicle vehicle=vo.selectByNumber(carId);
		if(order==null||vehicle==null)
		{
			JOptionPane.showMessageDialog(null, "查询不到此车的相关信息！");
		}
		else {

			Integer price_daily=vehicle.getPrice_daily();
			Date nowDate=new Date();
			Long times=nowDate.getTime()-order.getStart().getTime();
			Integer days=(int) (times/86400000);
			Integer totalPrice=price_daily*days;
			useTimeTxt.setText(days.toString());
			paymentTxt.setText(totalPrice.toString());

		}
	}

}
