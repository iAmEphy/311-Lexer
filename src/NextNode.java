
public class NextNode extends StatementNode{
	
	VariableNode next;
	
	//node reference
	Node nextnext;
	public String getString() {
        return next.toString();
    }
	//to string 
	@Override
	public String toString() {
        return "NextNode "+ next.toString();
    }
	
	//constructor
	public NextNode(VariableNode next) {
        this.next = next;
    }
}
