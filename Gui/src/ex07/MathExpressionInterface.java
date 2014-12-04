package ex07;
public interface MathExpressionInterface {
	double evaluate();
}
abstract class MathExpression implements MathExpressionInterface {
	public abstract double evaluate();
}
abstract class BinaryOperator extends MathExpression {
	private MathExpression e1,e2;
	protected BinaryOperator(MathExpression e1, MathExpression e2){
		this.e1 = e1;
		this.e2 = e2;
	}
	protected abstract double evaluate(double v1,double v2);
	public double evaluate(){
		return evaluate(e1.evaluate(),e2.evaluate());
	}
}