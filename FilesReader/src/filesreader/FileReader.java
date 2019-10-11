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
public class FileReader {
    private String fileName;
    
    public FileReader(String name){
        this.fileName = name;
    }
    
    public FileReader(){
        this.fileName = "";
    }
    
    public String getFileName(){
        return this.fileName;
    }

    public void setFileName(String name){
        this.fileName = name;
    }
    
    
    
}
