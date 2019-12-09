package Ex1Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myMathPro.ComplexFunction;
import myMathPro.Polynom;
import myMathPro.function;

class ComplexFunctionTest {

	@Test
	void testF() {
		ComplexFunction m = new ComplexFunction("plus",new Polynom("4x^2+3x"),new Polynom("4x"));
		double x = m.f(1);
		assertEquals(11,x);
	}

	@Test
	void testInitFromString() {
		ComplexFunction m = new ComplexFunction();
		function y = m.initFromString("plus(div(+5x^2+2x,-4x^2+3),div(4x,x))");
		function x = new ComplexFunction("plus", new ComplexFunction("div",new Polynom("5x^2+2x"),new Polynom("-4x^2+3")),new ComplexFunction("div",new Polynom("4x"),new Polynom("x")));
		
		assertEquals(x,y);
	}

	@Test
	void testCopy() {
		ComplexFunction m = new ComplexFunction("plus",new Polynom("4x^2+3x"),new Polynom("4x"));
		function y = new ComplexFunction();
		y=m.copy();
		assertEquals(y,m);
		
	}

	@Test
	void testPlus() {
		ComplexFunction m = new ComplexFunction(new Polynom("4x^2+7"));
		function y =  new Polynom("12x^3+3x^2+3");
		m.plus(y);
		ComplexFunction ans = new ComplexFunction("plus",new Polynom("4x^2+7"),new Polynom("12x^3+3x^2+3"));
		assertEquals(ans,m);
	}

	@Test
	void testMul() {
		ComplexFunction m = new ComplexFunction("plus",new Polynom("4x^2+7"),new Polynom("x^3+8x^2+7x+7x+1"));
		function y =  new Polynom("12x^3+3x^2+3");
		m.mul(y);
		ComplexFunction ans = new ComplexFunction("mul",new ComplexFunction("plus",new Polynom("4x^2+7"),new Polynom("x^3+8x^2+7x+7x+1")),new Polynom("12x^3+3x^2+3"));
		assertEquals(ans,m);
	}

	@Test
	void testDiv() {
		ComplexFunction m = new ComplexFunction("plus",new Polynom("x^2+7"),new Polynom("x^3+5x+9"));
		function y =  new ComplexFunction(new Polynom("10x^2+3x+1"));
		m.div(y);
		ComplexFunction ans = new ComplexFunction("div",new ComplexFunction("plus",new Polynom("x^2+7"),new Polynom("x^3+5x+9")),new ComplexFunction(new Polynom("10x^2+3x+1")));
		assertEquals(ans,m);
	}

	@Test
	void testMax() {
		ComplexFunction m = new ComplexFunction(new Polynom("4x^2+7"));
		function y =  new Polynom("12x^3+3x^2+3");
		m.max(y);
		ComplexFunction ans = new ComplexFunction("max",new Polynom("4x^2+7"),new Polynom("12x^3+3x^2+3"));
		assertEquals(ans,m);
	}

	@Test
	void testMin() {
		ComplexFunction m = new ComplexFunction(new Polynom("4x^2+7"));
		function y =  new Polynom("12x^3+3x^2+3");
		m.min(y);
		ComplexFunction ans = new ComplexFunction("min",new Polynom("4x^2+7"),new Polynom("12x^3+3x^2+3"));
		assertEquals(ans,m);
	}

	@Test
	void testComp() {
		ComplexFunction m = new ComplexFunction(new Polynom("4x^2+7"));
		function y =  new Polynom("12x^3+3x^2+3");
		m.comp(y);
		ComplexFunction ans = new ComplexFunction("comp",new Polynom("4x^2+7"),new Polynom("12x^3+3x^2+3"));
		assertEquals(ans,m);
	}

	@Test
	void testToString() {
		ComplexFunction m = new ComplexFunction("plus",new Polynom("4x^2+3x"),new Polynom("4x"));
		String s = m.toString();
		String ans = "plus(4.0x^2+3.0x,4.0x)";
		assertEquals(ans,s);
	}

}
