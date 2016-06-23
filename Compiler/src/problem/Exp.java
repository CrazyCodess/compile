package problem;
/**
 * 表达式文法的产生式
 * @author CrazyCodess
 *
 */
public class Exp {
	private char s;
	private char d;
	private char[] exp=new char[5];
	public char getS() {
		return s;
	}
	public void setS(char s) {
		this.s = s;
	}
	public char getD() {
		return d;
	}
	public void setD(char d) {
		this.d = d;
	}
	public char[] getExp() {
		return exp;
	}
	public void setExp(char[] exp) {
		this.exp = exp;
	}
}
