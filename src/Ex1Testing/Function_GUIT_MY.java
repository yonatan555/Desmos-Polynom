package Ex1Testing;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myMathPro.ComplexFunction;
import myMathPro.Functions_GUI;
import myMathPro.Polynom;
import myMathPro.function;
import myMathPro.functions;

class Function_GUIT_MY {

	private functions _data = null;
	public static void test1() {
		String s = " plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x - 4.0)),2.0)";
		ComplexFunction m = new ComplexFunction("plus", new Polynom("5x"), new Polynom("2x"));
		function y = m.initFromString(s);
		m.plus(new Polynom("2x^5"));
		m.mul(new Polynom("-x"));
		m.max(new Polynom("2"));
		m.div(new Polynom("0"));
		function n = m.copy();
		System.out.println(n);
		System.out.println(m.equals(n));
		System.out.println(m.f(2));
		System.out.println(m);
		System.out.println(y);
		Polynom p = new Polynom("5x^2+0");
		System.out.println(p);
	}

	public static void test2() {
		String[] arr = { "7x+1", "2x^2-5x", "2", "x^4-8" };
		Polynom p = new Polynom(arr[0]);
		ComplexFunction cf = new ComplexFunction(p);
		for (int i = 1; i < arr.length; i++) {
			cf.plus(new Polynom(arr[i]));
		}
		System.out.println(cf);
	}

	@BeforeEach
	void testDrawFunctionsJSON() {
		_data.drawFunctions("GUI_params.txt");
		// fail("Not yet implemented");
	}
	@Test
	void testInitFromFile() throws Exception {

		Functions_GUI m = new Functions_GUI();
		
		m.initFromFile("test.txt");
		
		Iterator<function> itrfunc = m.iterator();
		while (itrfunc.hasNext()) {
			function func = itrfunc.next();
			if (!m.contains(func)) {
				fail("couldnt find the File");
			}
		}
	}

	 @Test
	void testSaveToFile() {

	}

	
	 @Test
	void testDrawFunctions() {

	}

	public static functions FunctionsFactory() {
		return _data;

}
}