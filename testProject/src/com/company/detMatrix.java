package com.company;

public class detMatrix { // нахождение определителя матрицы из первой лабораторной работы, используется и здесь

    public double[][] matrix;
    public int size;

    public detMatrix(int size) {
        this.size = size;
        this.matrix = new double[size][size];
    }

    public double findDet() {
        if (size == 1) {
            return matrix[0][0];
        } else if (size == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            float result = 0;
            detMatrix minor = new detMatrix(size - 1);
            for (int i = 0; i < size; i++) {
                for (int j = 1; j < size; j++) {
                    System.arraycopy(matrix[j], 0, minor.matrix[j - 1], 0, i);
                    System.arraycopy(matrix[j], i + 1, minor.matrix[j - 1], i, size - (i + 1));
                }
                result += Math.pow(-1, i) * matrix[0][i] * minor.findDet();
            }
            //System.arraycopy(1, 2, 3, 5, 6);
            return result;
        }
    }
    public static double findDet(double[][] matrix, int size) { // из первой лабораторной
        if (size == 1) {
            return matrix[0][0];
        } else if (size == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            float result = 0;
            detMatrix minor = new detMatrix(size - 1);
            for (int i = 0; i < size; i++) {
                for (int j = 1; j < size; j++) {
                    System.arraycopy(matrix[j], 0, minor.matrix[j - 1], 0, i);
                    System.arraycopy(matrix[j], i + 1, minor.matrix[j - 1], i, size - (i + 1));
                }
                result += Math.pow(-1, i) * matrix[0][i] * minor.findDet();
            }
            //System.arraycopy(1, 2, 3, 5, 6);
            return result;
        }
    }
}
