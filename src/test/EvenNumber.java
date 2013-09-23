package test;

public class EvenNumber {
	public static void Output(int n) {
		System.out.println("Even");
		int A[][];
		A = new int[n][n];
		int x = 0, y = 0;

		if (n % 4 == 0) { // n = 4k,dual even
			System.out.println("Dual Even");
			// Divide the array by the location in 2 pieces,0 for 1st time
			// filling in the numbers of
			// positive sequence,-1 for 2nd time filling in descending numbers.

			for (x = 0; x < n / 2; x++) { // Top left
				for (y = 0; y < n / 2; y++) {
					if (x % 2 == y % 2) {
						A[x][y] = -1;
					} else {
						A[x][y] = 0;
					}
				}
			}
			for (x = n / 2; x < n; x++) { // Bottom right
				for (y = n / 2; y < n; y++) {
					if (x % 2 == y % 2) {
						A[x][y] = -1;
					} else {
						A[x][y] = 0;
					}
				}
			}
			for (x = n / 2; x < n; x++) { // Bottom left
				for (y = 0; y < n / 2; y++) {
					if (x % 2 != y % 2) {
						A[x][y] = -1;
					} else {
						A[x][y] = 0;
					}
				}
			}
			for (x = 0; x < n / 2; x++) { // Top right
				for (y = n / 2; y < n; y++) {
					if (x % 2 != y % 2) {
						A[x][y] = -1;
					} else {
						A[x][y] = 0;
					}
				}
			}
			// fill in the numbers
			int number1 = 1;
			int number2 = n * n;
			for (x = 0; x < n; x++) {
				for (y = 0; y < n; y++) {
					if (A[x][y] == 0)
						A[x][y] = number1;
					else
						A[x][y] = number2;
					number1++;
					number2--;
				}
			}
			// Output
			for (x = 0; x < n; x++) {
				for (y = 0; y < n; y++) {
					System.out.print(A[x][y] + "\t");
				}
				System.out.println();
			}
		} else { // n = 4k + 2,single even
			System.out.println("Single Even");
			for(x=0;x<n;x++)
				for(y=0;y<n;y++)
					A[x][y]=0;
			//Divide in A,B,C,D by n/2 and fill in the numbers as OddNumber			
			int a=1;
			x = 0;
			y = n / 4;
			while (a <= n * n / 4) {	//fill in Sector A
				A[x][y] = a;
				if (x == 0 && y == n/2-1)
					x++;
				else if (x == 0 && y != n/2-1) {
					x = n/2-1;
					y++;
				} else if (x != 0 && y == n/2-1) {
					x--;
					y = 0;
				} else if (A[x - 1][y + 1] == 0) {
					x--;
					y++;
				} else if (A[x - 1][y + 1] != 0)
					x++;
				a++;
			}
			x = n / 2;
			y = n * 3 / 4;
			while (a <= n * n / 2) {	//fill in Sector B
				A[x][y] = a;
				if (x == n/2 && y == n-1)
					x++;
				else if (x == n/2 && y != n-1) {
					x = n-1;
					y++;
				} else if (x != n/2 && y == n-1) {
					x--;
					y = n/2;
				} else if (A[x - 1][y + 1] == 0) {
					x--;
					y++;
				} else if (A[x - 1][y + 1] != 0)
					x++;
				a++;
			}
			x=0;
			y=n*3/4;
			while (a <= n * n / 4 * 3) {	//fill in Sector C
				A[x][y] = a;
				if (x == 0 && y == n-1)
					x++;
				else if (x == 0 && y != n-1) {
					x = n/2-1;
					y++;
				} else if (x != 0 && y == n-1) {
					x--;
					y = n/2;
				} else if (A[x - 1][y + 1] == 0) {
					x--;
					y++;
				} else if (A[x - 1][y + 1] != 0)
					x++;
				a++;
			}
			x=n/2;
			y=n/4;
			while (a <= n * n) {	//fill in Sector D
				A[x][y] = a;
				if (x == n/2 && y == n/2-1)
					x++;
				else if (x == n/2 && y != n/2-1) {
					x = n-1;
					y++;
				} else if (x != n/2 && y == n/2-1) {
					x--;
					y = 0;
				} else if (A[x - 1][y + 1] == 0) {
					x--;
					y++;
				} else if (A[x - 1][y + 1] != 0)
					x++;
				a++;
			}
			//Exchange the position
			int m = (n-2)/4-1;
			int temp;
			for(int i=0;i<n/2;i++){
				if(i==m+1){
					temp = A[i][i];
					A[i][i] = A[n/2+i][i];
					A[n/2+i][i] = temp;
				}else{
					temp = A[i][m];
					A[i][m] = A[n/2+i][m];
					A[n/2+i][m] = temp;
				}
			}
			if(m>0){
				m--;
				for(int i=0;i<n/2;i++){
					temp = A[i][n-1-m];
					A[i][n-1-m] = A[n/2+i][n-1-m];
					A[n/2+i][n-1-m] = temp;					 
				}
			}
			
			//Output
			for (x = 0; x < n; x++) {
				for (y = 0; y < n; y++) {
					System.out.print(A[x][y] + "\t");
				}
				System.out.println();
			}
		}
	}
}
