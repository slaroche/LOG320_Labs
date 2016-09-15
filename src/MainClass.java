import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import algo.AnagramAlgo;
import algo.MarcAlgo;
import algo.MaxAlgo;
import algo.PdfAlgo;
import algo.SamCAlgo;
import algo.SamCAlgo2;
import algo.SamCAlgo3;

public class MainClass {

	/**
	 * Main.
	 * @param args
	 */
	public static void main(String[] args) {
		//ArrayList<String> wordsList = getListFile(args[0]);
		//ArrayList<String> dictList = getListFile(args[1]);
		String dictPath = "src/input/dict.txt";
		String WordsPath = "src/input/words.txt";
		
		AnagramAlgo algoPDF = new PdfAlgo(false);
		AnagramAlgo algoMarc = new MarcAlgo(false);
		AnagramAlgo algoSamC = new SamCAlgo(false);
		AnagramAlgo algoMax = new MaxAlgo(false);
		AnagramAlgo algoSamC2 = new SamCAlgo2(false);
		AnagramAlgo algoSamC3 = new SamCAlgo3(false);
		
		//algoMarc.start(dictPath,WordsPath);
		//System.out.println("^^ = Marc Algo");
		//algoPDF.start(dictPath,WordsPath);
		//System.out.println("^^ = PDF Algo");
		//algoSamC.start(dictPath,WordsPath);
		//System.out.println("^^ = SamC Algo");
		//algoSamC2.start(dictPath,WordsPath);
		//System.out.println("^^ = SamC Algo 2");
		algoSamC3.start(dictPath,WordsPath);
		algoMax.start(dictPath,WordsPath);
		System.out.println("^^ = Max Algo");
		System.out.println("^^ = SamC Algo 3");
	}
	
	/**
	 * Recuperer le ficher par son nom et le lire.
	 * @param filePath : le nom du ficher a lire
	 * @return la liste des mots du fichier
	 */
	@SuppressWarnings("resource")
	private static ArrayList<String> getListFile(String filePath)
	{
		Scanner textInFile;
		ArrayList<String> list= new ArrayList<String>();
		
		try {
			textInFile = new Scanner(new File(filePath)).useDelimiter(",\\s*");
			while (textInFile.hasNextLine()) {
				list.add(textInFile.nextLine());
			    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
