package myMathPro;

public class aviTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Monom m1 = new Monom(2,2);
		Monom m2 = new Monom(3,3);
		ComplexFunction cf = new ComplexFunction();
				cf.initFromString("div(mul(plus(2.0x^2,3.0x^3),2.0x^2),2.0x^2)");
		System.out.println(cf.toString());

		/*cf.mul(m1);
		System.out.println(cf.toString());
		cf.div(m1);
		System.out.println(cf.toString());
		cf.comp(m1);
		System.out.println(cf.toString());
		cf.max(m1);
		System.out.println(cf.toString());
		cf.min(m1);
		System.out.println(cf.toString());
		*/
		
		
	}

}
