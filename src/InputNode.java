import java.util.ArrayList;

public class InputNode extends StatementNode {
	
	
	private ArrayList<Node> inputlist = new ArrayList<>();
	
	private StringNode input;
	private Node varnode;
	
	public Node getInput() {
        return input;
    }
	
	public ArrayList<Node> getList() {
		return inputlist;
	}
	//to string 
	@Override
	public String toString() {
        return "InputNode "+ input;
    }
	
	//constructor
	
	public InputNode(StringNode input, ArrayList<Node> inputlist1){
		this.input = input;
		this.inputlist = inputlist1;
	}
	
	public InputNode(VariableNode varnode, ArrayList<Node> inputlist1){
		this.varnode = varnode;
		this.inputlist = inputlist1;
	}
}
