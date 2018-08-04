package by.karpau.part1.domain;

public class Array {
	private int[] array;

	public Array() {
		array = new int[0];
	}

	public Array(int[] array) {
		this.array = getCopyOfArray(array);
	}

	public int[] getCopyOfArray(int[] arr) {
		int[] newArr = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			newArr[i] = arr[i];
		}
		return newArr;
	}
	
	public int getLength() {
		return array.length;
	}

	public int getElementByIndex(int index) {
		return array[index];
	}

	public int[] getArray() {
		return getCopyOfArray(array);
	}

	public void setElementByIndex(int newElement, int index) {
		array[index] = newElement;
	}

	public void choiceSort() {
		for (int i = 0; i < getLength() - 1; i++) {
			for (int j = i + 1; j < getLength(); j++) {
				if (array[i] > array[j]) {
					int container = array[i];
					array[i] = array[j];
					array[j] = container;
				}
			}
		}
	}

	public void mergeSort(int start, int end) {
		int[] arr = { 0 };
		if (end - start > 1) {
			int middle = (end + start) / 2;
			mergeSort(start, middle);
			mergeSort(middle, end);
			arr = new int[end - start];
			int i = start;
			int j = end;
			for (int k = 0; k < arr.length; k++) {
				if (j >= end || i < middle && arr[i] < arr[j]) {
					arr[k] = array[i++];
				} else {
					arr[k] = array[j++];
				}
			}
		}
		System.arraycopy(arr, 0, array, start, arr.length);
	}

	public void quickSort(int start, int end) {
		int i = start;
		int j = end;
		int keyElement = array[(i + j) / 2];
		while (i < j) {
			while (array[i] < keyElement) {
				i++;
			}
			while (array[j] > keyElement) {
				j--;
			}
			if (i <= j) {
				int container = array[i];
				array[i] = array[j];
				array[j] = container;
				i++;
				j--;
			}
		}
		if (start < j) {
			quickSort(start, j);
		}
		if (end > i) {
			quickSort(i, end);
		}
	}

	public int binarySearch(int element) {
		for(int i=0;i<array.length-1;i++) {
			if(array[i] > array[i+1]) {
				return -1;
			}
		}
		
		int beg = 0;
		int end = array.length - 1;
		while (end - beg > 1) {
			if (array[(beg + end) / 2] < element) {
				beg = (beg + end) % 2 == 0 ? (beg + end) / 2 : (beg + end + 1) / 2;
			} else if (array[(beg + end) / 2] > element) {
				end = (beg + end) / 2;
			} else {
				return (beg + end) / 2;
			}
		}
		if (array[beg] == element || array[end] == element) {
			return beg + 1;
		} else {
			return -1;
		}
	}

	@Override
	public String toString() {
		String arrayStr = this.getClass().getName() + " ";
		for (int el : array) {
			arrayStr += el + " ";
		}
		return arrayStr.trim();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		Array testArray = (Array) obj;
		if (this.hashCode() != testArray.hashCode()) {
			return false;
		}
		if (obj == null || obj.getClass().getName() != this.getClass().getName()) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		if (array == null) {
			return 0;
		}
		int code = 0;
		for (int el : array) {
			code += Math.pow(el, 2);
		}
		return code;
	}
}
