package by.karpau.part1.service;

import by.karpau.part1.domain.*;

public class ArrayActions {
	private Array array;

	public ArrayActions() {
	}
	
	public ArrayActions(Array array) {
		this.array = array;
	}

	public int getMaxValue() {
		int[] arr = array.getArray();
		int max = arr[0];
		for (int el : arr) {
			max = max < el ? el : max;
		}
		return max;
	}

	public int getMinValue() {
		int[] arr = array.getArray();
		int min = arr[0];
		for (int el : arr) {
			min = min > el ? el : min;
		}
		return min;
	}

	public int[] getSimpleValues() {
		int[] arr = new int[array.getLength()];
		int counter = 0;
		for (int el : array.getArray()) {
			if (isSimple(el)) {
				arr[counter++] = el;
			}
		}
		return arr;
	}

	public boolean isSimple(int element) {
		if (element % 2 == 0 || element <= 1) {
			return false;
		}
		for (int i = 3; i < element / 2; i += 2) {
			if (element % i == 0) {
				return false;
			}
		}
		return true;
	}

	public int[] getArrayOfFib() {
		int first = 1;
		int second = first;
		int[] arrOfFib = new int[array.getLength()];
		int counter = 0;
		while (second < getMaxValue()) {
			if (array.binarySearch(second) != -1) {
				arrOfFib[counter++] = second;
			}
			int container = second;
			second = second + first;
			first = container;
		}
		return arrOfFib;
	}

	public static int[] getUnityOfArrays(int[] arr1, int[] arr2) {
		int[] arr3 = new int[arr1.length + arr2.length];
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);
		System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
		return arr3;
	}

	public int[] getThreeDigitValues() {
		int[] arr = array.getArray();
		int[] arrOfTDV = new int[arr.length];
		int counter = 0;
		for (int el : arr) {
			if (el > 101 && el < 988) {
				int n1 = el % 10, n2 = (el % 100) / 10, n3 = el / 100;
				if (n1 != n2 && n1 != n3 && n2 != n3) {
					arrOfTDV[counter++] = el;
				}
			}
		}
		int[] retArr = new int[counter];
		for(int i = 0; i<counter;i++) {
			retArr[i] = arrOfTDV[i];
		}
		return retArr;
	}
}
