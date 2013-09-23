package test;

public class OddNumber {	
	public static void Output(int n){
		System.out.println("Odd");
		int number = n;
		int A[][] = new int[n][n];			
		for (int i = 0; i < number; i++)
			for (int j = 0; j < number; j++)
				A[i][j] = 0;
		//fill in the numbers
		int a = 1, x = 1, y = (number + 1) / 2;
		while (a != number * number + 1) {
			A[x - 1][y - 1] = a;
			if (x == 1 && y == number)
				x++;
			else if (x == 1 && y != number) {
				x = number;
				y++;
			} else if (x != 1 && y == number) {
				x--;
				y = 1;
			} else if (A[x - 2][y] == 0) {
				x--;
				y++;
			} else if (A[x - 2][y] != 0)
				x++;
			a++;
		}
		//Output
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++)
				System.out.print(A[i][j] + "\t");
			System.out.println();
		}
	}
}
