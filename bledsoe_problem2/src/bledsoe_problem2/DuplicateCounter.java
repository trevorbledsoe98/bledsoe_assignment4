package bledsoe_problem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {
	
	HashMap<String, Integer> wordCounter = new HashMap<>();
	
	public void count(String dataFile) throws FileNotFoundException{
		
		File file = new File(dataFile);
		
		Scanner sc = new Scanner(file);
		while (sc.hasNext()) {
			String word = sc.next();
			if (word != null && !word.isEmpty()) {
				word = word.toLowerCase();
				if(wordCounter.containsKey(word)) {
					wordCounter.put(word, wordCounter.get(word)+1);
					
				}
				
				else {
					wordCounter.put(word, 1);
				}
			}
		}
		
		sc.close();
		System.out.println("Data Written to File");
	}
	
	public void write(String outputFile) throws IOException{
		FileWriter writer = new FileWriter(outputFile);
		
		for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
			writer.write(entry.getKey() + "\t\t\t\t\t" + entry.getValue());
			writer.write("\n");
		}
		
		writer.close();
	}	
}
