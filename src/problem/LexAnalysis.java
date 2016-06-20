package problem;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import org.junit.Test;

import view.LexAnaConsole;

public class LexAnalysis {
	
	final static int BUFFERSIZE=128;
	public static void main(String[] args) throws IOException {
		LexAnalysis lexAna=new LexAnalysis();
		String currentPath=lexAna.getClass().getResource(".").getFile().toString();  
		File file=new File(currentPath+"lex.txt");
		RandomAccessFile fileInput=new RandomAccessFile(file,"r");
		StringBuffer compileInfo;
		compileInfo=lexAna.analysis(fileInput);
		new LexAnaConsole(compileInfo);
		fileInput.close();
	}
	public StringBuffer analysis(RandomAccessFile filein) throws IOException{
		char[] lexbuff=new char[BUFFERSIZE];
		Lex lex=new Lex();
		int line=1;
		char t;
		int syn,len,i;
		String temp;
		int cnt=0;
		StringBuffer buffer=new StringBuffer();
		//System.out.println("-----");
		while((temp=filein.readLine())!=null){
			i=0;
			line++;
			len=temp.length();
			
			
			System.out.println(temp+len);
			
			
			cnt=0;
			while(i<len){
				t=temp.charAt(i);
				i++;
				if(t==' '||	t=='\t'){
					continue;
				}
				else if(t==';'){
					
					System.out.println(";");
					
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
					
				else if(Character.isDigit(t)){//Ê¶±ðÊý×Ö
					
					
					
					System.out.println("digit");
					
					
					
					
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
						else if(t==' '||t=='\t'){
							syn=lex.lexpatt("digitdigit*");
							buffer.append("("+syn+","+new String(lexbuff).trim()+")");
							lexbuff=new char[BUFFERSIZE];
							cnt=0;
							break;
						}
						else if(lex.isExist(t+"")){
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
					
					System.out.println("letter");
					System.out.println(t);
					
					if(cnt+1>BUFFERSIZE){
						buffer=new StringBuffer("compiler error!");
						
						return buffer;
					}
					lexbuff[cnt]=t;
					cnt++;
					
					while(i<len){
						
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
						else if(t== ' '||t=='\t'){
							String temp1=new String(lexbuff).trim();
							
							
							System.out.println("error");
							if(temp1.equals("begin")||temp1.equals("if")||temp1.equals("then")||temp1.equals("while")||temp1.equals("do")||temp1.equals("end"));
							else temp1="letter(letter|digit)*";
							syn=lex.lexpatt(temp1);
							buffer.append("("+syn+","+temp1+")");
							lexbuff=new char[BUFFERSIZE];
							System.out.println(buffer);
							cnt=0;
							break;
						}
						else if(lex.isExist(t+"")){
							String temp1=new String(lexbuff).trim();
							
							
							System.out.println("error");
							if(temp1.equals("begin")||temp1.equals("if")||temp1.equals("then")||temp1.equals("while")||temp1.equals("do")||temp1.equals("end"));
							else temp1="letter(letter|digit)*";
							syn=lex.lexpatt(temp1);
							buffer.append("("+syn+","+temp1+")");
							lexbuff=new char[BUFFERSIZE];
							System.out.println(buffer);
							cnt=0;
							i--;
							break;
						}
						else {
							buffer=new StringBuffer("compiler error!");
							//System.out.println("error");
							return buffer;
						}
					}
				}
				else {
					System.out.println("other");
					
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
			}

		return buffer;
		//System.out.println(buffer);
	}
	public void compleError(){
		System.err.println("compiler error!");
		System.exit(0);
	}
	
	@Test
	public void test() throws IOException{
		
		
	}
	
}
