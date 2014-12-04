package GUI;

public class Prime extends Model{
	public static final int N = 1000;
	int A[]; 
	public Prime(){
		A = new int[N];
	}
	public boolean check(){
		if(isPrime(INPUT)){
			SetANS(Print(INPUT));
			return true;
		}else{
			SetANS(Print2(INPUT));
			return false;
		}
	}

	public void SetInt(int x){
		INPUT = x;
	}

	private boolean isPrime(int n){
		long start,end;
		start = System.currentTimeMillis();
		if(n <= 1) return false;
		if(n == 2||n == 3) return true;
		for(int i = 2; i <= Math.sqrt(n); i++){
			end = System.currentTimeMillis();
			if((end-start)>=5000){
				break;
			}
			if(n%i == 0) return false;
		}
		return true;
	}
	public void Number(){
		int i = 0;
		int num = 0;
		while(i < N){
			if(isPrime(num)){
				A[i] = num;
				i++;
			}
			num++;
		}
	}
	public int Search(int n){
		long start,end;
		start = System.currentTimeMillis();

		int count = 0;
		for(int i = 2;i <= n; i++){

			end = System.currentTimeMillis();
			if((end-start)>=10000){
				count = -1;
				break;
			}
			if(isPrime(i))
				count++;
		}
		return count;
	}
	public String Print(int ans){
		String s = "";
		int num = Search(ans);
		if(num%10 == 1) s = num+"st";
		else if(num%10 == 2) s = num+"nd";
		else if(num == -1) s = "";
		else s = num +"th";
		return ans+" is "+s+" Prime";
	}

	public int MultPrime(int x){
		int ans = 1;
		for(int i = 2;i < x; i++){
			if(isPrime(i)) {
				Print(i);
				ans *= i;
			}
		}
		return ans;
	}
	public String Print2(int x){
		String ans = String.valueOf(x);
		String t = " = ";
		int n = x;
		int i = 2;
		long start;
		long end;
		start = System.currentTimeMillis();

		while(n > 1){
			end = System.currentTimeMillis();
			if((end-start)>=5000){
				ans = "error";
				break;
			}

			if(n%i==0){
				ans += t + i;
				t = "*";
				n /= i;
			}else
				i++;
		}
		return ans;


	}
	public static void main(String[] args){


	}


}
