package com.rsclabs.util;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by rich on 25/07/2016.
 */
public class MatrixTest
{
    @Test
    public void testIdentity()
    {
        Matrix m = Matrix.Values(3,2);

        System.out.print(m);

        Matrix nm = m.row(1);

        System.out.print(nm);
        Matrix nc = m.col(0);
        System.out.print(nc);

        Matrix sub = m.subMatrix(0,1,2,2);
        System.out.print(sub);

        Matrix tr = m.transpose();



        Matrix or = tr.transpose();

        double data1[][] = {{1,2,3},{4,5,6}};
        Matrix a = new Matrix(data1);

        double data2[][] = {{1,2,3},{9,8,7}};
        Matrix b = new Matrix(data1);

        Matrix c = a.multiply(b);


    }

    @Test
    public void testMultiply()
    {
        double data1[][] = {{1,2,3},{4,5,6}};
        Matrix a = new Matrix(data1);

        double data2[][] = {{9},{8},{7}};
        Matrix b = new Matrix(data2);

        Matrix c = a.multiply(b);

    }


    @Test
    public void testLoad() throws IOException
    {
        Matrix a = Matrix.load("ex1data1.txt");



    }

}