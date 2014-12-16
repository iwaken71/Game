package report2;

public class Newton {

	final static int N = 9999; 
	final static double limit= 0.00000001;  

	double[] X;

	Newton(){
		X = new double[N];

	}





	void run(){
		int k = 1;
		X[0] = 10;
		while(k <= 999){
			X[k] = 0.8*X[k-1]+2/Math.pow(X[k-1],4.0);
			System.out.println("n = "+k+"‚Ì‚Æ‚«"+X[k]);
			if(X[k]-X[k-1]<limit && X[k]-X[k-1]>-limit) break;
			k++;
		}


	}
	
	void run22(){
		int k = 1;
		X[0] = 3;
		while(k <= 999){
			X[k] = (9*X[k-1]+1+4/(X[k-1]+1))/12;
			System.out.println("n = "+k+"‚Ì‚Æ‚«"+X[k]);
			if(X[k]-X[k-1]<limit && X[k]-X[k-1]>-limit) break;
			k++;
		}
	}
	
	void run21(){
		int k = 1;
		X[0] = -3;
		while(k <= 999){
			X[k] = (9*X[k-1]+1+4/(X[k-1]+1))/12;
			System.out.println("n = "+k+"‚Ì‚Æ‚«"+X[k]);
			if(X[k]-X[k-1]<limit && X[k]-X[k-1]>-limit) break;
			k++;
		}
	}
	void run3(){
		int k = 1;
		X[0] = -1;
		while(k <= 999){
			X[k] = (2*Math.pow(X[k-1],3.0)-6*Math.pow(X[k-1],2.0)+6)/(3*Math.pow(X[k-1],2.0)-12*X[k-1]+11);
			System.out.println("n = "+k+"‚Ì‚Æ‚«"+X[k]);
			if(X[k]-X[k-1]<limit && X[k]-X[k-1]>-limit) break;
			k++;
		}
	}

	public static void main(String[] args){
		Newton n = new Newton();
		n.run22
		();

	}

}

