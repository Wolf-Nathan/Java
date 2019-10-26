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
    	this.initializeContenu();
    	
    }
    
    //Fonction qui récupère le contenu du fichier et instancie un ArrayList contenant chaque ligne
    public void initializeContenu() {
    	try {
    		InputStream a = new FileInputStream(this.file);
    		InputStreamReader lecture = new InputStreamReader(a);
    		BufferedReader buff = new BufferedReader(lecture);
    		String ligne;
    		while((ligne=buff.readLine())!=null) {
    			this.contenu.add(ligne);
    		}
    		buff.close();
    	}
    	catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    public void lire() {
    	int i = 0;
    	System.out.println("Contenu du fichier");
    	while(i<this.contenu.size()) {
    		System.out.println(this.contenu.get(i));
    		i++;
    	}
    }
    
    public void lireSensInverse() {
    	int i = this.contenu.size()-1;
    	System.out.println("Contenu du fichier à l'envers");
    	while(i>=0) {
    		System.out.println(this.contenu.get(i));
    		i--;
    	}
    }
    
    public void lecturePalyndromique() {
    	ArrayList<String> reverse = new ArrayList<String>();
    }
	
}
