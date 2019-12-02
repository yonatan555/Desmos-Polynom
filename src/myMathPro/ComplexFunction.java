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
		if (s.equals("Plus")) operator=operator.Plus;
		if (s.equals("Times")) operator=operator.Times;
		if (s.equals("Divid")) operator=operator.Divid;
		if (s.equals("Comp")) operator=operator.Comp;
		if (s.equals("Error")) operator=operator.Error;
		if (s.equals("Max")) operator=operator.Max;
		if (s.equals("Min")) operator=operator.Min;
		if (s.equals("None")) operator=operator.None;
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
		if (this.operator==operator.Plus) return left1+right1;
		if (this.operator==operator.Times) return left1*right1;
		if (this.operator==operator.Divid) return left1/right1;
		if (this.operator==operator.Comp) return 0;
		if (this.operator==operator.Error) return 0;
		if (this.operator==operator.Max) return Math.max(left1, right1);
		if (this.operator==operator.Min) return Math.min(left1, right1);
		if (this.operator==operator.None) return 0;
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
		this.left=new ComplexFunction(this.operator,this.left, this.right);
		this.right = f1; 
		this.operator=operator.Plus;
	}

	@Override
	public void mul(function f1) {
		this.left=new ComplexFunction(this.operator,this.left, this.right);
		this.right = f1; 
		this.operator=operator.Times;

	}

	@Override
	public void div(function f1) {
		this.left=new ComplexFunction(this.operator,this.left, this.right);
		this.right = f1; 
		this.operator=operator.Divid;

	}

	@Override
	public void max(function f1) {
		this.left=new ComplexFunction(this.operator,this.left, this.right);
		this.right = f1; 
		this.operator=operator.Max;

	}

	@Override
	public void min(function f1) {
		this.left=new ComplexFunction(this.operator,this.left, this.right);
		this.right = f1; 
		this.operator=operator.Min;

	}

	@Override
	public void comp(function f1) {
		this.left=new ComplexFunction(this.operator,this.left, this.right);
		this.right = f1; 
		this.operator=operator.Comp;

	}

	@Override
	public function left() {
		ComplexFunction fun = new ComplexFunction((Polynom)this.left);
		return fun;
	}

	@Override
	public function right() {
		ComplexFunction fun = new ComplexFunction((Polynom)this.right);
		return fun;
	}

	@Override
	public Operation getOp() {
		return this.operator;
	}
	public String toString() {
		String opera="";
		String P1="";
		String P2="";
		if(this.operator==operator.Plus) opera="Plus";
		if(this.operator==operator.Divid) opera="Divid";
		if(this.operator==operator.Comp) opera="Comp";
		if(this.operator==operator.Error) opera="Error";
		if(this.operator==operator.Max) opera="Max";
		if(this.operator==operator.Min) opera="Min";
		if(this.operator==operator.None) opera="None";
		if(this.operator==operator.Times) opera="Times";
		if(this.right!=null) P2=this.right.toString();
		if(this.left!=null) P1=this.left.toString();
		
		return opera+"("+P1+","+P2+")";
	}

}
