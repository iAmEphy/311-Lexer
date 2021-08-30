
public class FloatNode extends Node	{
	
	private float floatnumber;
	private float valuef; 
	
	
	//get float
	public float getNumber() {
        return floatnumber;
    }
	//to string 
	@Override
	public String toString() {
        return "FloatNode "+floatnumber;
    }
	
	//float constructor
	public FloatNode(float f) {
        this.valuef = f;
    }
}
