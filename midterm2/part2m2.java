<<<<<<< HEAD
import java.util.Scanner;
import java.io.File;

public class part2m2 {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Use: java part2m2 filename");
            System.exit(1);
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("please include the source file");
            System.exit(2);
        }
    
        Scanner in = new Scanner(file);
        long charCount = 0L;
        int lines = 0;
        int words = 0;

        while(in.hasNext()) {
            String line = in.nextLine();
            
            String[] wordArray = line.split(" ");         

            charCount += line.length();
            lines += 1;
            words += wordArray.length;
        }
        System.out.printf("File %s has%n" +
                "%d characters%n" + 
                "%d words%n" +
                "%d lines%n%n",
                args[0], charCount, words, lines);
    }
=======
import java.util.Scanner;
import java.io.File;

public class part2m2 {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Use: java part2m2 filename");
            System.exit(1);
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("please include the source file");
            System.exit(2);
        }
    
        Scanner in = new Scanner(file);
        long charCount = 0L;
        int lines = 0;
        int words = 0;

        while(in.hasNext()) {
            String line = in.nextLine();
            
            String[] wordArray = line.split(" ");         

            charCount += line.length();
            lines += 1;
            words += wordArray.length;
        }
        System.out.printf("File %s has%n" +
                "%d characters%n" + 
                "%d words%n" +
                "%d lines%n%n",
                args[0], charCount, words, lines);
    }
>>>>>>> 6e22061cf32aaedcc0260e23f23e85e766b18a94
}