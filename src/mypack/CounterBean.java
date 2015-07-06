package mypack;

import java.io.Serializable;

public class CounterBean implements Serializable {

	public CounterBean(){}
	private int counter = 1;
	
	public int getCounter(){
		return counter;
	}
	
	public void setCounter(int counter){
		this.counter = counter;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Counter is: " + this.counter;
	}

}
