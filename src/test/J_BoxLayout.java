package test;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.sun.xml.internal.ws.api.server.Container;

public class J_BoxLayout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame app=new JFrame("�в���");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(220, 130);
		java.awt.Container c=app.getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.X_AXIS));
		String s;
		JButton b;
		for(int i=0;i<10;i++){
			s="��ť"+(i+1);
			b=new JButton(s);
			c.add(b);
			
		}
		app.setVisible(true);
	}

}
