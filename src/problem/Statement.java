package problem;

/**
 * 变量登记表
 * @author CrazyCodess
 *
 */
public class Statement {

	private String id=new String();
	private char[] type=new char[10];	
	private String value = new String();
	
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public char[] getType() {
		return type;
	}



	public void setType(char[] type) {
		this.type = type;
	}



	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}
}
