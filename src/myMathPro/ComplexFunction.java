package myMathPro;

import myMathPro.Operation;
import myMathPro.Polynom;
import myMathPro.function;

public class ComplexFunction implements complex_function{
	public function left;
	public function right;
	public Operation operator;

	public ComplexFunction() {
		this.left=null;
		this.right=null;
		this.operator=null;
	}
	public ComplexFunction(Operation p, function f1, function f2) {
		this.left=f1;
		this.right=f2;
		this.operator=p;
	}

	public ComplexFunction(String s ,Polynom f1, Polynom f2) {
		this.left=f1;
		this.right=f2;
		s = s.toLowerCase();
		if (s.equals("plus")) operator=Operation.Plus;
		if (s.equals("times")) operator=Operation.Times;
		if (s.equals("divid")) operator=Operation.Divid;
		if (s.equals("comp")) operator=Operation.Comp;
		if (s.equals("error")) operator=Operation.Error;
		if (s.equals("max")) operator=Operation.Max;
		if (s.equals("min")) operator=Operation.Min;
		if (s.equals("none")) operator=Operation.None;
	}
	public ComplexFunction(Polynom p) {
		this.left=p;
		this.right=null;
		operator=null;
	}
	@Override
	public double f(double x) {
		double left1 = this.left.f(x);
		double right1 = this.right.f(x);
		if (this.operator==Operation.Plus) return left1+right1;
		if (this.operator==Operation.Times) return left1*right1;
		if (this.operator==Operation.Divid) return left1/right1;
		if (this.operator==Operation.Comp) return 0;
		if (this.operator==Operation.Error) return 0;
		if (this.operator==Operation.Max) return Math.max(left1, right1);
		if (this.operator==Operation.Min) return Math.min(left1, right1);
		if (this.operator==Operation.None) return 0;
		return 0;
	}

	@Override
	public function initFromString(String s) {
		String p1="";
		String p2="";
		String opera="";
		//s=s.toUpperCase();
		//for (int i = 0; i < s.length(); i++) {
		int i=0;
		if(s.charAt(i)>='A' && s.charAt(i)<='Z') {
			for (int j = i; j < s.length(); j++) {
				if(s.charAt(j)=='(') { 
					opera=s.substring(i, j);
					i=j;
					break;
				}
			}
		}
		if(s.charAt(i)=='(') {
			if(s.charAt(i+1)=='+' || s.charAt(i+1)=='-') {
				for (int j = i+1; j < s.length(); j++) {
					if(s.charAt(j)==',' || s.charAt(j)== ')') {
						p1=s.substring(i+1, j);
						i=j;
						break;
					}
				}
			}
			else {
				for (int j = i+1; j < s.length(); j++) {
					if(s.charAt(j)=='(') { 
						opera=s.substring(i+1, j);
						i=j;
						break;
					}
				}
			}
		}
		if(s.charAt(i)==',') {
			for (int j = i+1; j < s.length(); j++) {
				if(s.charAt(j)==')') {
					p2=s.substring(i+1, s.length()-1);
					break;
				}
			}

		}
		//}
		ComplexFunction fun = new ComplexFunction(opera, new Polynom(p1), new Polynom(p2));
		return fun;
	}

	@Override
	public function copy() {
		ComplexFunction fun = new ComplexFunction(this.operator, this.left, this.right);
		return fun;
	}

	@Override
	public void plus(function f1) {
		this.left = new ComplexFunction(this.operator,this.left, this.right);
		this.right = f1; 
		this.operator=Operation.Plus;
	}

	@Override
	public void mul(function f1) {
		this.left = new ComplexFunction(this.operator,this.left, this.right);
		this.right = f1; 
		this.operator = Operation.Times;

	}

	@Override
	public void div(function f1) {
		this.left = new ComplexFunction(this.operator,this.left, this.right);
		this.right = f1; 
		this.operator = Operation.Divid;
	}

	@Override
	public void max(function f1) {
		this.left=new ComplexFunction(this.operator,this.left, this.right);
		this.right = f1; 
		this.operator=Operation.Max;
	}

	@Override
	public void min(function f1) {
		this.left=new ComplexFunction(this.operator,this.left, this.right);
		this.right = f1; 
		this.operator=Operation.Min;
	}

	@Override
	public void comp(function f1) {
		this.left=new ComplexFunction(this.operator,this.left, this.right);
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
		String opera="";
		String P1="";
		String P2="";
		if(this.operator==Operation.Plus) opera="Plus";
		if(this.operator==Operation.Divid) opera="Divid";
		if(this.operator==Operation.Comp) opera="Comp";
		if(this.operator==Operation.Error) opera="Error";
		if(this.operator==Operation.Max) opera="Max";
		if(this.operator==Operation.Min) opera="Min";
		if(this.operator==Operation.None) opera="None";
		if(this.operator==Operation.Times) opera="Times";
		if(this.left!=null)P1 = this.left.toString();
		if(this.right!=null)P2 = this.right.toString();

		return opera+"("+P1+","+P2+")";
	}

}
