package test;

import java.io.*;

public class Main {
	public static void main(String[] args) {
		int n;
		n = 3;
		boolean flag = false;		
		while(!flag){
			try {
				System.out.print("Input a Integer:");
				BufferedReader strin = new BufferedReader(new InputStreamReader(
						System.in));
				n = Integer.parseInt(strin.readLine());
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(!(n >= 3))
				System.out.println("Must more than 2,please input again!");
			else
				flag = true;
		}
		
		if(n%4 == 1 || n%4 ==3)
			OddNumber.Output(n);
		else
			EvenNumber.Output(n);
		
	}
}