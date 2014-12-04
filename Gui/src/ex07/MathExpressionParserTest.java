package ex07;
import java.io.StreamTokenizer;
import java.io.StringReader;
public class MathExpressionParserTest {
	public String run(String str) {
		StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(str));
		MathExpressionParser parser = new MathExpressionParser(tokenizer);
		try {
			return Double.toString(parser.parseExpression().evaluate());
		}catch(Exception e){
			System.err.println(e);
			System.exit(1);
			return "?";
		}
	}
}