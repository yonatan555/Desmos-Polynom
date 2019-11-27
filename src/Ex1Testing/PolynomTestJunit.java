package Ex1Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myMathPro.Monom;
import myMathPro.Polynom;

class PolynomTestJunit {

	@Test
	void testFunctison() {
		
	}

	@Test
	void testPolynomString() {
		Polynom p = new Polynom("-3x^2+2x+1");
		Polynom t = new Polynom();
		t.add(new Monom ("3x^2"));
		t.add(new Monom("2x"));
		t.add(new Monom("1"));
		assertEquals(t, p);
	}

	@Test
	void testF() {
		fail("Not yet implemented");
	}

	@Test
	void testAddPolynom_able() {
		fail("Not yet implemented");
	}

	@Test
	void testAddMonom() {
		fail("Not yet implemented");
	}

	@Test
	void testSubstract() {
		fail("Not yet implemented");
	}

	@Test
	void testMultiplyPolynom_able() {
		fail("Not yet implemented");
	}

	@Test
	void testEqualsPolynom_able() {
		fail("Not yet implemented");
	}

	@Test
	void testRoot() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
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
