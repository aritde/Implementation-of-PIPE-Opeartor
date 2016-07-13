package bonus;
public class SUBTRACT implements Chain {

	private Chain nextInChain;
	private int value;

	@Override
	public void setNextChain(Chain c) {
		this.nextInChain = c;
	}

	@Override
	public void Calculation(int new_result) {
		int result = new_result-value;
		if(null == nextInChain){
			System.out.println("Final Result: "+result);
		}else{
			nextInChain.Calculation(result);
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
