package planAFlight;
import java.util.ArrayList;

public class Cities {
	
	
	public static ArrayList<String> getCities(ArrayList<String> dataTokens)
	{
		ArrayList<String> Duplicatecities = new ArrayList<String>();
		
		for(int i = 0; i < dataTokens.size(); i += 4) {   
			Duplicatecities.add(dataTokens.get(i).toString());
	//		System.out.println((dataTokens.get(i)).toString());
		}
		for(int i = 1; i < dataTokens.size(); i += 4) {   
			Duplicatecities.add(dataTokens.get(i).toString());
	//		System.out.println((dataTokens.get(i)).toString());
		}
		
		return Duplicatecities;
	}
	public static ArrayList<String> removeDuplicates(ArrayList<String> list) 
    { 
        // Create a new ArrayList 
        ArrayList<String> newList = new ArrayList<String>(); 
  
        // Traverse through the first list 
        for (int i = 0; i < list.size(); i++) { 
  
            // If this element is not present in newList 
            // then add it 
            if (!newList.contains(list.get(i).toString())) { 
  
                newList.add(list.get(i).toString()); 
            } 
        } 
  
        // return the new list 
        return newList; 
    }
	public static ArrayList<String> getPath(ArrayList<String> dataTokens, String originCity) {
		ArrayList<String> path = new ArrayList<String>();
		
		// get path all adjacent cities to given city
		for (int i = 0; i < dataTokens.size(); i += 4) {
			if (dataTokens.get(i).equals(originCity)) {
				path.add(dataTokens.get(i + 1) + "," + dataTokens.get(i + 2) + "," + dataTokens.get(i + 3));
			}
			if (dataTokens.get(i + 1).equals(originCity)) {
				path.add(dataTokens.get(i) + "," + dataTokens.get(i + 2) + "," + dataTokens.get(i + 3));
			} 
		}
		
		return path;
	}

}



