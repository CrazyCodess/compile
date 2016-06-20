package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import org.junit.Test;

public class LexAnaConsole extends JFrame{

	public LexAnaConsole(StringBuffer compileInfo) throws IOException{
		
		setSize(500,250);
		setVisible(true);
		setTitle("¥ ∑®±‡“Î–≈œ¢");
		Container c=getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT));
		//JTextArea text=new JTextArea(250,500);
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
		//c.add(text);
		
		c.setBackground(Color.darkGray);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
/*	@Test
	public void test(){
		new LexAnaConsole("±‡“Î¥ÌŒÛ£°");
	}*/
	public static void main(String[] args) throws IOException {
		new LexAnaConsole(new StringBuffer("±‡“Î¥ÌŒÛ£°"));
	}
}
