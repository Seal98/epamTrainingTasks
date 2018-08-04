package by.karpau.part2.domain;

public class Matrix {
	private double[][] matrix;

	public Matrix() {
		matrix = new double[0][0];
	}

	public Matrix(double[][] array) {
		matrix = getCopyOfMatrix(array);
	}

	public double[][] getCopyOfMatrix(double[][] array){
		double[][] newArr = new double[array.length][];
		newArr = new double[array.length][];
		for(int i=0;i<array.length;i++) {
			newArr[i] = new double[array[i].length];
			for(int j=0;j<array[i].length;j++) {
				newArr[i][j] = array[i][j];
			}
		}
		return newArr;
	}
	
	public int getLength() {
		return matrix.length;
	}

	public double getElementByIndex(int index1, int index2) {
		try {
			return matrix[index1][index2];
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		return -1;
	}

	public double[][] getMatrix() {
		return getCopyOfMatrix(matrix);
	}

	public void setElementByIndex(int newElement, int index1, int index2) {
		matrix[index1][index2] = newElement;
	}

	public void sortRows(int k) {
		for (int i = 0; i < matrix.length - 1; i++) {
			for (int j = i + 1; j < matrix.length; j++) {
				if (matrix[i][k] > matrix[j][k]) {
					double[] container = matrix[i];
					matrix[i] = matrix[j];
					matrix[j] = container;
				}
			}
		}
	}

	public void changeStringsOfMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			int lastInd = matrix.length - 1;
			int startInd = 0;
			while (lastInd > startInd) {
				while (matrix[i][lastInd] == 0) {
					lastInd--;
				}
				while (matrix[i][startInd] != 0) {
					startInd++;
				}
				if (lastInd < startInd) {
					break;
				} else {
					double container = matrix[i][lastInd];
					matrix[i][lastInd] = matrix[i][startInd];
					matrix[i][startInd] = container;
				}
			}
		}
	}

	public void transposeMatrix() {
		for (int i = 0; i < matrix.length-1; i++) {
			for (int j = i+1; j < matrix.length; j++) {
				double container = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = container;
			}
		}
	}

	public void sortColumns(int k) {
		for (int i = 0; i < matrix.length - 1; i++) {
			for (int j = i + 1; j < matrix.length; j++) {
				if (matrix[k][i] > matrix[k][j]) {
					swapColumns(i, j);
				}
			}
		}
	}

	public void swapColumns(int c1, int c2) {
		for (int i = 0; i < matrix.length; i++) {
			double container = matrix[i][c1];
			matrix[i][c1] = matrix[i][c2];
			matrix[i][c2] = container;
		}
	}

	@Override
	public String toString() {
		String arrayStr = this.getClass().getName() + "\n";
		for (double[] elY : matrix) {
			for (double elX : elY) {
				arrayStr += elX + " ";
			}
			arrayStr += "\n";
		}
		return arrayStr.trim();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		Matrix testArray = (Matrix) obj;
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
		if (matrix == null)
			return 0;
		int code = 0;
		for (double[] elY : matrix) {
			for (double elX : elY) {
				code += Math.pow(elX, 2);
			}
		}
		return code;
	}
}
