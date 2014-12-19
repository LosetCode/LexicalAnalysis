package com.bang.words;

import java.io.IOException;
import java.util.Hashtable;

public class Lexer {
	char a=' ';
	char b= ' ';
	private static Hashtable<String,KeyWord> words = new Hashtable<String,KeyWord>();
	static {
		words.put("begin", new KeyWord("begin",1));
		words.put("if", new KeyWord("if",1));
		words.put("while", new KeyWord("while",1));
		words.put("do", new KeyWord("do",1));
		words.put("for", new KeyWord("for",1));
		words.put("int", new KeyWord("int",1));
		words.put("float", new KeyWord("float",1));
		words.put("char", new KeyWord("char",1));
	};
	public Lexer(){
	}
	public Token scan() throws IOException{
		Token t = new Token(' ');
		while(a==' '||a=='\n')
		{
			readA();
		}
		if(!Character.isLetterOrDigit(a))//如果a是符号的话就可以进来
		{
			t = isOperator();//判断是否为运算符
			if(t.getlogo()==1){
				a=' ';//如果是相同的就让a置空，从下一个开始读取
			}else if(t.getlogo()==0)
			{
				return t;//防止被a是数字时t被覆盖，因为执行了isoperator（）之后a就变成下个字符了，如果是&&&12.213的话a就变成数字
			}
		}
		//判断数字
		if(Character.isDigit(a))
		{
			int v = 0;
			do{
				v = v*10+Character.digit(a, 10);//将字符转换为int
				readA();
			}while(Character.isDigit(a));
			if(a !='.')
			{
				t=new Num(v);
				return t;
			}
			else{
				float x = v;float d =10;
				readA();
				while(Character.isDigit(a))
				{
					x += Character.digit(a, 10)/d;
					d*=10;
					readA();
				}
				t=new Float(x);
				return t;
			}
		}
		//判断关键字还是普通标识符
		if(Character.isLetter(a))
		{
			StringBuilder br = new StringBuilder();
			do{
				br.append(a);
				readA();
			}while(Character.isLetterOrDigit(a));
			String s = br.toString();
			t = words.get(s);
			if (t!=null) return t;
			else{
				t=new KeyWord(s,2);
				return t;
			}
		}
		return t;
	}
	private Token isOperator() throws IOException {
		switch(a)//判断a是否为运算符
		{
		case '+':if(CompareNext('+')) 
				{
					return new Operator("++");
				} 
				else{
					return new Token(b);
				}
		case '-':if(CompareNext('-')) 
				{
					return new Operator("--");
				} else{
					return new Token(b);
				}
		case '*':
		case '/':
		case '=':
		case '(':
		case ')':
		case ';':
		case '!':
		case '>':
		case '<':if(CompareNext('='))//运算符<=
			{
				return new Operator(b+"=");
			}else{
				return new Token(b);
			}
		case '&':if(CompareNext('&'))//运算符&&
			{
				return new Operator(a+"&");
			}else{
				return new Token(b);
			}
		case '|':if(CompareNext('|'))//运算符||
			{
				return new Operator(a+"|");
			}else{
				return new Token(b);
			}
		default:break;
		}
		return new Token(' ');
	}
	
	
	
	
	
	
	
	
	
	
	private void readA() throws IOException {
			a = (char) System.in.read();
	}
	private boolean CompareNext(char tmp) throws IOException{
		b=a;
		readA();
		if(a!=tmp)
			return false;
		else
			return true;
		
		
		
	}
}
