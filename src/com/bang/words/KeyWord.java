package com.bang.words;

public class KeyWord extends Token{
	public String keyword ;
	public int logo;
	public KeyWord(String word,int logo) {
		super(' ');
		this.keyword = word;
		this.logo = logo;
	}
	public void tostring(){
		if(logo == 1)
			System.out.println("关键字："+keyword);
		else
			System.out.println("变量："+keyword);
	}

}
