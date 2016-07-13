package bonus;

public class ADD implements Chain {

	private Chain nextInChain;
	private int value;

	@Override
	public void setNextChain(Chain c) {
		this.nextInChain = c;
	}

	@Override
	public void Calculation(int new_result) {
		int result = value + new_result;
		if(null == nextInChain){
			System.out.println(" Final Result is: "+result);
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
