package myMathPro;

import com.google.gson.Gson;
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
	public ComplexFunction(Operation p, function f1, Polynom p2) {
		this.left = f1;
		this.right = p2;
		this.operator = p;
	}
	public ComplexFunction(String s, function f1, function f2) {
		this.left = f1;
		this.right = f2;
		s = s.toLowerCase();
		if (s.equals("plus"))
			operator = Operation.Plus;
		if (s.equals("times"))
			operator = Operation.Times;
		if (s.equals("divid"))
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
	public ComplexFunction(function f1, function f2) {
		this.left = f1;
		this.right = f2;
	}

	public ComplexFunction(String s, Polynom f1, Polynom f2) {
		this.left = f1;
		this.right = f2;
		s = s.toLowerCase();
		if (s.equals("plus"))
			this.operator = Operation.Plus;
		if (s.equals("times"))
			this.operator = Operation.Times;
		if (s.equals("divid"))
			this.operator = Operation.Divid;
		if (s.equals("comp"))
			this.operator = Operation.Comp;
		if (s.equals("error"))
			this.operator = Operation.Error;
		if (s.equals("max"))
			this.operator = Operation.Max;
		if (s.equals("min"))
			this.operator = Operation.Min;
		if (s.equals("none"))
			this.operator = Operation.None;
	}

	public ComplexFunction(Polynom p) {
		this.left = null;
		this.right = p;
		this.operator = null;
	}
	

	@Override
	public double f(double x) {
		double left1 = this.left.f(x);
		double right1 = this.right.f(x);
		if (this.operator == Operation.Plus)
			return left1 + right1;
		if (this.operator == Operation.Times)
			return left1 * right1;
		if (this.operator == Operation.Divid)
			return left1 / right1;
		if (this.operator == Operation.Comp)
			return 0;
		if (this.operator == Operation.Error)
			return 0;
		if (this.operator == Operation.Max)
			return Math.max(left1, right1);
		if (this.operator == Operation.Min)
			return Math.min(left1, right1);
		if (this.operator == Operation.None)
			return this.left.f(x);
		return 0;
	}

	@Override
	public function initFromString(String s) {
		String p1 = "";
		String p2 = "";
		String opera = "";
		int x = 0;
		int c = 0;
		int m=0;
		s = s.toLowerCase();
		int count=0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='(') count++;
		}
		if (count==1) {
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i)=='(') {
					opera=s.substring(0,i);
					m=i;
				}
				if(s.charAt(i)==',') {
					p1=s.substring(m+1, i);
					p2=s.substring(i+1,s.length()-1);
				}
			}
			this.left=new Polynom(p1);
			this.right= new Polynom(p2);
			if (opera.equals("plus"))this.operator = Operation.Plus;
			else if (opera.equals("div"))this.operator = Operation.Divid;
			else if (opera.equals("mul"))this.operator = Operation.Times;
			else if (opera.equals("max"))this.operator = Operation.Max;
			else if (opera.equals("min"))this.operator = Operation.Min;
			else if (opera.equals("comp"))this.operator = Operation.Comp;
			else this.operator=Operation.Error;
			
			return new ComplexFunction(this.operator,this.left,	this.right);
		}
		else {
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i)=='(') {
					opera=s.substring(0, i);
					x=i;
					break;
				}
			}
			for (int i = s.length()-1; i > 0; i--) {
				if(s.charAt(i)==',') {
					p2=s.substring(i+1,s.length()-1);
					c=i;
					break;
				}
			}
			
			if (opera.equals("plus"))this.operator = Operation.Plus;
			else if (opera.equals("div"))this.operator = Operation.Divid;
			else if (opera.equals("mul"))this.operator = Operation.Times;
			else if (opera.equals("max"))this.operator = Operation.Max;
			else if (opera.equals("min"))this.operator = Operation.Min;
			else if (opera.equals("comp"))this.operator = Operation.Comp;
			else this.operator=Operation.Error;
			s=s.substring(x+1, c);
			this.left=initFromString(s);
			return new ComplexFunction(this.operator,this.left,new Polynom(p2));
		}
		
	}

	@Override
	public function copy() {
		ComplexFunction fun = new ComplexFunction(this.operator, this.left, this.right);
		return fun;
	}

	@Override
	public void plus(function f1) {
		this.left = new ComplexFunction(this.operator, this.left, this.right);
		this.right = f1;
		this.operator = Operation.Plus;
	}

	@Override
	public void mul(function f1) {
		this.left = new ComplexFunction(this.operator, this.left, this.right);
		this.right = f1;
		this.operator = Operation.Times;

	}

	@Override
	public void div(function f1) {
		this.left = new ComplexFunction(this.operator, this.left, this.right);
		this.right = f1;
		this.operator = Operation.Divid;
	}

	@Override
	public void max(function f1) {
		this.left = new ComplexFunction(this.operator, this.left, this.right);
		this.right = f1;
		this.operator = Operation.Max;
	}

	@Override
	public void min(function f1) {
		this.left = new ComplexFunction(this.operator, this.left, this.right);
		this.right = f1;
		this.operator = Operation.Min;
	}

	@Override
	public void comp(function f1) {
		this.left = new ComplexFunction(this.operator, this.left, this.right);
		this.right = f1;
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
		String opera = "";
		String P1 = "";
		String P2 = "";

		if(this.right==null) {
			if (this.left != null) {
				if(this.left instanceof Polynom) {
					Polynom p = (Polynom) this.left;
					P1 = p.toString();
				}
			}
			return P1;
		}
			else {
				if (this.operator == Operation.Plus)
					opera = "Plus";
				if (this.operator == Operation.Divid)
					opera = "Divid";
				if (this.operator == Operation.Comp)
					opera = "Comp";
				if (this.operator == Operation.Error)
					opera = "Error";
				if (this.operator == Operation.Max)
					opera = "Max";
				if (this.operator == Operation.Min)
					opera = "Min";
				if (this.operator == Operation.None)
					opera = "None";
				if (this.operator == Operation.Times)
					opera = "Times";
				if (this.right != null) {
					if(this.right instanceof Polynom) {
						Polynom p = (Polynom) this.right;
						P2 = p.toString();
					}
				}
				return opera + "(" + this.left.toString() + "," + P2 + ")";
			}
		}
	}
