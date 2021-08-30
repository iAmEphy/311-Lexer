
public class AssignmentNode extends StatementNode{

	private String varnode;
	private Node Nodeassign; 
	//private String variablenode;
	//private String assignnode;
	
	//get
	public Node getAssign() {
        return Nodeassign;
    }
	//to string 
	@Override
	public String toString() {
        return "AssignmentNode  "+ varnode + " " + Nodeassign;
    }
	
	//constructor
	public AssignmentNode(String varnode, Node Nodeassign) {
		this.varnode = varnode;
        this.Nodeassign = Nodeassign;
        
    }
}
