/**
Project #3, RecursionAJY
Author, Austin Young
Date, 04OCT19
**/

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class CatalanRecursive {

	public static File file = new File("C:\\Eclipse_workspaces\\CS215\\RecursionAJY\\Records\\CatalanRecursiveResults.txt"); //Creates a file in the SRC called Records that keeps track of the results.
	private static boolean running = true; //isRunning, defines the variable for the running while loop.				//I was trying to avoid using my specific file path, because then it wouldn't work on other machines.
	private static String time; //Creates the time variable to detiremine.
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long n;
		long begin, finish;
		
	while(running) { //My while running loop that executes through the process of inputting n and k and finding the ways/subsets/items.
		System.out.println("Enter an integar for N"); //Value for N.
		n = scan.nextInt();

	begin = System.currentTimeMillis(); //Stores the current millisecond in currentTimeMillis to record the beginning times of the calculation.
	double temp = calculate(n); //Defining temp to find our how many "ways" there are.
	System.out.println("C(" + n + ") = " + temp);
	finish = System.currentTimeMillis(); //Stores the final value for time in currentTimeMillis to record how long it took for the calculate to run.
	time = getTime((begin - finish)/1000);
	
	try {
		saveFile(n, temp);
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
	
	private static double calculate(long n) { //A method of Recursion where I used double to run my calculation.

		double catalan = 0; //Initilized catalan as 0.
		if(n <= 1) {
			return 1;
		}
		for(int i = 0; i < n; i++) {
			catalan = catalan + calculate(i) * calculate(n-i-1);
		}
		return catalan; //Returns the calculated value.
		
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

	private static void saveFile(long n, double temp) throws IOException { //Creates the records and saves the k, n, and temp.
		file.createNewFile();
		Path path = Paths.get("C:\\Eclipse_workspaces\\CS215\\RecursionAJY\\Records\\CatalanRecursiveResults.txt"); //Creates a file in the SRC called Records that keeps track of the results.
		Files.write(path, ("\n" + n + ", " + temp + ", " + time).getBytes(), StandardOpenOption.APPEND);
	}

}
