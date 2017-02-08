package texas_holdem_java_bot;

import java.util.Comparator;

public enum Value implements Comparator<Value> {
	two(2),
	three(3),
	four(4),
	five(5),
	six(6),
	seven(7),
	eight(8),
	nine(9),
	ten(10),
	jack(11),
	queen(12),
	king(13),
	ace(14);
	
	private int suitValue;
	
	private Value(int suitValue) {
		this.suitValue = suitValue;
	}
	
	public int getSuitValue() {
		return this.suitValue;
	}
	
	@Override
	public int compare(Value o1, Value o2) {
		return ((Integer)o1.getSuitValue()).compareTo(o2.getSuitValue());
	}
}
