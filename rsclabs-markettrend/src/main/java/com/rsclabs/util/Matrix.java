package com.rsclabs.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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

    public Matrix(double [][]m)
    {
        this.m = m;
        this.numCols = m[0].length;
        this.numRows = m.length;
    }

    public int getNumCols()
    {
        return numCols;
    }

    public int getNumRows()
    {
        return numRows;
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

    public Matrix multiply(Matrix right)
    {
        if( getNumCols() != right.getNumRows() )
        {
            throw new RuntimeException("Matrix is the wrong shape");
        }

        int aColCount = getNumCols();
        int aRowCount = getNumRows();
        int bColCount = right.getNumCols();

        Matrix nm = new Matrix(aRowCount,bColCount);

        for( int i = 0 ; i < aRowCount; ++i )
        {
            for( int j = 0; j < bColCount; ++j )
            {
                for( int k = 0; k < aColCount; ++k )
                {
                    nm.m[i][j] += m[i][k] * right.m[k][j];
                }
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

    public static Matrix load(String fileName) throws IOException
    {

        BufferedReader br = new BufferedReader(new FileReader(fileName));

        List<String> mlist = new ArrayList();

        String line;
        while ((line = br.readLine()) != null)
        {
            mlist.add(line);
        }

        int numRows = mlist.size();
        int numCols = mlist.get(0).split(",").length;

        double data[][] = new double[numRows][numCols];

        for( int i = 0; i < mlist.size(); ++i )
        {
            String colData[] = mlist.get(i).split(",");
            for( int j = 0; j < colData.length; ++j )
            {
                data[i][j] = Double.parseDouble(colData[j]);
            }
        }

        return new Matrix(data);
    }

}
