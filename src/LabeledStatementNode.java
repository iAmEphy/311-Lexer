
public class LabeledStatementNode extends StatementNode{

	private String label;
	private AssignmentNode state;
	
	public String getString() {
        return label;
    }
	Node labelnode;
	public Node getLabel() {
    	return labelnode;
    }
	//to string 
	@Override
	public String toString() {
        return "LabelStateMentNode "+ label;
    }
	
	//constructor
	public LabeledStatementNode(String label, AssignmentNode state) {
        this.label = label;
        this.state = state;
    }
}
