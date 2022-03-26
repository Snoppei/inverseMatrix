package com.company;

import com.company.ru.vsu.cs.util.ArrayUtils;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        double[][] Matrix;
        //Matrix = ArrayUtils.readDoubleArray2FromConsole();
        Matrix = ArrayUtils.readDoubleArray2FromFile("C:\\Users\\Pavel\\IdeaProjects\\testProject\\src\\com\\company\\input.txt");
        double[][] checkMatrix = Matrix;
        // берем исходную матрицу из файла ввода
        double[][] AlgDop = new double[Matrix.length][Matrix.length]; // массив для зранения алг. доп.
        double[][] inversedMatrix = inverseMatrix.inverseMatrix(Matrix); // находим обратную матрицу

        for(int i = 0; i < AlgDop.length; i++){ // Вывод обратной матрицы в консоль
            for(int j = 0; j < AlgDop[0].length; j++){
                System.out.print(inversedMatrix[i][j] + ", ");
            }
            System.out.println();
        }

        System.out.println("Проверка: ");
        double[][] res = new double[checkMatrix.length][checkMatrix.length];
        for (int i = 0; i < checkMatrix.length; i++) {
            for (int j = 0; j < inversedMatrix[0].length; j++) {
                for (int k = 0; k < inversedMatrix.length; k++) {
                    res[i][j] += checkMatrix[i][k] * inversedMatrix[k][j];
                }
            }
        }
        for(int i = 0; i < AlgDop.length; i++){ // Вывод проверки матрицы в консоль
            for(int j = 0; j < AlgDop[0].length; j++){
                System.out.print(res[i][j] + ", ");
            }
            System.out.println();
        }


        ArrayUtils.writeArrayToFile("C:\\Users\\Pavel\\IdeaProjects\\testProject\\src\\com\\company\\output.txt", inversedMatrix);
        // записываем обратную матрицу в файл вывода
    }
}
