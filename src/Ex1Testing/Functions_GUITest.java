package Ex1Testing;

import java.io.IOException;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;


import myMathPro.ComplexFunction;
import myMathPro.Functions_GUI;
import myMathPro.Monom;
import myMathPro.Operation;
import myMathPro.Polynom;
import myMathPro.Range;
import myMathPro.function;
import myMathPro.functions;

/**
 * Note: minor changes (thanks to Amichai!!) The use of "get" was replaced by
 * iterator!
 * 
 * Partial JUnit + main test for the GUI_Functions class, expected output from
 * the main: 0) java.awt.Color[r=0,g=0,b=255] f(x)= plus(-1.0x^4 +2.4x^2
 * +3.1,+0.1x^5 -1.2999999999999998x +5.0) 1) java.awt.Color[r=0,g=255,b=255]
 * f(x)= plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0) 2)
 * java.awt.Color[r=255,g=0,b=255] f(x)= div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5
 * -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1) 3)
 * java.awt.Color[r=255,g=200,b=0] f(x)= -1.0x^4 +2.4x^2 +3.1 4)
 * java.awt.Color[r=255,g=0,b=0] f(x)= +0.1x^5 -1.2999999999999998x +5.0 5)
 * java.awt.Color[r=0,g=255,b=0] f(x)= max(max(max(max(plus(-1.0x^4 +2.4x^2
 * +3.1,+0.1x^5 -1.2999999999999998x +5.0),plus(div(+1.0x +1.0,mul(mul(+1.0x
 * +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)),div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5
 * -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)),-1.0x^4 +2.4x^2
 * +3.1),+0.1x^5 -1.2999999999999998x +5.0) 6) java.awt.Color[r=255,g=175,b=175]
 * f(x)= min(min(min(min(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x
 * +5.0),plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x
 * -4.0)),2.0)),div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x
 * +5.0),-1.0x^4 +2.4x^2 +3.1)),-1.0x^4 +2.4x^2 +3.1),+0.1x^5
 * -1.2999999999999998x +5.0)
 * 
 * @author boaz_benmoshe
 *
 */
class Functions_GUITest {
	private functions _data = null;
	public static void main(String[] a) throws IOException {
		
		
		try {
			Functions_GUI m =  new Functions_GUI();	
			m.initFromFile("test.txt");
			m.drawFunctions(800, 600, new Range(-10, 10), new Range(-5, 15), 200);
			
			
			
		}
		catch (Exception e) {
			System.out.println("ss");
		}

		/*// test1();
		 test2(); 

		
		 * Polynom p1= new Polynom ("x^8+2x^2+1"); Polynom p2=new Polynom("x");
		 * 
		 * ComplexFunction cf = new ComplexFunction("plus",new Polynom("0.5x^7"),p2);
		 * ComplexFunction cf1 = new ComplexFunction("mul", new Polynom("x"), new
		 * Polynom("x^2+x"));
		 * 
		 * 
		 * Functions_GUI m = new Functions_GUI();
		 * 
		 * 
		 * m.add(p1); m.add(p2); m.add(cf); m.add(cf1);
		 * m.drawFunctions("GUI_params.txt");
		 

		Functions_GUI data = (Functions_GUI) FunctionsFactory();
		int w = 1000, h = 600, res = 200;
		Range rx = new Range(-10, 10);
		Range ry = new Range(-5, 15);
		data.drawFunctions(w, h, rx, ry, res);

		Functions_GUI m = new Functions_GUI();
		ComplexFunction e = new ComplexFunction("div", new ComplexFunction(new Polynom("4x^2")),
				new ComplexFunction("mul", new Polynom("x"), new Polynom("x^7")));
		System.out.println(e.f(0));

		m.initFromFile("Functions_GUITest.txt");
		m.saveToFile("txt");
		ComplexFunction fun = new ComplexFunction();
		System.out.println(fun.initFromString("plus(div(+5x^2+2x,-4x^2+3),div(4x,x))"));
		ComplexFunction x = new ComplexFunction();
		function y = x.initFromString("comp(div(+5x^2+2x,-4x^2+3),comp(div(x,x^2),div(5x,2x^2+1)))");
		System.out.println(y.f(0));
		FunctionsFactory();

		data.drawFunctions(w, h, rx, ry, res);
		String file = "function_file.txt";
		String file2 = "function_file2.txt";
		try {
			data.saveToFile(file);
			Functions_GUI data2 = new Functions_GUI();
			data2.initFromFile(file);
			data.saveToFile(file2);
		} catch (Exception ed) {
			ed.printStackTrace();
		}

		String JSON_param_file = "GUI_params.txt";
		data.drawFunctions(JSON_param_file);
*/
	}
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
	/*void setUp() throws Exception {
		_data = FunctionsFactory();
	}*/
	// @Test
	void testInitFromFile() {
		Functions_GUI m =  new Functions_GUI();	
		m.initFromFile("test.txt");
		
		Iterator<function> itrfunc = m.iterator();
		
		
	}
	// @Test
	void testSaveToFile() {
		
		
	
	}
	// @Test
	void testDrawFunctions() {
		
	
	}

	public static functions FunctionsFactory() {
		functions ans = new Functions_GUI();
		String s1 = "3.1 +2.4x^2 -x^4";
		String s2 = "5 +2x -3.3x +0.1x^5";
		String[] s3 = { "x +3", "x -2", "x -4" };
		Polynom p1 = new Polynom(s1);
		Polynom p2 = new Polynom(s2);
		Polynom p3 = new Polynom(s3[0]);
		ComplexFunction cf3 = new ComplexFunction(p3);
		for (int i = 1; i < s3.length; i++) {
			cf3.mul(new Polynom(s3[i]));
		}
		System.out.println(cf3);
		ComplexFunction cf = new ComplexFunction(Operation.Plus, p1, p2);
		ComplexFunction cf4 = new ComplexFunction("div", new Polynom("x +1"), cf3);
		cf4.plus(new Monom("2"));
		System.out.println(ans.size());// 0
		ans.add(cf.copy());
		System.out.println(ans);
		System.out.println(ans.size());// 1
		ans.add(cf4.copy());
		System.out.println(ans.size());// 2
		cf.div(p1);
		ans.add(cf.copy());
		System.out.println(ans.size());// 3
		String s = cf.toString();
		System.out.println(s);
		function cf5 = cf4.initFromString(s1);
		function cf6 = cf4.initFromString(s2);
		ans.add(cf5.copy());
		System.out.println(ans.size());// 4
		ans.add(cf6.copy());
		System.out.println(ans);
		System.out.println(ans.size());// 5
		Iterator<function> iter = ans.iterator();
		function f = iter.next();
		ComplexFunction max = new ComplexFunction(f);
		ComplexFunction min = new ComplexFunction(f);
		while (iter.hasNext()) {
			f = iter.next();
			max.max(f);
			min.min(f);
		}
		System.out.println(max);
		System.out.println(min);

		ans.add(max);
		ans.add(min);
		System.out.println(ans.size());// 7
		return ans;
	}
}
