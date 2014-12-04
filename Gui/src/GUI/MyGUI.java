package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;




import javax.swing.*;

public class MyGUI extends JFrame implements ActionListener,MyFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel Anspanel,Expanel;
	private JTextField TextField;
	private String formula;
	private JLabel display,explanation;
	//private JTextPane explanation;
	private JPanel Runpanel;
	private JButton Runbutton,button1,button2;
	private Control control;
	private String STR = "0";

	MyGUI(String title,Control control){
		//ウィンドウのタイトル
		super(title);
		this.control = control;
		
		
		//クローズボタンを押したときにアプリケーションが終了することを意味する。
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 250);
		this.setLocationRelativeTo(null);

		panel = new JPanel();//全体のパネル
		Anspanel = new JPanel();//計算結果表示部分
		Expanel = new JPanel();//説明文
		TextField = new JTextField("0",15);//入力用フィールド
		formula = control.First();//最初に出力される文字列
		display = new JLabel(formula);//計算結果表示
		explanation = new JLabel(control.Explanation());
		Anspanel.setPreferredSize(new Dimension(250,25));
		Anspanel.setBackground(Color.white);
		Anspanel.add(display);
		Expanel.setPreferredSize(new Dimension(250,100));
		//Expanel.setBackground();
		Expanel.add(explanation);

		Runpanel = new JPanel();
		Runbutton = new JButton("Run");
		button1 = new JButton("+");
		button2 = new JButton("-");
		
		
		Runpanel.add(Runbutton);
		panel.add(button1);
		panel.add(button2);
		Runbutton.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		//frame.pack();
		panel.add(Anspanel,BorderLayout. NORTH);
		panel.add(TextField,BorderLayout. CENTER);
		panel.add(Runpanel,BorderLayout. SOUTH);
		panel.add(Expanel,BorderLayout. SOUTH);
		this.add(panel);
		this.getContentPane().add(panel);
		//this.setVisible(true);
	}
	public void run(){
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		try{
			String push = ((JButton)e.getSource()).getText();
			if(push.equals("Run")){
				String input = TextField.getText();
				STR = input;
				formula = control.Output(STR);
				display.setText(formula);
			}else if(push.equals("+")){
				STR = String.valueOf(Integer.valueOf(STR).intValue()+1);
				formula = control.Output(STR);
				display.setText(formula);
			}else if(push.equals("-")){
				STR = String.valueOf(Integer.valueOf(STR).intValue()-1);
				formula = control.Output(STR);
				display.setText(formula);
			}
		}catch(Exception E){
			display.setText("計算不可能");
		}
	}

}




