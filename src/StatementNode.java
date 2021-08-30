
public abstract class StatementNode extends Node{

	String statement;
	private Node next;
	
	
	//get
	//public String getStatement() {
     //   return statement;
    //}
	//to string 
	@Override
	public String toString() {
        return " "+ statement;
    }
	
	//constructor
	//public StatementNode(String statement) {
    //    this.statement = statement;
   // }
	
	//public StatementNode(String varnode, Node nodeassign) {
   //     this.statement = varnode;
  //  }
}
