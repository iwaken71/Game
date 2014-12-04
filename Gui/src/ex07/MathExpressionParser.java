package ex07;

import java.io.StreamTokenizer;

public class MathExpressionParser {
	private StreamTokenizer parser;
	MathExpressionParser (StreamTokenizer st){
		parser = st;
		parser.ordinaryChar('/');
		parser.ordinaryChar('-');
	}
	public MathExpression parseExpression () throws Exception{
		MathExpression  val;
		val = parseTerm();
		while(true){
			int token = parser.nextToken();
			switch(token){
			case'+':
				val = new Plus(val,parseTerm ());
				break;
			case '-':
				val = new Minus(val,parseTerm());
				break;
			default:
				parser.pushBack();
				return val;
			}
		}

	}
	public MathExpression  parseTerm () throws Exception{
		MathExpression  val;

		val = parseFactor();

		while(true){
			int token = parser.nextToken();
			switch(token){
			case'*':
				val = new Mult(val,parseFactor());
				break;
			case '/':
				val = new Div(val, parseFactor());
				break;
			case '^':
				val = new Power(val,parseFactor());
			default:
				parser.pushBack();
				return val;
			}
		}
	}
	public MathExpression  parseFactor() throws Exception {
		MathExpression  x;
		int token = parser.nextToken();

		switch(token){
		case '(':
			x = parseExpression();
			if(parser.nextToken() == ')')
				return x;
			else throw new Exception("括弧の対応が正しくありません");
		case StreamTokenizer.TT_NUMBER:
			return new IntegerConstant(parser.nval);
		case '-':
			x = parseTerm();
			return new Mult(new IntegerConstant(-1.0),x);
		default:
			throw new Exception("正しい数式ではありません");
		}
	}
}
