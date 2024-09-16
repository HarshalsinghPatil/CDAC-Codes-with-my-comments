class Interval implements Comparable<Interval> {
// instance fields
	private int min;
	private int sec;
//constructor 
	public Interval(int m, int s) {
		min = m + s / 60;
		sec = s % 60; 
	}
//Getters and Setters
	public int minutes() {
		return min;
	}

	public int seconds() {
		return sec;
	}

	public int time() {
		return 60 * min + sec;
	}
// toString ,hashcode  and equals method
	public String toString() {
		if(sec < 10)
			return min + ":0" + sec;
		return min + ":" + sec;
	}

	public int hashCode() {
		return min + sec;
	}
//
	public boolean equals(Object other) {
		if(other instanceof Interval) {
			//if other is the instance of Interval class then downcast "other" to that "object"
			Interval that = (Interval)other; //explicit down-casting
			// to check both the objects are same or not
			return (this.min == that.min) && (this.sec == that.sec);
		}
		return false;
	}

	public int compareTo(Interval that) {
		return this.time() - that.time();
	}
}

