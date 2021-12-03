/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixmultiplication_clean;
import java.util.Random;
/**
 *
 * @author Franyell
 */
public class Matrix {
    
    int values[][];
   
    Matrix(int size){
        
        values= new int[size][size];
    }
    
    int [][] getValues(){
        return values;
    }
    
    Matrix(int v[][]){
      //load matrix from file 
       values= v;
   }
   
    
   Matrix(String filename){
      //load matrix from file 
      //TODO implement me
   }
   
   void saveMatrixToFile(String filename){
       //TODO implment me
   }
   
   int getElement(int i, int j){
       return values[i][j];
   }
   
   void setElement(int i, int j, int val){
       this.values[i][j]= val;
   }
   
   Matrix  sequentialMul(Matrix b){
       
       int numberOfRows= this.getNumberOfRows();
       int numberOfCols = this.getNumberOfCols();
       Matrix result= new Matrix(numberOfRows);
       
       for(int row=0; row< numberOfRows; row++){
           for( int col=0;col< numberOfCols; col++)
           {
                int val=0;
                for(int i=0;i< numberOfCols;i++){
                    val = val+ this.getElement(i,i)* b.getElement(i, i);
                }
                result.setElement(row, col, val);
           }
       }
       return result;
   }
   
    //Multiply a rows by a col and store the result in the given position
   void doRowsProduct(Matrix b, Matrix result, int fromRow, int toRow){
       
       int numberOfRows= this.getNumberOfRows();
       int numberOfCols = this.getNumberOfCols();
       result= new Matrix(numberOfRows);
       
       for(int row=fromRow; row< toRow; row++){
           for( int col=0;col< numberOfCols; col++)
           {
                int val=0;
                for(int i=0;i< numberOfCols;i++){
                    val = val+ this.getElement(i,i)* b.getElement(i, i);
                }
                result.setElement(row, col, val);
           }
       }
       
        
   }
   
   
   //Multiply a row by a col and store the result in the given position
   void doDotProduct(Matrix b, Matrix result, int row){
       //TODO implement me
       int numberOfRows= this.getNumberOfRows();
       int numberOfCols = this.getNumberOfCols();
       
       
       for(int i=0; i< numberOfRows; i++){
           for( int j=0;j< numberOfCols; j++)
           {
                int val=0;
                val = val+ this.getElement(row,j)* b.getElement(j, row);
                result.setElement(row, j, val);
           }
       }
   }
   
   
   
   
   void sequentialMul(Matrix b, Matrix result){
       
       int numberOfRows= this.getNumberOfRows();
       int numberOfCols = this.getNumberOfCols();
       
       for(int i=0; i< numberOfRows; i++){
           for(int j=0;j< numberOfCols;j++){
               for(int k=0;k<numberOfCols;k++){
                   
               }
           }
       }
      
       
   }
    
    @Override
   public String toString(){
        int numberOfRows= this.getNumberOfRows();
       int numberOfCols = this.getNumberOfCols();
       String r="";
       for(int i=0;i< numberOfRows; i++){
           for(int j=0;j< numberOfCols; j++){
               r=r+" "+this.getElement(i, j);
           }
           r+="\n";
       }
       return r;
   }
   

    private int getNumberOfRows() {
        return this.values.length;
    }

    private int getNumberOfCols() {
        return this.values.length;
    }
   
    
    public static Matrix generateRandomSquareMatrix(int size, int max){
        Matrix r = new Matrix(size);
        Random rand= new Random(1);
       
        for(int i=0;i< size; i++){
            for(int j=0;j< size; j++){
                int val = rand.nextInt(max);
                r.setElement(i, j, val);
            }
        }
        return r;
    }
   
    
    
}
