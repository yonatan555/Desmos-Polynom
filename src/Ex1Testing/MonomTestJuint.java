package Ex1Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myMathPro.ComplexFunction;
import myMathPro.Monom;
import myMathPro.Polynom;
class MonomTestJuint {

	@Test
	void testDerivative() {
		Monom exist = new Monom("4x");
		Monom test = new Monom(exist.derivative());
		Monom expected = new Monom("4");
		assertEquals(expected, test,"error");
	}
	@Test
	void testF() {
		Monom m = new Monom("4x^2");
		double a = m.f(2);
		assertEquals(16, a);
	}

	@Test
	void testMonomString() {
		Monom m = new Monom("3x");
		Monom r = new Monom(3,1);
		assertEquals(r, m,"succeed");
	}

	@Test
	void testAdd() {
		Monom m = new Monom("4x^2");
		m.add(new Monom("3x^2"));
		Monom e = new Monom("7x^2");
		assertEquals(e, m);
	}

	@Test
	void testMultipy() {
		Monom m = new Monom ("3x^3");
		m.multipy(new Monom ("4x"));
		Monom n = new Monom ("12x^4");
		assertEquals(n, m);
	}

	@Test
	void testToString() {
		Monom m = new Monom ("3x^ 5");
		String s=m.toString();
		assertEquals("3.0x^5", s);
	}

	@Test
	void testInitFromString() {
		Monom m =new Monom ();
		 m.initFromString("3.0x^2");
		 Monom i = new Monom ("3.0x^2");
		assertEquals(i, m);
	}

	@Test
	void testCopy() {
		Monom m =new Monom ("3.0x^2");
		 Monom i = (Monom) m.copy();
		assertEquals(i, m);
	}

}
