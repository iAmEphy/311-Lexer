
public class VariableNode extends Node{

	private String variablename;
	
	
	
	//get
	public String getVariable(){
        return variablename;
    }	
	//to string 
	@Override
	public String toString() {
        return "VariableNode "+ variablename;
    }
	
	//constructor
	public VariableNode(String variablename) {
        this.variablename = variablename;
    }
}
