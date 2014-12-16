package report2;

public class SOR extends Matrix{

	double w = 0.01;
	int Min = 99999;
	double Wmin = 1;
	double[] X_1 = new double[N];
	double[] X1 = new double[N];
	public SOR(){
		SetE();
		Q(4);
	}

	private void run(){
		while(0 < w&& w < 2){
			this.setX0(0);

			int k = 0;

			for(int count = 0; count < 9999; count++){
				for(int i = 0; i < N; i++){
					this.Copy(X_1,this.MatVec(T,this.VecPlus(b,this.VecPlus(this.ScaVec(-1,this.MatVec(L, X_1)), this.ScaVec(-1,this.MatVec(U, X))))),i);
				}
				this.Copy(X1,this.VecPlus(this.ScaVec(w, X_1), this.ScaVec(1-w, X)));
				
				if(isfinish(X1,X)){
					k = count + 1;
					if(Min > k){
						Min = k;
						Wmin = w;
					}
					this.Copy(X, X1);
					break;
				}
				
				this.Copy(X, X1);

			}
			w += 0.01;
		}
		System.out.println("w="+Wmin+"‚Ì‚Æ‚«"+Min+"‰ñ");
	}
	private void Q(int n){
		double d = 0;
		double el = 0;
		double er = 0;
		switch(n){
		case 1:
			b[0] = 6;
			b[1] = 10;
			b[2] = 8;
			b[3] = 10;
			b[4] = 7;
			b[5] = 6;
			b[6] = 7;
			b[7] = 10;
			b[8] = 7;
			b[9] = 5;
			d = 4;
			el = 1;
			er = 1;
			break;
		case 2:
			b[0] = 1;
			b[1] = -1;
			b[2] = 2;
			b[3] = -1;
			b[4] = -1;
			b[5] = 2;
			b[6] = -2;
			b[7] = 2;
			b[8] = -1;
			b[9] = 1;
			d = 2;
			el = -1;
			er = -1;
			break;
		case 3:
			b[0] = 2;
			b[1] = 4;
			b[2] = -3;
			b[3] = 0;
			b[4] = -1;
			b[5] = 4;
			b[6] = -3;
			b[7] = -1;
			b[8] = 4;
			b[9] = -2;
			d = 4;
			el = -3;
			er = -1;
			break;
		case 4:
			b[0] = -2;
			b[1] = 4;
			b[2] = -1;
			b[3] = -3;
			b[4] = 4;
			b[5] = -1;
			b[6] = 0;
			b[7] = -3;
			b[8] = 4;
			b[9] = 2;
			d = 4;
			el = -1;
			er = -3;
			break;
		default:
			break;
		}

		for(int i = 0; i < N ;i++){
			for(int j = 0; j < N; j++){
				if(i == j){
					A[i][j] = d;
					D[i][j] = A[i][j];
					L[i][j] = 0;
					U[i][j] = 0;
				}
				else if(j == i + 1){
					A[i][j] = er;
					U[i][j] = A[i][j];
					D[i][j] = 0;
					L[i][j] = 0;
				}
				else if(j == i - 1){
					A[i][j] = el;
					L[i][j] = A[i][j];
					D[i][j] = 0;
					U[i][j] = 0;
				}
				else{
					A[i][j] = 0;
					D[i][j] = 0;
					L[i][j] = 0;
					U[i][j] = 0;
				}
			}
		}
		//	this.Copy(M,this.ScaMat(this.MatPlus(L, U), -1/d));
		this.Copy(T, this.ScaMat(E, 1/d));
	}
	public static void main(String[] args) {
		SOR g1  = new SOR();
		g1.run();

	}

}

