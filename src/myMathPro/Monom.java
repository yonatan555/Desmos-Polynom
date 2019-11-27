
package myMathPro;

import java.util.Comparator;

import org.hamcrest.core.IsInstanceOf;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real
 * number and a is an integer (summed a none negative), see:
 * https://en.wikipedia.org/wiki/Monomial The class implements function and
 * support simple operations as: construction, value at x, derivative, add and
 * multiply.
 * 
 * @author Boaz
 *
 */
public class Monom implements function {
	public static final Monom ZERO = new Monom(0, 0);
	public static final Monom MINUS1 = new Monom(-1, 0);
	public static final double EPSILON = 0.0000001;
	public static final Comparator<Monom> _Comp = new Monom_Comperator();

	public static Comparator<Monom> getComp() {
		return _Comp;
	}

	public Monom(double a, int b) {
		this.set_coefficient(a);
		this.set_power(b);
	}

	public Monom() {
		this._coefficient = 0;
		this._power = 0;
	}

	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}

	public double get_coefficient() {
		return this._coefficient;
	}

	public int get_power() {
		return this._power;
	}

	/**
	 * this method returns the derivative monom of this.
	 * 
	 * @return
	 */
	public Monom derivative() {
		if (this.get_power() == 0) {
			return getNewZeroMonom();
		}
		return new Monom(this.get_coefficient() * this.get_power(), this.get_power() - 1);
	}

	public double f(double x) {
		double ans = 0;
		double p = this.get_power();
		ans = this.get_coefficient() * Math.pow(x, p);
		return ans;
	}

	public boolean isZero() {
		return this.get_coefficient() == 0;
	}

	// ***************** add your code below **********************
	public Monom(String s) throws RuntimeException {

		s = s.toLowerCase();
		String a = ""; // _coefficient
		int i = 0;
		if (s == "") { // if the string is empty
			a = "0";
			this._coefficient = 0;
			this._power = 0;
			return;
		}
		if (s.charAt(0) == '-') { // if the coef is '-'
			i = 1;
			if (s.charAt(1) == 'x')
				a = "1";
		}
		if (s.charAt(0) == 'x') {
			this._coefficient = 1;
			a = "1";
		}
		while (i < s.length() && s.charAt(i) != 'x') { // add the whole num to string
			if (s.charAt(i) >= 32 && s.charAt(i) <= 44 || s.charAt(i) == 47 || s.charAt(i) >= 58 && s.charAt(i) <= 93
					|| s.charAt(i) >= 95 && s.charAt(i) <= 119 || s.charAt(i) >= 121 && s.charAt(i) <= 127)
				throw new RuntimeException("wrong input");
			else {
				a = a + s.charAt(i);
				i++;
			}
		}
		if (s.charAt(0) == '-') {
			this._coefficient = -1 * Double.parseDouble(a);
		} else {
			this._coefficient = Double.parseDouble(a);
		}
		Boolean flag = false; // power
		a = "";
		int index = 0;
		while (index < s.length()) { // if X is exist
			if (s.charAt(index) == 'x')
				flag = true;
			index++;
		}
		if (flag == false)
			this._power = 0;
		else if (s.charAt(s.length() - 1) == 'x')// if X is at last char
			this._power = 1;
		else {
			i = i + 2;
			while (i < s.length()) {
				a = a + s.charAt(i);
				i++;
			}
			this._power = Integer.parseInt(a);
		}
	}

	public void add(Monom m) {
		this._coefficient = this._coefficient + m._coefficient;
	}

	public void multipy(Monom d) {
		this._coefficient = this._coefficient * d._coefficient;
		this._power = this._power + d._power;
	}

	public String toString() {
		String ans = "";
		if (this._power == 0)
			return "" + this._coefficient;
		if (this._power == 1)
			return this._coefficient + "x";

		ans = "" + this._coefficient + "x" + "^" + this._power;
		return ans;
	}

	public boolean equals(Object c) {
		if (c instanceof Monom) {

			if (this.get_coefficient() == ((Monom) c).get_coefficient() && this.get_power() == ((Monom) c).get_power())
				return true;
			if (this.get_coefficient() == 0 && ((Monom) c).get_coefficient() == 0)
				return true;
		}
		return false;
	}

	@Override
	public function initFromString(String s) {

		return null;
	}

	@Override
	public function copy() {

		return null;
	}
	// you may (always) add other methods.

	// ****************** Private Methods and Data *****************

	private void set_coefficient(double a) {
		this._coefficient = a;
	}

	private void set_power(int p) {
		if (p < 0) {
			throw new RuntimeException("ERR the power of Monom should not be negative, got: " + p);
		}
		this._power = p;
	}

	private static Monom getNewZeroMonom() {
		return new Monom(ZERO);
	}

	private double _coefficient;
	private int _power;
}
