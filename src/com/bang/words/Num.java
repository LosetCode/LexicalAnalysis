package com.bang.words;

import com.bang.words.Token;

public class Num extends Token{
	private int number;
	public Num(int number) {
		super((char)number);
		this.number = number;
	}
	public void  tostring()
	{
		System.out.println("整数："+number);
	}

}
