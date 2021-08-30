import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class Interpreter {
	//the hashmaps
	HashMap<String, Integer> IntMap = new HashMap<>();
	
	HashMap<String, Float> FloatMap = new HashMap<>();
	
	HashMap<String, String> StringMap = new HashMap<>();
	
	HashMap<String, Node> NodeMap = new HashMap<>();
	
	//private ArrayList<Token> token = new ArrayList<>();
	
	private ArrayList<Node> nodelist = new ArrayList<>();
	
	private Parser parsers;
	
	//constructor
	public Interpreter(Parser parsers){
		this.parsers = parsers;
		nodelist.add(parsers.Statements());
		
	}
	IntegerNode intnode;
	
	FloatNode floatnode;
	
	StringNode stringnode;
	
	StatementsNode Snode;
	
	LabeledStatementNode labelnode;
	
	AssignmentNode Assignnode;
	
	
	//Java stack of type Node as a local variable
	Node typeNode;
	
	//3 hashmaps Integer Float String
	public void getHash() {
		
		for(int i = 0; i < nodelist.size(); i++) {
			
		
		//integer
		if(parsers.Statement() == intnode) {
			IntMap.put(intnode.toString(), intnode.getNumber());
		}
		
		//float
		else if(parsers.Statement() == floatnode) {
			FloatMap.put(floatnode.toString(), floatnode.getNumber());
		}
		
		//string
		else if(parsers.Statement() == stringnode) {
			StringMap.put(stringnode.toString(), stringnode.toString());
		}
		
		else {
			
			
		}
		
		//look for label statement, replace with child node, assignmentnode
		if(Snode.getStatements() ==  labelnode) {
			NodeMap.put(Snode.toString(), Assignnode);
		}
		
		}
		
	}

	
	Node next;
	
	DataNode datanode;
	
	ReadNode readnode;
	
	PrintNode printnode;
	
	private ArrayList<Node> readlist = new ArrayList<>();
	
	//FOR and NEXT
	public void getFor() throws Exception{
		
		
		ForNode fornode = null;
		for(int i = 0; i < nodelist.size(); i++) {
			
			if(nodelist.contains(labelnode)) {
				
				NodeMap.put(labelnode.toString(), labelnode.getLabel());
				
			}
			else if(nodelist.contains(fornode)) {
				
				NodeMap.put(fornode.toString(), fornode.getFor());
				
				//Next reference
				Node temp;
		
				temp = fornode.getFor();
			}
		}
		
		//for(int x = 1; x < nodelist.size(); x++) {
			
		//}
	}
	
	
	
	
	
	public void dataread() {
		
		
		//ADD DATA READ?
		for(int i = 0; i < nodelist.size(); i++) {
			if(parsers.Statements() == datanode) {
				datanode = (DataNode) parsers.Statements();
				nodelist.add(datanode);
				//READ?
				readlist.add(datanode);
			}
			
		}
		
		
	}
	
	public void initialize() throws Exception {
		getHash();
		getFor();
		
	}
	
	StatementsNode withAnS;
	Node x;
	public void runOverStatementS() {
		int i;
		
		
		////Next item
		//for(i= 0; i < nodelist.size(); i++) {
		//	Node temp = nodelist.get(i);
		//	nodelist.set(i + 1, temp);
			
		//}
		
		
		//put statement node in a list
		ArrayList<Node> temporary = withAnS.getstate();
		//Next for each to the next item
		for(i= 0; i < nodelist.size(); i++) {
			
			if(withAnS.getStatements() != null) {
				
				//get the next item and set to next
				withAnS.next = temporary.get(i + 1);
				
				
			}
			
			//if(nodelist != null) {
				
				//withAnS.next = nodelist.get(i+1);
				
			
			//}
			
		}
	}
	
	AssignmentNode assignnode;
	InputNode inputnode;
	FunctionNode functionnode;
	VariableNode varnode;
	IfNode ifnode;
	public void interpret(StatementNode statenode) throws Exception{
		
		//put nodes from StatementS into list
		ArrayList<Node> temporary1 = withAnS.getstate();
		
		for(int i = 0; i < nodelist.size(); i++) {
			
			
			
			//another way to check readnode?
			if(withAnS.getStatements() instanceof ReadNode) {
				ArrayList<VariableNode> temporaryREAD = readnode.getRead();
				if(readlist.get(i) == temporaryREAD.get(i)) {
					
					StringMap.put(readlist.get(i).toString(), readlist.get(i).toString());
					
				}
				else {
					throw new Exception("error");
				}
				
			}
			
			
			//If true, set the currentNode to the FILL IN
			if(withAnS.getStatements() instanceof IfNode) {
				Node booltemp = ifnode.boolop();
				if(booltemp.toString() == "true" || booltemp.toString() == "True") {
					Node currentNode = stringnode;
				}
			}
			Stack<Node> nodestack = new Stack<>();
			
			
			//GOTO??
			if(withAnS.getStatements().toString() == "GOTO" || withAnS.getStatements().toString() == "THEN") {
				//set the currentNode to the label lookup.
				nodestack.push(withAnS.getStatements());
			}
			
			//Set the currentNode to the label lookup (from the map) for the gosub’s label.
			if(withAnS.getStatements() instanceof GosubNode) {
				nodestack.push(withAnS.getStatements());
				
			}
				
			
			//Set the currentInstruction to be that Node.
			if(withAnS.getStatements() instanceof ReturnNode) {
				nodestack.pop();
				nodestack.push(withAnS.getStatements());
			}
			
			if(withAnS.getStatements() instanceof ForNode) {
				int temps;
				temps = IntMap.get(i);
				IntMap.remove(i);
			}
			
			
			if(withAnS.getStatements() instanceof NextNode) {
				NextNode nextnode;
				ForNode fornode = (ForNode) withAnS.getStatements();
			}
			
			
			
			
			//determine which type of statement is in list
			if(temporary1.get(i) != null) {
				
				if(temporary1.get(i) == readnode) {
					ArrayList<VariableNode> temporaryREAD = readnode.getRead();
					
					//no match throw expceiton
					if(temporaryREAD.get(i) != readlist.get(i)) {
						
						throw new Exception("error");
						
					}
					else {
						
					}
					
				}
				
				
				
				//process expression     Lookup/create the variable and set its value in the map.
				if(temporary1.get(i) == assignnode) {
					Node assigntemp = assignnode.getAssign();
					
					if(NodeMap.get(i) == assignnode) {
						
						NodeMap.put(assignnode.toString(), assigntemp);
						
					}
				}
				
				//to print the string. Use Java appropriate input processing for input and assign the variable the values from Java.
				if(temporary1.get(i) == inputnode) {
					
					System.out.println(inputnode.toString());
					
					NodeMap.put(inputnode.toString(), inputnode);
					
				}
				
				//for each child of Print, use Java to print the values.
				if(temporary1.get(i) == printnode) {
					System.out.println(printnode.getPrint());
					
				}
				
				
				//evaluate each of the parameters, then run whatever Java code to implement the function
				if(temporary1.get(i) == functionnode) {
					ArrayList<Node> tempFunctionList = functionnode.getFunction();
					
					if(tempFunctionList.get(i) != null) {
						
						String temp = tempFunctionList.get(i).toString();
						
						//RANDOM FUNCTION
						if(temp == "RANDOM") {

							Random rand = new Random();
							int x = rand.nextInt(100);
							
						}
						
						if(temp == "LEFT$") {
							
							
							Scanner scans = new Scanner(System.in);
							//ask for number for leftmost and if the string is longer, then get left most character
							String input = scans.nextLine();
							int k = Integer.parseInt(input);
							if(temp.length() > k) {
								String leftstring = temp.substring(0, k);
								String rightstring = temp.substring(temp.length() - k);
								
							
							}
							else {
								
							}
						}
						
						if(temp == "RIGHT$") {
							
							
							Scanner scans = new Scanner(System.in);
							//ask for number for leftmost and if the string is longer, then get left most character
							String input = scans.nextLine();
							int k = Integer.parseInt(input);
							if(temp.length() > k) {
								
								String rightstring = temp.substring(temp.length() - k);
								
							
							}
							else {
								
							}
						}
						
						if(temp == "MID$") {
							Scanner scans = new Scanner(System.in);
							String input = scans.nextLine();
							String secondinput = scans.nextLine();
							
							int k = Integer.parseInt(input);
							
							int x = Integer.parseInt(secondinput);
							
							String midstring = temp.substring(k, x);
							
						}
						else {
							
						}
						
						
						//STRING TO AN INT
						if(temp == "VAL") {
							
							int number = Integer.valueOf(temp);
							
						}
						else {
							
							
						}
						
						//NUMBER TO STRING
						if(temp == "NUM$") {
							
							String s = String.valueOf(temp);
							
						}
						
					}
					
				}
				
				
				
				
			}
		}
		
	}
	MathOpNode mathop;
	
	
	
	public Node EvaluateIntMathOp(Node e) {
		
		//check if its integer
		if(e == intnode) {
			return e;
			
		}
		else {
			
		}
		
		//integer variable
		if(e == varnode) {
			return e;
		}
		
		
		if(e == mathop) {
			EvaluateIntMathOp(mathop.getLeft());
			EvaluateIntMathOp(mathop.getRight());
		}
		
		//EVALUATE LEFT RIGHT
		//+ - * /
		
		if(e == mathop.getLeft() || e == mathop.getRight()) {
			
			if(mathop.getLeft() == intnode) {
				
				int a =Integer.parseInt(mathop.getLeft().toString());
			
				int b = Integer.parseInt(mathop.getRight().toString());

				if(mathop.getop().toString() == "+") {
					
				
					int c = a + b;
				
				
					IntegerNode intnode = new IntegerNode(c);
				
				
					return intnode;
					
				}
			
			
				if(mathop.getop().toString() == "-") {
				
					int c = a - b;
				
					IntegerNode intnode = new IntegerNode(c);
				
				
					return intnode;
			
				}
			
			
			
				if(mathop.getop().toString() == "/") {
				
					int c = a / b;
				
					IntegerNode intnode = new IntegerNode(c);
				
				
					return intnode;
			
				}
			
			
				if(mathop.getop().toString() == "*") {
				
					int c = a * b;
				
					IntegerNode intnode = new IntegerNode(c);
				
				
					return intnode;
			
				}
			
			
			
			}
			
			
			//float
			if(mathop.getLeft() == floatnode) {
				
				float g = Float.parseFloat(mathop.getLeft().toString());
				
				float h = Float.parseFloat(mathop.getRight().toString());

				if(mathop.getop().toString() == "+") {
					
				
					float j = g + h;
				
				
					FloatNode floatnode = new FloatNode(j);
				
				
					return floatnode;
					
				}
				
				if(mathop.getop().toString() == "-") {
					
					
					float j = g - h;
				
				
					FloatNode floatnode = new FloatNode(j);
				
				
					return floatnode;
					
				}
			
				
				if(mathop.getop().toString() == "/") {
					
					
					float j = g / h;
				
				
					FloatNode floatnode = new FloatNode(j);
				
				
					return floatnode;
					
				}
				
				if(mathop.getop().toString() == "*") {
					
					
					float j = g * h;
				
				
					FloatNode floatnode = new FloatNode(j);
				
				
					return floatnode;
					
				}
			}
			
		}

		//if(e == mathop.getRight()) {
		//	
		//}
		
		return null;
	}
}
