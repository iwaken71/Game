package GUI;

public class FourNum extends Model{

	private int A[] = new int[4];
	private double Num[] = new double[7];
	private Expression e[] = new Expression[3];
	private String Num4[] = new String[4];

	public FourNum(){
	}
	public void SetInt(int num){
		INPUT = num;
	}
	public String Print(int n){
		return "";
	}
	public String Print2(int n){
		return "";
	}
	private void Start(){
		int x = INPUT;
		A[0] = x/1000;
		x -= A[0]*1000;
		A[1] = x/100;
		x -= A[1]*100;
		A[2] = x/10;
		x -= A[2]*10;
		A[3] = x;
		for(int i = 0;i < 4; i++){
			Num[i] = A[i];
			toString();
			Num4[i] = String.valueOf(A[i]);
		}
	}
	private String Mul(String left,Expression ex,String right){
		return "("+left+ ex.Getstr() +right+")";
	}

	public boolean check(){
		this.Start();
		if(INPUT<=999||10000<=INPUT){
			SetANS(INPUT+" is out of range");
			return false;
		}
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				for(int k = 0; k < 5; k++){
					if(Part1(i,j,k)){
						SetANS(GetANS()+"=10");
						return true;
					}
				}	
			}
		}
		SetANS(INPUT +" is not found");
		return false;
	}

	private boolean Part1(int a,int b,int c){
		e[0] = new Expression(a,Num[0],Num[1]);
		Num[4] = e[0].Cal();
		e[1] = new Expression(b,Num[2],Num[3]);
		Num[5] = e[1].Cal();
		e[2] = new Expression(c,Num[4],Num[5]);
		Num[6] = e[2].Cal();

		if(Num[6] == 10.0) {
			SetANS(Mul(Mul(Num4[0],e[0],Num4[1]),e[2],Mul(Num4[2],e[1],Num4[3])));
			return true;
		}
		e[0] = new Expression(a,Num[1],Num[2]);
		Num[4] = e[0].Cal();
		e[1] = new Expression(b,Num[0],Num[4]);
		Num[5] = e[1].Cal();
		e[2] = new Expression(c,Num[5],Num[3]);
		Num[6] = e[2].Cal();

		if(Num[6] == 10.0){
			SetANS(Mul(Mul(Num4[0],e[1],Mul(Num4[1],e[0],Num4[2])),e[2],Num4[3]));
			return true;
		}
		e[0] = new Expression(a,Num[0],Num[1]);
		Num[4] = e[0].Cal();
		e[1] = new Expression(b,Num[4],Num[2]);
		Num[5] = e[1].Cal();
		e[2] = new Expression(c,Num[5],Num[3]);
		Num[6] = e[2].Cal();

		if(Num[6] == 10.0) {
			SetANS(Mul(Mul(Mul(Num4[0],e[0],Num4[1]),e[1],Num4[2]),e[2],Num4[3]));
			return true;
		}
		e[0] = new Expression(a,Num[2],Num[3]);
		Num[4] = e[0].Cal();
		e[1] = new Expression(b,Num[1],Num[4]);
		Num[5] = e[1].Cal();
		e[2] = new Expression(c,Num[0],Num[5]);
		Num[6] = e[2].Cal();

		if(Num[6] == 10.0) {
			SetANS(Mul(Num4[0],e[2],Mul(Num4[1],e[1],Mul(Num4[2],e[0],Num4[3]))));
			return true;
		}
		e[0] = new Expression(a,Num[1],Num[2]);
		Num[4] = e[0].Cal();
		e[1] = new Expression(b,Num[4],Num[3]);
		Num[5] = e[1].Cal();
		e[2] = new Expression(c,Num[0],Num[5]);
		Num[6] = e[2].Cal();

		if(Num[6] == 10.0){
			SetANS(Mul(Num4[0],e[2],Mul(Mul(Num4[1],e[0],Num4[2]),e[1],Num4[3])));
			return true;
		}

		return false;
	}
	private class Expression{
		int sel;
		double e1,e2;
		private String str;
		Expression(int sel,double e1,double e2){
			this.sel = sel;
			this.e1 = e1;
			this.e2 = e2;
		}

		double Cal(){
			

			switch(sel){
			case 0:
				this.str = "+";
				return e1+e2;
			case 1:
				this.str = "-";
				return e1-e2;
			case 2:
				this.str = "*";
				return e1*e2;
			case 3:
				this.str = "/";
				return e1/e2;
			default:

				break;
			}


			return -1;
		}
		public String Getstr(){
			return this.str;
		}
	}
	public static void main(String[] args){
		int count = 0;
		FourNum f = new FourNum();
		for(int i = 1000;i<10000;i++){
			f.SetInt(i);
			if(f.check()){
				count++;	
			}
		}
		System.out.println(count);

	}
}
