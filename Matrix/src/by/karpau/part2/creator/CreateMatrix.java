package by.karpau.part2.creator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class CreateMatrix {
	private CreateMatrix() {
	}

	public static double[][] createMatrixByRandom() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Type the size of array");
		int size = sc.nextInt();
		double[][] arr = new double[size][size];
		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				arr[i][j] = (double) rand.nextInt(10000) / 100 - 50;
			}
		}
		sc.close();
		return arr;
	}

	public static double[][] readMatrixFromFile() {
		double[][] array = { { 0 } };
		try {
			BufferedReader br = new BufferedReader(new FileReader("input.txt"));

			String line = "";
			StringTokenizer st;
			Stack<String> s = new Stack<>();
			while ((line = br.readLine()) != null) {
				s.push(line);
			}
			array = new double[s.size()][s.size()];
			for (int i = array.length - 1; i >= 0; i--) {
				String str = s.pop();
				st = new StringTokenizer(str);
				int counter = 0;
				while (st.hasMoreTokens()) {
					array[i][counter++] = Integer.parseInt(st.nextToken());
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return array;
	}

	public static int[][] readIntMatrixFromFile() {
		int[][] array = { { 0 } };
		try {
			BufferedReader br = new BufferedReader(new FileReader("jaggedArray.txt"));

			String line = "";
			StringTokenizer st;
			Stack<String> s = new Stack<>();
			Stack<Integer> stOfNumbers = new Stack<>();
			while ((line = br.readLine()) != null) {
				s.push(line);
			}
			array = new int[s.size()][];
			for (int i = array.length - 1; i >= 0; i--) {
				String str = s.pop();
				st = new StringTokenizer(str);
				int counter = 0;
				while (st.hasMoreTokens()) {
					stOfNumbers.push(Integer.parseInt(st.nextToken()));
				}
				array[i] = new int[stOfNumbers.size()];
				for (int j = array[i].length - 1; j >= 0; j--) {
					array[i][j] = stOfNumbers.pop();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return array;
	}
}
