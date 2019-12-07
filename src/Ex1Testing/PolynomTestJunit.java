package Ex1Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myMathPro.Monom;
import myMathPro.Polynom;
import myMathPro.Polynom_able;

class PolynomTestJunit {
	@Test
	void testPolynomString() {
		Polynom p = new Polynom("+3x^2+2x+1");
		Polynom t = new Polynom();
		t.add(new Monom ("3x^2"));
		t.add(new Monom("2x"));
		t.add(new Monom("1"));
		assertEquals(t, p);
	}

	@Test
	void testF() {
		Polynom p = new Polynom("+4x^3+2");
		double i = 6;
		assertEquals(i, p.f(1));
	}

	@Test
	void testAddPolynom_able() {
		Polynom p = new Polynom("+4x^3+2x^2-1");
		Polynom y = new Polynom("+2x^2+2");
		p.add(y);
		Polynom t = new Polynom("+4x^3+4x^2+1");
		assertEquals(t, p);
	}

	@Test
	void testAddMonom() {
		Polynom p = new Polynom("+4x^3+2x^2-1");
		Monom y = new Monom("12");
		p.add(y);
		Polynom t = new Polynom("+4x^3+2x^2+11");
		assertEquals(t, p);
	}

	@Test
	void testSubstract() {
		Polynom p = new Polynom("4x^3+2x^2-1");
		Polynom y = new Polynom("2x^2+2");
		p.substract(y);
		Polynom t = new Polynom("4x^3-3");
		assertEquals(t, p);
	}

	@Test
	void testMultiplyPolynom_able() {
		Polynom p = new Polynom("x");
		Polynom_able y = new Polynom("x^2");
		p.multiply(y);
		Polynom t = new Polynom("x^3");
		assertEquals(t, p);
	}

	@Test
	void testRoot() {
		Polynom root = new Polynom("x-4");
		double exp = root.root(5, -5, 0.0000001);
		if(exp<=4.0001 && exp>3.9999) {
			exp = 4.0; 
		}
		assertEquals(4.0,exp);
	}

	@Test
	void testDerivative() {
		Polynom func = new Polynom("3x^4+12x^2+7x+3");
		Polynom_able m = func.derivative();
		Polynom derv1 = new Polynom("12x^3+24x+7");
		assertEquals(derv1,m);
	}

	@Test
	void testArea() {
		Polynom m = new Polynom("x^2+1");
		double i = m.area(-1,2, 0.0000001);
		System.out.println(i);
		assertEquals(1.0833333333374775, i);
	}

	@Test
	void testMultiplyMonom() {
		Polynom p = new Polynom("5x^2+3x");
		Monom m = new Monom("x");
		p.multiply(m);
		Polynom y = new Polynom("5x^3+3x^2");
		assertEquals(y, p);
	}

	@Test
	void testToString() {
		Polynom m = new Polynom("3x^2+55x+1");
		String i = m.toString();
		String j = "3.0x^2+55.0x+1.0";
		assertEquals(j, i);
	}

	@Test
	void testInitFromString() {
		Polynom p = new Polynom();
		Polynom i = new Polynom("3x^2+5x+5");
		assertEquals(i, p.initFromString("3x^2+5x+5"));
	}

}
