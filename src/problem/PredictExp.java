package problem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Stack;
import java.util.Vector;

import view.LexAnaConsole;

public class PredictExp {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PredictExp preExp=new PredictExp();
		String currentPath=preExp.getClass().getResource("../").getFile().toString();  
		File file=new File(currentPath+"/doc/exp.txt");
		RandomAccessFile fileInput=new RandomAccessFile(file,"r");
		String exp;
		exp=fileInput.readLine();
		fileInput.close();
		StringBuffer buffer;
		buffer=preExp.predict(exp);
		System.out.println(buffer);
		new LexAnaConsole(buffer);
	}
	
	public  StringBuffer predict(String exp) throws IOException{
		PreTab  preTab=new PreTab();
		Stack stack = new Stack();
		Vector<String> vect = new Vector();
		StringBuffer buffer=new StringBuffer();
		int i=0;
		char[] pre=new char[5]; 
		int len=exp.length();
		stack.push('#');
		stack.push('S');
		while(i<len){
			if(exp.charAt(i)=='#'){
				//System.out.println("top"+(char)stack.pop());
				//System.out.println("top"+(char)stack.peek());
				if((char)stack.peek()=='#'){
					vect.add("接受！");
					for(int j=0;j<vect.size();j++){
						buffer.append("第"+(j+1)+"步使用的产生式："+(String)vect.get(j)+"\n");
					}
					break;
				}
			}
			pre=preTab.getProduct(exp.charAt(i), (char)stack.peek());
			//System.out.println(exp.charAt(i)+"...."+(char)stack.peek());
			if(pre==null){
				System.out.println("null");
				buffer=new StringBuffer("compiler error!");
				break;
			}
			System.out.println(new String(pre));
			vect.add((char)stack.pop()+"->"+new String(pre).trim());
			for(int j=pre.length-1;j>=0;j--){
				if(pre[j]!='$')stack.push(pre[j]);
			}
			if((char)stack.peek()==exp.charAt(i)&&exp.charAt(i)!='#'){
				System.out.println("pop"+(char)stack.peek());
				vect.add(exp.charAt(i)+"匹配");
				i++;
				stack.pop();
			}
		}
		
		
		return buffer;
	}
	
	
	
	
	

}
