import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Basic {

	//main method, scanner
	public static void main(String[] args){
	
		System.out.println("enter Filename");
		
		String filename = args[0];
		//try catch 
		try {
			//loop through textfile and print tokens
			for(String line : Files.readAllLines(Path.of(filename))) {
				Lexer lexers = new Lexer(line);
			   lexers.lex(line);
			   System.out.println(line);
			}
			
			Lexer lexers = new Lexer(filename);
			ArrayList<Token> tokens = lexers.lex(args[0]);
			//ArrayList<Token> tek = new ArrayList<>();
			//while(Lexer.toke != null) {
			//	Parser parsers = new Parser(Lexer.toke);
			//	parsers.parse();
			//	System.out.println(Lexer.toke);
			//}
			ArrayList<Token> tokenlist = new ArrayList<>();
			tokenlist.addAll(lexers.toke);
			
			while(tokenlist != null) {
				Parser parsers = new Parser(tokenlist);
				parsers.parse();
				System.out.println(tokenlist);
			}
			
			for(Token t : tokens) {
	            System.out.println(t);         
	        }
			
			
		}
		catch (Exception e){    
			e.printStackTrace();
			}
	
		
	if(args.length != 1) {
		System.out.println("error");
		System.exit(0);
	}
	else {
		
	}
	}
	private final Map<TokenValue, String> maps = new HashMap<TokenValue, String>();
}
