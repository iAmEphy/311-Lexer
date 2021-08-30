import java.util.ArrayList;
import java.util.Iterator;


public class Parser {

	private Lexer listtoken;
	private ArrayList<Token> tokenlist = new ArrayList<>();
	
	//constructor for tokens
	public Parser(ArrayList<Token> tokens) {
		tokenlist = tokens;
		
	}

	public ArrayList<Token> getList(){
		return tokenlist;
	}

	@Override
	public String toString() {
		
        StringBuilder strings = new StringBuilder();
        
        for (Token token : tokenlist) {
        	
            strings.append(token.toString());
            
            System.out.println("\n");
        }
        
        return strings.toString();
        
    }

	//.parse method
	public Node parse() throws Exception {
		
		
		Node x = null;
		
		System.out.println(tokenlist.toString());
		while(tokenlist.size() != 0) {
			x = Statements();
			if(x != null) {
	                
				System.out.println(x.toString());
				
	        }
			else {
				
			}

		}
	        return x;
	}
	
	
	public ArrayList<Token> matchAndRemove(TokenValue tok) {
		
		
		for(int i = 0; i < tokenlist.size(); i++) {
			
			//iterate and if matches, remove it from tokenlist
			if(tokenlist.get(i).getToken() == tok) {
				tokenlist.remove(i);
				i++;
				break;
			}
			else {
				
				return null;
				
			}
			
		}
		return tokenlist;
	}
	
	public Node expression() throws Exception {
		
	        Node leftnode=null;
	        Node rightnode = null;
	        TokenValue numberToken= TokenValue.NUMBER;

	       
	        if(matchAndRemove(numberToken)!=null)
	            leftnode = factor();
	        
	        TokenValue additiontoken= TokenValue.PLUS;
	        TokenValue subtracttoken = TokenValue.MINUS;
	        TokenValue multiply = TokenValue.MULTIPLY;
	        TokenValue divide = TokenValue.DIVIDE;
	        TokenValue RightParen= TokenValue.RPAREN;
	        TokenValue LeftParen= TokenValue.LPAREN;
	        
	        if(matchAndRemove(additiontoken) != null) {
	        	return leftnode;
	        	
	        }
	        
	        
	        
	      //caling function invocation
	        functionInvocation();
		for(int i = 0; i < tokenlist.size() ; i++) {
			
			//remove left and right parenthesis from tokenlist
			if(tokenlist.get(i).getToken() == LeftParen) {
				tokenlist.remove(i);
				
			}
			else if(tokenlist.get(i).getToken() == RightParen) {
				tokenlist.remove(i);
				
			}
			else {
				throw new Exception("Error");
			}
		}
		return leftnode;
	}
	public int index = 0;
	String words;
	
	
	//term
	public Node term() throws Exception {
		
		TokenValue tokenmultiply = TokenValue.MULTIPLY;
		TokenValue tokendivide = TokenValue.DIVIDE;
		
		for(int i = 0; i < tokenlist.size() ; i++) {
			Node left = null;
			//if it has multiply token, then return node
			if(tokenlist.get(i).getToken() == tokenmultiply){
				
				return left;
			}
			else if(tokenlist.get(i).equals(tokendivide)) {
				return left;
			}
			else {
				return left;
			}
		}
		
	    return z;
	}
	
	Node op;
	public int in;
	public float f;
	//Node x;
	//Node y;
	Node z= null;
	private TokenValue tok2;
	//factor helper
	public Node factor() throws Exception {
		Node right = null;
		
		TokenValue tokennumber= TokenValue.NUMBER;
		TokenValue RightParen= TokenValue.RPAREN;
        TokenValue LeftParen= TokenValue.LPAREN;
        TokenValue identify = TokenValue.IDENTIFIER;
        
        
       
		for(int i = 0; i < tokenlist.size() ; i++) {
		
			
			//if theres an identifier, then return variable node
			if(tokenlist.get(i).getToken() == (identify)) {
				VariableNode variablenode = new VariableNode(tokenlist.get(i).toString());
				return variablenode;
			}
			
		//if it is a int, then return int node. same for float node
			if(Integer(tokenlist.get(i).toString())) {		
				IntegerNode intnode = new IntegerNode(Integer.parseInt(tokenlist.get(i).toString()));
				tokenlist.remove(i);
				return intnode;
			}
			else if(Float(tokenlist.get(i).toString())) {
				FloatNode floatnode = new FloatNode(Float.parseFloat(tokenlist.get(i).toString()));
				tokenlist.remove(i);
				return floatnode;
			}
			else if(tokenlist.get(i).getToken() == (LeftParen)) {
				expression();
			}
			else if(tokenlist.get(i).getToken() == (RightParen)) {
				expression();
			}
			else {
				throw new Exception("Error");
			}
		}
		
		return right;
	}

	
	
