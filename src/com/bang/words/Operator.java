package com.bang.words;

public class Operator extends Token{
	String oper;
	public static int logo=1;
	public Operator(String oper)
	{
		super('1');
		this.oper=oper;
	}
	public void tostring()
	{
		System.out.println("运算符："+oper);
	}
	public int getlogo(){
		return this.logo;
	}
}
