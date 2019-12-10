package myMathPro;

import java.util.Iterator;

public class aviTest {

	public static void main(String[] args) {
		Functions_GUI m = new Functions_GUI();
		ComplexFunction a = new ComplexFunction("min",new Polynom("4x^2"),new Polynom("2"));
		a.plus(new Polynom("x^3"));
		a.comp(new Polynom("x"));
		a.plus(new Polynom("3x+1"));
		Polynom b = new Polynom("3x");
		Monom c = new Monom("4x^2");
		m.add(a);
		m.add(b);
		m.add(c);
		
		Iterator<function> d = m.iterator();
		while(d.hasNext()) {
			System.out.println(d.next().toString());
		}
		int w=1000, h=600, res=200;
		Range rx = new Range(-10,10);
		Range ry = new Range(-5,10);
		m.drawFunctions(w, h, rx, ry, res);
		
	}
}





