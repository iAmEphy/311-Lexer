
public class ReturnNode extends StatementNode{
	private String returnvar;
	
	public String getString() {
        return returnvar;
    }
	//to string 
	@Override
	public String toString() {
        return "ReturnNode "+ returnvar;
    }
	
	//constructor
	public ReturnNode(String returnvar) {
        this.returnvar = returnvar;
    }
}
