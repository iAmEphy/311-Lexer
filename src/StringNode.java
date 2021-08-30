
public class StringNode extends Node{
	
	private String prints;
	
	Node stringnodel;
	public String getString() {
        return prints;
    }
	
	public Node getStringNode() {
		return stringnodel;
	}
	//to string 
	@Override
	public String toString() {
        return "StringNode "+ prints;
    }
	
	//constructor
	public StringNode(String prints) {
        this.prints = prints;
    }
}
