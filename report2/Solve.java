package report2;

public class Solve {
	private final static int N = 4;
	double[][] A = new double[N][N];
	double[] b = new double[N];
	double[] X = new double[N];
	double[] m = new double[N];
	double pivt;


	Solve(){
		A[0][0]=10E8;A[0][1]=1.0; A[0][2]=1.0; A[0][3]=0;
		A[1][0]=10;  A[1][1]=10;   A[1][2]=10; A[1][3]=0;
		A[2][0]=1.0; A[2][1]=1.0;A[2][2]=1.0; A[2][3]=0;
		A[3][0]=0; A[3][1]=0;A[3][2]=0; A[3][3]=0;
		b[0] = 0;
		b[1] = 0;
		b[2] = 0;
		b[3] = 0;
		for(int i = 0; i < N; i++){
			X[i] = 0.0;
		}
	}

	void run(){
		for(int k = 0;k < N-1;k++){
			for(int i = k; i < N;i++){
				if(A[k][k] != 0)
					m[i] = -A[k][i]/A[k][k];
				for(int j = k; j < N;j++){

					A[i][j] = A[i][j] + m[i]*A[k][j];
					b[i] = b[i] + m[i]*b[k];
					print2();

				}
			}
		}
	}
	void run2(){
		//int k = 1;
		double ans = 0.0;
		for(int i = N-1;i>=0;i--){
			for(int j = i+1;j<N;j++){
				ans += A[i][j]*X[j];
			}
			X[i] = (b[i]-ans)/A[i][i];

		}

	}
	void print(){
		for(int i = 0; i < N; i++){
			System.out.println("X"+i+"="+X[i]);
		}
	}
	void print2(){
		for(int i = 0; i < N;i++){
			for(int j = 0; j < N; j++){
				System.out.print(A[i][j]+",");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args){
		Solve s = new Solve();
		s.print();
		s.run();
		s.run2();
		s.print();
	}
}
