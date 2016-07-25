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

//        Matrix nm = m.row(1);
//        Matrix nc = m.col(0);

        Matrix tr = m.transpose();

        Matrix or = tr.transpose();


    }

}