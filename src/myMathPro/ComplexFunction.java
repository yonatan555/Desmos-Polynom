package myMathPro;

import java.util.Iterator;

import myMathPro.Operation;
import myMathPro.Polynom;
import myMathPro.function;

public class ComplexFunction implements complex_function {
	public function left;
	public function right;
	public Operation operator;

	public ComplexFunction() {
		this.left = null;
		this.right = null;
		this.operator = Operation.None;
	}

	public ComplexFunction(Operation p, function f1, function f2) {
		this.left = f1;
		this.right = f2;
		if (p == Operation.Error) {
			throw new ExceptionInInitializerError("The input couldnt be intilaized");
		} else
			this.operator = p;
	}

	public ComplexFunction(String s, function f1, function f2) {

		if (s == null || s.length() == 0) {
			throw new RuntimeException("The input couldnt be intilaized");
		}
		if (f2 != null) {
			this.right = f2.copy();
		}
		this.left = f1.copy();

		s = s.toLowerCase();
		s = s.replaceAll(" ", "");
		if (s.equals(""))
			throw new RuntimeException("Empty string");
		if (s.equals("plus"))
			operator = Operation.Plus;
		if (s.equals("mul"))
			operator = Operation.Times;
		if (s.equals("div"))
			operator = Operation.Divid;
		if (s.equals("comp"))
			operator = Operation.Comp;
		if (s.equals("max"))
			operator = Operation.Max;
		if (s.equals("min"))
			operator = Operation.Min;
		if (s.equals("none"))
			operator = Operation.None;
		if (s.equals("error")) {
			throw new ExceptionInInitializerError("The input couldnt be intilaized");
		}
		if (!(s.equals("plus")) && !(s.equals("div")) && !(s.equals("comp")) && !(s.equals("error"))
				&& !(s.equals("max")) && !(s.equals("min")) && !(s.equals("none")) && !(s.equals("mul"))) {
			throw new ExceptionInInitializerError("The input couldnt be got");
		}
	}

	public ComplexFunction(function f1) {
		if (f1 == null) {
			throw new RuntimeException("The input couldnt be intilaized");
		} else {
			this.left = f1;
			this.right = null;
			this.operator = Operation.None;
		}
	}

	@Override
	public double f(double x) { // Y vaule in X point
		if (this.right == null) {
			return this.left.f(x);
		} else {
			double left1 = this.left.f(x);
			double right1 = this.right.f(x);
			if (this.operator == Operation.Plus)
				return left1 + right1;
			if (this.operator == Operation.Times)
				return left1 * right1;
			if (this.operator == Operation.Divid) { // if right value is 0 it will be -infinite/infinite
				if ((this.left.f(x) == 0) && (this.right.f(x) == 0)) { // if the both values are equal to 0
					throw new ArithmeticException("Not defiend 0/0");
				}
				return left1 / right1;
			}
			if (this.operator == Operation.Comp) {
				if (this.right == null) {
					return this.left.f(x);
				}
				return this.left.f((this.right.f(x)));
			}
			if (this.operator == Operation.Max)
				return Math.max(left1, right1);
			if (this.operator == Operation.Min)
				return Math.min(left1, right1);
			if (this.operator == Operation.None)
				return this.left.f(x);
			return 0;
		}
	}

	@Override
	public function initFromString(String s) {// init a function from String
		s = s.replaceAll(" ", "");
		if (s.equals(""))
			throw new RuntimeException("Empty string");
		s = s.toLowerCase();
		String f1 = "";
		String f2 = "";
		String opera = "";
		int index = 0;
		int mid = 0;
		index = s.indexOf('(');
		if (index != -1) {
			mid = findMid(index, s); // using findMid func to cut substring in the right place
			opera = s.substring(0, index);
			f1 = s.substring(index + 1, mid);
			f2 = s.substring(mid + 1, s.length() - 1);
			function left = initFromString(f1);
			function right = initFromString(f2);
			function t = new ComplexFunction(opera, left, right);
			return t;
		} else {
			function left = new ComplexFunction(new Polynom(s));
			return left;
		}
	}

