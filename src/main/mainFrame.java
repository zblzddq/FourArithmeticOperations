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
	private final ButtonGroup buttonGroup = new ButtonGroup();    //定义单选按钮组
	private JTextField textField_1;
	Calendar calendar = Calendar.getInstance();

	/**
	 * Launch the application.
	 * 主函数入口
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
//		定义变量及设置
		setTitle("\u56DB\u5219\u8FD0\u7B97\u751F\u6210");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 261);
		setLocation(350	, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		fileName = "/四则运算题"+calendar.get(Calendar.HOUR_OF_DAY)+"."+
				calendar.get(Calendar.MINUTE)+"."+calendar.get(Calendar.SECOND);
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("请选择题目数量");
		label.setFont(new Font("宋体", Font.BOLD, 12));
		label.setBounds(34, 23, 103, 15);
		panel.add(label);

		JRadioButton choosebtn1 = new JRadioButton("25道题目");

		buttonGroup.add(choosebtn1);
		choosebtn1.setBounds(34, 44, 121, 23);
		panel.add(choosebtn1);
		
		JRadioButton choosebtn2 = new JRadioButton("50道题目");
		choosebtn2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		buttonGroup.add(choosebtn2);
		choosebtn2.setBounds(34, 69, 121, 23);
		panel.add(choosebtn2);
		
		JRadioButton choosebtn3 = new JRadioButton("100道题目");
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
		
		JLabel label2 = new JLabel("请选择文档生成的位置");
		label2.setFont(new Font("宋体", Font.BOLD, 12));
		label2.setBounds(165, 23, 130, 15);
		panel.add(label2);
		
		JButton open = new JButton("选择");
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc=new JFileChooser();  
		        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY );  
		        jfc.showDialog(new JLabel(), "选择文件夹");  
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
		
		JButton todo = new JButton("生成文档");
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
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				try {
					openDic(filePath+fileName);
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}*/
				if(fileName != null && filePath != null && setMoudel != null && isSelectedCheckBox){
					
					WordTest wTest = new WordTest();
					try {
						wTest.createWord(filePath, fileName, setMoudel);
					} catch (UnsupportedEncodingException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(todo, "生成成功 ! ");
					wTest = null;
					try {
						openDic(filePath+fileName);
					} catch (IOException e1) {
						// 生成成功后打开文档位置
						e1.printStackTrace();
					}
					System.gc();
				}
				else {
					System.out.println(isSelectedCheckBox);
					System.out.println(filePath+fileName);
					System.out.println(setMoudel);
					JOptionPane.showMessageDialog(todo, "生成失败 ! 请检查是否勾选所有需选按钮 !");
					
				}
			}
		});
		todo.setBounds(263, 180, 93, 23);
		panel.add(todo);
		
		JLabel label_1 = new JLabel("选择生成的题目范围");
		label_1.setFont(new Font("宋体", Font.BOLD, 12));
		label_1.setBounds(34, 123, 121, 15);
		panel.add(label_1);
		
		JCheckBox plus = new JCheckBox("加法");
		plus.setBounds(34, 144, 56, 23);
		plus.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				if (plus.isSelected()) {
					mainFrame.plus = true;
				}
				else {
					mainFrame.plus = false;
				}
			}
		});
		panel.add(plus);
		
		JCheckBox minus = new JCheckBox("减法");
		minus.setBounds(92, 144, 56, 23);
		minus.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				if (minus.isSelected()) {
					mainFrame.minus = true;
				}
				else {
					mainFrame.minus = false;
				}
			}
		});
		panel.add(minus);
		
		JCheckBox time = new JCheckBox("乘法");
		time.setBounds(34, 169, 56, 23);
		time.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				if (time.isSelected()) {
					mainFrame.time = true;
				}
				else {
					mainFrame.time = false;
				}
			}
		});
		panel.add(time);
		
		JCheckBox devide = new JCheckBox("除法");
		devide.setBounds(92, 169, 56, 23);
		devide.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				if (devide.isSelected()) {
					mainFrame.devide = true;
				}
				else {
					mainFrame.devide = false;
				}
			}
		});
		panel.add(devide);
		
		JCheckBox isdcm = new JCheckBox("包含小数");
		isdcm.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
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