	public Node Statements() {
		//PrintNode printnode;
		
		//return statements node
		Node statementsnode;
		
		while(Statement() != null) {
			statementsnode = Statement();
			
			return statementsnode;
			//if(Statement() == printnode) {
		//		StatementsNode statementsnode = new StatementsNode();
			//}
		
			
		}
		
		
		return null;
		
		//return statementsnode;
		//keeps printing empty lines??
		
	}
	
	public TokenValue nexttoken(TokenValue token) {
		TokenValue nexttoken;
		for(int i = 0; i < tokenlist.size(); i++) {
			if(tokenlist.get(i).getToken() == token) {
				nexttoken = tokenlist.get(i).getToken();
				return nexttoken;
			}
		}
		
		return null;
	}
	//statement. if its print return print node, if assignment then return assignment node
	public Node Statement() {
		TokenValue tokenprint = TokenValue.PRINT;
		TokenValue tokenequal = TokenValue.EQUALS;
		Node assign = null;
		TokenValue tokenidentify = TokenValue.IDENTIFIER;
		TokenValue stringtoken = TokenValue.STRING;
		TokenValue numbertoken = TokenValue.NUMBER;
		TokenValue endline = TokenValue.EndOfLine;
		
		TokenValue tokenlabel = TokenValue.LABEL;
		TokenValue tokenreturn = TokenValue.RETURN;
		TokenValue fortoken = TokenValue.FOR;
		TokenValue nexttoken = TokenValue.NEXT;
		TokenValue gosubtoken = TokenValue.GOSUB;
		
		TokenValue iftoken = TokenValue.IF;
		Iterator s = tokenlist.iterator();
		Node test = null;
		//STEP INCREMENT
		
		IntegerNode FOR = new IntegerNode(2);
		//STEP INCREMENT?
		int STEP = 1;
		
		
		TokenValue lessthan = TokenValue.LESSTHAN;
		
		TokenValue lessequals = TokenValue.LESSEQUALS;
				
		TokenValue greaterthan = TokenValue.GREATERTHAN;
		TokenValue greaterequals = TokenValue.GREATEREQUALS;
		TokenValue notequals = TokenValue.NOTEQUALS;
		
		//if node boolean expression
		while(s.hasNext()) {
			//iterate through list\
		
			//finds if tokens
			if(s.next() == iftoken) {
			
				//finds ops and return ifnodes
				if(s.next() == tokenequal) {
					BooleanOperationNode boolnode = new BooleanOperationNode(tokenequal.toString());
					if(s.next() == numbertoken) {
						IfNode ifnode = new IfNode(iftoken.toString(), boolnode, numbertoken.toString());
						return ifnode;
					}
				}
				else if(s.next() == lessthan) {
					BooleanOperationNode boolnode = new BooleanOperationNode(lessthan.toString());
					if(s.next() == numbertoken) {
						IfNode ifnode = new IfNode(iftoken.toString(), boolnode, numbertoken.toString());
						return ifnode;
					}
				}
				else if(s.next() == lessequals) {
					BooleanOperationNode boolnode = new BooleanOperationNode(lessequals.toString());
					if(s.next() == numbertoken) {
						IfNode ifnode = new IfNode(iftoken.toString(), boolnode, numbertoken.toString());
						return ifnode;
					}
				}
				else if(s.next() == greaterthan) {
					BooleanOperationNode boolnode = new BooleanOperationNode(greaterthan.toString());
					if(s.next() == numbertoken) {
						IfNode ifnode = new IfNode(iftoken.toString(), boolnode, numbertoken.toString());
						return ifnode;
					}
				}
				else if(s.next() == greaterequals) {
					BooleanOperationNode boolnode = new BooleanOperationNode(greaterequals.toString());
					if(s.next() == numbertoken) {
						IfNode ifnode = new IfNode(iftoken.toString(), boolnode, numbertoken.toString());
						return ifnode;
					}
				}
				else if(s.next() == notequals) {
					BooleanOperationNode boolnode = new BooleanOperationNode(notequals.toString());
					if(s.next() == numbertoken) {
						IfNode ifnode = new IfNode(iftoken.toString(), boolnode, numbertoken.toString());
						return ifnode;
					}
				}
			}
		}
		
		
		
		for(int i = 0; i < tokenlist.size(); i++){
			
			
			//checking for if tokens
			if(tokenlist.get(i).getToken() == iftoken) {
				//check for operators then if a number follows, if so, then return ifnode

				//TokenValue currenttoken = nexttoken(lessthan);
				//BooleanOperationNode boolnode = new BooleanOperationNode(currenttoken.toString());
				//TokenValue nextnumber = nexttoken(numbertoken);
				//IfNode ifnode = new IfNode(boolnode, nextnumber.toString());
				
				if(tokenlist.get(i + 1).getToken() == lessthan) {
					BooleanOperationNode boolnode = new BooleanOperationNode(lessthan.toString());
					
					if(tokenlist.get(i + 2).getToken() == numbertoken) {
						IfNode ifnode = new IfNode(iftoken.toString(), boolnode, numbertoken.toString());
						
						return ifnode;
					}
					else {
						
					}
				}
				//EQUALS
				else if(tokenlist.get(i + 1).getToken() == tokenequal) {
					BooleanOperationNode boolnode = new BooleanOperationNode(tokenequal.toString());
					if(tokenlist.get(i + 2).getToken() == numbertoken) {
						IfNode ifnode = new IfNode(iftoken.toString(), boolnode, numbertoken.toString());
						return ifnode;
					}
					
				}
				//LESS EQUALS
				else if(tokenlist.get(i + 1).getToken() == lessequals) {
					BooleanOperationNode boolnode = new BooleanOperationNode(lessequals.toString());
					if(tokenlist.get(i + 2).getToken() == numbertoken) {
						IfNode ifnode = new IfNode(iftoken.toString(), boolnode, numbertoken.toString());
						return ifnode;
					}
					
				}
				//greater equals token
				else if(tokenlist.get(i + 1).getToken() == greaterequals) {
					BooleanOperationNode boolnode = new BooleanOperationNode(greaterequals.toString());
					if(tokenlist.get(i + 2).getToken() == numbertoken) {
						IfNode ifnode = new IfNode(iftoken.toString(), boolnode, numbertoken.toString());
						return ifnode;
					}
					
				}
				//greater than
				else if(tokenlist.get(i + 1).getToken() == greaterthan) {
					BooleanOperationNode boolnode = new BooleanOperationNode(greaterthan.toString());
					if(tokenlist.get(i + 2).getToken() == numbertoken) {
						IfNode ifnode = new IfNode(iftoken.toString(), boolnode, numbertoken.toString());
						return ifnode;
					}
					
				}
				//not equals
				else if(tokenlist.get(i + 1).getToken() == notequals) {
					BooleanOperationNode boolnode = new BooleanOperationNode(notequals.toString());
					if(tokenlist.get(i + 2).getToken() == numbertoken) {
						IfNode ifnode = new IfNode(iftoken.toString(), boolnode, numbertoken.toString());
						return ifnode;
					}
					
				}
				
				else {
					
				}
				
			
				
			}
			
			//remove endofline
			if(tokenlist.get(i).getToken() == endline) {
				matchAndRemove(tokenlist.get(i).getToken());
				tokenlist.remove(i);
			}
			
			
			
			//LOOK FOR LABEL BEOFRE ANYTHING ELSE PART 6
			//LabeledStateMentNode find and return then macthandremove from list

			if(tokenlist.get(i).getToken() == tokenlabel) {
				AssignmentNode assignnode = new AssignmentNode(tokenlist.get(i).toString(), assign);
				LabeledStatementNode labelstate = new LabeledStatementNode(tokenlist.get(i).toString(), assignnode);
				matchAndRemove(tokenlist.get(i).getToken());
				tokenlist.remove(i);
				return labelstate;
			}
			
			
			//GO SUB, token identifier then into constructor gosubnode and return gosub
			if(tokenlist.get(i).getToken() == tokenidentify) {		
					GosubNode gosub = new GosubNode(tokenlist.get(i).toString());
					matchAndRemove(tokenlist.get(i).getToken());
					
				return gosub;
			}
			
			//not sure if its looking for "GOSUB"
			if(tokenlist.get(i).getToken() == gosubtoken) {
			GosubNode gosub = new GosubNode(tokenlist.get(i).toString());
			tokenlist.remove(i);
			return gosub;
			}
			
			//RETURN NODE RETURN alone in a line and construct return node
			if(tokenlist.get(i).getToken() == tokenreturn) {
				ReturnNode returnnode = new ReturnNode(tokenlist.get(i).toString());
				matchAndRemove(tokenlist.get(i).getToken());
				tokenlist.remove(i);
				return returnnode;
				
				
				
			}
			
			//FOR NODE look for for token
			if(tokenlist.get(i).getToken() == fortoken) {
				ForNode fornode = new ForNode(FOR);
				matchAndRemove(tokenlist.get(i).getToken());
				tokenlist.remove(i);
				return fornode;
			}
			//NEXT NODE look for next token
			if(tokenlist.get(i).getToken() == nexttoken) {
				VariableNode varnode = new VariableNode(tokenlist.get(i).toString());
				NextNode nextnode = new NextNode(varnode);
				matchAndRemove(tokenlist.get(i).getToken());
				tokenlist.remove(i);
				return nextnode;
			}
				
			
			
			//check print token and return printnode
			else if(tokenlist.get(i).getToken() == tokenprint) {
				PrintNode printnode = new PrintNode(tokenlist.get(i).toString());
				matchAndRemove(tokenlist.get(i).getToken());
				//return printnode;
				
			}
			//check if its equal and return assignment node
			else if(tokenlist.get(i).getToken() == tokenequal) {
			AssignmentNode assignnode = new AssignmentNode(tokenlist.get(i).toString(), assign);
			matchAndRemove(tokenlist.get(i).getToken());
			return  assignnode;
			}
			
			//check identifier and return readnode
			else if(tokenlist.get(i).getToken() == tokenidentify) {
				VariableNode varnode = new VariableNode(tokenlist.get(i).toString());
				ArrayList<VariableNode> varlist = new ArrayList<>();
				varlist.add(varnode);
				ReadNode readnode = new ReadNode(varlist);
				matchAndRemove(tokenlist.get(i).getToken());
				return readnode;
			}
			
			//string node
			else if(tokenlist.get(i).getToken() == stringtoken) {
				StringNode stringnode = new StringNode(tokenlist.get(i).toString());
				test = stringnode;
				matchAndRemove(tokenlist.get(i).getToken());
				return stringnode;
			}
			
			//input node
			else if(tokenlist.get(i).getToken() == stringtoken || tokenlist.get(i).getToken() == tokenidentify) {
				//InputNode inputnode = new InputNode(tokenidentify)
				ArrayList<Node> nodelist = new ArrayList<>();
				if(tokenlist.get(i).getToken() == stringtoken) {
					StringNode stringnode = new StringNode(tokenlist.get(i).toString());
					InputNode inputnode = new InputNode(stringnode, nodelist);
					nodelist.add(inputnode);
					matchAndRemove(tokenlist.get(i).getToken());
					return inputnode;
				}
				else {
					VariableNode varnode = new VariableNode(tokenlist.get(i).toString());
					nodelist.add(varnode);
					InputNode inputnode = new InputNode(varnode, nodelist);
					matchAndRemove(tokenlist.get(i).getToken());
					return inputnode;
					
				}
				
			}
			
			//data node
			else if(tokenlist.get(i).getToken() == numbertoken) {
				
				
				//check for int
				if(Integer(tokenlist.get(i).toString())) {
					ArrayList<Node> datalist = new ArrayList<>();
					//make arraylist. set token to int k. add it integernode and add intnode to list and sent to datanode
					int k = Integer.parseInt(tokenlist.get(i).toString());
					
					IntegerNode intnode = new IntegerNode(k);
					datalist.add(intnode);
					
					DataNode datanodelist = new DataNode(datalist);
					matchAndRemove(tokenlist.get(i).getToken());
					return datanodelist;
				}
				//check for float
				if(Float(tokenlist.get(i).toString())) {
					ArrayList<Node> datalist = new ArrayList<>();
					//make arraylist. set token to int e. add it Float Node and add Float Node to list and sent to datanode
					Float e = Float.parseFloat(tokenlist.get(i).toString());
					
					FloatNode floatnode = new FloatNode(e);
					
					datalist.add(floatnode);
					
					DataNode datanodelist = new DataNode(datalist);
					matchAndRemove(tokenlist.get(i).getToken());
					return datanodelist;
				}
				//check for string
				if(tokenlist.get(i).getToken() == stringtoken) {
					ArrayList<Node> datalist = new ArrayList<>();
					
					StringNode stringnode = new StringNode(tokenlist.get(i).toString());
					datalist.add(stringnode);
					
					DataNode datanodelist = new DataNode(datalist);
					matchAndRemove(tokenlist.get(i).getToken());
					return datanodelist;
				}
				
				
				
				
				
				
				
			}
			
			
			else {
				return null;
			}
		}
		return null;
		
	}
	
	
	//print statement. if token is print then return print token
	public PrintNode PrintStatement() {
		TokenValue tokenprint = TokenValue.PRINT;
		
		for(int i = 0; i < tokenlist.size() ; i++) {
			if(tokenlist.get(i).getToken() == tokenprint) {
				PrintNode printnode = new PrintNode(tokenlist.get(i).toString());
				matchAndRemove(tokenlist.get(i).getToken());
				return printnode;
			}
			else {
				return null;
			}
		}
		return null;
		
		
	}
		
