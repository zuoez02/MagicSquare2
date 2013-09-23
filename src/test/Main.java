package test;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		int n;
		n = 3;
		try{
			System.out.print("请输入一个整数：");
			  BufferedReader strin=new BufferedReader(new InputStreamReader(System.in));
			  n=Integer.parseInt(strin.readLine());
		}catch(Exception e){
			e.printStackTrace();
		}
		int A[][] = new int[n][n];
		for(int i = 0;i < n;i++)
			for(int j = 0;j<n;j++)
				A[i][j] = 0;
		int a = 1,x = 1,y = (n+1)/2;
		while(a != n*n +1){
			A[x-1][y-1]=a;
			if(x == 1 && y == n)
				x++;
			else if(x ==1 && y != n)
			{
				x = n;
				y++;
			}
			else if(x != 1 && y == n)
			{
				x--;
				y=1;
			}
			else if(A[x-2][y] == 0)
			{
				x--;
				y++;
			}
			else if(A[x-2][y] != 0)
				x++;
			a++;
		}
		for(int i = 0;i < n;i++){
			for(int j = 0;j<n;j++)
				System.out.print(A[i][j]+"\t");
			System.out.println();
		}
	}
}