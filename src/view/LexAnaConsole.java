package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.junit.Test;

import javafx.scene.text.Font;

public class LexAnaConsole  implements ActionListener {

	
	 JFrame jf;
	 JPanel jpanel;
	 //JButton jb1, jb2, jb3;
	 JTextArea jta = null;
	 JScrollPane jscrollPane;
	public LexAnaConsole(StringBuffer compileInfo,String title,int height,int width) throws IOException{
		

		/*setSize(400, 300);
		setLocation(400, 200);
		setVisible(true);
		setTitle("词法编译信息");
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		text=new JTextArea(new String(compileInfo),10,15);
		text.setTabSize(4);
		text.setFont(new java.awt.Font("Dialog", 1, 15));
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setBackground(Color.darkGray);
		//text.setText();
		text.setForeground(Color.white);
		JScrollPane jscrollPane = new JScrollPane(text);
		  
		  
		//JTextArea text=new JTextArea(250,1500);
		JLabel aLabel= new JLabel(new String(compileInfo));
		//text.setFont(new java.awt.Font("Dialog", 1, 15));
		//text.setForeground(Color.white);
		//text.append(new String(compileInfo));
		aLabel.setHorizontalTextPosition(JLabel.LEFT);
		aLabel.setForeground(Color.white);
		aLabel.setFont(new java.awt.Font("Dialog", 1, 15));
		aLabel.setVerticalTextPosition(JLabel.TOP);
		aLabel.setAutoscrolls(true);
		c.add(aLabel);
		c.add(jscrollPane, BorderLayout.CENTER);
		//c.add(jpanel, BorderLayout.SOUTH);
		c.setBackground(Color.darkGray);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		
		
		 jf = new JFrame(title);
		  Container contentPane = jf.getContentPane();
		  contentPane.setLayout(new BorderLayout());

		  jta = new JTextArea(10, 30);
		  jta.setTabSize(4);
		  jta.setFont(new java.awt.Font("Dialog", 1, 15));
		  jta.setLineWrap(true);// 激活自动换行功能
		  jta.setWrapStyleWord(true);// 激活断行不断字功能
		  jta.setBackground(Color.darkGray);
		  jta.setText(new String(compileInfo));
		  jta.setForeground(Color.white);
		  jscrollPane = new JScrollPane(jta);
		  jpanel = new JPanel();
		  jpanel.setLayout(new GridLayout(1, 3));

/*		  jb1 = new JButton("复制");
		  jb1.addActionListener(this);
		  jb2 = new JButton("粘贴");
		  jb2.addActionListener(this);
		  jb3 = new JButton("剪切");
		  jb3.addActionListener(this);

		  jpanel.add(jb1);
		  jpanel.add(jb2);
		  jpanel.add(jb3);*/

		  contentPane.add(jscrollPane, BorderLayout.CENTER);
		  contentPane.add(jpanel, BorderLayout.SOUTH);

		  jf.setSize(width, height);
		  jf.setLocation(400, 200);
		  jf.setVisible(true);

		  jf.addWindowListener(new WindowAdapter() {
		   public void windowClosing(WindowEvent e) {
		    System.exit(0);
		   }
		  });

	}
	
/*	 public void actionPerformed(ActionEvent e) {
		  if (e.getSource() == jb1) {
		   jta.copy();
		  } else if (e.getSource() == jb2) {
		   jta.paste();
		  } else if (e.getSource() == jb3) {
		   jta.cut();
		  }
		 }*/
/*	@Test
	public void test(){
		new LexAnaConsole("编译错误！");
	}*/
	public static void main(String[] args) throws IOException {
		new LexAnaConsole(new StringBuffer("编译错误！"),"测试",50,50);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
