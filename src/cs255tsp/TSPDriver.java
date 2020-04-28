package cs255tsp;

import java.io.IOException;
import java.util.*;


/**
 * @author Angela Wang, Rakesh Gururaj
 *
 */
public class TSPDriver {
	
	/**
	 * @param args
	 * @throws IOException
	 * Main Function call
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		TSPHelper tspHelper = new TSPHelper();
		ReadCities readCities = new ReadCities();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the path for Cities List: ");
		TSPHelper.citiesFilePathBF = scanner.nextLine();
		System.out.println("Enter the path for Distance Matrix: ");
		TSPHelper.distanceFilePathBF = scanner.nextLine();
		
		List<City> citiesList = readCities.insertCities(TSPHelper.citiesFilePathBF); //Reads the cities file from the predefined path for Brute Force (11 Cities).
		ReadCityInfo readCityInfo = new ReadCityInfo(TSPHelper.citiesFilePath);//Reads the cities file from the predefined path.
		City startCity = new City("Aachen", 0,false);
		int numberofCities = readCityInfo.getNumberofCities();
		Map<Integer,City> cityInfo = readCityInfo.getCityInfo();
		ReadDistanceMatrix readDistance = new ReadDistanceMatrix();
		double[][] distanceMatrix = readDistance.insertDistances(TSPHelper.distanceFilePath); //Reads the distance matrix from the predefined path.
		double[][] distanceMatrixBF = readDistance.insertDistances(TSPHelper.distanceFilePathBF);//Reads the distance matrix from the predefined path for Brute Force (11 Cities).
		
		
		String approach = "Enter the approach to solve Traveling Salesman Problem:\n"+
							"1. Brute Force Approach\n"+
							"2. Greedy Approach\n"+
							"3. Dynamic Programming Approach\n";
		System.out.println(approach);
		int choice = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Starting City for the travel");
		String startingCity = scanner.nextLine();
		
		scanner.close();
		
		/*
		Choice = 1
		When the selection is 1, for finding the shortest route, we chose the brute force approach.
		By this approach we can affirm that the solution we get is the shortest path of all the unique routes.
		The time complexity of this algorithm is huge.
		The number of unique routes a salesman can travel starting from a city is (n-1)! where n is the total number of cities to travel.
		The running time of this approach is O(n!)
		By choosing this approach the solution will become impractical even with cities count = 12. (11! = 39916800 unique routes)
		
		Choice = 2
		When the selection is 2, for finding the shortest route, we chose the Greedy Approach.
		However, by this approach we cannot assure the solution is the shortest of all the routes.
		The time complexity of this algorithm is 
		The execution time of this approach is minimal when compared to the brute force approach but we will have to compromise the shortest route since greedy does not yield the shortest route.
		
		Choice = 3
		When the selection is 3, for finding the shortest route, we chose the Dynamic Programming approach.
		This approach affirms that the solution we get is the shortest path to travel for the given cities.
		The time complexity of this approach is O(nˆ2*2ˆn)
		However, this approach is better than the Brute force approach.
		This approach will also become impractical when the number of cities to travel grows.
		
		*/
		switch (choice) {
		case 1:
			long startTime = TSPHelper.time;
			
			int cityID = tspHelper.getStartCityID(startingCity, citiesList);
			citiesList.remove(new City(startingCity));			
			new TSPBruteForce(citiesList.size(),new City(startingCity,cityID,true),citiesList,distanceMatrixBF);
			long endTime = System.currentTimeMillis()-startTime;
			
			System.out.println("\nTotal time taken for finding shortest route for "+citiesList.size()+" cities is: "+endTime/1000 +" seconds" );
			System.out.println("\nTotal Memory taken for finding shortest route for "+((double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024) + " KB");
			break;
		case 2:
			startTime = TSPHelper.time;
			TSPGreedy tspGreedy = new TSPGreedy(numberofCities,distanceMatrix,cityInfo,startCity);
			double minimumGreedy = tspGreedy.calRouteGreedy();
			String routeGreedy = tspGreedy.buildRoute();
			System.out.println("The Shortest Distance in Greedy approach for "+citiesList.size()+" cities is: " +minimumGreedy);
			System.out.println("The Shortest Distance in Greedy approach for "+citiesList.size()+" cities is: "+routeGreedy);
			endTime = System.currentTimeMillis()-startTime;
			System.out.println("\nTotal time taken for finding shortest route for "+citiesList.size()+" cities is: "+endTime/1000 +" seconds" );
			System.out.println("\nTotal Memory taken for finding shortest route for "+((double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024) + " KB");
			break;
		case 3:
			startTime = TSPHelper.time;
			TSPDP tspDp = new TSPDP(numberofCities,distanceMatrix,cityInfo,startCity);
			double minimumDP = tspDp.calRouteDp();
			String routeDP = tspDp.buildRoute();
			System.out.println("The Shortest Distance in Dynamic Programming approach for "+citiesList.size()+" cities is: " + minimumDP);
			System.out.println("The Shortest Distance in Dynamic Programming approach for "+citiesList.size()+" cities is: "+ routeDP);
			endTime = System.currentTimeMillis()-startTime;
			System.out.println("\nTotal time taken for finding shortest route for "+citiesList.size()+" cities is: "+endTime/1000 +" seconds" );
			System.out.println("\nTotal Memory taken for finding shortest route for "+((double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024) + " KB");
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		
	}

}
