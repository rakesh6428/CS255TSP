package greedy;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;



public class ReadCityMatrix {

	private double[][] distanceMatrix;
	
	public ReadCityMatrix(String path) {
		
		try {
			//read distance matrix into the 2D array
			File file = new File(path);
			Scanner fileScanner = new Scanner(file);
			int length = fileScanner.nextLine().trim().split(" ").length;
			distanceMatrix = new double[length][length];
			fileScanner.close();
			fileScanner = new Scanner(file);
			int rowNumber = 0;
			while (fileScanner.hasNextLine()) {
				String[] distance = fileScanner.nextLine().trim().split(" ");
				for (int i = 0; i < distance.length; i++) {
					distanceMatrix[rowNumber][i] = Double.parseDouble(distance[i]);
					distanceMatrix[i][rowNumber] = Double.parseDouble(distance[i]);
				}
				rowNumber++;
			}
			fileScanner.close();
			
		} catch(Exception e) {
			System.out.print("path not find");
		}
		
	}

	
	public double[][] getDistanceMatrix() {
		return distanceMatrix;
	}
	
	
}

