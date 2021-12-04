/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixmultiplication_clean;

/**
 *
 * @author Usuario
 */
public class threadMultipliers extends Thread{
    
    private int FromRow;
    private int ToRow;
    Matrix matrixA;
    Matrix matrixB;
    Matrix result;
    int mynum;
    
    public threadMultipliers(int FromRow, int ToRow, int mynum) {
       this.FromRow = FromRow;
       this.ToRow = ToRow;
       this.mynum = mynum;
       
    }
    
    public void setMatrixA(Matrix A){
        this.matrixA = A;
    }
    
    public void setMatrixB(Matrix B){
        this.matrixB = B;
    }
    

    @Override
    public void run() {
        this.result = new Matrix(matrixA.getValues().length);
        this.matrixA.doRowsProduct(matrixB, result, FromRow, ToRow);
    }
    
}
