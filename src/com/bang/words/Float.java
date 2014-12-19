package com.bang.words;

public class Float extends Token{
	private float f;
	public Float(float f) {
		super((char)f);
		this.f=f;
	}
	public void tostring(){
		System.out.println("实数："+f);
	}
}
