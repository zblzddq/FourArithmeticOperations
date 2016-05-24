package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;

public class mainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4876258596683970588L;
	private JPanel contentPane;
	public static boolean plus,minus,time,devide,isdecimal;
	private boolean isSelectedCheckBox;
	private String setMoudel = null;
	private String filePath = null;
	private String fileName = null;
	private final ButtonGroup buttonGroup = new ButtonGroup();    //���嵥ѡ��ť��
	private JTextField textField_1;
	Calendar calendar = Calendar.getInstance();

	/**
	 * Launch the application.
	 * ���������
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
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
	public mainFrame() {
//		�������������
		setTitle("\u56DB\u5219\u8FD0\u7B97\u751F\u6210");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 261);
		setLocation(350	, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		fileName = "/����������"+calendar.get(Calendar.HOUR_OF_DAY)+"."+
				calendar.get(Calendar.MINUTE)+"."+calendar.get(Calendar.SECOND);
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("��ѡ����Ŀ����");
		label.setFont(new Font("����", Font.BOLD, 12));
		label.setBounds(34, 23, 103, 15);
		panel.add(label);

		JRadioButton choosebtn1 = new JRadioButton("25����Ŀ");

		buttonGroup.add(choosebtn1);
		choosebtn1.setBounds(34, 44, 121, 23);
		panel.add(choosebtn1);
		
		JRadioButton choosebtn2 = new JRadioButton("50����Ŀ");
		choosebtn2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		buttonGroup.add(choosebtn2);
		choosebtn2.setBounds(34, 69, 121, 23);
		panel.add(choosebtn2);
		
		JRadioButton choosebtn3 = new JRadioButton("100����Ŀ");
		choosebtn3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		buttonGroup.add(choosebtn3);       
		choosebtn3.setBounds(34, 94, 121, 23);
		panel.add(choosebtn3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(161, 58, 130, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label2 = new JLabel("��ѡ���ĵ����ɵ�λ��");
		label2.setFont(new Font("����", Font.BOLD, 12));
		label2.setBounds(165, 23, 130, 15);
		panel.add(label2);
		
		JButton open = new JButton("ѡ��");
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc=new JFileChooser();  
		        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY );  
		        jfc.showDialog(new JLabel(), "ѡ���ļ���");  
		        File file=jfc.getSelectedFile();  
		        if (null != file) {
		        	if(file.isDirectory()){  
				          textField_1.setText(file.getAbsolutePath());
				          filePath = textField_1.getText().replaceAll("\\\\", "/");
				          }
				}
		         
			}
		});
		open.setBounds(291, 57, 65, 23);
		panel.add(open);
		
		JButton todo = new JButton("�����ĵ�");
		todo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			isSelectedCheckBox = plus||time||minus||devide;
/*					System.out.println(isSelectedCheckBox);
				WordTest wTest = new WordTest();
				System.out.println(filePath+fileName);
				System.out.println(setMoudel);
				WordTest test = new WordTest();
				try {
					wTest.createWord(filePath,fileName,setMoudel);
				} catch (UnsupportedEncodingException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				try {
					openDic(filePath+fileName);
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}*/
				if(fileName != null && filePath != null && setMoudel != null && isSelectedCheckBox){
					
					WordTest wTest = new WordTest();
					try {
						wTest.createWord(filePath, fileName, setMoudel);
					} catch (UnsupportedEncodingException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(todo, "���ɳɹ� ! ");
					wTest = null;
					try {
						openDic(filePath+fileName);
					} catch (IOException e1) {
						// ���ɳɹ�����ĵ�λ��
						e1.printStackTrace();
					}
					System.gc();
				}
				else {
					System.out.println(isSelectedCheckBox);
					System.out.println(filePath+fileName);
					System.out.println(setMoudel);
					JOptionPane.showMessageDialog(todo, "����ʧ�� ! �����Ƿ�ѡ������ѡ��ť !");
					
				}
			}
		});
		todo.setBounds(263, 180, 93, 23);
		panel.add(todo);
		
		JLabel label_1 = new JLabel("ѡ�����ɵ���Ŀ��Χ");
		label_1.setFont(new Font("����", Font.BOLD, 12));
		label_1.setBounds(34, 123, 121, 15);
		panel.add(label_1);
		
		JCheckBox plus = new JCheckBox("�ӷ�");
		plus.setBounds(34, 144, 56, 23);
		plus.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO �Զ����ɵķ������
				if (plus.isSelected()) {
					mainFrame.plus = true;
				}
				else {
					mainFrame.plus = false;
				}
			}
		});
		panel.add(plus);
		
		JCheckBox minus = new JCheckBox("����");
		minus.setBounds(92, 144, 56, 23);
		minus.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO �Զ����ɵķ������
				if (minus.isSelected()) {
					mainFrame.minus = true;
				}
				else {
					mainFrame.minus = false;
				}
			}
		});
		panel.add(minus);
		
		JCheckBox time = new JCheckBox("�˷�");
		time.setBounds(34, 169, 56, 23);
		time.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO �Զ����ɵķ������
				if (time.isSelected()) {
					mainFrame.time = true;
				}
				else {
					mainFrame.time = false;
				}
			}
		});
		panel.add(time);
		
		JCheckBox devide = new JCheckBox("����");
		devide.setBounds(92, 169, 56, 23);
		devide.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO �Զ����ɵķ������
				if (devide.isSelected()) {
					mainFrame.devide = true;
				}
				else {
					mainFrame.devide = false;
				}
			}
		});
		panel.add(devide);
		
		JCheckBox isdcm = new JCheckBox("����С��");
		isdcm.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO �Զ����ɵķ������
				if (isdcm.isSelected()) {
					mainFrame.isdecimal = true;
				}
				else {
					mainFrame.isdecimal = false;
				}
			}
		});
		isdcm.setBounds(150, 154, 103, 23);
		panel.add(isdcm);
		

		
		choosebtn1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (choosebtn1.isSelected()) {
					setMoudel = "model_25.ftl";
				}
			}
		});
		choosebtn2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (choosebtn2.isSelected()) {
					setMoudel = "model_50.ftl";
				}
			}
		});
		choosebtn3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (choosebtn3.isSelected()) {
					setMoudel = "model_100.ftl";
					}
			}
		});
		

	}
	
	public void openDic(String string) throws IOException{
		File file=new File(string+".doc"); 
		System.out.println(string+".doc");
		Runtime.getRuntime().exec(
		"rundll32 SHELL32.DLL,ShellExec_RunDLL "
		+ "Explorer.exe /select," + file.getAbsoluteFile());
	}
}
