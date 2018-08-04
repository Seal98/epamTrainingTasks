package by.karpau.part1.runner;

import java.io.IOException;

import by.karpau.part1.creator.CreateArray;
import by.karpau.part1.domain.Array;
import by.karpau.part1.inputData.InputData;
import by.karpau.part1.service.ArrayActions;

public class Runner {
	public static void main(String[] args) {
		Array array2 = new Array(CreateArray.createArrayByRandom());
		Array arr1 = new Array();
		System.out.println(arr1.getLength());
		System.out.println(array2.toString());
		ArrayActions aa = new ArrayActions(array2);
		int[] arr = aa.getThreeDigitValues();
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}

	}
}
