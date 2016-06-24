package Table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

import problem.Exp;
/**
 * 表达式的预测分析表
 * @author CrazyCodess
 *
 */
public class OperTab {
	Exp[] preTable=new Exp[20];
	
	public OperTab() throws IOException{//构造方法初始化预测分析表
		InputStream is=getClass().getClassLoader().getResourceAsStream("config/oper.txt");
		 BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String table;
		int i=0;
		while((table=br.readLine())!=null){
			String[] spilt=table.split(",");
			Exp exp=new Exp();
			exp.setS(spilt[1].charAt(0));
			exp.setD(spilt[0].charAt(0));
			exp.setExp(spilt[2].toCharArray());
			preTable[i]=exp;
			i++;
		}
		br.close();
	}
	
	
	
	public Exp[] getPreTable() {
		return preTable;
	}



	public void setPreTable(Exp[] preTable) {
		this.preTable = preTable;
	}

	public char[] getProduct(char d,char s){
		Exp[] products=getPreTable();
		String exp=null;
		for(int i=0;i<20;i++){
			if(products[i].getS()==s&&products[i].getD()==d){
				
				return products[i].getExp();
			}
		}
		return null;
	}

	@Test
	public void test() throws IOException{
		OperTab tab=new OperTab();
		for(int i=0;i<20;i++){
			System.out.println(tab.getPreTable()[i].getD()+","+tab.getPreTable()[i].getS()
					+","+new String(tab.getPreTable()[i].getExp()).trim());
		}
	}
}
