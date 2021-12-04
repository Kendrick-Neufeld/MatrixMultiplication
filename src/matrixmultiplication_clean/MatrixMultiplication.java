/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixmultiplication_clean;

/**
 *
 * @author Franyell
 */
public class MatrixMultiplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         int temp[][]= {{1,2},{1,2}};
         
         int N= 1024;
         int threads= 8;
                  
          long start = System.nanoTime();
         
           implementThreadedMultTest(N,threads );
           long end = System.nanoTime();
        System.out.println("ParALLEL Execution time: "+ (end -start)*10e-9);
        
        
       Matrix matrixA= Matrix.generateRandomSquareMatrix(N, 2);
       Matrix matrixB= Matrix.generateRandomSquareMatrix(N, 2);
       
        start = System.nanoTime();
        Matrix r = matrixA.sequentialMul(matrixB);
        end = System.nanoTime();
        System.out.println("Execution time Sequential: "+ (end -start)*10e-9);
        
   
        
        
    }
    
    public static void implementThreadedMultTest(int N, int threads ){
        
       Matrix matrixA= Matrix.generateRandomSquareMatrix(N, 2);
       Matrix matrixB= Matrix.generateRandomSquareMatrix(N, 2);
        
        threadMultipliers[] threadM = new threadMultipliers[threads];
        int From=0;
        int To = N/threads;
        
        for(int i=0; i < threads; i++){
            threadM[i] = new threadMultipliers(From, To);
            threadM[i].setMatrixA(matrixA);
            threadM[i].setMatrixB(matrixB);
            From = To;
            To = To+To;
            if(To > N){
              To = N;
            }
            threadM[i].run();
        }
        
            //System.out.println(result);
            
      
        
    }
    
    
    
}
