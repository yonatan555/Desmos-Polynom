package myMathPro;

import myMathPro.Operation;
import myMathPro.Polynom;
import myMathPro.function;

public class ComplexFunction implements complex_function{
	public function left;
	public function right;
	public Operation operator;
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public function copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void plus(function f1) {
		this.left=new ComplexFunction(this.operator,this.left, this.right);
		this.right = f1; 
		this.operator=operator.Plus;
	}

	@Override
	public void mul(function f1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void div(function f1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void max(function f1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void min(function f1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void comp(function f1) {
		
		
	}

	@Override
	public function left() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public function right() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operation getOp() {
		// TODO Auto-generated method stub
		return null;
	}

}
