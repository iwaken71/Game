package ex07;

public class Controller {
	final MathExpressionParserTest evaluate = new MathExpressionParserTest();
	public String Controll(String input,String formula,String memory){
		if(formula.equals("0") && (input.equals("0")||input.equals("1")||input.equals("2")||input.equals("3")||input.equals("4")||input.equals("5")||input.equals("6")||input.equals("7")||input.equals("8")||input.equals("9"))){
			formula = "";
		}
		if(input.equals("C")){
			return "0";
		}if(input.equals("±")){
			double Cal = Double.valueOf(formula);
			return String.valueOf(-Cal);
		}
		if(input.equals("1/x")){
			double Cal = Double.valueOf(formula);
			return String.valueOf(1/Cal);
		}
		if(input.equals("√")){
			double val = Double.valueOf(formula);
			return String.valueOf(Math.sqrt(val));
		}
		if(input.equals("0")||input.equals("00")||input.equals("1")||input.equals("2")||input.equals("3")||input.equals("4")||input.equals("5")||input.equals("6")||input.equals("7")||input.equals("8")||input.equals("9")||input.equals("+")||input.equals("-")||input.equals("^")){
			return formula + input;
		}
		if(input.equals("×")) return formula + "*";
		if(input.equals("^")) return formula + "^";
		if(input.equals("÷")) return formula + "/";
		if(input.equals("=")){
			return evaluate.run(formula);
		}
		if(input.equals(".")){
			if(formula.indexOf(".") == -1) return formula + input;
			else return formula;
		}
		if(input.equals("MR")) return memory;
		if(input.equals("DEL")){
			try{
				if(formula.length()==1) return "0";
				else return formula.substring(0,formula.length()-1);
			}catch(Exception E) {
				return  "0";
			}
		}
		if(input.equals("(")||input.equals(")")){
			if(formula.equals("0")){
				return input;
			}
			return formula + input;
		}
		if(input.equals("π")) if(formula.equals("0"))return Double.toString(Math.PI); else return formula + Double.toString(Math.PI);
		if(input.equals("e")) if(formula.equals("0"))return Double.toString(Math.PI); else return formula + Double.toString(Math.E);
		else{
			return formula;
		}
	}
	public String Memory (String input,String formula,String memory){
		if(input.equals("MC")) return "0";
		if(input.equals("M+")) return Double.toString(Double.valueOf(memory)+Double.valueOf(formula));
		if(input.equals("M-")) return Double.toString(Double.valueOf(memory)-Double.valueOf(formula));
		else return memory;
	}

}




