package problem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class StateLexAna {
	
	
	public static final int BUFFERSIZE=128;
	
	
/*	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StateLexAna stateLex = new StateLexAna();
		String currentPath=stateLex.getClass().getResource("../").getFile().toString();  
		File file=new File(currentPath+"/doc/statement.txt");
		RandomAccessFile fileInput=new RandomAccessFile(file,"r");
		String state=fileInput.readLine();
		fileInput.close();
		StringBuffer buffer=stateLex.statementAna(state);
		//new LexAnaConsole(buffer,"说明语句的词法分析器",440,440);
	}*/
	
	/**
	 * @param state
	 * @return
	 */
	public StringBuffer statementAna(String state){
		int[] type = new int[4];
		Vector vect = new Vector();
		char[] stateBuff=new char[BUFFERSIZE];
		StringBuffer buffer=new StringBuffer();
		int len=state.length();
		int i=0,cnt=0;
		char[] string=new char[BUFFERSIZE];
		char ch;
		boolean isVar=true;
		String[] spilt = state.split(" ");
		if(!spilt[0].equals("const")){
			buffer=new StringBuffer("It is not a constant declaration statement!\nPlease input a string again!\n");
			
			return buffer;
		}
		i=state.indexOf("const")+6;
		while(i<len){
			ch=state.charAt(i);
			if(Character.isLetter(ch)){
				isVar=true;
				while(i<len&&ch!='='){
					if(!Character.isLetterOrDigit(ch)&&ch!='_'&&isVar)isVar=false;
					stateBuff[cnt]=ch;
					cnt++;
					i++;
					ch=state.charAt(i);
				}
				if(i<len-1)i++;
				System.out.println("i=="+i);
				ch=state.charAt(i);
				if(isVar){
					if(ch=='\''){
						if((i+2)<len&&state.charAt(i+2)=='\''){
							buffer.append(new String(stateBuff).trim()+"(char,'"+state.charAt(i+1)+"')\n");
							stateBuff=new char[BUFFERSIZE];
							cnt=0;
							while(state.charAt(i)!=','&&state.charAt(i)!=';'&&i<len)i++;
							type[1]++;
						}
						else {
							buffer.append(new String(stateBuff).trim()+"(Wrong! There are  more than one char in ''.)\n");
							stateBuff=new char[BUFFERSIZE];
							cnt=0;
							while(state.charAt(i)!=','&&state.charAt(i)!=';'&&i<len)i++;
						}
					}
					else if(ch=='\"'){
						int j=0;
						string=new char[BUFFERSIZE];
						i++;
						ch=state.charAt(i);
						while(i<len&&ch!='\"'){
							string[j]=ch;
							j++;
							i++;
							ch=state.charAt(i);
						}
						buffer.append(new String(stateBuff).trim()+"(string,\""+new String(string).trim()+"\")\n");
						stateBuff=new char[BUFFERSIZE];
						cnt=0;
						type[2]++;
						while(state.charAt(i)!=','&&state.charAt(i)!=';'&&i<len)i++;
						
					}
					else if(Character.isDigit(ch)){
						int num=0;
						double fnum;
						
						double j=0.1;
						while(ch!='.'&&ch!=','&&ch!=';'&&i<len){
							num=num*10+ch-'0';
							System.out.println("num="+num+" ch="+ch);
							i++;
							ch=state.charAt(i);
							
						}
						
						if(ch=='.'){
							i++;
							fnum=num+0.0;
							ch=state.charAt(i);
							while(ch!=','&&ch!=';'&&i<len){
								fnum+=(ch-'0')*j;
								j*=0.1;
								i++;
								ch=state.charAt(i);
							}
							buffer.append(new String(stateBuff).trim()+"(float,"+fnum+")\n");
							stateBuff=new char[BUFFERSIZE];
							cnt=0;
							type[3]++;
						}else {
							buffer.append(new String(stateBuff).trim()+"(integer,"+num+")\n");
							stateBuff=new char[BUFFERSIZE];
							cnt=0;
							type[0]++;
						}
					}
				}
				else{
					buffer.append(new String(stateBuff).trim()+"(Wrong! It is not a identifier!)\n");
					stateBuff=new char[BUFFERSIZE];
					cnt=0;
					while(state.charAt(i)!=','&&state.charAt(i)!=';'&&i<len)i++;
				}
			}
			else if(ch==','||ch==';'||ch==' '||ch=='\t')i++;
			else{
				//stateBuff[cnt] = ch;
				//cnt++;
				//i++;
				while(i<len&&ch!='='){
					stateBuff[cnt]=ch;
					cnt++;
					i++;
					ch=state.charAt(i);
				}
				buffer.append(new String(stateBuff).trim()+"(Wrong! It is not a identifier!)\n");
				stateBuff=new char[BUFFERSIZE];
				cnt=0;
				while(state.charAt(i)!=','&&state.charAt(i)!=';'&&i<len)i++;
			}
		}
		
		buffer.append("int_num="+type[0]+";  char_num="+type[1]+"; string_num="+type[2]+"; float_num="+type[3]);
		
		return buffer;
		
	}
}
