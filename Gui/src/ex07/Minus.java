package ex07;

class Minus extends BinaryOperator{
	public Minus (MathExpression e1, MathExpression e2){
		super(e1,e2);
	}
	protected double evaluate(double v1,double v2){
		return v1 - v2;
	}
}
class Mult extends BinaryOperator{
	public Mult (MathExpression e1, MathExpression e2){
		super(e1,e2);
	}
	protected double evaluate(double v1,double v2){
		return v1 * v2;
	}

}
class Plus extends BinaryOperator{
	public Plus (MathExpression e1, MathExpression e2){
		super(e1,e2);
	}
	protected double evaluate(double v1,double v2){
		return v1 + v2;
	}
}
class Div extends BinaryOperator{
	public Div (MathExpression e1, MathExpression e2){
		super(e1,e2);
	}
	protected double evaluate(double v1,double v2){
		try{
			return v1/v2;
		}catch(ArithmeticException e){
			System.out.println("計算不能");
			System.exit(-1);
			return 0;
		}
	}
}
class Power extends BinaryOperator{
	public Power (MathExpression e1, MathExpression e2){
		super(e1,e2);
	}protected double evaluate(double v1,double v2){
		return Math.pow(v1, v2);
	}
}
class IntegerConstant extends MathExpression{
	private double n;
	public IntegerConstant(double n) {
		this.n = n;
	}
	public double evaluate(){
		return n;
	}
}
