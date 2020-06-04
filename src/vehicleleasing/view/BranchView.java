package vehicleleasing.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class BranchView extends JFrame {

	private JPanel contentPane;
	private JTextField txtLoginInSucessfully;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					BranchView frame = new BranchView();
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
	public BranchView() {
		setTitle("\u64CD\u4F5C\u7A97");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		txtLoginInSucessfully = new JTextField();
		txtLoginInSucessfully.setBackground(Color.YELLOW);
		txtLoginInSucessfully.setFont(new Font("微软雅黑", Font.BOLD, 17));
		txtLoginInSucessfully.setText("Login in sucessfully!");
		txtLoginInSucessfully.setColumns(10);

		JButton selectBut = new JButton("\u67E5\u8BE2");
		selectBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SearchInfo(e);
			}
		});

		JButton returnBut = new JButton("\u8FD8\u8F66");
		returnBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				returnCar(e);
			}
		});

		JButton leaseBut = new JButton("\u79DF\u8F66");
		leaseBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Leasing(e);
			}
		});

		JButton delBut = new JButton("\u5220\u9664");
		delBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteOrder(e);
			}
		});

		JButton addBut = new JButton("\u65B0\u8F66\u5F55\u5165");
		addBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addCar(e);
			}
		});

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.ITALIC, 14));
		textField.setText("   \u8BF7\u9009\u62E9\u63A5\u4E0B\u6765\u7684\u64CD\u4F5C\uFF01");
		textField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(selectBut, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addComponent(returnBut, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(leaseBut, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addComponent(delBut, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
								.addGap(20))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(163)
								.addComponent(addBut, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(166, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap(126, Short.MAX_VALUE)
								.addComponent(txtLoginInSucessfully, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
								.addGap(121))
		);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(txtLoginInSucessfully, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(selectBut)
														.addComponent(leaseBut))
												.addGap(26)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(returnBut)
														.addComponent(delBut))
												.addGap(27))
										.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
												.addComponent(textField, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
												.addGap(27)))
								.addComponent(addBut)
								.addContainerGap(40, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private void addCar(ActionEvent e) {
		// TODO Auto-generated method stub
		AddCarView frame=new AddCarView();
		frame.setVisible(true);
	}

	private void deleteOrder(ActionEvent e) {
		// TODO Auto-generated method stub
		DeleteView frame=new DeleteView();
		frame.setVisible(true);
	}

	private void returnCar(ActionEvent e) {
		// TODO Auto-generated method stub
		ReturnCarView frame=new ReturnCarView();
		frame.setVisible(true);
	}

	private void Leasing(ActionEvent e) {
		// TODO Auto-generated method stub
		LeasingCarView frame=new LeasingCarView();
		frame.setVisible(true);
	}

	//点击查询进入查询界面
	private void SearchInfo(ActionEvent e) {
		// TODO Auto-generated method stub
		SearchView frame=new SearchView();
		frame.setVisible(true);

	}

}
