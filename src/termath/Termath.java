package termath;

import java.util.function.Function;

public class Termath {

	public Axis xAxis;
	public Axis yAxis;

	private char chFunc;
	private char chZero;
	private char chSpace;

	public Termath () {
		this(12, 6);
	}

	public Termath (double xLength, double yLength) {
		this(xLength, 0.05, yLength, 0.1);
	}

	public Termath (double xLength, double xUnit, double yLength, double yUnit) {
		double xh = xLength / 2;
		double yh = yLength / 2;
		this.xAxis = new Axis(-xh, xh, xUnit, '—');
		this.yAxis = new Axis(-yh, yh, yUnit, '|');
		this.chFunc = '·';
		this.chZero = '+';
		this.chSpace = ' ';

	}

	public Termath (double xMin, double xMax, double xUnit, double yMin, double yMax, double yUnit) {
		this(xMin, xMax, xUnit, yMin, yMax, yUnit, '·', '+', ' ', '—', '|');
	}

	public Termath (double xMin, double xMax, double xUnit, double yMin, double yMax, double yUnit, char chFunc,
			char chZero, char chSpace, char chXAxis, char chYAxis) {
		this.xAxis = new Axis(xMin, xMax, xUnit, chXAxis);
		this.yAxis = new Axis(yMin, yMax, yUnit, chYAxis);
		this.chFunc = chFunc;
		this.chZero = chZero;
		this.chSpace = chSpace;
	}

	public void setChFunc (char chFunc) {
		this.chFunc = chFunc;
	}

	public void setChZero (char chZero) {
		this.chZero = chZero;
	}

	public void setChSpace (char chSpace) {
		this.chSpace = chSpace;
	}

	private void print (char ch) {
		System.out.print(ch);
	}

	public void func (Function<Double, Double> f) {
		double x, y, fx;
		y = yAxis.getMax();

		while (y >= yAxis.getMin()) {
			x = xAxis.getMin();

			while (x <= xAxis.getMax()) {
				fx = f.apply(x);

				if (yAxis.inUnit(y, fx)) {
					print(chFunc);
				} else if (xAxis.inUnit(x, 0)) {
					if (yAxis.inUnit(y, 0)) {
						print(chZero);
					} else {
						print(yAxis.getChar());
					}
				} else if (yAxis.inUnit(y, 0)) {
					System.out.print(xAxis.getChar());
				} else {
					System.out.print(chSpace);
				}

				x += xAxis.getUnit();
			}
			System.out.print('\n');
			y -= yAxis.getUnit();
		}
	}
	

	public void sine () {
		this.func(Math::sin);
	}

	public void cosine () {
		this.func(Math::cos);
	}

	public void tangent () {
		this.func(Math::tan);
	}

	public void linear (double n) {
		this.func(x -> x * n);
	}

	public void square () {
		this.func(x -> x * x);
	}

	public void cube () {
		this.func(x -> x * x * x);
	}

	public void power (double n) {
		this.func(x -> Math.pow(x, n));
	}

	public void exponential () {
		this.func(x -> Math.pow(Math.E, x));
	}

	public void reciprocal () {
		this.func(x -> 1 / x);
	}

	public void squareRoot () {
		this.func(Math::sqrt);
	}

	public void absolute () {
		this.func(Math::abs);
	}

	public void logaritmic () {
		this.func(Math::log);
	}
}
