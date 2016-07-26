package com.rsclabs.util;

import org.junit.Test;

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


    }

}