import java.util.ArrayList;

public class DataNode extends StatementNode{

	private ArrayList<Node> nodelist = new ArrayList<>();
	
	//Reference
	
	Node next;
	
	private StringNode listofstring;
	private IntegerNode intnode;
	private FloatNode floats;

		//get
		public ArrayList<Node> getString() {
	        return nodelist;
	    }
		
		public IntegerNode getInt() {
	        return intnode;
	    }
		
		public FloatNode getFloat() {
			return floats;
		}
		
		
		//to string 
		@Override
		public String toString() {
	        return "Data Node "+ listofstring + "\n" + intnode + "\n" + floats;
	    }
		
		//constructor
		public DataNode(ArrayList<Node> nodelist) {
	        this.nodelist = nodelist;
	    }

}
