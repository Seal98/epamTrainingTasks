package by.karpau.part1.inputData;

import java.util.Scanner;

public class InputData {
	private InputData() {}
	
	public static int[] getArray() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Type the size of array");
		int sizeOfArray = sc.nextInt();
		int[] arr = new int[sizeOfArray];
		System.out.println("Type the elements");
		for (int i = 0; i < sizeOfArray; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		return arr;
	}
}
