import java.awt.EventQueue;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lock extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lock frame = new Lock();
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
	public Lock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 432);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 0, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Folder Locker");
		lblNewLabel.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(152, 52, 223, 27);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField.setBounds(38, 128, 460, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		final JButton browse = new JButton("Browse");
		browse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== browse) {
					JFileChooser filechoose =new JFileChooser();
					int response=filechoose.showOpenDialog(null);
					if(response==JFileChooser.APPROVE_OPTION) {
						File file=new File(filechoose.getSelectedFile().getAbsolutePath());
						textField.setText(file.getPath());
					}
				}
			}
		});
		browse.setForeground(SystemColor.desktop);
		browse.setFont(new Font("Tahoma", Font.PLAIN, 24));
		browse.setBounds(38, 211, 124, 37);
		contentPane.add(browse);
		
		JButton lock = new JButton("Lock");
		lock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					File file=new File(textField.getText());
					file.setReadable(false);
					file.setWritable(false);
					file.setExecutable(false);
					
					
					JOptionPane.showMessageDialog(null, "Folder locked..You can only read the file.");
				}
				catch(Exception ea) {
					JOptionPane.showMessageDialog(null,"Exception raised...");
				}
			}
		});
		lock.setForeground(Color.BLACK);
		lock.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lock.setBounds(131, 301, 124, 37);
		contentPane.add(lock);
		
		JButton unlock = new JButton("Unlock");
		unlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File file=new File(textField.getText());
					file.setReadable(true);
					file.setWritable(true);
					file.setExecutable(true);
					JOptionPane.showMessageDialog(null, "Folder unlocked...");
				}
				catch(Exception ea) {
					JOptionPane.showMessageDialog(null,"Exception raised...");
				}
			}
		});
		unlock.setForeground(Color.BLACK);
		unlock.setFont(new Font("Tahoma", Font.PLAIN, 24));
		unlock.setBounds(282, 301, 124, 37);
		contentPane.add(unlock);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				Change_pswd cp=new Change_pswd();
				cp.setVisible(true);
			}
		});
		btnChangePassword.setForeground(Color.BLACK);
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnChangePassword.setBounds(334, 214, 174, 37);
		contentPane.add(btnChangePassword);
	}
}