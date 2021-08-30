import java.util.ArrayList;

import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

public class Lexer {
	
	private char c;
	//regex
	private final static String number = "[0-9\\\\+\\\\-\\\\*/\\\\(\\\\)]*";

    private final static String op = "[+*/-]";
	
    static ArrayList<Token> toke = new ArrayList<Token>();

    
    String coolword = "";
    private final String input;
    
    //constructor
    public Lexer(String input) {
    	
        this.input = input;
    
        readChar();
      
     
    }
	//to string method
	public String toString() {
		
        StringBuilder strings = new StringBuilder();
        
        for (Token token : toke) {
        	
            strings.append(token.toString());
            
            System.out.println("\n");
        }
        
        return strings.toString();
        
    }
	
	
	
	public ArrayList<Token> lex(String input) throws Exception{
		int i;
		//loop through all lines and switch case
		for(i = 0; i < input.length(); i++) {
			Character peek = peekChar();
			
			switch(input.charAt(i)){
			case '+':
				toke.add(new Token(TokenValue.PLUS, "+"));
                break;
            case '-':
            	if((i < input.length() - 1) && !Character.isDigit(input.charAt(i + 1))) {
            		toke.add(new Token(TokenValue.MINUS, "-"));
            	}
            	if((i < input.length() - 1) && Character.isDigit(input.charAt(i + 1))) {
            		toke.add(new Token(TokenValue.NUMBER, Character.toString(input.charAt(i)) + Character.toString(input.charAt(i+1))));
            	}
                break;
            case '*':
            	toke.add(new Token(TokenValue.MULTIPLY, "*"));
                break;
            case '/':
            	if(input.charAt(i) == '/') {
            	toke.add(new Token(TokenValue.DIVIDE, "/"));
            	}
                break;           	
            case ',':
            	toke.add(new Token(TokenValue.COMMA, ","));
            	break;
            case ' ':
            	
            		//toke.add(new Token(TokenValue.EndOfLine, " "));
            	
            		//toke.add(new Token(TokenValue.EndOfLine, " "));
            	break;
            case '1':
            	toke.add(new Token(TokenValue.NUMBER, "1"));         
                break;
            case '2':
            	toke.add(new Token(TokenValue.NUMBER, "2"));
            	
                break;
            case '3':
            	
            	toke.add(new Token(TokenValue.NUMBER, "3"));
            	
            	
                break;
            case '4':
            	
            		toke.add(new Token(TokenValue.NUMBER, "4"));
            	
                break;
            case '5':
            	toke.add(new Token(TokenValue.NUMBER, "5"));
      
                break;
            case '6':
            	toke.add(new Token(TokenValue.NUMBER, "6"));

            case '7':
            	toke.add(new Token(TokenValue.NUMBER, "7"));
                break;
            case '8':
            	
            	toke.add(new Token(TokenValue.NUMBER, "8"));
                break;
            case '9':
            	toke.add(new Token(TokenValue.NUMBER, "9"));
            	
                break;
            case '"':
            	if(input.startsWith("\"")) {
            		if(input.endsWith("\"")) {
            			toke.add(new Token(TokenValue.STRING, ""));
            		}
            	}
            	break;
            case '<':
            	//if next character is = or >
                if (peek != null) {
                    if (peek == '=') {
                        Character curr = c;
                        readChar();
                        toke.add(new Token(TokenValue.LESSEQUALS, curr + Character.toString(c)));
                    }
                    else if(peek == '>') {
                    	Character curr = c;
                    	readChar();
                    	toke.add(new Token(TokenValue.NOTEQUALS, curr + Character.toString(c)));
                    }
                    else {
                    	
                        toke.add(new Token(TokenValue.LESSTHAN, Character.toString(c)));
                    }
                }
            
            		//toke.add(new Token(TokenValue.LESSTHAN, "<"));
            
            		//toke.add(new Token(TokenValue.LESSEQUALS, "<="));
            	
            case '>':
            	if (peek != null) {
                    if (peek == '=') {
                    	Character curr = c;
                        readChar();
                        toke.add(new Token(TokenValue.GREATEREQUALS, curr + Character.toString(c)));
                    } 
                    }
            	else {
                    toke.add(new Token(TokenValue.GREATERTHAN, Character.toString(c)));
                }
            	//toke.add(new Token(TokenValue.GREATERTHAN, ">"));
            	break;
            case '=':
            	
            		toke.add(new Token(TokenValue.EQUALS, "="));

            	break;
            	
            case '(':
            	toke.add(new Token(TokenValue.LPAREN, "("));
            	break;
            case ')':
            	toke.add(new Token(TokenValue.RPAREN, ")"));
            	break;
           
          
            	
            
            case ':':
            	//toke.add(new Token(TokenValue.LABEL, ":"));
            	break;
           
			default:
				if (peek != null) {
                      //  toke.add(new Token(TokenValue.EndOfLine, ""));
                    
				}
				
				
				//checks if its a letter, reads it and assign token
				 if (Character.isLetter(input.charAt(i))) {
	                    String literal = readIdentifier();
	                    
	                    //Part 6. CHECK FOR GOSUB FOR NEXT STEP TO RETURN AND LABEL
	                    if(input.startsWith("G")) {
	                    	toke.add(new Token(TokenValue.GOSUB, literal));
	                    	
	                    }
	                    //for
	                    if(input.charAt(i) == 'F' && input.charAt(i+1) == 'O') {
	                    	toke.add(new Token(TokenValue.FOR, literal));
	                    }
	                    //NEXT
	                    if(input.startsWith("N")) {
	                    	toke.add(new Token(TokenValue.NEXT, literal));
	                    	
	                    }
	                    //STEP
	                    if(input.startsWith("S")) {
	                    	toke.add(new Token(TokenValue.STEP, literal));
	                    	
	                    }
	                    //TO
	                    if(input.startsWith("T")) {
	                    	toke.add(new Token(TokenValue.TO, literal));
	                    	
	                    }
	                    //return
	                    if(input.charAt(i) == 'R' && input.charAt(i+1) == 'E') {
	                    	toke.add(new Token(TokenValue.RETURN, literal));
	                    }
	                    //LABEL
	                    if(input.charAt(i) == 'L' && input.charAt(i+1) == 'A') {
	   					 toke.add(new Token(TokenValue.LABEL, literal));
	   				 }
	                    
	                    //IF
	                    if(input.charAt(i) == 'I' && input.charAt(i+1) == 'F') {
	                    		//input.startsWith("I")) {
	                    	toke.add(new Token(TokenValue.IF, literal));
	                    }
	                  //
	                    //THEN?
	                    if(input.charAt(i) == 'T' && input.charAt(i+1) == 'H') {
	                    	toke.add(new Token(TokenValue.THEN, literal));
	                    }
	                    
	                    //RANDOM
	                    if(input.charAt(i) == 'R' && input.charAt(i+1) == 'A') {
	                    	toke.add(new Token(TokenValue.RANDOM, literal));
	                    	
	                    }
	                    //LEFT
	                    if(input.charAt(i) == 'L' && input.charAt(i+1) == 'E') {
	                    	toke.add(new Token(TokenValue.LEFT$, literal));
	                    	
	                    }
	                    //RIGHT
	                    if(input.charAt(i) == 'R' && input.charAt(i+1) == 'I') {
	                    	toke.add(new Token(TokenValue.RIGHT$, literal));
	                    	
	                    }
	                    //MID
	                    if(input.charAt(i) == 'M' && input.charAt(i+1) == 'I') {
	                    	toke.add(new Token(TokenValue.MID$, literal));
	                    	
	                    }
	                    //NUMS
	                    if(input.charAt(i) == 'N' && input.charAt(i+1) == 'U') {
	                    	toke.add(new Token(TokenValue.NUM$, literal));
	                    	
	                    }
	                    //VAL
	                	if(input.charAt(i) == 'V' && input.charAt(i+1) == 'A') {
	                		toke.add(new Token(TokenValue.VAL, literal));
	                	}
	                	
	                    
	                    
	                    
	                    
	                    
	                    
	                    
	                   
	                    //if hashmap contain value, then add to print token 
	                    
	                    
	                    //if hashmap not contain value, then add to identifier
	                    if(!maps.containsValue(literal)) {
	                    	if(input.endsWith(":") || input.endsWith(",")) {
	                    		maps.put(TokenValue.LABEL, literal);
		    					toke.add(new Token(TokenValue.LABEL, literal));
	                    	}
	                    	else if(input.endsWith("$")) {
	                    		maps.put(TokenValue.IDENTIFIER, literal + "$");
		    					toke.add(new Token(TokenValue.IDENTIFIER, literal + "$"));
	                    	}
	                    	
	                    	else if(input.endsWith("%")) {
	                    		maps.put(TokenValue.IDENTIFIER, literal + "%");
		    					toke.add(new Token(TokenValue.IDENTIFIER, literal + "%"));
	                    	}
	                    	
	                    	else {
	                    	maps.put(TokenValue.IDENTIFIER, literal);
	                    	//toke.add(new Token(TokenValue.IDENTIFIER, literal));
	                    	}
	                    	
	                    }
	                    
	                    else if(maps.containsValue(literal)) {
	                    	toke.remove(new Token(TokenValue.IDENTIFIER, literal));
	                    	//toke.add(new Token(TokenValue.PRINT, literal));
	                    }
	                    
	                  
	                    
				 }
				 if(input.charAt(i) == '"') {
					 toke.add(new Token(TokenValue.STRING, readString()));
				 }
				
			}
			
			
		}
		
		
		
	
		return toke;
	}

	
	 private int currentposition;
	 private int nextstring;

	 //return tokens
	 public ArrayList<Token> getList() {
	       return toke;
	   }
	 
	 //reads letters
	 private String readIdentifier() {
		 
	        int pos = currentposition;
	        
	        while (Character.isLetter(c))
	        	
	            readChar();
	        
	        return input.substring(pos, currentposition);
	    }
	

	 //read char
	private void readChar() {
		
        if (nextstring >= input.length()) {
        	
            c = '\0';
            
        } else {
        	
            c = input.charAt(nextstring);
            
        }
        currentposition = nextstring;
        
        nextstring++;
    }
	//read strings
	private String readString() {
		
        int pos = currentposition + 1;
        
        for (;;) {
        	
            readChar();
            
            if (c == '"' || c == '\0')
            	
                break;
        }
        
        return input.substring(pos, currentposition);
    }
	
	private Character peekChar() {
		
        if (nextstring >= input.length()) {
        	
            return null;
        }
        return input.charAt(nextstring);
    }
	
	public Map<TokenValue, String> getMap(){
		return maps;
	}
	 private final Map<TokenValue, String> maps = new HashMap<TokenValue, String>();
}

