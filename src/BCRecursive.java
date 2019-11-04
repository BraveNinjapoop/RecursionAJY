/**
Project #3, RecursionAJY
Author, Austin Young
Date, 04OCT19
**/

import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.file.StandardOpenOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class BCRecursive {

	public static File file = new File("C:\\Eclipse_workspaces\\CS215\\RecursionAJY\\Records\\BCRecursiveResults.txt"); //Creates a file in the SRC called Records that keeps track of the results.
	private static boolean running = true; //isRunning, defines the variable for the running while loop.			//I was trying to avoid using my specific file path, because then it wouldn't work on other machines.
	private static String time; //Creates the time variable to detiremine.
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long n, k; //Initialized both n and k for calculations.
		long begin, finish; //Initialized both begin and finish to keep track of time.
		
	while(running) { //My while running loop that executes through the process of inputting n and k and finding the ways/subsets/items.
		System.out.println("Enter an integar for N"); //Value for N.
		n = scan.nextInt();
		System.out.println("Enter an integar for K"); //Value for K.
		k = scan.nextInt();
				
	begin = System.currentTimeMillis(); //Stores the current millisecond in currentTimeMillis to record the beginning times of the calculation.
	double temp = calculate(n, k); //Defining temp to find our how many "ways" there are.
	System.out.println("There are " + temp + " ways to " + k + " subsets from " + n + " items. ");
	finish = System.currentTimeMillis(); //Stores the final value for time in currentTimeMillis to record how long it took for the calculate to run.
	time = getTime((begin - finish)/1000);
	
	try {
		saveFile(n, k, temp);
	} catch(IOException e) {
		System.out.println("Writing to file failed"); //Throws an exception if the writing to the file failed.
	}
	
	System.out.println("Do you want to enter more values for either K or N? Y or N"); //Option to input more values for K or N or stop.
	String choice = scan.nextLine().toLowerCase();
	choice = scan.nextLine().toLowerCase();
	if(choice.equals("n"))
		running = false; //If user decides to stop inputting values, "N" will result in running (the program) to be false.
		
		}
	}
	
	private static double calculate(long n, long k) { //A method of Recursion where I used double to run my calculation.
		if (k > n - k)
            k = n - k;
 
        double calculate = 1.0; //Defines Calculate.
        for (int i = 1; i <= k; i++)
            calculate = calculate * (n + 1 - i) / i;
        return calculate; //Returns the calculated value.
	}
        
    public static String getTime(long time) { //getTime grabs the time calculations that I made in the while loop.
    	if(time < 1)
    		return ("1 second.");
    	else if(time >= 60) {
    		return (time/60 + "minutes," + time%60 + "seconds.");
    	}
    	else
    		return (time + "seconds.");
    	}

	private static void saveFile(long n, long k, double temp) throws IOException { //Creates the records and saves the k, n, and temp.
		file.createNewFile();
		Path path = Paths.get("C:\\Eclipse_workspaces\\CS215\\RecursionAJY\\Records\\BCRecursiveResults.txt"); //Creates a file in the SRC called Records that keeps track of the results.
		Files.write(path, ("\n" + n + ", " + k + ", " + temp + ", " + time).getBytes(), StandardOpenOption.APPEND);
	}
}
