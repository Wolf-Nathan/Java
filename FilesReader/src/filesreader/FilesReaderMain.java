/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesreader;

/**
 *
 * @author licence
 */
public class FilesReaderMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    	
    	FileReader file = new FileReader("C:/Users/natha/Desktop/test.txt");
    	file.lire();
    	file.lireSensInverse();
    	file.lecturePalyndromique();
    }
    
}
