import java.util.Scanner;
import java.util.ArrayList;
/**
 * Fibonacci Number Finder
 * This program allows the user to find the Fibonacci number located at whatever position they enter. The number is then displayed to them at the end
 * 
 * @author Candice Williams
 * @version 12/16/2020
 */
public class FibonacciWilC {
  
  
  public static void main(String[] args) { 
    int positionNum, ans=0, index=2, fibonacci;
    ArrayList<Integer> fibonacciTerm = new ArrayList <Integer>();
    fibonacciTerm.add(0, 1);
    fibonacciTerm.add(1, 1);
    
    displayUserInstructions();
    positionNum = getPositionNumber();
    fibonacci = determineFibonacciTerm(positionNum, ans, index, fibonacciTerm);
    displayFibonacciNum(fibonacci, positionNum);
  }
  
  
  /**
   * This displays the instructions on how the program works to the user
   */
  public static void displayUserInstructions()
  {
   Scanner strIn = new Scanner(System.in);
   String enter;
    
   System.out.println("The Fibonacci sequence is one of the most famous formulas in mathematics. Each number in the sequence is the sum of the two numbers that precede it.");
   System.out.println("The first 10 numbers of the fibbonaci are 1, 1, 2, 3, 5, 8, 13, 21, 34 and 55. This program shows you the value of any number located in the Fibonacci sequence by you entering it's location number.");
   System.out.println("Please enter a positive integer value greater than 0 and the program will display the Fibonacci number at that position.\nPress 'Enter' to begin.");
   enter = strIn.nextLine();
  }
  
  /**
   * This gets a valid position number the user wants to see the fibonacci at.
   * 
   * @return a valid user position number
   */
  public static int getPositionNumber()
  {
    Scanner strIn = new Scanner(System.in);
    String userInput;
    int positionNum=0;
    boolean isWholeNum = true;
    
    do
    {
      System.out.println("What Fibonacci term would you like to see?");
      userInput=strIn.nextLine();
      try
      {
        positionNum = Integer.parseInt(userInput);
        if(positionNum<=0)
        {
          Integer.parseInt("x"); 
        }
        isWholeNum = false;
      }
      
      catch(NumberFormatException error)
      {
       System.out.println("Sorry but \""+userInput+"\" is not a positive whole number greater than zero. Please try again\n");
      }
    }while(isWholeNum);
    return positionNum;
  }
  
  /**
   * This determines the Fibonacci number located at whatever position the user entered
   * 
   * @param positionNum The location of the Fibonacci number the user wants to see
   * @param fibonacci This is the value of the current fibonacci number the program is on
   * @param index This determines what two numbers must be added together to make the fibonacci
   * @param fibonacciTerm this holds the calculated fibonacci values 
   * @return the fibonacci value located at the inputted user position
   */
  public static int determineFibonacciTerm(int positionNum, int fibonacci, int index, ArrayList<Integer> fibonacciTerm)
  {
    
    if (positionNum == 1 || positionNum == 2)
    {
      return 1; 
    }
    
    if(index ==positionNum){
     return fibonacci; 
    }
    else
    {
      fibonacci=fibonacciTerm.get(index-2) + fibonacciTerm.get(index-1);
      fibonacciTerm.add(fibonacci);
      return determineFibonacciTerm(positionNum, fibonacci, index+1, fibonacciTerm);
    }
  }
  
  /**
   * This displays the Fibonacci number located at the user's inputted position
   * 
   * @param fibonacci The fibonacci number located at the user's inputted position
   * @param positionNum The user's location number
   */
  public static void displayFibonacciNum(int fibonacci, int positionNum)
  {
   String finalAns;
   finalAns=Integer.toString(positionNum);
   if (finalAns.substring(finalAns.length()-1).equals("3"))
   {
    if (finalAns.equals("13"))
    {
     finalAns=finalAns.concat("th"); 
    }
    else{
     finalAns=finalAns.concat("rd"); 
    }
   }
   
   if (finalAns.substring(finalAns.length()-1).equals("2"))
   {
    if (finalAns.equals("12"))
    {
     finalAns=finalAns.concat("th"); 
    }
    else{
     finalAns=finalAns.concat("nd"); 
    }
   }
   
   if (finalAns.substring(finalAns.length()-1).equals("1"))
   {
    if (finalAns.equals("11"))
    {
     finalAns=finalAns.concat("th"); 
    }
    else{
     finalAns=finalAns.concat("st"); 
    }
   }
   
   else{
    finalAns=finalAns.concat("th"); 
   }
   
   
   System.out.println("The "+finalAns+" number of the fibonacci is " +fibonacci); 
  }
  
  
}
