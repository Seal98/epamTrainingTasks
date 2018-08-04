package by.karpau.part1.creator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class CreateArray {
	private CreateArray() {}
	
	public static int[] createArrayByRandom() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Type the size of array");
		int[] arr = new int[sc.nextInt()];
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(1000) + 1;
		}
		sc.close();
		return arr;
	}

	public static int[] readArrayFromFile(){
		int[] array = {0};
		try {
			BufferedReader br = new BufferedReader(new FileReader("input.txt"));

			String line = "";
			StringTokenizer st;
			Stack<Integer> s = new Stack<>();
			while ((line = br.readLine()) != null) {
				st = new StringTokenizer(line);
				while(st.hasMoreTokens()) {
					s.push(Integer.parseInt(st.nextToken()));
				}
			}
			array = new int[s.size()];
			for(int i=0;i<array.length;i++) {
				array[array.length - (i+1)] = s.pop();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return array;
	}
}
