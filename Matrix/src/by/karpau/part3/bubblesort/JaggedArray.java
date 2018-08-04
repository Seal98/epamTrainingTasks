package by.karpau.part3.bubblesort;

public class JaggedArray {
	private int[][] jaggedMatrix;

	public JaggedArray() {
		jaggedMatrix = new int[0][];
	}

	public JaggedArray(int[][] matrix) {
		jaggedMatrix = JaggedArray.getCopyOfMatrix(matrix);
	}

	/**
	 * Parameter: 0 - ascending sort !0 - decreasing sort
	 */
	public void sortBySumInRow(int typeOfSorting) {
		int[] arrayOfSums = new int[jaggedMatrix.length];
		int sum;
		for (int i = 0; i < jaggedMatrix.length; i++) {
			sum = 0;
			for (int j = 0; j < jaggedMatrix[i].length; j++) {
				sum += jaggedMatrix[i][j];
			}
			arrayOfSums[i] = sum;
		}
		bubbleSort(arrayOfSums);
		if (typeOfSorting != 0) {
			reverseArray();
		}
	}
	
	/**
	 * Parameter: 0 - ascending sort !0 - decreasing sort
	 */
	public void sortByMaxElementInRow(int typeOfSorting) {
		createArrayOfMinOrMaxElements(1, typeOfSorting);
	}
	
	/**
	 * Parameter: 0 - ascending sort !0 - decreasing sort
	 */
	public void sortByMinElementInRow(int typeOfSorting) {
		createArrayOfMinOrMaxElements(0, typeOfSorting);
	}

	public void createArrayOfMinOrMaxElements(int minOrMax, int typeOfSorting) {
		int[] arrayOfMinElements = new int[jaggedMatrix.length];
		int minOrMaxElement;
		for (int i = 0; i < jaggedMatrix.length; i++) {
			if (jaggedMatrix[i].length != 0) {
				minOrMaxElement = jaggedMatrix[i][0];
			} else {
				arrayOfMinElements[i] = 0;
				continue;
			}
			for (int j = 1; j < jaggedMatrix[i].length; j++) {
				if(minOrMax == 0) {
					minOrMaxElement = minOrMaxElement > jaggedMatrix[i][j] ? jaggedMatrix[i][j] : minOrMaxElement;
				}
				else {
					minOrMaxElement = minOrMaxElement < jaggedMatrix[i][j] ? jaggedMatrix[i][j] : minOrMaxElement;
				}
			}
			arrayOfMinElements[i] = minOrMaxElement;
		}
		bubbleSort(arrayOfMinElements);
		if (typeOfSorting != 0) {
			reverseArray();
		}
	}
	
	public void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length - i; j++) {
				if (array[j - 1] > array[j]) {
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
					int[] tempRow = jaggedMatrix[j - 1];
					jaggedMatrix[j - 1] = jaggedMatrix[j];
					jaggedMatrix[j] = tempRow;
				}

			}
		}
	}

	public void reverseArray() {
		int[] rowOfArray;
		for (int i = 0; i < jaggedMatrix.length/2; i++) {
			rowOfArray = jaggedMatrix[i];
			jaggedMatrix[i] = jaggedMatrix[jaggedMatrix.length - 1 - i];
			jaggedMatrix[jaggedMatrix.length - 1 - i] = rowOfArray;
		}
	}

	public static int[][] getCopyOfMatrix(int[][] matrix) {
		int[][] copyOfMatrix = new int[matrix.length][];
		for (int i = 0; i < matrix.length; i++) {
			copyOfMatrix[i] = new int[matrix[i].length];
			for (int j = 0; j < matrix[i].length; j++) {
				copyOfMatrix[i][j] = matrix[i][j];
			}
		}
		return copyOfMatrix;
	}

	@Override
	public String toString() {
		String arrayStr = this.getClass().getName() + "\n";
		for (int[] elY : jaggedMatrix) {
			for (int elX : elY) {
				arrayStr += elX + " ";
			}
			arrayStr += "\n";
		}
		return arrayStr.trim();
	}
}
