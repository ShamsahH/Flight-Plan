package planAFlight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ReadFile 
{
	
	public void readData(String fileName, ArrayList<String> dataTokens, AtomicInteger numData) throws IOException {
		
		// read file
		String line;

		BufferedReader readData = new BufferedReader(new FileReader(fileName));
		
		numData.set(Character.getNumericValue(readData.read()));
		
		// store data in Arraylist
		while ((line = readData.readLine()) != null) {		
			
			String[] result;
			
			result = line.split("\\|");
			
		}		
			
		readData.close();
	}

}
