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

    public Matrix(int rows,int cols)
    {
        this.numCols = cols;
        this.numRows = rows;
        m = new double[this.numRows][this.numCols];
    }

    public static Matrix Identity(int size)
    {
        Matrix nm = new Matrix(size,size);

        for(int i = 0; i < size; ++i)
        {
            nm.m[i][i]=1.0;
        }

        return nm;
    }

    public static Matrix Values(int numRows,int numCols)
    {
        Matrix nm = new Matrix(numRows,numCols);

        double val = 1;

        for(int y = 0; y < numRows; ++y)
        {
            for( int x = 0; x < numCols; ++x )
            {
                nm.m[y][x] = val;
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
        Matrix nm = new Matrix(1, numCols);

        for( int i = 0; i < numCols; ++i )
        {
            nm.m[0][i] = m[row][i];
        }

        return nm;
    }

    public Matrix col(int col)
    {
        Matrix nm = new Matrix(numRows,1);

        for( int i = 0; i < numRows; ++i )
        {
            nm.m[i][0]=m[i][col];
        }

        return nm;
    }

    public Matrix subMatrix(int sx,int sy, int w, int h)
    {
        Matrix nm = new Matrix(w,h);
        for( int y = 0; y < h; ++y )
        {
            for( int x = 0; x < w; ++x)
            {
                nm.m[y][x] = m[sy+y][sx+x];
            }
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


    @Override
    public String toString()
    {
        String out = "";

        for( int y = 0; y < numRows ; ++y )
        {
            String delim = "";
            for( int x = 0; x < numCols; ++x )
            {
                out += delim + String.format("%2.3f",m[y][x]);
                delim = ", ";
            }
            out += System.lineSeparator();
        }

        return out;
    }

}
