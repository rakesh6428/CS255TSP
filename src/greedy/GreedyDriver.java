package greedy;

import java.util.Map;

public class GreedyDriver {
	
	public static void main(String[] args) {
		ReadCityInfo readCityInfo = new ReadCityInfo("/Users/waq/Desktop/cs255-final/CS255TSP/src/DP/Germany_Cities.txt");
		ReadCityMatrix readCityMatrix = new ReadCityMatrix("/Users/waq/Desktop/cs255-final/CS255TSP/src/DP/DistanceMatrix.txt");
		int numberofCities = readCityInfo.getNumberofCities();
		Map<Integer,City> cityInfo = readCityInfo.getCityInfo();
		double[][] distanceMatrix = readCityMatrix.getDistanceMatrix();
		City startCity = new City("Aachen", 0,false);
		TSPGreedy tspGreedy = new TSPGreedy(numberofCities,distanceMatrix,cityInfo,startCity);
		double min = tspGreedy.calRouteGreedy();
		String res = tspGreedy.buildRoute();
		System.out.println(min);
		System.out.print(res);
		
	}

}
