package GUI;

public class Calcu implements Control{
	Model model;
	private String Suuji = "";
	public Calcu(Model model){
		this.model = model;
	}public String First(){
		return "4桁の数字を入力してください";
	}public String Explanation(){
		return "<html>4つの数字に四則演算を行い <br> "
				+ "10になるかどうか調べます<html>";
	}
	public String Output(String input){
		Delstr(input);
		int num = Integer.valueOf(Suuji).intValue();
		this.model.SetInt(num);
		model.check();
		return model.GetANS();
	}
	private void Delstr(String input){
		Suuji = "";
		int length = input.length();
		char c[] = new char[length];
		for(int i = 0; i < length; i++){
			c[i] = input.charAt(i);
		}
		for(int i = 0; i < length; i++){
			if(c[i] == '0'||c[i] == '1'||c[i] == '2'||c[i] == '3'||c[i] == '4'||c[i] == '5'||c[i] == '6'||c[i] == '7'||c[i] == '8'||c[i] == '9'||c[i] == '-'){
				Suuji += c[i];
				//	System.out.println(c[i]);
			}else{
				Suuji += "";
			}
		}

	}
}
