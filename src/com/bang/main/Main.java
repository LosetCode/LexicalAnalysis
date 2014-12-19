package com.bang.main;

import java.io.IOException;

import com.bang.words.Lexer;
import com.bang.words.Operator;
import com.bang.words.Token;

public class Main {

	public static void main(String[] args) throws IOException {
		Token token = null;
		Lexer lexer = new Lexer();
		for(int i=0;i<30;i++)
		{
			token = lexer.scan();
			token.tostring();
		}
	}

}
