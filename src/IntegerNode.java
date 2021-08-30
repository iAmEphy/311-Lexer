
public class IntegerNode extends Node {
	private int integernumber;
	private int value; 
	
	//get the int number
	public int getNumber() {
        return integernumber;
    }
	
	//tostring method
	@Override
	public String toString() {
        return "IntegerNode " + integernumber;
    }
	
	//constructor
	public IntegerNode(int v) {
        this.value = v;
    }
	
	
}
