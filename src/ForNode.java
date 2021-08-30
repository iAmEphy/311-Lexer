
public class ForNode extends StatementNode{
	private IntegerNode fornode;
	
	//next reference
	Node next;
	public String getString() {
        return fornode.toString();
    }
	
	public Node getFor() {
		return fornode;
	}
	//to string 
	@Override
	public String toString() {
        return "ForNode "+ fornode;
    }
	
	//constructor
	public ForNode(IntegerNode fornode) {
        this.fornode = fornode;
    }
}
