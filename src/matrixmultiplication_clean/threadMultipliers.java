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
public class threadMultipliers implements Runnable{
    
    private int FromRow;
    private int ToRow;
    Matrix matrixA;
    Matrix matrixB;
    Matrix result;
    
    
    public threadMultipliers(int FromRow, int ToRow) {
       this.FromRow = FromRow;
       this.ToRow = ToRow;
    }

    @Override
    public void run() {
        
    }
    
}
