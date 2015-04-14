package sep;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class login extends JFrame {

	public static dconnection conn = new dconnection();
	public static Connection connection = conn.getDBConnection();
	public static String query=" ";
	public static ResultSet rs;
	
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setBounds(48, 48, 200, 50);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(48, 95, 200, 50);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(114, 64, 200, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==13 || arg0.getKeyCode()==10)
				{
					try{
						Statement statement = connection.createStatement();
						
						String fquery = "select password from users where username='"+textField.getText()+"'";
						rs = statement.executeQuery(fquery);
						rs.next();
						
						if(rs.getString(1).equals(passwordField.getText()))
						{
							
								Patents_Data_Manager manager = new Patents_Data_Manager();
								manager.frame.setVisible(true);
								dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Username or Password Mismatch");
						}
					}
					catch(Exception s)
					{
						JOptionPane.showMessageDialog(null, "Username or Password Mismatch");
						s.printStackTrace();
						
					}
				}
					
			}
		});
		passwordField.setBounds(114, 109, 200, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					Statement statement = connection.createStatement();
					
					String fquery = "select password from users where username='"+textField.getText()+"'";
					rs = statement.executeQuery(fquery);
					rs.next();
					
					if(rs.getString(1).equals(passwordField.getText()))
					{
						
							Patents_Data_Manager manager = new Patents_Data_Manager();
							manager.frame.setVisible(true);
							dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Username or Password Mismatch");
					}
				}
				catch(Exception s)
				{
					JOptionPane.showMessageDialog(null, "Username or Password Mismatch");
					s.printStackTrace();
				}
		}});
		
		btnLogin.setBounds(48, 156, 89, 23);
		contentPane.add(btnLogin);
	}
}