	public Node PrintList(String commas) throws Exception {
		TokenValue tokenprint = TokenValue.PRINT;
		TokenValue tokenstring = TokenValue.STRING;
		
		
		PrintNode printnode = new PrintNode(commas);
		printnode = (PrintNode)expression();
		//return printnode;
		
		StringNode stringnode = new StringNode(commas);
		return stringnode;
	}
	
	
	//assignment
	public AssignmentNode Asssignment() {
		TokenValue equals = TokenValue.EQUALS;
		Node x = null;
		
		//for loop. get equals assignment and return assignment node
		for(int i = 0; i < tokenlist.size() ; i++) {
			if(tokenlist.get(i).getToken() == equals) {
				AssignmentNode assign = new AssignmentNode(tokenlist.get(i).toString(), x);
				matchAndRemove(tokenlist.get(i).getToken());
				return assign;
			}
			else {
				return null;
			}
		}
			
		return null;
	}
	
	
	//math op helper
	public Node left(TokenValue tok) {
		
		Node leftnode = null;
		
		return leftnode;
	}
	
	//mathop helper
	public Node right(TokenValue tok) {
		Node rightnode = null;
		
		return rightnode;
	}
	 
	//check if its integer
	public boolean Integer(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
       
        return true;
    }
	
	
   
