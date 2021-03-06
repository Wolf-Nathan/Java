package filesreader;

import java.util.ArrayList;

public abstract class FilesReaderAbstract {
	
	abstract void lire();
	abstract void initializeContenu();
	abstract void lireSensInverse();
	abstract void lecturePalyndromique();
	abstract void diff(FileReader autreFichier);
	abstract ArrayList<String> getContenu();

}
