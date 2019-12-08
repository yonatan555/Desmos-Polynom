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

	public ComplexFunction(Operation p, function f1, Polynom p2) {
		this.left = f1;
		this.right = p2;
		this.operator = p;
	}

	public ComplexFunction(String s, function f1, function f2) {
		this.left = f1;
		this.right = f2;
		s = s.toLowerCase();
		s = s.replaceAll(" ", "");
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

	public ComplexFunction(function f1) {
		this.left = f1;
		this.right = null;
		this.operator = Operation.None;
	}

	public ComplexFunction(String s, Polynom f1, Polynom f2) {
		this.left = f1;
		this.right = f2;
		s = s.toLowerCase();
		s = s.replaceAll(" ", "");
		if (s.equals("plus"))
			this.operator = Operation.Plus;
		if (s.equals("times"))
			this.operator = Operation.Times;
		if (s.equals("div"))
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

	@Override
	public function initFromString(String s) {
		s = s.replaceAll(" ", "");
		s = s.toLowerCase();
		String f1 = "";
		String f2 = "";
		String opera = "";
		int mid = 0;
		int index =0;
		if(s.indexOf('(')!=-1)
		{
		 index = s.indexOf('(');
		 mid = findMid(index,s);
		}
		if (s.indexOf('(')==-1) {
			function left = new ComplexFunction(new Polynom(s));
			return left ;
		} else {
			mid = findMid(index,s);
			opera = s.substring(0, s.indexOf('('));
			f1 = s.substring(s.indexOf('(')+1, mid);
			f2 = s.substring(mid + 1, s.length() - 1);
			
			this.operator = findOp(opera);
			function left = initFromString(f1);
			function right= initFromString(f2);
			this.left = left;
			this.right = right;
			function func = new ComplexFunction(this.operator, this.left, this.right);
			return func;
			}
			/*
			 * String p1 = ""; String p2 = ""; String opera = ""; s = s.replaceAll(" ", "");
			 * int x = 0; int c = 0; int m = 0; s = s.toLowerCase(); int count = 0; for (int
			 * i = 0; i < s.length(); i++) { if (s.charAt(i) == '(') count++; } if (count ==
			 * 1) { for (int i = 0; i < s.length(); i++) { if (s.charAt(i) == '(') { opera =
			 * s.substring(0, i); m = i; } if (s.charAt(i) == ',') { p1 = s.substring(m + 1,
			 * i); p2 = s.substring(i + 1, s.length() - 1); } } this.left = new Polynom(p1);
			 * this.right = new Polynom(p2); if (opera.equals("plus")) this.operator =
			 * Operation.Plus; else if (opera.equals("div")) this.operator =
			 * Operation.Divid; else if (opera.equals("mul")) this.operator =
			 * Operation.Times; else if (opera.equals("max")) this.operator = Operation.Max;
			 * else if (opera.equals("min")) this.operator = Operation.Min; else if
			 * (opera.equals("comp")) this.operator = Operation.Comp; else this.operator =
			 * Operation.Error;
			 * 
			 * return new ComplexFunction(this.operator, this.left, this.right); } else {
			 * for (int i = 0; i < s.length(); i++) { if (s.charAt(i) == '(') { opera =
			 * s.substring(0, i); x = i; break; } } for (int i = s.length() - 1; i > 0; i--)
			 * { if (s.charAt(i) == ',') { p2 = s.substring(i + 1, s.length() - 1); c = i;
			 * break; } }
			 * 
			 * if (opera.equals("plus")) this.operator = Operation.Plus; else if
			 * (opera.equals("div")) this.operator = Operation.Divid; else if
			 * (opera.equals("mul")) this.operator = Operation.Times; else if
			 * (opera.equals("max")) this.operator = Operation.Max; else if
			 * (opera.equals("min")) this.operator = Operation.Min; else if
			 * (opera.equals("comp")) this.operator = Operation.Comp; else this.operator =
			 * Operation.Error; s = s.substring(x + 1, c); this.left = initFromString(s);
			 * return new ComplexFunction(this.operator, this.left, new Polynom(p2)); }
			 */
		
	}
	private Operation findOp(String opera) {
		if (opera.equals("plus"))
			return this.operator = Operation.Plus;
		if (opera.equals("times"))
			return this.operator = Operation.Times;
		if (opera.equals("div"))
			return this.operator = Operation.Divid;
		if (opera.equals("max"))
			return this.operator = Operation.Max;
		if (opera.equals("min"))
			return this.operator = Operation.Min;
		return this.operator = Operation.None;
	}
	public int countOfBlancks(String s) {
		int counter = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				counter++;
			}
		}
		return counter;
	}
	public int findMid(int index ,String s) {
		int m = 0;
		int j = 0;
		int counter = 0;
		for (int i = index; i <s.length(); i++) {
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
		}
		this.left = new ComplexFunction(this.operator, this.left, this.right);
		this.right = f1;
		this.operator = Operation.Plus;
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
		}
		this.left = new ComplexFunction(this.operator, this.left, this.right);
		this.right = f1;
		this.operator = Operation.Divid;
	}

	@Override
	public void max(function f1) {
		if (f1 == null)
			return;
		if (this.right == null) {
			this.right = f1;
			this.operator = Operation.Max;
		}
		this.left = new ComplexFunction(this.operator, this.left, this.right);
		this.right = f1;
		this.operator = Operation.Max;
	}

	@Override
	public void min(function f1) {
		if (f1 == null)
			return;
		if (this.right == null) {
			this.right = f1;
			this.operator = Operation.Min;
		}
		this.left = new ComplexFunction(this.operator, this.left, this.right);
		this.right = f1;
		this.operator = Operation.Min;
	}

	@Override
	public void comp(function f1) {
		if (f1 == null)
			return;
		if (this.right == null) {
			this.right = f1;
			this.operator = Operation.Comp;
		}
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
		String oper = getOperation();
		String ans = oper + "(" + this.left.toString() + "," + this.right.toString() + ")";
		return ans ;
	}
	private String getOperation() {
	if(this.operator==Operation.Plus)	
	{
		return "plus" ;
	}
	if(this.operator==Operation.Divid)	
	{
		return "div" ;
	}
	if(this.operator==Operation.Times)	
	{
		return "mul" ;
	}
	if(this.operator==Operation.Max)	
	{
		return "max" ;
	}
	if(this.operator==Operation.Min)	
	{
		return "min" ;
	}
	if(this.operator==Operation.Comp)	
	{
		return "comp" ;
	}
	if(this.operator==Operation.Error)	
	{
		return "error" ;
	}
	if(this.operator==Operation.None)	
	{
		return "none" ;
	}
	return "error";
	}
}
