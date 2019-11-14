package test;

import MathDraw.MathDraw;
import java.util.Scanner;

class TestFunc {
	// you can make your own fucntions and send them to MathDraw
	public static double elevarE (double x) {
		return Math.pow(Math.E, x);
	}
}

public class testMathDraw {
	public static void main (String[] args) {

		Scanner a = new Scanner(System.in);
		// Just for make the program wait

		MathDraw md = new MathDraw(12, 0.05, 2.5, 0.05);
		md.sine();
		a.nextInt();
		md.cosine();
		a.nextInt();
		md.tangent();
		a.nextInt();
		md.reciprocal();
		// a lot of preloaded functions

		md = new MathDraw(-5, 5, 0.05, -2.5, 5.5, 0.1);

		md.func(TestFunc::elevarE);
		// you send your own functions this way
		a.nextInt();
		
		md.yAxis.setMin(-4);
		md.func(x -> x * x * x);
		// or this way
		a.nextInt();

		a.close();
	}
}
