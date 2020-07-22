package cit381;

// Java Import Classes
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class AI_Final_Project {
	
//Scanner input
public static Scanner input = new Scanner(System.in);

// ArrayList for initial saving
public static ArrayList<String> elements = new ArrayList<>();

// Initializing probability variables
public static double rockProb;
public static double papProb;
public static double sciProb;

// Initializing the AI decision variable
public static String decision;
	
	public static void countFrequencies(ArrayList<String> list, String weapon) 
    { 
        // HashMap initializer to store the inputs  
        Map<String, Integer> hm = new HashMap<String, Integer>(); 
       
        // Beginning Three Values 
        hm.put("rock", 1);
        hm.put("scissors", 1);
        hm.put("paper", 1);
        
        // Adding the input keys and values into the HashMap
        for (String i : list) { 
            Integer j = hm.get(i); 
            hm.put(i, (j == null) ? 1 : j + 1); 
        } 
        
        // Total variable initializer
        int total = 0;
  
        // Setting the total 
        for (HashMap.Entry<String, Integer> val : hm.entrySet()) { 
            total += val.getValue();            
        } 
       
        
        // Setting Rock probabilities
        if (weapon.equals("rock") || weapon.equals("paper") || weapon.contentEquals("scissors")) {
        int rock = hm.get("rock");
        rockProb = (((double)rock)/(total));
        
        // Setting Paper probabilities
        int paper = hm.get("paper");
        papProb = (((double)paper)/((double)total));
        
        // Setting Scissors probabilities
        int scissors = hm.get("scissors");
        sciProb = (((double)scissors)/(total));
        }
        
        // Probabilities output (for debugging and insight into the program)
//        System.out.println("========== Probabilities =========");
//        System.out.println(rockProb);
//		System.out.println(papProb);
//		System.out.println(sciProb);
//		System.out.println("==================================");
       
    } 
  
	
	// Actual game and decisions
	public static void playGame(ArrayList<String> elements) throws IOException {
		// Game Number
		int gameNum = 0;
		
		// Iterating the game number for each game
		for (int i = 0; i <= elements.size(); i++) {
			gameNum++;
		}
		
		// Game output
		System.out.println("Game #" + gameNum);
		
		// Starting input:
		System.out.print("Choose 'rock', 'paper', 'scissors to play or 'exit' to leave: ");
		String weapon = input.nextLine();
		
		
		// Adding to ArrayList
		if (weapon.equalsIgnoreCase("rock") || weapon.equalsIgnoreCase("paper") || weapon.equalsIgnoreCase("scissors")) {
			elements.add(weapon);
		}
		
		// Using new parameters for cF method
		countFrequencies(elements, weapon);
		
		// Deciding what to choose based on the probabilities
		if ((rockProb > papProb) && (rockProb > sciProb)) {
			decision = "Paper";
		} else if ((papProb > rockProb) && (papProb > sciProb)) {
			decision = "Scissors";
		} else if ((sciProb > rockProb) && (sciProb > papProb)) {
			decision = "Rock";
		} else if ((weapon.equalsIgnoreCase("rock")) && ((rockProb == papProb) || (rockProb == sciProb))) {
			decision = "Paper";
		} else if ((weapon.equalsIgnoreCase("paper")) && ((papProb == rockProb) || (papProb == sciProb))) {
			decision = "Scissors";
		} else if ((weapon.equals("scissors")) && ((sciProb == papProb) || (sciProb == rockProb))) {
			decision = "Rock";
		}
		
		// Making it look better with all caps
		String finalDecision = decision.toUpperCase();
		String lethalWeapon = weapon.toUpperCase();
		
		System.out.println("\n============================================");
		
		// Output the 1v1 results
				System.out.println("Your choice: " + lethalWeapon + "  |   "
						+ "AI choice: " + finalDecision + "\n");
		
		//Choose which player wins the battle
		int winner = tally(weapon, decision);
		
		// Determine the winner's results
		if (winner == 1) {
			System.out.println("Humanity won because " + weapon + " beat " + decision);
			}
		else if (winner == -1 ){
			System.out.println("You lost and the AI won... " + decision + " beat " + weapon);
		
		} else if (winner == 0 ) {
			System.out.println("Both tied with: " + weapon);
		}
		System.out.println("============================================\n");
		
		//Exit IF statement
		if (weapon.equalsIgnoreCase("exit")) {
			leaveGame();
		}
	}
	
	// Method that determines who wins in a head to head
	public static int tally(String weapon, String decision) {
		
		// User: Rock 
		if (weapon.equalsIgnoreCase("rock")) {
			if (decision.equalsIgnoreCase("rock")) {
				return 0;
			} 
			else if (decision.equalsIgnoreCase("paper")) {
				return -1;
			}
			else {
				return 1;
			}
		}
		
		// User: Paper
		else if (weapon.equalsIgnoreCase("paper")) {
			if (decision.equalsIgnoreCase("rock")) {
				return 1;
			}
			else if (decision.equalsIgnoreCase("paper")) {
				return 0;
			}
			else {
				return -1;
			}
		}
		
		// User: Scissors
		else {
			if (decision.equalsIgnoreCase("rock")) {
				return -1;
			}
			else if (decision.equalsIgnoreCase("paper")) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}
	
	// Public method that exits the game and terminates the program
	public static void leaveGame() {
		System.out.println("Thank you for playing!");
		System.exit(1);
	}
	
	// Main Method
	public static void main(String[] args) throws IOException {
		
		// Title
		System.out.print("Rock, Paper Scissors!\n\n");
		
		// Replay the game
		try {
		do {
			playGame(elements);
		}
		while(true);
		} catch (NullPointerException e) {
			System.err.print("Please check your input and restart program.");
			System.exit(1);
		}
	}
	
	
}
