
public class MathOpNode extends Node {
	
	Node left;
	Node right;
	Node mathop;
	MathOp op;
	
	
	public MathOpNode(MathOp op, Node left, Node right) {
		this.left = left;
		this.right = right;
		this.op = op;
		
	}
	
	//left reference of node
	public Node getLeft() {
		return left;
	}
	
	//right reference of node
	public Node getRight() {
		return right;
	}
	
	//mathOperation enum
	public enum MathOp {
		  ADD, 
		  SUBTRACT, 
		  MULTIPLY, 
		  DIVIDE;
	}
	
	//get Op 
	public MathOp getop() {
		return op;
	}
	
	
	//to string method
	@Override
	public String toString() {
        return "MathopNode " + mathop + right + left;
    }
		
}
