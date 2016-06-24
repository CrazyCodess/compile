package test;

import java.util.Scanner;
/**
 * 实验一
 * @author huang
 *
 */
public class LexicalAnalysis {
	
	static int length = 1000;
	static String input[] = new String[length];
	String analysis[] = new String[length];
	static int p;
	static int syn;
	static int num;
	static String token = "";
	static String order[] = { "begin", "if", "then", "while", "do", "end" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入源程序：");
		p = 0;
		while (sc.hasNext()) {
			input[p] = sc.next();
			String in = input[p];
			if (in.charAt(in.length() - 1) == '#')
				break;
			p++;
		}
		Analy();
	}

	private static void Analy() {
		// TODO Auto-generated method stub
		for (int i = 0; i <= p; i++) {

			lex(input[i]);

		}
	}

	private static void lex(String s) {
		// TODO Auto-generated method stub
		for (int i = 0; i < s.length();) {
			boolean flag1 = false; // 对标识符的识别
			if (Character.isLetter(s.charAt(i))) {
				while (Character.isLetterOrDigit(s.charAt(i))) {
					token = token.concat(String.valueOf(s.charAt(i)));
					if (i == s.length() - 1) {
						flag1 = true;
						break;
					}
					i++;
				}
				if (flag1 == false)
					i--;
				boolean flag = false;
				for (int j = 0; j < order.length; j++) {
					if (token.equals(order[j])) {
						syn = j + 1;
						System.out.println("(" + syn + "," + token + ")");
						token = "";
						flag = true;
					}
				}
				if (flag == false) {
					syn = 10;
					System.out.println("(" + syn + ",'" + token + "')");
					token = "";
				}
				if (i == s.length() - 1)
					break;
				i++;
				continue;
			}

			if (s.charAt(i) == '#') { // 对#的识别
				syn = 0;
				token = String.valueOf(s.charAt(i));
				System.out.println("(" + syn + "," + token + ")");
				token = "";
				if (i == s.length() - 1)
					break;
				i++;
				continue;
			}

			boolean flag2 = false;
			if (Character.isDigit(s.charAt(i))) { // 判断当前是否为数字
				while (Character.isDigit(s.charAt(i))) {
					token = token.concat(String.valueOf(s.charAt(i)));
					num = Integer.parseInt(token);
					if (i == s.length() - 1) {
						flag2 = true;
						break;
					}
					i++;
				}
				if (flag2 == false)
					i--;
				syn = 11;
				System.out.println("(" + syn + "," + num + ")");
				token = "";
				if (i == s.length() - 1)
					break;
				i++;
				continue;
			}
			if (s.charAt(i) == '+') {
				syn = 13;
				token = String.valueOf(s.charAt(i));
				System.out.println("(" + syn + "," + token + ")");
				token = "";
				if (i == s.length() - 1)
					break;
				i++;
				continue;
			}

			if (s.charAt(i) == '-') {
				syn = 14;
				token = String.valueOf(s.charAt(i));
				System.out.println("(" + syn + "," + token + ")");
				token = "";
				if (i == s.length() - 1)
					break;
				i++;
				continue;
			}

			if (s.charAt(i) == '*') {
				syn = 15;
				token = String.valueOf(s.charAt(i));
				System.out.println("(" + syn + "," + token + ")");
				token = "";
				if (i == s.length() - 1)
					break;
				i++;
				continue;
			}

			if (s.charAt(i) == '/') {
				syn = 16;
				token = String.valueOf(s.charAt(i));
				System.out.println("(" + syn + "," + token + ")");
				token = "";
				if (i == s.length() - 1)
					break;
				i++;
				continue;
			}

			if (s.charAt(i) == '(') {
				syn = 27;
				token = String.valueOf(s.charAt(i));
				System.out.println("(" + syn + "," + token + ")");
				token = "";
				if (i == s.length() - 1)
					break;
				i++;
				continue;
			}

			if (s.charAt(i) == ')') {
				syn = 28;
				token = String.valueOf(s.charAt(i));
				System.out.println("(" + syn + "," + token + ")");
				token = "";
				if (i == s.length() - 1)
					break;
				i++;
				continue;
			}

			if (s.charAt(i) == ';') {
				syn = 26;
				token = String.valueOf(s.charAt(i));
				System.out.println("(" + syn + "," + token + ")");
				token = "";
				if (i == s.length() - 1)
					break;
				i++;
				continue;
			}

			if (s.charAt(i) == '=') {
				syn = 25;
				token = String.valueOf(s.charAt(i));
				System.out.println("(" + syn + "," + token + ")");
				token = "";
				if (i == s.length() - 1)
					break;
				i++;
				continue;
			}

			if (s.charAt(i) == ':') {
				if (i + 1 <= s.length() - 1 && s.charAt(i + 1) == '=') {
					token = token.concat(String.valueOf(s.charAt(i))
							+ String.valueOf(s.charAt(i + 1)));
					syn = 18;
					System.out.println("(" + syn + "," + token + ")");
					token = "";
					if (i >= s.length() - 2) break;
					i = i + 2;
					continue;
				} else {
					token = token.concat(String.valueOf(s.charAt(i)));
					syn = 17;
					System.out.println("(" + syn + "," + token + ")");
					token = "";
					if (i == s.length() - 1)
						break;
					i++;
					continue;
				}

			}

			if (s.charAt(i) == '<') {
				char c = s.charAt(i + 1);
				if (c == '>') {
					token = token.concat(String.valueOf(s.charAt(i))
							+ String.valueOf(s.charAt(i + 1)));
					syn = 21;
					System.out.println("(" + syn + "," + token + ")");
					token = "";
					if (i >= s.length() - 2)
						break;
					i = i + 2;
					continue;
				}
				if (c == '=') {
					token = token.concat(String.valueOf(s.charAt(i))
							+ String.valueOf(s.charAt(i + 1)));
					syn = 22;
					System.out.println("(" + syn + "," + token + ")");
					token = "";
					if (i >= s.length() - 2)
						break;
					i = i + 2;
					continue;
				} else {
					token = token.concat(String.valueOf(s.charAt(i)));
					syn = 20;
					System.out.println("(" + syn + "," + token + ")");
					token = "";
					if (i == s.length() - 1)
						break;
					i++;
					continue;
				}
			}

			if (s.charAt(i) == '>') {
				char c = s.charAt(i + 1);
				if (c == '=') {
					token = token.concat(String.valueOf(s.charAt(i))
							+ String.valueOf(s.charAt(i + 1)));
					syn = 24;
					System.out.println("(" + syn + "," + token + ")");
					token = "";
					if (i >= s.length() - 2)
						break;
					i = i + 2;
					continue;
				} else {
					token = token.concat(String.valueOf(s.charAt(i)));
					syn = 23;
					System.out.println("(" + syn + "," + token + ")");
					token = "";
					if (i == s.length() - 1)
						break;
					i++;
					continue;

				}
			}
			else  {
				System.out.println("Input Error Appears " + s.charAt(i));
				if(i==s.length()-1) break;
				i++;
				continue;
			}
		}
	}
}
