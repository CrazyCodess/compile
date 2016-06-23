package Table;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

/**
 * 算符优先关系表
 * @author CrazyCodess
 *
 */
public class PtyTable {

	char[][] oper = new char[8][8];
	public  PtyTable() throws IOException{
		
		InputStream is=getClass().getClassLoader().getResourceAsStream("doc/OperPrio.txt");
		 BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		
		String table;
		int i=0,j=0;
		while((table=br.readLine())!=null){
			String[] spilt=table.split("\t");
			//System.out.println(spilt[i]);
			for(i=0;i<spilt.length;i++){
				//System.out.println(spilt[i]);
				oper[j][i]=spilt[i].charAt(0);
			}
			j++;
		}
		br.close();
	}
	
	public char queryOper(char op1,char op2){
		int p1=0,p2=0;
		switch (op1) {
		case '+':p1=0;
			break;
		case '-':p1=1;
			break;
		case '*':p1=2;
			break;
		case '/':p1=3;
			break;
		case '(':p1=4;
			break;
		case ')':p1=5;
			break;
		case '#':p1=7;
			break;
		default:p1=-1;
			break;
		}
		switch (op2) {
		case '+':p2=0;
			break;
		case '-':p2=1;
			break;
		case '*':p2=2;
			break;
		case '/':p2=3;
			break;
		case '(':p2=4;
			break;
		case ')':p2=5;
			break;
		case '#':p2=7;
			break;
		default:p2=-1;
			break;
		}
		
		if(p1==-1||p2==-1){
			return '*';
		}else 
		return oper[p1][p2];
	}
	
	

	
	public char[][] getOper() {
		return oper;
	}

	public void setOper(char[][] oper) {
		this.oper = oper;
	}
	
	
}
