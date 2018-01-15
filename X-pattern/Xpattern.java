/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
public class Xpattern {
    public static void main(String[] args) {
    Scanner scan = new Scanner (System.in); // initializing and defining a new Scanner object
    System.out.print("Enter the height/width of your encryption: "); // print statement asking for dimensions of encryption
    int height = 0; // definition of heigh variable
    boolean heightCheck = scan.hasNextInt(); // defines a boolean type to check if the value entered is an integer
    if (!heightCheck){ // if the entered value is not an integer, the while loop runs
      while (!heightCheck) { // beginning of the while loop
        Scanner scan2 = new Scanner (System.in); // initialization of definition of new scanner to run only in while loop
        System.out.println("ERROR! Please enter an integer."); // prints error message
        System.out.print("Enter the height/width of your encryption: "); // asks the user to enter dimensions of encryption
        heightCheck = scan2.hasNextInt(); // redefines heightCheck to return true if the user enters an integer
        if (heightCheck) { // runs only if the user enters an integer
          height = scan2.nextInt(); // defines height as the next integer the user enters
        }
        else if (height < 0 || height > 100) {
          System.out.println("Please enter an integer between 1 and 100.");
          heightCheck = false;
          continue;
        }
        else { 
          continue; // while loop continues if the user does not enter an integer
        }
      }
    }
    else { // if the user enters an integer to begin with
      height = scan.nextInt(); // height is defined as the integer the user enters
    }
   
    while (height <= 0 || height > 100) { // beginning of a while loop to check if the integer is less than 100
      Scanner scan3 = new Scanner (System.in); // import a new scanner object for the while loop
      System.out.println("ERROR! The number you entered is out of range or you entered an invalid type.");  // prints error message
      System.out.println("Please enter a number less than 100."); // print statement asking for a number less than 100
      System.out.print("Enter the height/width of your encryption: "); // asks user to enter the height/width of the encryption
      heightCheck = scan3.hasNextInt(); // variable checking to see if the user entered an integer
      if (!heightCheck){ // if the user did not enter an integer, if statement runs
        height = 101; // sets the value of height to 101 so that the while loop continues
      } // end of if statement
      else { // beginning of else statement
        height = scan3.nextInt(); // stores the next integer that the user enters as in the variable, height
      } // end of else statement
    } // end of while loop
    
    int i = 0; // intializing and defining i as 0
    while (i < height) { // beginning of while loop that runs when i < than the entered height
      int j = 0; // initializes j as an integer and stores it as zero; each time this statement is met, j becomes 0
      while (j < height) { // opening of inner loop to run while j < than the entered height
        if (j + i == height - 1 || height - (i + j) == height - 2 * i) { // if statement to check our algorithms (it will print at the nth and height - nth positions)
          System.out.print(" "); // prints a space if either statement is true
        } // end of if statement
        else { // beginning of else statement
        System.out.print("*"); // prints an asterisk if the conditions in the if statement are not met
        } // end of if statement
        j++; // one is added to the variable, j
      } // end of inner while loop
      i++; // one is added to the variable, i
      System.out.print("\n"); // goes to the next line
    } // end of outer while loop
  } // end of main method    
}
