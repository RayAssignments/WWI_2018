package q3;

import java.util.Scanner;
import java.util.Arrays;

public class Q3 {
	
	/*
	Question 3:
		Generate 500 random numbers and print the nth smallest number in a programming language
		of your choice.
	*/
	 
	public static int[ ] GenerateRandom(){
		int [ ] rand = new int [500];
		for (int i = 0; i < rand.length; i++ ){
			rand[i] = (int)(Math.random()*500+1);
		}
		return rand;
	}

	
	public static int FindSmallNth(int RandInts[ ], int n){
		Arrays.sort(RandInts);	
		return RandInts[n-1];
	}

	
	public static void main(String args[ ]){

		System.out.println("Please enter a value for n: ");
		Scanner sc =  new Scanner(System. in);
		int nInput = sc.nextInt();

		int [ ] RandInts = GenerateRandom();
		int nthSmallestElement = FindSmallNth(RandInts, nInput); 
		System.out.println("Your "+nInput+"th "+"smallest number is: "+nthSmallestElement);
	}	
	
}//end class