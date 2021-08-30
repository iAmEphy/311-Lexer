
public class IfNode extends Node{
	private String ifnode;
	private BooleanOperationNode boolop;
	private String ifstring;
	
	public String getIf() {
        return ifnode.toString();
    }
	//to string 
	@Override
	public String toString() {
        return "IfNode " + ifstring + " " + boolop + " " + ifnode;
    }
	
	//constructor
	//label second parameter
	public IfNode(String ifstring, BooleanOperationNode boolop, String ifnode) {
		this.ifstring = ifstring;
		this.boolop = boolop;
        this.ifnode = ifnode;
    }
	
	public Node boolop() {
		return boolop;
	}
}
