package com.rsclabs.util;

/**
 * Created by rich on 25/07/2016.
 *
 * offers some basic matrix functionality, enough to get us going
 */
public class Matrix
{
    // sort of hoping java turns this into one contiguous array
    private final double m[][];
    private final int numCols;
    private final int numRows;

    public Matrix(int cols,int rows)
    {
        this.numCols = cols;
        this.numRows = rows;
        m = new double[this.numRows][this.numCols];
    }

    public static Matrix Identity(int numCols,int numRows)
    {
        Matrix nm = new Matrix(numCols,numRows);

        for(int i = 0; i < numRows; ++i)
        {
            nm.m[i][i]=1.0;
        }

        return nm;
    }

    public static Matrix Values(int numCols,int numRows)
    {
        Matrix nm = new Matrix(numCols,numRows);

        double val = 1;

        for(int i = 0; i < numRows; ++i)
        {
            for( int j = 0; j < numCols; ++j )
            {
                nm.m[i][j] = val;
                val+=1.0;
            }
        }

        return nm;
    }

    public double get(int row,int col)
    {
        return m[row][col];
    }

    public void set(int row,int col,double value)
    {
        m[row][col] = value;
    }

    public Matrix row(int row)
    {
        Matrix nm = new Matrix(numRows,1);

        for( int i = 0; i < numRows; ++i )
        {
            nm.set(0,i,m[row][i]);
        }

        return nm;
    }

    public Matrix col(int col)
    {
        Matrix nm = new Matrix(1,numCols);

        for( int i = 0; i < numCols; ++i )
        {
            nm.set(i,0,m[i][col]);
        }

        return nm;
    }

    public Matrix transpose()
    {
        Matrix nm = new Matrix(numRows,numCols);

        for( int r = 0; r < numRows; ++r )
        {
            for( int c = 0; c < numCols; ++c)
            {
                nm.m[c][r] = m[r][c];
            }
        }

        return nm;
    }

}
