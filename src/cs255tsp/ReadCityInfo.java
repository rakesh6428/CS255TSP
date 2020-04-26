package cs255tsp;


import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Angela Wang, Rakesh Gururaj
 * This class is used to Read cities from the file and create cities matrix.
 */
public class ReadCityInfo {

	private int numberofCities;
	private Map<Integer,City> cityInfo;
	
	
	public ReadCityInfo(String path) {
		try {
			//read city information into map, key is id, value is name
			cityInfo = new HashMap<Integer,City>();
			File file  = new File(path);
			Scanner fileScanner = new Scanner(file);
			while(fileScanner.hasNextLine()) {
				String[] info = fileScanner.nextLine().trim().split(" ");
				int Id = Integer.parseInt(info[1]);
				String name = info[0];
				cityInfo.put(Id, new City(name,Id, false));
			}
			numberofCities = cityInfo.size();
			fileScanner.close();
			
		} catch(Exception e) {
			System.out.print(e);
		}
	}
	
	public int getNumberofCities() {
		return numberofCities;
	}
	
	public Map<Integer,City>  getCityInfo() {
		return cityInfo;
	}
	
	
	
	
}