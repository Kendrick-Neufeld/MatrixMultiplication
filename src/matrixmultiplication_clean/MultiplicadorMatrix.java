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
public class MultiplicadorMatrix {
    
    Matrix matrizA;
    Matrix matrizB;
    Matrix resultado;
    String fileguardado;
    int threads;
    int N;
    double Normaltime;
    double Paralelltime;
    
    MultiplicadorMatrix(String matrixA,String matrixB,String fileguardado){
        this.matrizA = new Matrix(matrixA);
        this.matrizB = new Matrix(matrixB);
        this.threads = 0;
        this.N = this.matrizA.values.length;
        this.Normaltime =0;
        this.Paralelltime =0;
        this.fileguardado = fileguardado;
    }
    
    public double getNormaltime(){
        return this.Normaltime;
    }
    
    public double getParalelltime(){
        return this.Paralelltime;
    }
    
    public void setThreads(int threads){
        this.threads = threads;
    }
    
    public void MultiplyMatrices(){
         long start = System.nanoTime();
         
           implementThreadedMultTest(N,threads,matrizA,matrizB );
           long end = System.nanoTime();
         this.Paralelltime = ((end -start)*10e-9);
           
         
        start = System.nanoTime();
        this.resultado = matrizA.sequentialMul(matrizB);
        end = System.nanoTime();
        this.Normaltime = ((end -start)*10e-9);
         
        this.resultado.saveMatrixToFile(this.fileguardado);
        
    }
    
    public void implementThreadedMultTest(int N, int threads,Matrix matrixA, Matrix matrixB ){
        
        threadMultipliers[] threadM = new threadMultipliers[threads];
        int From=0;
        int To = N/threads;
        
        for(int i=0; i < threads; i++){
            threadM[i] = new threadMultipliers(From, To,i);
            threadM[i].setMatrixA(matrixA);
            threadM[i].setMatrixB(matrixB);
            From = To+1;
            To = To+To+1;
            if(To > N){
              To = N;
            }
            threadM[i].setresult(this.resultado);
            threadM[i].start();
        }
        
        try{
            for(int i=0;i<threads;i++){
            threadM[i].join();
            }
            
        }catch(InterruptedException e){
            System.out.println(e);
        }
            //System.out.println(result);  
      
        
    }
     
    
}
