package problem;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Ԥ�������
 * @author CrazyCodess
 *
 */
public class PreTab {

	Exp[] preTable=new Exp[13];
	public PreTab() throws IOException{//���췽����ʼ��Ԥ�������
		String currentPath=getClass().getResource("../").getFile().toString();  
		System.out.println(currentPath);
		File file=new File(currentPath+"/doc/expPro.txt");
		RandomAccessFile fileInput=new RandomAccessFile(file,"r");
		String table;
		int i=0;
		while((table=fileInput.readLine())!=null){
			String[] spilt=table.split(",");
			Exp exp=new Exp();
			exp.setS(spilt[1].charAt(0));
			exp.setD(spilt[0].charAt(0));
			exp.setExp(spilt[2].toCharArray());
			preTable[i]=exp;
			i++;
		}
		fileInput.close();
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
		for(int i=0;i<13;i++){
			if(products[i].getS()==s&&products[i].getD()==d){
				
				return products[i].getExp();
			}
		}
		return null;
	}
}
