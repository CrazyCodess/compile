package Table;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

/**
 * 初始化编码表
 * @author CrazyCodess
 *
 */
public class Lex {
	//int token;
	Map<String,Integer> map=new HashMap();
	
	public  Lex() throws IOException{
		
		InputStream is=getClass().getClassLoader().getResourceAsStream("config/symtable.properties");
		 BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String table;
		while((table=br.readLine())!=null){
			String[] spilt = table.split("\t");
			map.put(spilt[0], Integer.parseInt(spilt[1]));
		}
		br.close();
	}
	/**
	 * 根据单词符号返回种别码
	 * @param lexptr
	 * @return
	 */
	public int lexpatt(String lexptr){
		int index=-1;
		lexptr=lexptr.trim();
		if(map.containsKey(lexptr))
			index=map.get(lexptr);
		return index;
	}
	
	public boolean isExist(String key){
		key=key.trim();
		return map.containsKey(key);
	}	
}
