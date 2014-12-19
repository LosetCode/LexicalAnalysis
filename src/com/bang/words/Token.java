package com.bang.words;

public class Token {
	char word;
	public int logo=0;
	public Token(char word)
	{
		this.word=word;
	}
	public void tostring()
	{
		if(word!=' ')
		System.out.println("符号:"+word);
	}
	public int getlogo(){
		return this.logo;
	}
}
