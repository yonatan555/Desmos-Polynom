package Ex1Testing;

import myMath.Monom;
import myMath.Polynom;

public class PolynomTest {
	public static void main(String[] args) {
		test1(); 
		test2(); 
		test3(); 
		test4(); 
		test5(); 
		test6(); 
		test7();
		test8();
	}
	public static void test1() {
		Polynom p1 = new Polynom();
		String[] monoms = { "3x^2 + x" }; // test if the consrctuor is working
		Monom m1 = new Monom(monoms[0]);
		for (int i = 0; i < monoms.length; i++) {
			Monom m = new Monom(monoms[i]);
			p1.add(m);
		}
		System.out.println(p1); // test toString
		System.out.println(p1.f(2)); // test for f function (return the Y value at X value)
		System.out.println(p1.isZero()); // return if zero
		System.out.println(p1.root(1, 3, 0.000001)); // return the cross with pivot X
		System.out.println(p1.derivative()); // derivative
		System.out.println(p1.area(0, 2, 0.0000001)); // area
		p1.multiply(m1); // multiply function
		System.out.println(p1);
	}

	public static void test2() {
		Polynom p1 = new Polynom();
		String[] monoms = { "4x", "-3", "x^2", "x^3", "x^2" }; // test if the consrctuor is working
		Monom m1 = new Monom(monoms[0]);
		for (int i = 0; i < monoms.length; i++) {
			Monom m = new Monom(monoms[i]);
			p1.add(m);
		}
		System.out.println(p1); // test toString
		System.out.println(p1.f(2)); // test for f function (return the Y value at X value)
		System.out.println(p1.isZero()); // return if zero
		System.out.println(p1.derivative()); // derivative
		p1.multiply(m1); // multiply function
		System.out.println(p1);

	}

	public static void test3() {
		Polynom p1 = new Polynom();
		Polynom p2 = new Polynom();

		String[] monoms1 = { "x^4", "4x", "-3.2x^2", "4", "-1.5x^2" };
		String[] monoms2 = { "3", "x", "2x", "1.7x", "3.2x^2", "-3", "-1.5x^2" };

		for (int i = 0; i < monoms1.length; i++) {
			Monom m = new Monom(monoms1[i]);
			p1.add(m);
		}
		for (int i = 0; i < monoms2.length; i++) {
			Monom m = new Monom(monoms2[i]);
			p2.add(m);
		}
		p1.add(p2); // add function
		System.out.println(p1);
		System.out.println(p1); // test toString
		System.out.println(p1.derivative()); // derivative
		System.out.println(p1.isZero()); // return if zero
	}

	public static void test4() {
		Polynom p1 = new Polynom();
		Polynom p2 = new Polynom();

		String[] monoms1 = { "x^4", "4x", "-3.2x^2", "4", "-1.5x^2" };
		String[] monoms2 = { "3", "x", "2x", "1.7x", "3.2x^2", "-3", "-1.5x^2" };

		for (int i = 0; i < monoms1.length; i++) {
			Monom m = new Monom(monoms1[i]);
			p1.add(m);
		}
		for (int i = 0; i < monoms2.length; i++) {
			Monom m = new Monom(monoms2[i]);
			p2.add(m);
		}
		p1.multiply(p2); // polynom multiply test1
		System.out.println(p1);
		System.out.println(p2); // p2 toString
		System.out.println(p1.equals(p2)); // polynom isEqual between 2 strings		
		p1.multiply(p2);
		System.out.println("(p1+p2)*p2: " + p1);
		String s1 = p1.toString();
		System.out.println("from string: " + p1);
	}

	public static void test5() {
		Polynom p1 = new Polynom();
		String[] monoms = { "4x", "-3", "x^2", "x^3", "x^2" }; // test if the consrctuor is working
		Monom m1 = new Monom(monoms[0]);
		for (int i = 0; i < monoms.length; i++) {
			Monom m = new Monom(monoms[i]);
			p1.add(m);
		}
		System.out.println(p1.area(0, 2, 0.0000001)); // area
		System.out.println(p1.root(1, 3, 0.000001)); // return the cross with pivot X
		System.out.println(p1);
		System.out.println(p1); // test toString
		System.out.println(p1.derivative()); // derivative
		System.out.println(p1.isZero()); // return if zero
	}

	public static void test6() {
		Polynom p1 = new Polynom();
		String[] monoms = { "x", "3" }; // test if the consrctuor is working
		Monom m1 = new Monom(monoms[0]);
		for (int i = 0; i < monoms.length; i++) {
			Monom m = new Monom(monoms[i]);
			p1.add(m);
		}
		System.out.println(p1.area(0, 2, 0.0000001)); // area
		System.out.println(p1.root(1, 3, 0.000001)); // return the cross with pivot X
		System.out.println(p1);
		System.out.println(p1); // test toString
		System.out.println(p1.derivative()); // derivative
		System.out.println(p1.isZero()); // return if zero
	}

	private static void test7() {
		Polynom p1 = new Polynom();
		Polynom p2 = new Polynom();

		String[] monoms1 = { "x", "4x", "-1.2x^2", "4", "-9x^2" };
		String[] monoms2 = { "13","2x",  "3.5x^2" };

		for (int i = 0; i < monoms1.length; i++) {
			Monom m = new Monom(monoms1[i]);
			p1.add(m);
		}
		for (int i = 0; i < monoms2.length; i++) {
			Monom m = new Monom(monoms2[i]);
			p2.add(m);
		}
		p1.substract(p2);
		System.out.println(p1); // substract function between 2 polynoms
		System.out.println(p1);
		System.out.println(p1); // test toString
		System.out.println(p1.derivative()); // derivative
		System.out.println(p1.isZero()); // return if zero
	}

	private static void test8(){
		Polynom p1 = new Polynom();
		Polynom p2 = new Polynom();

		String[] monoms1 = { "x", "4x", "-1.2x^2", "4", "-9x^2" };
		String[] monoms2 = { "13","2x",  "3.5x^2" };

		for (int i = 0; i < monoms1.length; i++) {
			Monom m = new Monom(monoms1[i]);
			p1.add(m);
		}
		for (int i = 0; i < monoms2.length; i++) {
			Monom m = new Monom(monoms2[i]);
			p2.add(m);
		}
		p1.substract(p2);
		System.out.println(p1); // substract function between 2 polynoms
		System.out.println(p1);
		System.out.println(p1); // test toString
		System.out.println(p1.derivative()); // derivative
		System.out.println(p1.isZero()); // return if zero
	}

	}