	//check if its float
    public boolean Float(String s) {
        try { 
            Float.parseFloat(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
       
        return true;
    }
    
	public String getTokenList() {	
		
		 return tokenlist.toString();
		 
	}
	
	//functionInvocation
	public Node functionInvocation(){
		TokenValue tokenrandom = TokenValue.RANDOM;
		TokenValue tokenleft = TokenValue.LEFT$;
		TokenValue tokenright = TokenValue.RIGHT$;
		TokenValue tokenmid = TokenValue.MID$;
		TokenValue tokenval = TokenValue.VAL;
		
		ArrayList<Node> functionlist = new ArrayList<>();
		
		//loop through to find tokenvalues and return functionnode else null
		for(int i = 0; i < tokenlist.size(); i++){
			if(tokenlist.get(i).getToken() == tokenrandom) {
				StringNode stringnode = new StringNode(tokenlist.get(i).toString());
				functionlist.add(stringnode);
				FunctionNode functionnode = new FunctionNode(functionlist);
				return functionnode;
			}
			else if(tokenlist.get(i).getToken() == tokenleft) {
				StringNode stringnode = new StringNode(tokenlist.get(i).toString());
				functionlist.add(stringnode);
				FunctionNode functionnode = new FunctionNode(functionlist);
				return functionnode;
			}
			else if(tokenlist.get(i).getToken() == tokenright) {
				StringNode stringnode = new StringNode(tokenlist.get(i).toString());
				functionlist.add(stringnode);
				FunctionNode functionnode = new FunctionNode(functionlist);
				return functionnode;
			}
			else if(tokenlist.get(i).getToken() == tokenmid) {
				StringNode stringnode = new StringNode(tokenlist.get(i).toString());
				functionlist.add(stringnode);
				FunctionNode functionnode = new FunctionNode(functionlist);
				return functionnode;
			}
			else if(tokenlist.get(i).getToken() == tokenval) {
				StringNode stringnode = new StringNode(tokenlist.get(i).toString());
				functionlist.add(stringnode);
				FunctionNode functionnode = new FunctionNode(functionlist);
				return functionnode;
			}
			else {
				return null;
			}
		}
		return null;
	}
	
	
}
