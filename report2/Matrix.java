package report2;
abstract class Matrix {
	final static int N = 10;


	final static double LIMIT = 10E-8;
	double A[][] = new double[N][N];
	//double X[] = {0,0,0,0,0,0,0,0,0,0};
	double X[] = new double[N];
	double b[] = new double[N];
	double D[][] = new double[N][N];
	double L[][] = new double[N][N];
	double U[][] = new double[N][N];
	double M[][] = new double[N][N];
	double T[][] = new double[N][N];
	double E[][] = new double[N][N];
	void SetE(){
		for(int i = 0; i < N ;i++){
			for(int j = 0; j < N; j++){
				if(i == j)
					E[i][j] = 1;
				else
					E[i][j] = 0;
			}
		}
	}
	void setX0(int n){
		if(n == 1){
			for(int i = 0; i < N; i++){
				X[i] = 0.0;
			}
		}else if(n == 0){
			for(int i = 0; i < N; i++){
				X[i] = i+1.0;
			}
		}

	}
	boolean isfinish(double[] X1,double[] X){
		for(int i = 0; i < N; i++){
			if(Math.abs(X1[i]-X[i])>=LIMIT){
				return false;
			}
		}
		return true;
	}
	double[][] MatMalt(double[][] A,double[][] B){
		double C[][] = new double[N][N];
		for(int i = 0; i < N ;i++){
			for(int j = 0; j < N; j++){
				for(int k = 0; k < N; k++){
					C[i][j] += A[k][j]*B[i][k]; 
				}
			}
		}
		return C;
	}

	double[][] MatPlus(double[][] A,double[][] B){
		double C[][] = new double[N][N];
		for(int i = 0; i < N ;i++){
			for(int j = 0; j < N; j++){
				C[i][j] = A[i][j] + B[i][j];
			}
		}
		return C;
	}
	double[] VecPlus(double[] A,double[] B){
		double C[] = new double[N];
		for(int i = 0; i < N ;i++){
			C[i] = A[i] + B[i];
		}
		return C;
	}
	double[] MatVec(double[][] A,double[] b){
		double C[] = new double[N];
		for(int j = 0; j < N; j++){
			for(int k = 0; k < N; k++){
				C[j] += A[j][k]*b[k];
			}
		}
		return C;
	}
	double[][] ScaMat(double[][] A,double k){
		double C[][] = new double[N][N];
		for(int i = 0; i < N ;i++){
			for(int j = 0; j < N; j++){
				C[i][j] = A[i][j]*k;
			}
		}
		return C;
	}
	double[][] ScaMat(double k,double[][] A){
		double C[][] = new double[N][N];
		for(int i = 0; i < N ;i++){
			for(int j = 0; j < N; j++){
				C[i][j] = A[i][j]*k;
			}
		}
		return C;
	}
	double[] ScaVec(double[] A,double k){
		double C[] = new double[N];
		for(int i = 0; i < N ;i++){
			C[i] = A[i]*k;
		}
		return C;
	}
	double[] ScaVec(double k,double[] A){
		double C[] = new double[N];
		for(int i = 0; i < N ;i++){
			C[i] = A[i]*k;
		}
		return C;
	}
	void Copy(double[][] A,double[][] B){
		for(int i = 0; i < N ;i++){
			for(int j = 0; j < N; j++){
				A[i][j] = B[i][j];
			}
		}
	}
	void Copy(double[] A2,double[] B2){
		for(int i = 0; i < N ;i++){
			A2[i] = B2[i];
		}
	}
	void Copy(double[] A2,double[] B2,int i){
		A2[i] = B2[i];
	}
	void PrintX(){
		for(int i = 0; i < N; i++){
			System.out.println("X"+i+"="+X[i]);
		}
	}
	/*
	 * 
	 * 逆行列
	 * (GyakuGyouretu.java)
	 *
	 */




	//pivotは、消去演算を行う前に、対象となる行を基準とし、それ以降の
	//行の中から枢軸要素の絶対値が最大となる行を見つけ出し、対象の行と
	//その行とを入れ替えることを行う関数である。
	void pivot(int k,double a[][],int N){
		double max,copy;
		//ipは絶対値最大となるk列の要素の存在する行を示す変数で、
		//とりあえずk行とする
		int ip=k;
		//k列の要素のうち絶対値最大のものを示す変数maxの値をとりあえず
		//max=|a[k][k]|とする
		max=Math.abs(a[k][k]);
		//k+1行以降、最後の行まで、|a[i][k]|の最大値とそれが存在する行を
		//調べる
		for(int i=k+1; i<N; i++){	
			if(max<Math.abs(a[i][k])){
				ip=i;
				max=Math.abs(a[i][k]);
			}
		}
		if(ip!=k){
			for(int j=0; j<2*N; j++){
				//入れ替え作業
				copy    =a[ip][j];
				a[ip][j]=a[k][j];
				a[k][j] =copy;
			}
		}
	}

	//ガウス・ジョルダン法により、消去演算を行う
	void sweep(int k,double a[][],int N){
		double piv,mmm;
		//枢軸要素をpivとおく
		piv=a[k][k];
		//k行の要素をすべてpivで割る a[k][k]=1となる
		for(int j=0; j<2*N; j++)
			a[k][j]=a[k][j]/piv;
		//	
		for(int i=0; i<N; i++){
			mmm=a[i][k];
			//a[k][k]=1で、それ以外のk列要素は0となる
			//k行以外
			if(i!=k){
				//i行において、k列から2N-1列まで行う	
				for(int j=k; j<2*N; j++)
					a[i][j]=a[i][j]-mmm*a[k][j];
			}
		}
	}

	//逆行列を求める演算
	void gyaku(double a[][],int N){
		for(int k=0; k<N; k++){
			pivot(k,a,N);
			sweep(k,a,N);
		}
	}

}
