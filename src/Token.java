import java.util.Map;

//token class 
public class Token {
	
	private TokenValue tokenvalue;
	
	private String value;
    
    //static Token.Tokens tk = Token.Tokens.MULTIPLY;
    
    //to string method
	public String toString(){
		return tokenvalue + "(" + value + ")";

    }
	
	//constructor
	public Token(TokenValue tokenvalue, String value) {
        this.tokenvalue = tokenvalue;
       	this.value = value;
    }
	
	public Token(TokenValue type) {
        this(type, null);
    }
	
	
	public String getValue() {
		return value;
		}

	public TokenValue getToken() {
		
		return tokenvalue;
	}
    
	public TokenValue tokeniterator() {
		while(tokenvalue != null) {
			return tokenvalue;
		}
		return null;
	}

}
