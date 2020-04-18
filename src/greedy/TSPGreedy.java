package greedy;
import java.util.*;
/**
 * for greedy algorithm, route[i]= ci records the city in i step and mark as visited, 
 * in next step, find the nearest city cj of ci and let route[i+1] = cj 
 * 
 * 
 * @author Angela Wang, Rakesh Gururaj
 *
 */

public class TSPGreedy {
	private int numberofCities;
	private City startCity;
	private City[] route; //store the order of visited city
	private Set<Integer> visited;
	private List<String> citiesSelectedUI = new ArrayList<String>();
	private double[][] distanceMatrix;
	
	//initialize the distance information
	public TSPGreedy(int numberofCities,City startCity, double[][] distanceMatrix) {
		this.numberofCities = numberofCities;
		this.route  = new City[numberofCities];
		this.distanceMatrix = distanceMatrix;
		this.startCity = startCity;
		this.visited = new HashSet<>();
	}
	
	/**
	 * 
	 * @return sum of the path
	 */
	public double buildRoute() {
		int startId = startCity.getCityId();
		int i=0;
		route[0] = startCity;
		visited.add(startId);
		double sum = 0;
		
		while(i<numberofCities) {
			double[] distance = distanceMatrix[startId];
			double tempMin = Double.MAX_VALUE;
			int tempId = 0;
			for(int j=0;j<numberofCities;j++) {
				if(visited.contains(j)) {
					continue;
				}
				
				if(tempMin>distance[j]) {
					tempMin = distance[j];
					tempId = j;
				}
			}
			sum += tempMin;
			route[i] = new City(citiesSelectedUI.get(tempId),tempId,true);
			visited.add(tempId);
			i++;
		}
		
		return sum;
	}
	
	
}
