package myMathPro;

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
		this.operator = p;
	}

	public ComplexFunction(String s, function f1, function f2) {
		this.left = f1;
		this.right = f2;
		s = s.toLowerCase();
		s = s.replaceAll(" ", "");
		if (s.equals("plus"))
			operator = Operation.Plus;
		if (s.equals("mul"))
			operator = Operation.Times;
		if (s.equals("div"))
			operator = Operation.Divid;
		if (s.equals("comp"))
			operator = Operation.Comp;
		if (s.equals("error"))
			operator = Operation.Error;
		if (s.equals("max"))
			operator = Operation.Max;
		if (s.equals("min"))
			operator = Operation.Min;
		if (s.equals("none"))
			operator = Operation.None;
	}

	public ComplexFunction(function f1) {
		this.left = f1;
		this.right = null;
		this.operator = Operation.None;
	}

	@Override
	public double f(double x) {
		if (this.right == null){
			return this.left.f(x);
		} 
		else {
			double left1 = this.left.f(x);
			double right1 = this.right.f(x);

			if (this.operator == Operation.Plus)
				return left1 + right1;
			if (this.operator == Operation.Times)
				return left1 * right1;
			if (this.operator == Operation.Divid)
				return left1 / right1;
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
	public function initFromString(String s) {
		s = s.replaceAll(" ", "");
		s = s.toLowerCase();
		String f1 = "";
		String f2 = "";
		String opera = "";
		int index = 0;
		int mid = 0;
		index = s.indexOf('(');
		if (index != -1) {
			mid = findMid(index, s);
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

	private int findMid(int index, String s) {
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
		ComplexFunction fun = new ComplexFunction(this.operator, this.left, this.right);
		return fun;
	}

	@Override
	public void plus(function f1) {
		if (f1 == null)
			return;
		if (this.right == null) {
			this.right = f1;
			this.operator = Operation.Plus;
		} else {
			this.left = new ComplexFunction(this.operator, this.left, this.right);
			this.right = f1;
			this.operator = Operation.Plus;
		}
	}

	@Override
	public void mul(function f1) {
		if (f1 == null)
			return;
		if (this.right == null) {
			this.right = f1;
			this.operator = Operation.Times;
		} else {
			this.left = new ComplexFunction(this.operator, this.left, this.right);
			this.right = f1;
			this.operator = Operation.Times;
		}
	}

	@Override
	public void div(function f1) {
		if (f1 == null)
			return;
		if (this.right == null) {
			this.right = f1;
			this.operator = Operation.Divid;
		} else {
			this.left = new ComplexFunction(this.operator, this.left, this.right);
			this.right = f1;
			this.operator = Operation.Divid;
		}
	}

	@Override
	public void max(function f1) {
		if (f1 == null)
			return;
		if (this.right == null) {
			this.right = f1;
			this.operator = Operation.Max;
		} else {
			this.left = new ComplexFunction(this.operator, this.left, this.right);
			this.right = f1;
			this.operator = Operation.Max;
		}
	}

	@Override
	public void min(function f1) {
		if (f1 == null)
			return;
		if (this.right == null) {
			this.right = f1;
			this.operator = Operation.Min;
		} else {
			this.left = new ComplexFunction(this.operator, this.left, this.right);
			this.right = f1;
			this.operator = Operation.Min;
		}
	}

	@Override
	public void comp(function f1) {
		if (f1 == null)
			return;
		if (this.right == null) {
			this.right = f1;
			this.operator = Operation.Comp;
		} else {
			this.left = new ComplexFunction(this.operator, this.left, this.right);
			this.right = f1;
			this.operator = Operation.Comp;
		}
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
				return "";
			else
				return this.left.toString();
		}
		String oper = getOperation();
		String ans = oper + "(" + this.left.toString() + "," + this.right.toString() + ")";
		ans = ans.replaceAll(" ", "");
		return ans;
	}

	public boolean equals(Object m) { // equals function will return true if f(x) will return the same value in 10 different points
		
		if (m instanceof function) {
			int counter = 0;
			for (int i = 1; i < 11; i++) {
				if (this.f(i) == ((function) m).f(i))
					counter++;
			}
			if (counter == 10)
				return true;
		}
		return false;
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
