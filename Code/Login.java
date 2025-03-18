package employee.management.system;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	
	
	JTextField tusername;
	JPasswordField tpassword;
	
	JButton Login, Back;
	
	Login(){
		

		
		
		
		
		JLabel username=new JLabel("username");
		username.setBounds(40,20,100,30);
		add(username);
		tusername=new JTextField();
		tusername.setBounds(150,20,170,30);
		add(tusername);
		
		
		
		JLabel password=new JLabel("password");
		password.setBounds(40,70,100,30);
		add(password);
		tpassword=new JPasswordField();
		tpassword.setBounds(150,70,170,30);
		add(tpassword);
		
		
		
		
		Login=new JButton("LOGIN");
		Login.setBounds(150,140,150,30);
		Login.setBackground(Color.black);
		Login.setForeground(Color.white);
		Login.addActionListener(this);
		  
		add(Login);
		
		
		Back=new JButton("BACK");
		Back.setBounds(150,180,150,30);
		Back.setBackground(Color.black);
		Back.setForeground(Color.white);
		Back.addActionListener(this);
		add(Back);
		
		ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icon/Second.jpg"));
		Image i22=i11.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
		ImageIcon i33=new ImageIcon(i22);
		JLabel imgg=new JLabel(i33);
		imgg.setBounds(350,10,600,400);
		add(imgg);
		
		
		
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/LoginB.jpg"));
		Image i2=i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel img=new JLabel(i3);
		img.setBounds(0,0,600,300);
		add(img);
		
		
		
		
		setSize(600,300);
		setLocation(450,200);
		setLayout(null);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Login) {
			try {
				String username=tusername.getText();
				String passsword=tpassword.getText();
				
				conn conn=new conn();
				String query="select * from login where username ='"+username +"' and password = '"+passsword+"'";
				ResultSet resultSet=conn.statement.executeQuery(query);
				if(resultSet.next()) {
					setVisible(false);
					new Main_class();
				}
				else {
					JOptionPane.showMessageDialog(null,"Invalid username or Password");
				}
			}
			catch(Exception E) {
				E.printStackTrace();
				
			}
			
		}
		else if(e.getSource()==Back){
			System.exit(90);
			
			
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login(); 

	}

}
