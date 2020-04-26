package DP;

import java.util.Map;


//0 2 1 4
//2 0 5 3
//1 5 0 6
//4 3 6 0
public class DPDriver {
	public static void main(String[] args) {
		ReadCityInfo readCityInfo = new ReadCityInfo("/Volumes/SJSU/CS255 Design and Analysis of Algorithms/Final Project/CS255TSP/Dataset/Germany_Cities.txt");
		ReadCityMatrix readCityMatrix = new ReadCityMatrix("/Volumes/SJSU/CS255 Design and Analysis of Algorithms/Final Project/CS255TSP/Dataset/DistanceMatrix.txt");
		
		int numberofCities = readCityInfo.getNumberofCities();
		
		Map<Integer,City> cityInfo = readCityInfo.getCityInfo();
		double[][] distanceMatrix = readCityMatrix.getDistanceMatrix();
		
		City startCity = new City("Aachen",0,false); //
		TSPDp tspDp = new TSPDp(numberofCities,distanceMatrix,cityInfo,startCity);
		double min = tspDp.calRouteDp();
		String res = tspDp.buildRoute();
		System.out.println(min);
		System.out.print(res);

	}
}
