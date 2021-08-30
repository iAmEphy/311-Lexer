
public class GosubNode extends StatementNode{
	
private String sub;
	
	public String getString() {
        return sub;
    }
	//to string 
	@Override
	public String toString() {
        return "GoSubNode "+ sub;
    }
	
	//constructor
	public GosubNode(String sub) {
        this.sub = sub;
    }
}
