package GUI;

public class PrimeCon implements Control{

	private Model model;
	//private String Suuji;
	public PrimeCon(Model model){
		this.model = model;
	}
	public String Output(String input){
		int num = Integer.valueOf(input).intValue();
		this.model.SetInt(num);
		model.check();
		return model.GetANS();

	}
	public String First(){
		return "数字を入力してください";
	}
	public String Explanation(){
		return "<html>入力された数字が素数かどうか調べます。<br>素数なら何番目の素数か調べ、<br>素数でないなら素因数分解を行います。<html>";
	}
	/*
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
	private int Cal(int n,int x){

		int a = 1;
		for(int i = 0; i < n; i++){
			a *= 10;
		}
		return a*x;
	}
	*/
}
