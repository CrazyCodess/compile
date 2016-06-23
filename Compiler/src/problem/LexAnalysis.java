package problem;
import java.io.IOException;

import Table.Lex;

/**
 * 词法分析
 * @author CrazyCodess
 *
 */
public class LexAnalysis {
	
	final static int BUFFERSIZE=256;
	public StringBuffer analysis(String temp) throws IOException{
		temp=temp+" ";
		char[] lexbuff=new char[BUFFERSIZE];
		Lex lex=new Lex();
		int line=1;
		char t;
		int syn,len,i;
		int cnt=0;
		StringBuffer buffer=new StringBuffer();
			i=0;
			line++;
			len=temp.length();
			cnt=0;
			while(i<len){
				t=temp.charAt(i);
				i++;
				if(t==' '||	t=='\t'){
					continue;
				}
				else if(t==';'){
					
					//System.out.println(";");
					
						//cnt++;
						if(cnt+1>BUFFERSIZE){
							buffer=new StringBuffer("compiler error!");
							return buffer;
						}
						lexbuff[cnt]=t;
						cnt++;
						syn=lex.lexpatt(String.valueOf(lexbuff));
						buffer.append("("+syn+","+new String(lexbuff).trim()+")");
						lexbuff=new char[BUFFERSIZE];
						cnt=0;
					continue;
				}
					
				else if(Character.isDigit(t)){//识别数字
					
					lexbuff[cnt]=t;
					if(cnt+1>BUFFERSIZE){
						buffer=new StringBuffer("compiler error!");
						return buffer;
					}
					cnt++;
					while(i<len){
						t=temp.charAt(i);
						i++;
						if(Character.isDigit(t)){
							if(cnt+1>BUFFERSIZE){
								buffer=new StringBuffer("compiler error!");
								return buffer;
							}
							lexbuff[cnt]=t;
							cnt++;
							
							
						}
						else if(Character.isLetter(t)){
							buffer=new StringBuffer("compiler error!");
							return buffer;
							
						}
						else if(t==' '||t=='\t'||i>=len){//遇到分隔符
							syn=lex.lexpatt("digitdigit*");
							buffer.append("("+syn+","+new String(lexbuff).trim()+")");
							lexbuff=new char[BUFFERSIZE];
							cnt=0;
							break;
						}
						else if(lex.isExist(t+"")){//遇到特殊符号，分隔符作用
							syn=lex.lexpatt("digitdigit*");
							buffer.append("("+syn+","+new String(lexbuff).trim()+")");
							lexbuff=new char[BUFFERSIZE];
							cnt=0;
							//filein.seek(filein.getFilePointer()-2);
							i--;
							break;
						}
						else{
							buffer=new StringBuffer("compiler error!");
							return buffer;
						}
					}
					
				}
				else if(Character.isLetter(t)){
					
					//System.out.println("letter");
					//System.out.println(t);
					
					if(cnt+1>BUFFERSIZE){
						buffer=new StringBuffer("compiler error!");
						
						return buffer;
					}
					lexbuff[cnt]=t;
					cnt++;
					while(i<len){
						System.out.println("letter");
						t=(char)temp.charAt(i);
						i++;
						if(Character.isLetterOrDigit(t)){
							if(cnt+1>BUFFERSIZE){
								buffer=new StringBuffer("compiler error!");
								
								return buffer;
							}
							lexbuff[cnt]=t;
							cnt++;
						}
						else if(t== ' '||t=='\t'||i>=len){
							String temp1=new String(lexbuff).trim();
							
							
							//System.out.println("error");
							if(temp1.equals("begin")||temp1.equals("if")||temp1.equals("then")||temp1.equals("while")||temp1.equals("do")||temp1.equals("end"));
							else temp1="letter(letter|digit)*";
							syn=lex.lexpatt(temp1);
							buffer.append("("+syn+","+new String(lexbuff).trim()+")");
							lexbuff=new char[BUFFERSIZE];
							//System.out.println(buffer);
							cnt=0;
							break;
						}
						else if(lex.isExist(t+"")){
							String temp1=new String(lexbuff).trim();
							
							
							//System.out.println("error");
							if(temp1.equals("begin")||temp1.equals("if")||temp1.equals("then")||temp1.equals("while")||temp1.equals("do")||temp1.equals("end"));
							else temp1="letter(letter|digit)*";
							syn=lex.lexpatt(temp1);
							buffer.append("("+syn+","+new String(lexbuff).trim()+")");
							lexbuff=new char[BUFFERSIZE];
							//System.out.println(buffer);
							cnt=0;
							i--;
							break;
						}
						else {
							buffer=new StringBuffer("compiler error!");
							return buffer;
						}
					}
					
/*					
					String temp1=new String(lexbuff).trim();
					
					
					//System.out.println("error");
					if(temp1.equals("begin")||temp1.equals("if")||temp1.equals("then")||temp1.equals("while")||temp1.equals("do")||temp1.equals("end"));
					else temp1="letter(letter|digit)*";
					syn=lex.lexpatt(temp1);
					buffer.append("("+syn+","+new String(lexbuff).trim()+")");
					lexbuff=new char[BUFFERSIZE];
					//System.out.println(buffer);
					cnt=0;*/
					
				}
				else {
					//System.out.println("other");
					
					lexbuff[cnt]=t;
					cnt++;
					if(lex.isExist(String.valueOf(lexbuff))){
						if(i<len-1){
							t=temp.charAt(i);
							i++;
							if(t=='='||t=='>'){
								lexbuff[cnt]=t;
								cnt++;
								syn=lex.lexpatt(String.valueOf(lexbuff));
								buffer.append("("+syn+","+new String(lexbuff).trim()+")");
								lexbuff=new char[BUFFERSIZE];
								cnt=0;
							}else{
								syn=lex.lexpatt(String.valueOf(lexbuff));
								buffer.append("("+syn+","+new String(lexbuff).trim()+")");
								lexbuff=new char[BUFFERSIZE];
								cnt=0;
								i--;
							}
						}else{
							syn=lex.lexpatt(String.valueOf(lexbuff));
							buffer.append("("+syn+","+new String(lexbuff).trim()+")");
							lexbuff=new char[BUFFERSIZE];
							cnt=0;
						}


					}
					else {
						buffer=new StringBuffer("compiler error!");
						return buffer;
					}
				}
			}
			
/*			if(lexbuff[0]!=' '){
				syn=lex.lexpatt(String.valueOf(lexbuff));
				buffer.append("("+syn+","+new String(lexbuff).trim()+")");
			}*/
		return buffer;
	}
	
	
}
