
public class PrintNode extends StatementNode{

	private String print;
	
	
	
	//get
	public String getPrint() {
        return print;
    }
	//to string 
	@Override
	public String toString() {
        return "PrintNode "+ print;
    }
	
	//constructor
	public PrintNode(String print) {
        this.print = print;
    }
}
