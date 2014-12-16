package report2;

public class Newton2 {
	
	final static int N = 9999; 
	final static double LIMIT= 0.00000001; 
	final static double LIM= 0.0001; 

	double[] X;
	double[] Y;

	Newton2(){
		X = new double[N];
		Y = new double[N];

	}
	
	int run(double x,double y){
		int k = 1;
		X[0] = x;
		Y[0] = y;
		while(k <= 999){
			X[k] = X[k-1] - ((X[k-1]*X[k-1]-Y[k-1]*Y[k-1])*(X[k-1]*X[k-1]*X[k-1]-3*X[k-1]*Y[k-1]*Y[k-1]-1)+6*P(X[k-1],3)*P(Y[k-1],2)-2*X[k-1]*P(Y[k-1],4))/(3*P((P(X[k-1],2)+P(Y[k-1],2)),2));
			Y[k] = Y[k-1] - ((-2*X[k-1]*Y[k-1])*(X[k-1]*X[k-1]*X[k-1]-3*X[k-1]*Y[k-1]*Y[k-1]-1)+(X[k-1]*X[k-1]-Y[k-1]*Y[k-1])*(3*X[k-1]*X[k-1]*Y[k-1]-P(Y[k-1],3)))/(3*P((P(X[k-1],2)+P(Y[k-1],2)),2));
			if(X[k]-X[k-1]<LIMIT && X[k]-X[k-1]>-LIMIT) {
				if(Y[k]-Y[k-1]<LIMIT && Y[k]-Y[k-1]>-LIMIT) break;
			}
			k++;
		}
		if(Math.abs(X[k]-1.0)<LIM)return 1;
		if(Math.abs(X[k]+0.5)<LIM && Math.abs(Y[k]-Math.sqrt(3)/2)<LIM)return 2;
		if(Math.abs(X[k]+0.5)<LIM && Math.abs(Y[k]+Math.sqrt(3)/2)<LIM)return 3;
		
		
		return 0;


	}
	double P(double x,int n){
		double ans = 1.0;
		for(int i = 0;i < n;i++){
			ans *= x;
		}
		return ans;
	}

	public static void main(String[] args) {
		Newton2 n = new Newton2();
		
		for(int i = 0;i < 10000;i++){
		double ranx = 4*Math.random()-2;
		double rany = 4*Math.random()-2;
		if(n.run(ranx,rany)==1){
			System.out.println(ranx+" "+rany);
			
		}
		
		}

	}

}
