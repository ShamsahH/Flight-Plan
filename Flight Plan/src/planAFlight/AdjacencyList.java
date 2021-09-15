package planAFlight;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class AdjacencyList {
	
		private PriorityQueue<Node> queue;
		private LeadNode root;
		private int cityCounter = 0;
		private ArrayList <Path> paths;
		

		// take string (city), return kingNode that has city as origin

		private LeadNode cityToLead(String city) 
		{
			LeadNode Lead = root;

			while (!Lead.origin.equals(city)) 
			{
				Lead = Lead.nextKingNode;
			}

			return Lead;
		}

		public void printAllPaths(String origin, String destination, String priority) {

			HashSet<String> visited = new HashSet<String>(); // visited
			ArrayList<Path> paths = new ArrayList<Path>();
					
			// call recursive method to find all paths
			findPath(origin, destination, visited, new Path());
		}

		public void findPath(String origin, String destination, HashSet<String> visited, Path finalPath) {

			LeadNode current = cityToLead(origin); // current node

			if (current.origin.equals(destination)) // full path found
			{
				System.out.println(finalPath);
				return;
			}

			// put children in stack, check if already visited
			if (!visited.contains(current.origin)) // if have not visited current node
			{
				Node traverseChildren = current.flightPaths;
				HashSet<String> clonedSet = setClone(visited);
				clonedSet.add(current.origin);
				
				while (traverseChildren != null) { // add all kids to visited
					Path newPath = finalPath.clone();
					newPath.addCity(traverseChildren.cityName, traverseChildren.timeCost, traverseChildren.dollarCost);
					
					findPath(traverseChildren.cityName, destination, clonedSet, newPath);

					traverseChildren = traverseChildren.next;
				}
			}
		}

		

		private HashSet<String> setClone(HashSet<String> set) 
		{
			HashSet<String> newSet = new HashSet<String>();
			for (String value : set) {
				newSet.add(value);
			}

			return newSet;
		}
		
		public void insert(String king, String CN, int DC, int TC) 
		{
			LeadNode last = root;
			while (last != null && !last.origin.equals(king)) {
				last = last.nextKingNode;
			}

			if (last == null) {
				LeadNode node = new LeadNode(king);
				node.index = cityCounter++;

				node.nextKingNode = root;
				root = node;
				last = node; // reset last to the top
			}

			Node newNode = new Node(CN, DC, TC);
			newNode.next = last.flightPaths;
			last.flightPaths = newNode;
		}
		
		
		class Node 
			{
				String cityName;
				
				int timeCost;
				int dollarCost;
		
				Node next;

				// Constructor
				Node(String CN, int DC, int TC) 
				{
					cityName = CN;
					dollarCost = DC;
					timeCost = TC;
					next = null;
				}
			}

		class LeadNode 
		{
			String origin; // cityName
			Node flightPaths;
			LeadNode nextKingNode;

			int index;

			public LeadNode(String cityName) 
			{
				origin = cityName;
			}

		}

		 
		
		
	}

	

	
