package problem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Lex {
	//int token;
	Map<String,Integer> map=new HashMap();
	
	public  Lex() throws IOException{
		String currentPath=getClass().getResource(".").getFile().toString();  
		File file=new File(currentPath+"symtable.properties");
		RandomAccessFile fileInput=new RandomAccessFile(file,"r");
		String table;
		while((table=fileInput.readLine())!=null){
			String[] spilt = table.split("\t");
			map.put(spilt[0], Integer.parseInt(spilt[1]));
		}
	}
	
/*	public Lex(){
		//Lex[] table=new Lex[29]();
		
		//table=;
		//table={"begin","if","then"};
		
	}*/
	public int lexpatt(String lexptr){
		//System.out.println(lexptr);
		//System.out.println(lexptr.length());
		int index=-1;
		lexptr=lexptr.trim();
		//System.out.println(lexptr.length());
		if(map.containsKey(lexptr))
			index=map.get(lexptr);
		return index;
	}
	
	public boolean isExist(String key){
		key=key.trim();
		return map.containsKey(key);
	}
	@Test
	public void test() throws IOException{
		
		
		
		System.out.println(lexpatt("digitdigit*"));
		
	}
	
	
	
	
}
