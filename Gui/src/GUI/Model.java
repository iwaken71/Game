package GUI;


public abstract class Model {
	int INPUT;
	int OUTPUT;
	String ANS;
	abstract void SetInt(int num);
	public void SetANS(String s){this.ANS = s;}
	public String GetANS(){return this.ANS;}
	abstract boolean check();
}
