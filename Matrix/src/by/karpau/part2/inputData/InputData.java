package by.karpau.part2.inputData;

import java.util.Scanner;

public class InputData {
	private InputData() {}
	
	public static double[][] getArray() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Type the size of array");
		int sizeOfArray = sc.nextInt();
		double[][] arr = new double[sizeOfArray][sizeOfArray];
		System.out.println("Type the elements");
		for (int i = 0; i < sizeOfArray; i++) {
			for (int j = 0; j < sizeOfArray; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();
		return arr;
	}
}
