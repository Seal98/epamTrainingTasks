package by.karpau.part2.runner;

import by.karpau.part2.creator.CreateMatrix;
import by.karpau.part2.domain.Matrix;
import by.karpau.part2.service.MatrixActions;
import by.karpau.part3.bubblesort.JaggedArray;

public class Runner {

	public static void main(String[] args) {
		//Matrix array2 = new Matrix(CreateMatrix.createMatrixByRandom());
		
		//Matrix array3 = new Matrix(CreateMatrix.readMatrixFromFile());
		//System.out.println(array2.getElementByIndex(2, 2));
		//System.out.println(array2.toString());
		//MatrixActions aa = new MatrixActions(array2);
		//double[] arr = aa.getArrayOfSumBetweenTwoElements();
		//for(int i=0;i<arr.length;i++) {
		//	System.out.println("sum: " + arr[i]);
		//}
		JaggedArray ja = new JaggedArray(CreateMatrix.readIntMatrixFromFile());
		System.out.println(ja+"\n\n");
		ja.sortBySumInRow(0);
		System.out.println(ja+"\n\n");
		ja.sortByMaxElementInRow(0);
		System.out.println(ja+"\n\n");
		ja.sortByMinElementInRow(0);
		System.out.println(ja+"\n\n");
	}

}
