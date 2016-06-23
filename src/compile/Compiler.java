package compile;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import problem.Arithmetic;
import problem.LexAnalysis;
import problem.PredictExp;
import problem.StateLexAna;
/**
 * 小型编译器
 * @author CrazyCodess
 *
 */
public class Compiler  {

	
	  JFrame jf;
	  JPanel jpanel;
	 //JButton jb1, jb2, jb3;
	  JTextArea jta = null;
	  JScrollPane jscrollPane;
	  JMenu jm;
	  JMenuBar mBr;
	  JTextArea topText;
	public Compiler(String title,int height,int width) throws IOException{
		 mBr=new JMenuBar();
		 mBr.setBackground(Color.darkGray);
		 jf = new JFrame(title);
		 jf.setJMenuBar(mBr);
		 jm=new JMenu("编译选项");
		 
		 JMenuItem[] item = {new JMenuItem("普通词法分析"),new JMenuItem("说明语句词法分析"),new JMenuItem("表达式语法分析"),
				 new JMenuItem("算符优先表达式语法分析"),new JMenuItem("清空")};
		 //jm.add(item[0]);
		 //jm.add(item[1]);
		 for(int i=0;i<item.length;i++){
			 jm.add(item[i]);
		 }
		 
		 item[4].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clear();
			}
		});
		 
		 item[3].addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//clear();
				try {
					compile(3);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		 
		 
		 item[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					System.out.println("点击了");
					compile(0);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		 item[1].addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					System.out.println("点击了");
					compile(1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		 item[2].addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					System.out.println("点击了");
					compile(2);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		 //jm.setBackground(Color.WHITE);
		 jm.setForeground(Color.WHITE);
		 mBr.add(jm);
		 //jf.setUndecorated(true); 
		  Container contentPane = jf.getContentPane();
		  contentPane.setLayout(new GridLayout(2,1));
		  topText=new JTextArea(10,30);
		  topText.setFont(new java.awt.Font("Dialog", 1, 15));
		  topText.setLineWrap(true);
		  topText.setWrapStyleWord(true);
		  topText.setBackground(Color.darkGray);
		  topText.setForeground(Color.white);
		  topText.setTabSize(4);
		  jta = new JTextArea(10, 30);
		  jta.setTabSize(4);
		  jta.setFont(new java.awt.Font("Dialog", 1, 15));
		  jta.setLineWrap(true);// 激活自动换行功能
		  jta.setWrapStyleWord(true);// 激活断行不断字功能
		  jta.setBackground(Color.darkGray);
		  jta.setText("编译信息：\n");
		  jta.setForeground(Color.white);
		  jscrollPane = new JScrollPane(jta);
		  JScrollPane jscp=new JScrollPane(topText);
		  contentPane.add(jscp); //, BorderLayout.NORTH
		  contentPane.add(jscrollPane);
		  //contentPane.add(myCursor);
		  jf.setSize(width, height);
		  jf.setLocation(400, 200);
		  jf.setVisible(true);
		  
		  jf.addWindowListener(new WindowAdapter() {
		   public void windowClosing(WindowEvent e) {
		    System.exit(0);
		   }
		  });

	}	
	public void clear(){
		topText.setText("");
		jta.setText("编译信息：\n");
	}
	
	
	public void compile(int type) throws IOException{
		String temp=topText.getText();
		StringBuffer buffer=new StringBuffer();
		switch(type){
			case 0:LexAnalysis anaSis=new LexAnalysis();
				buffer=anaSis.analysis(temp);
				break;
			case 1:
				StateLexAna lexAna=new StateLexAna();
				buffer=lexAna.statementAna(temp);
				break;
			case 2:
				PredictExp preExp=new PredictExp();
				buffer=preExp.predict(temp);
				break;
			case 3:Arithmetic arithm=new Arithmetic();
				buffer=arithm.arith(temp);
				break;
		}
		
		
		//=preExp.predict(exp);
		System.out.println(buffer);
		jta.setText("编译信息：\n");;
		jta.append(buffer.toString());//buffer.toString()
	}
	public static void main(String[] args) throws IOException {
		new Compiler("小型编译器",500,500);/*new StringBuffer("编译错误！"),"测试",500,500*/
	}
}
