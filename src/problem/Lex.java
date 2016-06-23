package problem;
import java.io.File;
import java.io.IOException;
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
		String currentPath=getClass().getResource("../").getFile().toString();  
		File file=new File(currentPath+"/doc/symtable.properties");
		RandomAccessFile fileInput=new RandomAccessFile(file,"r");
		String table;
		while((table=fileInput.readLine())!=null){
			String[] spilt = table.split("\t");
			map.put(spilt[0], Integer.parseInt(spilt[1]));
		}
		fileInput.close();
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
