import java.util.ArrayList;

public class FunctionNode extends Node{
	private ArrayList<Node> functionlist;
	
	public ArrayList<Node> getFunction() {
        return functionlist;
    }
	//to string 
	@Override
	public String toString() {
        return "FunctionNode "+ functionlist.toString();
    }
	
	//constructor
	public FunctionNode(ArrayList<Node> functionlist) {
        this.functionlist = functionlist;
    }
}
