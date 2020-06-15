<<<<<<< HEAD
import java.util.Scanner;

public class finalpart2q1{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 	// Create a new Scanner

		// Prompt the user to enter the center coordinates and radii of two circles
		System.out.print("Enter circle1's center x-, y-coordinates, and radius: ");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble(); 
		double r1 = input.nextDouble();
		System.out.print("Enter circle2's center x-, y-coordinates, and radius: ");
		double x2 = input.nextDouble();
		double y2 = input.nextDouble(); 
		double r2 = input.nextDouble(); 

		if (Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5) 
			<= Math.abs(r1 - r2))
			System.out.println("circle2 is inside circle1");
		else if (Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5)
					<= r1 + r2)
			System.out.println("circle2 overlaps circle1");
		else
			System.out.println("circle2 does not overlap circle1");
	}
=======
import java.util.Scanner;

public class finalpart2q1{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 	// Create a new Scanner

		// Prompt the user to enter the center coordinates and radii of two circles
		System.out.print("Enter circle1's center x-, y-coordinates, and radius: ");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble(); 
		double r1 = input.nextDouble();
		System.out.print("Enter circle2's center x-, y-coordinates, and radius: ");
		double x2 = input.nextDouble();
		double y2 = input.nextDouble(); 
		double r2 = input.nextDouble(); 

		if (Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5) 
			<= Math.abs(r1 - r2))
			System.out.println("circle2 is inside circle1");
		else if (Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5)
					<= r1 + r2)
			System.out.println("circle2 overlaps circle1");
		else
			System.out.println("circle2 does not overlap circle1");
	}
>>>>>>> 6e22061cf32aaedcc0260e23f23e85e766b18a94
}