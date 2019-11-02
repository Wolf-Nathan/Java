/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesreader;

import java.util.ArrayList;

/**
 *
 * @author licence
 */
public interface FilesReaderInterface {
    public void lire();
    public void initializeContenu();
    public void lireSensInverse();
    public void lecturePalyndromique();
    public void diff(FileReader autreFichier);
    public ArrayList<String> getContenu();
    
    
}
