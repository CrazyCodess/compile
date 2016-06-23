package problem;
import java.io.IOException;
import java.util.Stack;
import java.util.Vector;

import Table.PreTab;

/**
 * 基于LL(1)文法的预测分析方法的表达式语法分析器
 * @author CrazyCodess
 *
 */
public class PredictExp {	
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
		while(i<len||!stack.empty()){
			if(i>=len){
				buffer=new StringBuffer("compile error! 输入符号串请以#号结尾!");
				break;
			}
			if((char)stack.peek()=='#'){
				if(i>=len){
					System.out.println("no #");
					buffer=new StringBuffer("输入符号串请以#号结尾!");
					break;
				}
				else if(exp.charAt(i)=='#'){
					int j;
					buffer.append("Step\t"+"Rule\t\n");
					vect.add("接受！");
					for(j=0;j<vect.size();j++){
						buffer.append((j+1)+"\t"+(String)vect.get(j)+"\n");
					}
					buffer.append("推导过程:\n"+vect.get(0));
					String[] spilt=new String[2];
					String temp=vect.get(0).split("->")[1];
					for(j=1;j<vect.size()-1;j++){
						spilt=vect.get(j).split("->");
						if(!spilt[0].contains("匹")){
							buffer.append("->");
							if(spilt[1].charAt(0)=='$'){
								temp=temp.replaceFirst(spilt[0],"");
								buffer.append(temp);
							}
								
							else{ 
								temp=temp.replaceFirst(spilt[0], spilt[1]);
								buffer.append(temp);
							
							}
						}

					}
					break;
				}
			}
			pre=preTab.getProduct(exp.charAt(i), (char)stack.peek());
			if(pre==null){
				buffer=new StringBuffer("compiler error! 无法识别该输入符号串！");
				break;
			}
			vect.add((char)stack.pop()+"->"+new String(pre).trim());
			for(int j=pre.length-1;j>=0;j--){
				if(pre[j]!='$')stack.push(pre[j]);
			}
			if((char)stack.peek()==exp.charAt(i)&&exp.charAt(i)!='#'){
				vect.add(exp.charAt(i)+"匹配");
				i++;
				stack.pop();
			}
		}
		return buffer;
	}
}
