
public class BooleanOperationNode extends Node{
	private String boolOp;
	
	public String getBoolean() {
        return boolOp;
    }
	//to string 
	@Override
	public String toString() {
        return "BooleanOpNode "+ boolOp;
    }
	
	//constructor
	public BooleanOperationNode(String boolOp) {
        this.boolOp = boolOp;
    }
}
