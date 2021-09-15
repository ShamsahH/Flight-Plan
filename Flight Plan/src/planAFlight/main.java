package planAFlight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {
	public static void main(String[] args) throws IOException 
	{

		String flightData, requestedFlightPlans;
		Scanner input = new Scanner(System.in);

		FileWriter myWriter = new FileWriter("output.txt");

		// get flightData.txt
		System.out.print("Insert name of Flight Data File: ");
		flightData = input.nextLine();
		
		System.out.println("received " + flightData);

		// get flightPaths.txt
		System.out.print("Insert name of Requested Flight File: ");
		requestedFlightPlans = input.nextLine();
		
		System.out.println("received " + requestedFlightPlans);

		// read file ---------------------------------------------------------------
		BufferedReader readData = new BufferedReader(new FileReader(flightData));
		String line;
		int numData = Character.getNumericValue(readData.read());
		readData.readLine();
		AdjacencyList obj = new AdjacencyList();

		// store data in array
		while ((line = readData.readLine()) != null) {
			String[] result = line.split("\\|");

			//System.out.println("---------------------");

			int dc = Integer.parseInt(result[2]);
			int tc = Integer.parseInt(result[3]);

			obj.insert(result[0], result[1], dc, tc);
			obj.insert(result[1], result[0], dc, tc);
		}
		readData.close();

		BufferedReader readRequest = new BufferedReader(new FileReader(requestedFlightPlans));
		String line2;
		int numRequests = Character.getNumericValue(readRequest.read());
		readRequest.readLine();

		// store data in array
		while ((line2 = readRequest.readLine()) != null) {
			String[] result = line2.split("\\|");


			myWriter.write("\n" + result[0] + " to: ");
			System.out.println("\n" + result[0] + " to: ");
			obj.printAllPaths(result[0], result[1], result[2]);

//			System.out.print("---------------------");

		}
		readRequest.close();
		input.close();
		myWriter.close();
		

	}


}
