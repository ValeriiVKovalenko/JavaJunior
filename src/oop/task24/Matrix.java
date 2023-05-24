package oop.task24;

public class Matrix {

    private double[][] array;
    private int row;
    private int column;

    public Matrix(int row, int column) {
        array = new double[row][column];
    }

    public void sumMatrix(double[][] anotherArray) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] += anotherArray[i][j];
            }
        }
    }

    public void multiplicationOnNumber(int number) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] *= number;
            }
        }
    }

    public void printMatrix() {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    public void multiplicationMatrix(double[][] anotherMatrix) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] *= anotherMatrix[i][j];
            }
        }
    }
}
