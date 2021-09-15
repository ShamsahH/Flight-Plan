package planAFlight;

public class AdjacentNodes 
{
	String cityName;
	int dollarCost;
	int timeCost;
	AdjacentNodes next;
	
	
	public String toString() 
	{
		String message = cityName + ", $" + Integer.toString(dollarCost) + " " + Integer.toString(timeCost);
		
		return message;
	}
	
	public AdjacentNodes (String cityName, int dollarCost, int timeCost, AdjacentNodes next) 
	{
		this.cityName = cityName;
		this.dollarCost = dollarCost;
		this.timeCost = timeCost;
		this.next = next;
	}
}
