package com.khveras.matrix.operations

class DeterminantCalculator {
	public static final int[][] matrix = [[6, 3, 5, 7], [2, 8, 6, 2], [1, 9, 4, 2], [8, 1, 7, 5]];
	
	public boolean validateMatrix(int[][] matrix){
		println("Validating matrix...");
		int msize= matrix.size();
		for (int row=0; row<msize; row++){
			if (matrix[row].size()!=msize){
				System.out.println("Matrix is invalid. It is "+matrix[row].size()+" values in row "+(row+1)+", while number of rows is "+msize);
				return false;
			}
		}
		println("Matrix is valid.");
		return true;
	}
	
	public void printMatrix(int[][] matrix){
		matrix.each {
			println(it);
		}
	}
	
	public int[][] calcSubMatrix(int[][] matrix, int column){
		int msize= matrix.size();
		
		if (msize==1){
			throw new RuntimeException("Can't calculate submatrix of matrix, which size is 1");
		}
		if (column<1){
			throw new RuntimeException("Column number must be greater than zero");
		}
		if (column>msize){
			throw new RuntimeException("Can't calculate submatrix of size greater than initial matrix size");
		}
		
		column-=1;
		def result = [][];
		matrix.eachWithIndex() { row, rowNum ->
			if (rowNum>0){
				def newRow = [];
				row.eachWithIndex() { obj, index ->
					if (index!=column){
						newRow[newRow.size()]=obj;
					}
				}
				result[result.size()]=newRow;
			}
		}
		return result;
	}
	
	public int calcDeterminant(int[][] matrix){
		int msize= matrix.size();
		if (msize<1){
			throw new RuntimeException("Matrix should contain at least 1 element");
		}
		if (msize==1){
			return matrix[0][0];
		}
		else{
			int[] firstRow = matrix[0];
			int result=0;
			firstRow.eachWithIndex() { item, j ->
				result+=(-1)**(j+1)*item*calcDeterminant(calcSubMatrix(matrix, j+1));
			}
			return result;
		}
	}
		
	
	public static void main(String[] args) {
		DeterminantCalculator dc = new DeterminantCalculator();
		println("Given matrix:");
		dc.printMatrix(matrix);
		if (!dc.validateMatrix(matrix)) return;
		println("Determinant: "+dc.calcDeterminant(matrix));
	}
}
