/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class FileReader extends FilesReaderAbstract implements FilesReaderInterface {
    private File file;
    private ArrayList<String> contenu;
    
    public FileReader(String nomFichier) {
    	this.file = new File(nomFichier);
    	this.contenu = new ArrayList<String>();
    	
    }
    
    public void lire() {
    	try {
    		InputStream a = new FileInputStream(this.file);
    		InputStreamReader lecture = new InputStreamReader(a);
    		BufferedReader buff = new BufferedReader(lecture);
    		String ligne;
    		while((ligne=buff.readLine())!=null) {
    			this.contenu.add(ligne);
    		}
    		buff.close();
    		System.out.println("Contenu du fichier :");
    		for(int i=0; i<this.contenu.size(); i++) {
    			System.out.println(this.contenu.get(i));
    		}
    	}
    	catch(Exception e) {
    		System.out.println(e.toString());
    	}
    }
	
	/*private String fileName;
    
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
    }*/
    
    
    
}
