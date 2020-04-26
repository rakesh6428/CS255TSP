package cs255tsp;

import java.util.List;

/**
 * @author Angela Wang, Rakesh Gururaj
 *
 */
public class TSPHelper {
	public static final String citiesFilePath = "/Volumes/SJSU/CS255 Design and Analysis of Algorithms/Final Project/CS255TSP/Dataset/Germany_Cities.txt";
	public static final String distanceFilePath = "/Volumes/SJSU/CS255 Design and Analysis of Algorithms/Final Project/CS255TSP/Dataset/DistanceMatrix.txt";
	public static final String citiesFilePathBF = "/Volumes/SJSU/CS255 Design and Analysis of Algorithms/Final Project/CS255TSP/Dataset/Germany_Cities_11.txt";
	public static final String distanceFilePathBF = "/Volumes/SJSU/CS255 Design and Analysis of Algorithms/Final Project/CS255TSP/Dataset/DistanceMatrix_11.txt";
	public static long time = System.currentTimeMillis();
	/**
	 * @param startingCity
	 * @param citiesList
	 * @return The City ID of the starting City
	 */
	int getStartCityID(String startingCity,List<City> citiesList) {
		int idnum = citiesList.indexOf(new City(startingCity));
		int cityID = citiesList.get(idnum).getCityId();
		return cityID;
	}
	
}
