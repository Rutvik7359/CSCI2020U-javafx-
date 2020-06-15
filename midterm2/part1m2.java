<<<<<<< HEAD
import java.io.*;

public class part1m2{
	public static void main(String[] args) throws IOException {
		int sum = 0; // Sum of the integers

		try ( // Create an data input stream for file Exercise17_03.dat
			DataInputStream input = 
				new DataInputStream(new FileInputStream("Exercise17_03.dat")); 
		) {
			// Read and sum the integers from the file
			while (true)
				sum += input.readInt();
		}
		catch (EOFException ex) { // Detect end of file
			System.out.println("Sum of the integers is: " + sum);
		}
	}
=======
import java.io.*;

public class part1m2{
	public static void main(String[] args) throws IOException {
		int sum = 0; // Sum of the integers

		try ( // Create an data input stream for file Exercise17_03.dat
			DataInputStream input = 
				new DataInputStream(new FileInputStream("Exercise17_03.dat")); 
		) {
			// Read and sum the integers from the file
			while (true)
				sum += input.readInt();
		}
		catch (EOFException ex) { // Detect end of file
			System.out.println("Sum of the integers is: " + sum);
		}
	}
>>>>>>> 6e22061cf32aaedcc0260e23f23e85e766b18a94
}