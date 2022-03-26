package com.company;

import com.company.ru.vsu.cs.util.ArrayUtils;

public class inverseMatrix {
    public static void FindAlgDop(double[][] srcMatrix, int size, double[][] refactoredMatrix) { // находим матрицу алгебраических дополнений
                                                         // исходная - srcMatrix, записываем в refactoredMatrix
        // находим определитель матрицы srcMatrix
        double det = detMatrix.findDet(srcMatrix, srcMatrix.length);

        if(det > 0) // знак алгебраического дополнения
            det = -1;
        else
            det = 1;

        double[][] minor = new double[srcMatrix.length-1][srcMatrix.length-1];

        for(int j = 0; j < size; j++) {
            for(int i = 0;i < size; i++) {
                // записываем алгебраическое дополнение в матрицу refactoredMatrix
                GetMinor(srcMatrix, minor, j, i, size);
                if( (i+j)%2 == 0)
                    refactoredMatrix[j][i] = det*detMatrix.findDet(minor, size-1);
                else
                    refactoredMatrix[j][i] = -det*detMatrix.findDet(minor, size-1);
            }
        }
    }
    public static int GetMinor(double[][] srcMatrix, double[][] refMatrix, int x, int y, int size) { // получаем минор
        int xCount = 0, yCount = 0;
        int i, j;
        for(i = 0; i < size; i++ ) {
            if( i != x ) {
                yCount = 0;
                for(j = 0; j < size; j++) {
                    if( j != y ) {
                        refMatrix[xCount][yCount] = srcMatrix[i][j];
                        yCount++;
                    }
                }
                xCount++;
            }
        }
        return 0;
    }
    public static void transposition(double[][] Matrix){ // транспонирование матрицы
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = i+1; j < Matrix.length; j++) {
                double temp = Matrix[i][j];
                Matrix[i][j] = Matrix[j][i];
                Matrix[j][i] = temp;
            }
        }
    }
    public static double[][] inverseMatrix(double[][] Matrix){ // объединяем все действия с матрицей в один метод
        double detMatrix = com.company.detMatrix.findDet(Matrix, Matrix.length);
        if(detMatrix==0){ // проверка на существование обратной матрицы
            System.out.println("Обратной матрицы не существует.");
        }
        else{
        double[][] AlgDop = new double[Matrix.length][Matrix.length];
        inverseMatrix.FindAlgDop(Matrix, Matrix.length, AlgDop); // из исходной матрицы делаем марицу алг. дополнений
        inverseMatrix.transposition(AlgDop); // транспонируем матрицу алг. дополнений
            double[][] inverseMatrix = new double[Matrix.length][Matrix.length];
            for (int i = 0; i < Matrix.length; i++){
                for(int j = 0; j < Matrix.length; j++){
                    AlgDop[i][j] = AlgDop[i][j] * (1.0/detMatrix);
                }
            }
            return AlgDop;
        }
        return null;
    }
}
