package bonus;
//import java.lang.Math;
public class Exponential implements Chain{

	private Chain nextInChain;
	private int value;

	@Override
	public void setNextChain(Chain c) {
		this.nextInChain = c;
	}

	@Override
	public void Calculation(int  new_result) {
		double result = Math.pow((double)new_result,(double)value);
		int res = (int)result;
		if(null == nextInChain){
			System.out.println(" Final Result: "+res);
		}else{
			nextInChain.Calculation(res);
		}
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Chain getChain() {
		return nextInChain;
	}

	public void setChain(Chain nextInChain) {
		this.nextInChain = nextInChain;
	}


}
