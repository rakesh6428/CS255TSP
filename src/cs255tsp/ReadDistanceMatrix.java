package cs255tsp;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadDistanceMatrix {

	double[][] insertDistances(String distanceFilePath) throws IOException {
		File distanceFile = new File(distanceFilePath);
		Scanner fileScanner = new Scanner(distanceFile);

		int matrixLength = fileScanner.nextLine().trim().split(" ").length;
		double[][] distanceMatrix = new double[matrixLength][matrixLength];
		fileScanner.close();
		fileScanner = new Scanner(distanceFile);

		int rowNumber = 0;
		while (fileScanner.hasNextLine()) {
			String[] distance = fileScanner.nextLine().trim().split(" ");
			for (int i = 0; i < distance.length; i++) {

				distanceMatrix[rowNumber][i] = Double.parseDouble(distance[i]);
			}
			rowNumber++;
		}
		fileScanner.close();
		return distanceMatrix;
	}
}
