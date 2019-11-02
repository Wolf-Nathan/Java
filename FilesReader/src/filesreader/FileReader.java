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
    	System.out.println("Lecture palyndromique");
    	for(int i = this.contenu.size()-1; i>=0; i-- ) {
    		for(int j = this.contenu.get(i).length()-1; j>=0; j--) {
    			//On récupère le contenu du fichier mais en caractère par caractère plûtot que ligne par ligne et en sens inverse
    			System.out.print(Character.toString(this.contenu.get(i).charAt(j)));
    		}
    		//Pour séparer les lignes du fichier
    		System.out.println();
    	}
    }
    
    public void diff(FileReader autreFichier) {
    	System.out.println("Comparaison des fichiers");
    	if(this.contenu.equals(autreFichier.getContenu())) {
    		System.out.println("Les fichiers sont identiques !");
    	}
    	else {
    		System.out.println("Les fichiers ne sont pas identiques :/");
    		if(this.contenu.size()<autreFichier.getContenu().size()) {
    			for(int i=0; i<this.contenu.size(); i++) {
    				if(!this.contenu.get(i).equals(autreFichier.getContenu().get(i))){
    					System.out.println("Les fichiers sont différents à la ligne "+ i);
    				}
    			}
    		}
    		else {
    			for(int i=0; i<autreFichier.getContenu().size(); i++) {
    				if(!this.contenu.get(i).equals(autreFichier.getContenu().get(i))){
    					int ligne = i+1;
    					System.out.println("Les fichiers sont différents à la ligne "+ ligne);
    				}
    			}
    		}
    	}
    	
    }
    
    public ArrayList<String> getContenu() {
    	return this.contenu;
    }
	
}
