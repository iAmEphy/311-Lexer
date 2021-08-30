import java.util.ArrayList;

public class ReadNode extends StatementNode{
	
	private ArrayList<VariableNode> varlist = new ArrayList<>();
	//get
		public ArrayList<VariableNode> getRead() {
	        return varlist;
	    }
		//to string 
		@Override
		public String toString() {
	        return "ReadNode "+ varlist;
	    }
		
		//constructor
		public ReadNode(ArrayList<VariableNode> varlist) {
	        this.varlist = varlist;
	    }

}
