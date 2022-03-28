package compiladorE1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lexema {
	
	private char [] content;
	private int contentIndex;
	
	
	public Lexema(String sourceCodePath) {
			
		try {
			String strContent;
			strContent = new String(Files.readAllBytes(Paths.get(sourceCodePath)));
			this.content = strContent.toCharArray();
			this.contentIndex = 0;
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
	//check the next char
	private char nextChar() {
		return this.content[this.contentIndex++];
	}
	
	//check the length of the source code
	private boolean hasNextChar() {
		return contentIndex < this.content.length;
	}
	
	//go back to the current char in a unity
	private void back() {
		this.contentIndex--;
	}
	
	//check if the letters are down
	private boolean isLetter(char c) {
		return (c >= 'a') && (c <= 'z');
	}
	
	//check if there is a digit
	private boolean isDigit(char c) {
		return (c >= 0) && (c <= 9);
	}
	
	//check if the next token is valid otherwise will run an error message 
	
	public Token nextToken() {
		Token token  = null;
		char c;
		int state = 0;
		
		StringBuffer lexema = new StringBuffer();
		while(this.hasNextChar()) {
			c = this.nextChar();
			/* 
			 * Call according to the state machine 
			 */
			switch(state) {
			case 0:
				if(c == ' '|| c == '\n' || c == '\t') { //white spaces chars
					state = 0;
				}
				else if(this.isLetter(c) || c == '_') {
					lexema.append(c);
					state = 1;
				}
				else if (this.isDigit(c)) {
					lexema.append(c);
					state = 4;
				}
				else if( c == ')' ||
						 c == '(' ||
						 c == '{' ||
						 c == '}' ||
						 c == ',' ||
						 c == ';') {
					lexema.append(c);
					state = 9;
				}
				else if(this.isLetter(c) || this.isDigit(c)) {
					lexema.append(c);
					state = 5;
				}
				else if(c == '<'||
						c == '>') {
					lexema.append(c);
					state = 6;
				}
				else if(c == '+'||
						c == '-'||
						c == '*'||
						c == '/') {
					lexema.append(c);
					state = 7;
				}
				else if(c == '=') {
					lexema.append(c);
					state = 8;
				}
				else if(c == '$') {
					lexema.append(c);
					state = 99;
					this.back();
				}else {
					lexema.append(c);
					throw new RuntimeException("ERRO : Token Invalido \"" + lexema.toString() + "\"");
				}
				break;
				/*
				 * call according to the token type
				 */
			}
		}
		return token;
	}
	
	public Token getNextToken() {
		return this.nextToken();
	}

}
