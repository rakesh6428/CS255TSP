package cs255tsp;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * for greedy algorithm, route[i]= ci records the city in i step and mark as
 * visited, in next step, find the nearest city cj of ci and let route[i+1] = cj
 * 
 * 
 * @author Angela Wang, Rakesh Gururaj
 *
 */

public class TSPGreedy {
	private int numberofCities;
	private City startCity;
	private City[] route; // store the order of visited city
	private Set<Integer> visited;
	private Map<Integer, City> cityInfo;// record all the city's name
	private double[][] distanceMatrix; // record city's distance to each other

	// initialize the distance information
	public TSPGreedy(int numberofCities, double[][] distanceMatrix, Map<Integer, City> cityInfo, City startCity) {
		this.numberofCities = numberofCities;
		this.route = new City[numberofCities + 1];
		this.distanceMatrix = distanceMatrix;
		this.startCity = startCity;
		this.cityInfo = cityInfo;
		this.visited = new HashSet<>();
	}

	/**
	 * 
	 * @return sum of the path
	 */
	public double calRouteGreedy() {
		int startId = startCity.getCityId();
		int i = 0;
		int index = 1; // index of route which record the order of city
		route[0] = startCity;
		visited.add(startId);
		double sum = 0;
		while (i < numberofCities) {
			double[] distance = distanceMatrix[startId];
			double tempMin = Double.MAX_VALUE;
			int tempId = 0;
			// each step find the minimal distance away from the last city
			for (int j = 0; j < numberofCities; j++) {
				// if visited or the same city, then ignore
				if (visited.contains(j) || j == tempId || j == startCity.getCityId()) {
					continue;
				}
				// update minimal distance
				if (tempMin > distance[j]) {
					tempMin = distance[j];
					tempId = j;
				}

			}

			if (tempMin != Double.MAX_VALUE) {
				sum += tempMin;
				startId = tempId;
			}

			// update route in each step
			route[index] = new City(cityInfo.get(tempId).getCityName(), tempId, true);
			visited.add(tempId);
			index++;
			i++;

		}

		sum += distanceMatrix[startId][startCity.getCityId()];

		return sum;
	}

	/**
	 * A function similar to over riding of the toString() function.
	 */
	public String buildRoute() {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= numberofCities; i++) {
			sb.append(route[i].getCityName());
			sb.append(" --> ");
		}

		return sb.substring(0, sb.length() - 5).toString();
	}

}