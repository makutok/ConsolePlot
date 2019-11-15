package termath;

public class Axis {
	private double min;
	private double max;
	private double unit;
	private char chAxis;

	public Axis (double min, double max, double unit) {
		this(min, max, unit, '·');
	}

	public Axis (double min, double max, double unit, char chAxis) {
		this.min = min;
		this.max = max;
		this.unit = unit;
		this.chAxis = chAxis;
	}

	public double getMin () {
		return min - unit;
	}

	public void setMin (double min) {
		this.min = min;
	}

	public double getMax () {
		return max + unit;
	}

	public void setMax (double max) {
		this.max = max;
	}

	public void setLength (double length) {
		double h = length / 2;
		this.min = -h;
		this.max = h;
	}

	public boolean inUnit (double n, double x) {
		double h = unit / 2;
		if (n >= x - h && n <= x + h) {
			return true;
		}
		return false;
	}

	public char getChar () {
		return chAxis;
	}

	public void setChar (char ch) {
		this.chAxis = ch;
	}

	public char posChar (double n) {
		if (Math.abs(n - (int) n) < unit) {
			return Character.forDigit(Math.abs((int) n), 1);
		}
		return chAxis;
	}

	public double getUnit () {
		return unit;
	}

	public void setUnit (double unit) {
		this.unit = unit;
	}
}
