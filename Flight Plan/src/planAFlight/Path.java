package planAFlight;
import java.util.ArrayList;

public class Path implements Cloneable
{
	String origin;
	private int totalCost;
	private int totalTime;
	
	private ArrayList<String> cityNames;

	public Path()
	{
		cityNames = new ArrayList<String>();
	}


	public Path clone() {
		Path newPath = new Path();
		newPath.totalTime = totalTime;
		newPath.totalCost = totalCost;
		
		for (String name : cityNames) {
			newPath.cityNames.add(name);
		}
		
		return newPath;
	}
	
	
	
	public String toString() 
	{
		String message = "" + cityNames + " Time:" + totalTime + " Cost: " + totalCost;
		return message;
	}
	
	public void addCity(String name, int currentTime, int currentCost) {
		totalTime += currentTime;
		totalCost += currentCost;
		cityNames.add(name);
	}


}


