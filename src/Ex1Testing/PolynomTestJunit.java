package Ex1Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myMathPro.Monom;
import myMathPro.Polynom;

class PolynomTestJunit {

	@Test
	void testFunctison() {
		fail("Not yet implemented");
	}

	@Test
	void testPolynomString() {
		Polynom p = new Polynom("3x^2+2x+1");
		Polynom t = new Polynom();
		t.add(new Monom ("3x^2"));
		t.add(new Monom("2x"));
		t.add(new Monom("1"));
		assertEquals(t, p);
	}

	@Test
	void testF() {
		Polynom p = new Polynom("4x^3+2");
		double i = 6;
		assertEquals(i, p.f(1));
	}

	@Test
	void testAddPolynom_able() {
		Polynom p = new Polynom("4x^3+2x^2-1");
		Polynom y = new Polynom("2x^2+2");
		p.add(y);
		Polynom t = new Polynom("4x^3+4x^2+1");
		assertEquals(t, p);
	}

	@Test
	void testAddMonom() {
		Polynom p = new Polynom("4x^3+2x^2-1");
		Monom y = new Monom("12");
		p.add(y);
		Polynom t = new Polynom("4x^3+2x^2+11");
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
		Polynom y = new Polynom("x^2");
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
		fail("Not yet implemented");
	}

	@Test
	void testArea() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

	@Test
	void testInitFromString() {
		fail("Not yet implemented");
	}

}
