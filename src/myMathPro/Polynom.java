package myMathPro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;

import org.hamcrest.core.IsInstanceOf;
import org.omg.CORBA.TIMEOUT;

import myMath.Monom;

/**
 * This class represents a Polynom with add, multiply functionality, it also
 * should support the following: 1. Riemann's Integral:
 * https://en.wikipedia.org/wiki/Riemann_integral 2. Finding a numerical value
 * between two values (currently support root only f(x)=0). 3. Derivative
 * 
 * @author Boaz
 *
 */
public class Polynom implements Polynom_able {
	ArrayList<Monom> polynom;

	/**
	 * Zero (empty polynom)
	 */
	public Polynom() {
		this.polynom = new ArrayList<Monom>();
		this.polynom.add(new Monom(Monom.ZERO));
	}
	public void  functison() {
		;
	}

	/**
	 * init a Polynom from a String such as: {"x", "3+1.4X^3-34x",
	 * "(2x^2-4)*(-1.2x-7.1)", "(3-3.4x+1)*((3.1x-1.2)-(3X^2-3.1))"};
	 * 
	 * @param s: is a string represents a Polynom
	 */
	public Polynom(String s) throws RuntimeException {
		this.polynom = new ArrayList<Monom>();

		if (s.length() == 0)
			this.add(Monom.ZERO);
		else {
			String a = "";
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) >= 32 && s.charAt(i) <= 42 ||s.charAt(i)==44 || s.charAt(i) == 47 || s.charAt(i) >= 58 && s.charAt(i) <= 93 || s.charAt(i) >= 95 && s.charAt(i) <= 119 
						|| s.charAt(i) >= 121 && s.charAt(i) <= 127)
					throw new RuntimeException("wrong input");
				else {
					if (s.charAt(i) == '+' || s.charAt(i) == '-' || i == (s.length()-1)) {
						if (s.charAt(0) == '-') {
							for (int j = 1; j < s.length(); j++) {
								if (s.charAt(j) == '+' || s.charAt(j) == '-') {
									a =  s.substring(0, j);
									if (s.charAt(j) == '-')
										s = s.substring(j);
									else
										s = s.substring(j+1);
									i = 0;
									Monom m = new Monom(a);
									this.add(m);
									break;
								}
							}
						} 
						else 
						{
							if (i==(s.length()-1)) {
								Monom m = new Monom(s);
								this.add(m);
								return;
							}
							else {
								a =  s.substring(0, i);
							}
							if (s.charAt(i) == '-')
								s = s.substring(i);
							else if (s.charAt(i)== '+')
								s = s.substring(i + 1);
							i = 0;
							Monom m = new Monom(a);
							this.add(m);
						}
					}
				}
			}
			if(s.length()==1) {
				Monom m = new Monom(s);
				this.add(m);
			}
				
		}
	}
	@Override
	public double f(double x) {
		double ans = 0;
		for (int i = 0; i < polynom.size(); i++) {
			ans += polynom.get(i).f(x);
		}
		return ans;
	}
	@Override
	public void add(Polynom_able p1) {
		Iterator<Monom> ite = p1.iteretor();
		while (ite.hasNext()) {
			this.add(ite.next());
		}
	}

	@Override
	public void add(Monom m1) {
		Boolean flag = false;
		for (int i = 0; i < this.polynom.size(); i++) { // adding monom to polynom
			if (this.polynom.get(i).get_power() == m1.get_power()) {
				this.polynom.get(i).add(m1);
				flag = true;
			}
		}
		if (flag == false)
			this.polynom.add(m1);
	}

	@Override

	public void substract(Polynom_able p1) {
		Monom m = new Monom("-1");
		p1.multiply(m);
		this.add(p1);
	}
	@Override
	public void multiply(Polynom_able p1) {

		Polynom ans = new Polynom();
		for (int i = 0 ; i<polynom.size();i++) {
			Iterator<Monom> it = p1.iteretor();
			while (it.hasNext()) {
				Monom m = new Monom("1");
				m.multipy(it.next());
				m.multipy(polynom.get(i));
				ans.add(m);
			}
		}
		this.polynom = ans.polynom;
		this.polynom.sort(Monom._Comp);


	}
	@Override
	public boolean equals(Object p1) {
		if(p1 instanceof Polynom_able) {
			polynom.sort(Monom._Comp);
			Iterator<Monom> etiP = ((Polynom_able )p1).iteretor();
			Iterator<Monom> etiT = this.iteretor();
			while (etiP.hasNext() || etiT.hasNext()) {
				if (!(etiP.next().equals(etiT.next())))
					return false;
			}
			return true;
		}
		return false;
	}
	@Override
	public boolean isZero() {
		for (int i = 0; i < polynom.size(); i++) {
			if (polynom.get(i).isZero() == false)
				return false;
		}
		return true;
	}
	@Override
	public double root(double x0, double x1, double eps) {
		double f0 = this.f(x0);
		double f1 = this.f(x1);
		if ((f0 * f1) > 0) {
			throw new RuntimeException("the multiply is up to 0 ,hence there is no cross with pivot X");
		}
		double x2 = (x0 + x1) / 2;		
		while (f(x2) < -eps ||  f(x2)> eps) {
			if (f(x2) > eps) {
				x1 = x2 ;
				x2 = (x0 + x1) / 2;
			}
			if(f(x2) <-eps) {
				x0 = x2 ;
				x2 = (x0 + x1) / 2;
			}
		}
		return x2;
	}
	@Override
	public Polynom_able copy() {

		Polynom_able polyCopy = new Polynom();
		Iterator<Monom> it = this.iteretor();
		while (it.hasNext()) {
			polyCopy.add(it.next());
		}
		return polyCopy;
	}

	@Override
	public Polynom_able derivative() {

		Polynom_able derive = new Polynom();
		Iterator<Monom> it = this.iteretor();
		while (it.hasNext()) {
			derive.add(it.next().derivative());
		}
		return derive;
	}

	@Override
	public double area(double x0, double x1, double eps) {
		if(x0 >= x1) {
			return 0; 
		}
		double n = (x0+x1)/eps;
		double avr = (x0+eps)/2;
		double x=0;
		double sum=0;
		for (int i = 1; i <=n; i++) {
			x=(this.f(avr))*eps;
			sum+=x;
			avr+=eps;
		}
		return Math.abs(sum);
	}

	@Override
	public Iterator<Monom> iteretor() {
		return polynom.iterator();
	}

	@Override
	public void multiply(Monom m1) {
		for (int i = 0; i < polynom.size(); i++) {
			polynom.get(i).multipy(m1);
		}
	}

	public String toString() {
		polynom.sort(Monom._Comp);
		String ans = "";
		ans =  polynom.get(0).toString();
		for (int i = 1; i < this.polynom.size(); i++) {
			ans += " + " + polynom.get(i).toString();
		}
		return ans;
	}
	@Override
	public function initFromString(String s) {
		// TODO Auto-generated method stub
		return null;
	}
}
