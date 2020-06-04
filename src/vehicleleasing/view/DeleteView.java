package vehicleleasing.view;

import vehicleleasing.dao.ClientDao;
import vehicleleasing.dao.VehicleDao;
import vehicleleasing.model.Client;
import vehicleleasing.model.Vehicle;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DeleteView extends JFrame {

	private JPanel contentPane;
	private JTextField userIdTxt;
	private JTextField carIdTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					DeleteView frame = new DeleteView();
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
	public DeleteView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u5220\u9664");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 17));

		JLabel lblNewLabel_1 = new JLabel("\u5BA2\u6237ID\uFF1A");

		userIdTxt = new JTextField();
		userIdTxt.setColumns(10);

		JButton userDelBut = new JButton("\u5220\u9664\u5BA2\u6237\u4FE1\u606F");
		userDelBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteUser(e);
			}
		});

		JLabel lblNewLabel_2 = new JLabel("\u8F66\u724C\u53F7");

		carIdTxt = new JTextField();
		carIdTxt.setColumns(10);

		JButton carDelBut = new JButton("\u5220\u9664\u8F66\u8F86\u4FE1\u606F");
		carDelBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteCar(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addContainerGap(178, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addGap(162))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(133)
								.addComponent(userDelBut, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(158, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(50)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(carIdTxt))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(userIdTxt, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(130, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(135)
								.addComponent(carDelBut, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(161, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addGap(34)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_1)
										.addComponent(userIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(41)
								.addComponent(userDelBut)
								.addGap(56)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_2)
										.addComponent(carIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(32)
								.addComponent(carDelBut)
								.addContainerGap(56, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void deleteCar(ActionEvent e) {
		// TODO Auto-generated method stub
		VehicleDao vo = new VehicleDao();
		String number = carIdTxt.getText();
		boolean flag = vo.delete(number);
		Vehicle vehicle = vo.selectByNumber(number);
		if (vehicle == null) {
			JOptionPane.showMessageDialog(null, "没有此车牌号的车辆！");
		} else {
			if (flag) {
				JOptionPane.showMessageDialog(null, "删除成功！");
			} else {
				JOptionPane.showMessageDialog(null, "删除失败！");
			}
		}
	}

	private void deleteUser(ActionEvent e) {
		// TODO Auto-generated method stub
		ClientDao cd = new ClientDao();
		if (userIdTxt.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "客户ID不能为空!");
		} else {
			Integer id = Integer.valueOf(userIdTxt.getText());
			Client client = cd.selectById(id);
			if (client == null) {
				JOptionPane.showMessageDialog(null, "没有此客户！");
			} else {
				boolean flag = cd.delete(id);
				if (flag) {
					JOptionPane.showMessageDialog(null, "删除成功！");
				} else {
					JOptionPane.showMessageDialog(null, "删除失败！");
				}

			}
		}
	}
}
