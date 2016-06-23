package problem;

import java.io.IOException;
import java.util.Stack;
import Table.OperTab;
public class JudgeExp {

	public  boolean judge(String exp) throws IOException{
		boolean isExp=true,isNum=false;
		OperTab  operTab=new OperTab();
		Stack stack = new Stack();
		char ch;
		int i=0;
		char[] oper=new char[5]; 
		int len=exp.length();
		stack.push('#');
		stack.push('E');
		while(i<len||!stack.empty()){
			if(i>=len){
				isExp=false;
				break;
			}
			if((char)stack.peek()=='#'){
				if(i>=len){
					System.out.println("no #");
					isExp=false;
					break;
				}
				else if(exp.charAt(i)=='#'){
					int j;

					break;
				}
			}
			ch=exp.charAt(i);
			isNum=false;
			while(Character.isDigit(ch)){
				
				i++;
				ch=exp.charAt(i);
				isNum=true;
			}
			if(isNum){
				ch='i';
				i--;
			}
			
			oper=operTab.getProduct(ch, (char)stack.peek());
			
			if(oper==null){
				isExp=false;
				break;
			}
			//System.out.println(new String(oper).trim());
			stack.pop();
			for(int j=oper.length-1;j>=0;j--){
				if(oper[j]!='$')stack.push(oper[j]);
			}
			if(((char)stack.peek()=='i'&&Character.isDigit(exp.charAt(i)))||(char)stack.peek()==exp.charAt(i)&&exp.charAt(i)!='#'){
				//vect.add(exp.charAt(i)+"匹配");
				System.out.println(exp.charAt(i)+"匹配");

				i++;
				stack.pop();
			}
		}
		return isExp;
	}
	
	public static void main(String[] args) throws IOException {
		JudgeExp jexp=new JudgeExp();
		if(jexp.judge("1-2+3#")){
			System.out.println("合法");
		}
		else{
			System.out.println("不合法");
		}
	}
}
