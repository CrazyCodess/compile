package test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String s=input.next();
			Pattern pattern=Pattern.compile(s);
			Matcher matcher = pattern.matcher("begin  if  then  while  do  end");
			StringBuffer sbr=new StringBuffer();
			while(matcher.find()){
				matcher.appendReplacement(sbr, "Java");
			}
			matcher.appendTail(sbr);	
			System.out.println(sbr.toString());
		}
*/	
		new Test().getPath();

		
	}

	public void getPath(){
	       //ȡ�ø�Ŀ¼·��  
	       String rootPath=getClass().getResource("/").getFile().toString();  
	       System.out.println(rootPath);
	       //��ǰĿ¼·��  
	       String currentPath1=getClass().getResource(".").getFile().toString();  
	       System.out.println(currentPath1);
	       String currentPath2=getClass().getResource("").getFile().toString();  
	       //��ǰĿ¼���ϼ�Ŀ¼·��  
	       System.out.println(currentPath2);
	       String parentPath=getClass().getResource("../").getFile().toString();
	       System.out.println(parentPath);
	}
}
