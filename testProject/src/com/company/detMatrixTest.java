package com.company;

import com.company.ru.vsu.cs.util.ArrayUtils;

import static org.junit.jupiter.api.Assertions.*;

class detMatrixTest { // попытка в юнит тесты

    @org.junit.jupiter.api.Test
    void findDetTest() {
        double[][] arr = ArrayUtils.readDoubleArray2FromFile("C:\\Users\\Pavel\\IdeaProjects\\testProject\\src\\com\\company\\inputTest.txt");
        assertEquals(-16, detMatrix.findDet(arr, arr.length));
    }
    @org.junit.jupiter.api.Test
    void findDetFromClassTest() {
        detMatrix newClass = new detMatrix(3);
        newClass.matrix = ArrayUtils.readDoubleArray2FromFile("C:\\Users\\Pavel\\IdeaProjects\\testProject\\src\\com\\company\\inputTest.txt");
        // лень геттеры сеттеры писать, потом переделать
        assertEquals(-16, newClass.findDet());
    }
}