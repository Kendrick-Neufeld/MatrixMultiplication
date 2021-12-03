/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixmultiplication_clean;

import java.io.*;

/**
 *
 * @author Franyell
 */
public class MatrixUtils {
    
    public static void loadFileInto2DArray(String filename, int src[][]) throws FileNotFoundException, IOException{
        
        FileInputStream file = new FileInputStream(filename);
        DataInputStream data = new DataInputStream(file);
      
       for(int i=0;i<src.length;i++){
           for(int  j =0; j< src[i].length; j++){
               int v=  data.readInt();
               src[i][j]=v;
           }
       }
       file.close();
    }    
    public static void saveFileFrom2DArray(String filename,  int dst[][]) throws FileNotFoundException, IOException{
        
       FileOutputStream file = new FileOutputStream(filename);
       DataOutputStream data = new DataOutputStream(file);
      
       for(int i=0;i<dst.length;i++){
           for(int  j =0; j< dst[i].length; j++){
               int v= dst[i][j];
               data.writeInt(v);
           }
       }
       file.close();
    }
}