	private int findMid(int index, String s) { // find the midlle of the Complex_function
		int m = 0;
		int j = 0;
		int counter = 0;
		for (int i = index; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				m++;
			}
			if (s.charAt(i) == ',') {
				j++;
			}
			if (j == m) {
				counter = i;
				return counter;
			}
		}
		return counter;
	}

	@Override
	public function copy() {
		function rt = null;
		function lft = null;
		Operation opi = setOper(this.getOperation());

		if (left != null) {
			lft = this.left.copy();
		}
		if (right != null) {
			rt = this.right.copy();
		}
		ComplexFunction fun = new ComplexFunction(opi, lft, rt);

		return fun;

	}

	@Override
	public void plus(function f1) {
		function f2 = f1.copy();
		if (this.right != null) {
			function cf = new ComplexFunction(this.getOperation(), this.left, this.right);
			this.left = cf.copy();

		}
		this.right = f2;
		this.operator = Operation.Plus;
	}

	@Override
	public void mul(function f1) {
		function f2 = f1.copy();
		if (this.right != null) {
			function cf = new ComplexFunction(this.getOperation(), this.left, this.right);
			this.left = cf.copy();

		}
		this.right = f2;
		this.operator = Operation.Times;
	}

	@Override
	public void div(function f1) {
		function f2 = f1.copy();
		if (this.right != null) {
			function cf = new ComplexFunction(this.getOperation(), this.left, this.right);
			this.left = cf.copy();

		}
		this.right = f2;
		this.operator = Operation.Divid;
	}

	@Override
	public void max(function f1) {
		function f2 = f1.copy();
		if (this.right != null) {
			function cf = new ComplexFunction(this.getOperation(), this.left, this.right);
			this.left = cf.copy();

		}
		this.right = f2;
		this.operator = Operation.Max;
	}

	@Override
	public void min(function f1) {
		function f2 = f1.copy();
		if (this.right != null) {
			function cf = new ComplexFunction(this.getOperation(), this.left, this.right);
			this.left = cf.copy();

		}
		this.right = f2;
		this.operator = Operation.Min;
	}

	@Override
	public void comp(function f1) {
		function f2 = f1.copy();
		if (this.right != null) {
			function cf = new ComplexFunction(this.getOperation(), this.left, this.right);
			this.left = cf.copy();

		}
		this.right = f2;
		this.operator = Operation.Comp;
	}

	@Override
	public function left() {
		return this.left;
	}

	@Override
	public function right() {
		return this.right;
	}

	@Override
	public Operation getOp() {
		return this.operator;
	}

	public String toString() {
		if (this.right == null) {
			if (this.left == null)
				throw new RuntimeException("Empty string");
			else
				return this.left.toString();
		}

		String oper = getOperation();
		String ans = oper + "(" + this.left.toString() + "," + this.right.toString() + ")";
		ans = ans.replaceAll(" ", "");
		return ans;

	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Monom) {
			Monom mon = (Monom) obj;
			int counter = 0;
			for (int i = 1; i <= 10; i++) {
				if (this.f(i) == mon.f(i)) {
					counter++;
				}
				if (counter >= 8) {
					return true;
				}
			}
		}
		if (obj instanceof Polynom) {
			Polynom pol = (Polynom) obj;
			int counter = 0;
			for (int i = 1; i <= 10; i++) {
				if (this.f(i) == pol.f(i)) {
					counter++;
				}
				if (counter >= 8) {
					return true;
				}
			}
		}
		if (obj instanceof ComplexFunction) {
			int counter = 0;
			ComplexFunction comp = (ComplexFunction) obj;
			for (int i = 1; i <= 10; i++) {
				if (this.f(i) == comp.f(i)) {
					counter++;
				}
				if (counter >= 8) {
					return true;
				}
			}
		}
		return false;
	}

	private Operation setOper(String s) {

		s = s.toLowerCase();
		s = s.replaceAll(" ", "");
		if (s.equals(""))
			throw new RuntimeException("Empty string");
		if (s.equals("plus"))
			return Operation.Plus;
		if (s.equals("mul"))
			return Operation.Times;
		if (s.equals("div"))
			return Operation.Divid;
		if (s.equals("comp"))
			return Operation.Comp;
		if (s.equals("max"))
			return Operation.Max;
		if (s.equals("min"))
			return Operation.Min;
		if (s.equals("none"))
			return Operation.None;
		if (s.equals("error")) {
			throw new ExceptionInInitializerError("The input couldnt be intilaized");
		}
		if (!(s.equals("plus")) && !(s.equals("div")) && !(s.equals("comp")) && !(s.equals("error"))
				&& !(s.equals("max")) && !(s.equals("min")) && !(s.equals("none")) && !(s.equals("mul"))) {
			throw new ExceptionInInitializerError("The input couldnt be got");
		}
		return Operation.Error;

	}

	private String getOperation() {
		if (this.operator == Operation.Plus) {
			return "plus";
		}
		if (this.operator == Operation.Divid) {
			return "div";
		}
		if (this.operator == Operation.Times) {
			return "mul";
		}
		if (this.operator == Operation.Max) {
			return "max";
		}
		if (this.operator == Operation.Min) {
			return "min";
		}
		if (this.operator == Operation.Comp) {
			return "comp";
		}
		if (this.operator == Operation.Error) {
			return "error";
		}
		if (this.operator == Operation.None) {
			return "none";
		}
		return "error";
	}
}
