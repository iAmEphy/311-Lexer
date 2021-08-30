import java.util.ArrayList;

public class StatementsNode extends Node{

	private ArrayList<Node> state = new ArrayList<>();
	private Node x; 
	Node next;
	
	//get
	public Node getStatements() {
        return x;
	}
	
	
	//to string 
	@Override
	public String toString() {
        return "StatementsNode "+ x;
    }
	
	//constructor
	public StatementsNode(Node x) {
       this.x = x;
        state.add(x);
	}
	
	public ArrayList<Node> getstate() {
		return state;
	}
}
