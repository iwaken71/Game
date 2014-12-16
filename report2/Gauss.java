package report2;

public class Gauss extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static int N = 4; //行列のサイズ
	double[][] A = new double[N][N];
	double[] b = new double[N];
	double[] X = new double[N];
	double[] m = new double[N];
	int pivot;
	boolean check = true;
	double e = 0.000000000001;

	//コンストラクタ　ここで代入値を決定する
	public Gauss(){
		A[0][0]=10E8;A[0][1]=1.0; A[0][2]=1.0; A[0][3]=0;
		A[1][0]=10;  A[1][1]=10;   A[1][2]=10; A[1][3]=0;
		A[2][0]=1.0; A[2][1]=1.0;A[2][2]=1.0; A[2][3]=0;
		A[3][0]=0; A[3][1]=0;A[3][2]=0; A[3][3]=0;
		b[0] = 0;
		b[1] = 0;
		b[2] = 0;
		b[3] = 0;
		//ランダム生成
		//this.RandomStart();
		/*
		 * 

//問題３−１
A[0][0]=1.0; A[0][1]= 1/e;
A[1][0]=1.0; A[1][1]= 1.0;
b[0] = 1/e + e -1;
b[1] = 1;
		 */

		//detA = 0

		/*

		A[0][0]= 2.0; A[0][1]= 3.0; A[0][2]= 4.0;
		A[1][0]= 5.0; A[1][1]= 6.0; A[1][2]= 7.0;
		A[2][0]= 8.0; A[2][1]= 9.0; A[2][2]=10.0;
		b[0] = 9.0;
		b[1] =18.0;
		b[2] =27.0;
		 */
		/*

//問題３
A[0][0]= 1.0; A[0][1]= 2.0; A[0][2]=-3.0;
A[1][0]= 2.0; A[1][1]= 4.0; A[1][2]= 1.0;
A[2][0]= 8.0; A[2][1]= 1.0; A[2][2]= -4.0;
b[0] = 1.0;
b[1] = 3.0;
b[2] =-2.0;
		 */
		/*

//問題２
A[0][0]= 1.0; A[0][1]=-1.0; A[0][2]= 3.0;
A[1][0]= 4.0; A[1][1]= 1.0; A[1][2]=-6.0;
A[2][0]= 3.0; A[2][1]= 0.0; A[2][2]= 1.0;
b[0] = 7.0;
b[1] = 0.0;
b[2] = 7.0;
		 */	 
		/*
//問題１
A[0][0]=2.0; A[0][1]=-1.0;
A[1][0]=3.0; A[1][1]=-2.0;
b[0] = 6.0;
b[1] = 7.0;
		 */
	}

		//前進消去過程
		void run(){
			try{
				//k段目の処理
				for(int k = 0;k < N-1;k++){
					//i行目への処理
					for(int i = k + 1; i < N;i++){
						if(Math.abs(A[k][k]) < 10e-12){
							int ip = select_pivot(k);
							swap_row(ip,k);

							System.out.println("第"+ip+"行と第"+k+"行を入れ替える"); //print
							check = false;

						}
						m[i] = -A[i][k]/A[k][k];
						A[i][k] = 0.0;
						for(int j = k + 1; j < N;j++){
							A[i][j] = A[i][j] + m[i]*A[k][j];
						}
						b[i] = b[i] + m[i]*b[k];

						if(check)
							print3(k,i,m[i]);
						check = true;
						print2();


					}
				}
			}catch(Exception e){
				System.out.println("0");
			}

		}

		//後退代入過程

		void run2(){
			double ans;
			for(int i = N-1;i>=0;i--){
				ans = 0.0;
				for(int j = i+1;j<=N-1;j++){
					if(i == N-1) break;
					ans += A[i][j]*X[j];
				}
				X[i] = (b[i]-ans)/A[i][i];
			}
		}

		//解を表示する
		void print(){
			for(int i = 0; i < N; i++){
				System.out.println("X"+i+"="+X[i]);
			}
		}

		//行基本変形を表示する
		void print2(){
			for(int i = 0; i < N;i++){
				for(int j = 0; j < N; j++){
					System.out.print(A[i][j]+",");
				}

				System.out.print("|"+b[i]);
				System.out.println();
			}
			System.out.println();

		}
		//計算過程を表示する
		void print3(int k,int i,double m){

			if(m>0)
				System.out.println("第"+i+"行に,第"+k+"行×"+m+"倍を足す");
			else
				System.out.println("第"+i+"行に,第"+k+"行×("+m+")" +"倍を足す");
		}

		//最適なピボットを選択する
		int select_pivot(int k){

			int ip = k;
			double max = 0.0;
			for(int i = k+1;k < N;k++){

				if(Math.abs(A[i][k])>max){
					max = Math.abs(A[i][k]);
					ip = i;
				}
			}
			return ip;
		}

		//行を入れ替える
		void swap_row(int ip,int k){

			double a_tmp[] = new double[N];
			double b_tmp;
			for(int j = 0;j < N; j++)
				a_tmp[j] = A[ip][j];
			b_tmp= b[ip];
			for(int j = 0;j < N; j++)
				A[ip][j] = A[k][j];
			b[ip] = b[k];
			for(int j = 0;j < N; j++)
				A[k][j] = a_tmp[j];
			b[k] = b_tmp;
		}

		//ランダムに初期値を設定する
		void RandomStart(){
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					A[i][j] = Math.random()*10;
				}
			}
			for(int j = 0; j < N; j++){
				b[j] = Math.random()*10;
			}
		}

		public static void main(String[] args){
			Gauss s = new Gauss();
			//時間の計測を開始する
			long start = System.nanoTime();
			s.run();
			s.run2();
			long end = System.nanoTime();
			System.out.println("Time:" + (end - start) / 1000000f + "ms");//1.0*10^-3 秒

			//解を表示する
			s.print();

		}

	}