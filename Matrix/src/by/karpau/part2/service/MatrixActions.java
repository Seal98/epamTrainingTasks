package by.karpau.part2.service;

import by.karpau.part2.domain.*;

public class MatrixActions {
	private Matrix matrix;

	public MatrixActions(Matrix array) {
		this.matrix = array;
	}

	public double[] getMaxFromEachRow() {
		double[] matrOfMaxEl = new double[matrix.getLength()];
		double[][] matr = matrix.getMatrix();
		for (int i = 0; i < matr.length; i++) {
			matrOfMaxEl[i] = matr[i][0];
			for (int j = 1; j < matr.length; j++) {
				if (matr[i][j] > matrOfMaxEl[i]) {
					matrOfMaxEl[i] = matr[i][j];
				}
			}
		}
		return matrOfMaxEl;
	}
	
	public double[] getMinFromEachColumn() {
		double[] matrOfMinEl = new double[matrix.getLength()];
		double[][] matr = matrix.getMatrix();
		for (int i = 0; i < matr.length; i++) {
			matrOfMinEl[i] = matr[0][i];
			for (int j = 0; j < matr.length; j++) {
				if (matr[j][i] < matrOfMinEl[i]) {
					matrOfMinEl[i] = matr[j][i];
				}
			}
		}
		return matrOfMinEl;
	}
	
	public double[] getArrayOfSumBetweenTwoElements() {
		double[] sum = new double[matrix.getLength()];
		for(int i=0;i<matrix.getLength();i++) {
			int ind1=0, ind2=0;
			for(int j=0;j<matrix.getLength();j++) {
				if(matrix.getElementByIndex(i, j) > 0) {
					ind1 = j;
					break;
				}
			}
			//System.out.println("|ind1| " + ind1 + " " + ind2 + " |||");
			ind2 = ind1;
			for(int j=ind2+1;j<matrix.getLength();j++) {
				//System.out.println("|ind2|| " + ind1 + " " + ind2 + " |||");
				if(matrix.getElementByIndex(i, j) > 0) {
					ind2 = j;
					break;
				}
			}
			sum[i] = getSumBetweenTwoElements(ind1, ind2, i);
		}
		return sum;
	}
	
	public double getSumBetweenTwoElements(int ind1, int ind2, int k) {
		double sum = 0;
		for(int i=ind1+1;i<ind2;i++) {
			sum+=matrix.getElementByIndex(k, i);
		}
		return sum;
	}
}
