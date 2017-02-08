package texas_holdem_java_bot;

import java.util.Comparator;

public enum Value implements Comparator<Value> {
	two(2, '2'),
	three(3, '3'),
	four(4, '4'),
	five(5, '5'),
	six(6, '6'),
	seven(7, '7'),
	eight(8, '8'),
	nine(9, '9'),
	ten(10, 'T'),
	jack(11, 'J'),
	queen(12, 'Q'),
	king(13, 'K'),
	ace(14, 'A');
	
	private int suitValue;
	private char value;
	
	private Value(int suitValue, char value) {
		this.suitValue = suitValue;
		this.value = value;
	}
	
	public int getSuitValue() {
		return this.suitValue;
	}
	
	public char getValueChar() {
		return this.value;
	}
	
	@Override
	public int compare(Value o1, Value o2) {
		return ((Integer)o1.getSuitValue()).compareTo(o2.getSuitValue());
	}
}
