package problem;

import java.io.IOException;
import java.util.Stack;
/**
 * 算符优先的表达式语法分析
 * @author CrazyCodess
 *
 */
public class Arithmetic {
	
	public StringBuffer arith(String exp) throws IOException{
		System.out.println(exp);
		StringBuffer buffer = new StringBuffer();
		PtyTable pTab = new PtyTable();
		Stack oper=new Stack();
		Stack opnd=new Stack();
		oper.push('#');
		int i=0,len,num,j;
		len=exp.length();
		char ch;
		char p,op1;
		boolean isAcce=false;
		while(i<len){
			ch=exp.charAt(i);
			//System.out.println(ch);
			if(Character.isDigit(ch)){
				//num=0;
				//opnd.push(ch-'0');
				//System.out.println(ch);
				num=0;
				//i++;
				//ch=exp.charAt(i);
				
				while(Character.isDigit(ch)){
					//System.out.println(ch);
					num=num*10+ch-'0';
					i++;
					if(i>=len)break;
					ch=exp.charAt(i);
					
				}
				opnd.push(num);
			}
			else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='('||ch==')'||ch=='#'){
				//System.out.println(ch);
				op1=(char) oper.peek();
				p=pTab.queryOper(op1, ch);
				if(p=='<'){
					oper.push(ch);
					i++;
				}
				else if (p=='='){
					if(ch=='#'){
						isAcce=true;
						break;
					}else{
						oper.pop();
					}
					i++;
				}
				else if(p=='>'){
					if(opnd.size()<2){
						buffer=new StringBuffer("The expression is error!");
						return buffer;
					}
					int b=(int) opnd.pop();
					int a=(int) opnd.pop();
					char op=(char) oper.pop();
					int sum=0;
					switch(op){
					case '+':sum=a+b;
					break;
					case '-':sum=a-b;
						break;
					case '*':sum=a*b;
						break;
					case '/':sum=a/b;
						break;
					}
					opnd.push(sum);
				}else{
					buffer=new StringBuffer("The expression is error!");
					return buffer;
				}
			}
			else{
				buffer=new StringBuffer("The expression is error!");
				return buffer;
			}
		}
		if(isAcce)
		buffer.append(opnd.pop());
		else buffer=new StringBuffer("The expression is error!");
		return buffer;
		
	}
	public static void main(String[] args) throws IOException {
		Arithmetic arith=new Arithmetic();
		System.out.println(arith.arith("5*5"));
	}
}
