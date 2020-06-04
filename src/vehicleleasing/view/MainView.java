package vehicleleasing.view;

import vehicleleasing.algorithm.DesCryptology;
import vehicleleasing.algorithm.XorCryptology;
import vehicleleasing.dao.ManagerDao;
import vehicleleasing.model.Manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JTextField idTxt;
	private JPasswordField pwdTxt;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setTitle("\u8F66\u8F86\u79DF\u8D41\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 738);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("E:\\java\u8BFE\u8BBE\\timg (1).jpg"));

		JLabel lblNewLabel_1 = new JLabel("      \u8F66\u8F86\u79DF\u8D41\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_1.setFont(new Font("ËÎÌå", Font.BOLD, 16));

		JLabel lblNewLabel_2 = new JLabel("\u8D26\u53F7");
		lblNewLabel_2.setFont(new Font("ËÎÌå", Font.BOLD, 14));

		JLabel lblNewLabel_3 = new JLabel("\u5BC6\u7801");
		lblNewLabel_3.setFont(new Font("ËÎÌå", Font.BOLD, 14));

		idTxt = new JTextField();
		idTxt.setColumns(10);

		pwdTxt = new JPasswordField();

		JButton loginBut = new JButton("\u767B\u5F55");
		loginBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login(e);
			}
		});

		JButton resetBut = new JButton("\u91CD\u7F6E");
		resetBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reset(e);
			}
		});
		JButton registerBut = new JButton("\u6CE8\u518C");
		registerBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				register(e);
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap(11, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 657, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(221)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(234, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap(129, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
								.addGap(29)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(pwdTxt)
										.addComponent(idTxt, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
								.addGap(208))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(69)
								.addComponent(loginBut, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(120)
								.addComponent(resetBut, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
								.addComponent(registerBut, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(56))
		);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
								.addGap(34)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(31)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_3)
										.addComponent(pwdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(55)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(loginBut)
										.addComponent(resetBut)
										.addComponent(registerBut))
								.addContainerGap(34, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	//×¢²á¿ò½øÐÐÕË»§×¢²á
	private void register(ActionEvent e) {
		String id=idTxt.getText();
		String pwd=pwdTxt.getText();
		ResourceBundle rs=ResourceBundle.getBundle("db");
		String cipher=rs.getString("cipher");
		ManagerDao md=new ManagerDao();
		if(id.equals("")||pwd.equals(""))
		{
			JOptionPane.showMessageDialog(null,"ÕËºÅºÍÃÜÂë²»ÄÜÎª¿Õ£¡");
		}
		else{
			//½øÐÐÃÜÂë¼ÓÃÜ£»
			String safePwd= DesCryptology.encrypt(pwd,cipher);
			Manager manager=new Manager(id,safePwd);
			md.insert(manager);
			JOptionPane.showMessageDialog(null,"×¢²á³É¹¦£¡");
		}
	}

	//ÖØÖÃÕËºÅºÍÃÜÂëµÄÊäÈë¿ò£»
	private void reset(ActionEvent e) {
		// TODO Auto-generated method stub
		idTxt.setText("");
		pwdTxt.setText("");

	}

	//µÇÂ¼°´Å¥µÄÊÂ¼þ¼àÌý
	private void login(ActionEvent e) {
		// TODO Auto-generated method stub
		String id=idTxt.getText();
		String pwd=pwdTxt.getText();
		Manager a=new Manager(id,pwd);
		ManagerDao md=new ManagerDao();
		Manager res=md.selectByUsername(id);
		ResourceBundle rs=ResourceBundle.getBundle("db");
		String cipher=rs.getString("cipher");
		pwd=XorCryptology.encrypt(pwd,cipher);
		if(res==null||res.getPassword()==null||res.getUsername()==null)
		{
			JOptionPane.showMessageDialog(null,"µÇÂ¼Ê§°Ü£¬ÕËºÅ»òÃÜÂë´íÎó£¡");
			System.out.println("µÇÂ¼Ê§°Ü£¡");

		}
		else if(res.getPassword().equals(pwd))
		{
			JOptionPane.showMessageDialog(null,"µÇÂ¼³É¹¦");
			BranchView frame=new BranchView();
			frame.setVisible(true);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"µÇÂ¼Ê§°Ü£¡");
			System.out.println("µÇÂ¼Ê§°Ü£¡");
		}
	}
}
