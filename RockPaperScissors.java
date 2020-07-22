import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Scanner;
@SuppressWarnings("unused")
public class RockPaperScissors {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input  = new Scanner(System.in);
		
		System.out.print("Choose your character: ");
		String testing = input.nextLine(); 
		String [] choices = {};
		
		JSONObject ch = new JSONObject();
		
		
		
		if (testing.equals("rock")) {
		//	choices = addX(choices.length, choices, testing);
			ch.put("choice", testing);
			System.out.println("Computer choice: paper");
		} else if (testing.equals("paper")) {
	//		choices = addX(choices.length, choices, testing);
			System.out.println("Computer choice: scissors");
		} else if (testing.equals("scissors")) {
	//		choices = addX(choices.length, choices, testing);
			System.out.println("Computer choice: rock");
		} else {
			System.err.println("N/A");
		}
		
//		for (int i = 0; i < choices.length; i++) {
//		System.out.println(choices[i]);
//		}
		
		System.out.println(ch);
	}
	
	public static String[] addX(int n, String []arr, String x) 
    { 
        int i; 
  
        // create a new array of size n+1 
        String newarr[] = new String[n + 1]; 
  
        // insert the elements from 
        // the old array into the new array 
        // insert all elements till n 
        // then insert x at n+1 
        for (i = 0; i < n; i++) 
            newarr[i] = arr[i]; 
  
        newarr[n] = x; 
  
        return newarr; 
    }
}
