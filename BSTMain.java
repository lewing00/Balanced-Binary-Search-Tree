/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author LeeAnna Ewing
 */
public class BSTMain {
    public static void main(String[] args) {
        //create instance of Random class
        Random r = new Random();
        //create Scanner object for keyboard input
        Scanner keyboard = new Scanner(System.in);
        
        int menuOption;
        int minValue = 0;
        int maxValue = 0;
       
        
        //get desired amount of nodes from user
        System.out.print("Please enter your desired number of nodes : ");
        int numNode = keyboard.nextInt();
        
        while (numNode <= 0)
        {
            System.out.print("Error: Please enter a positive integer greater than 0 for number of nodes");
            numNode = keyboard.nextInt();
        }
        //instantiate array based on user input       
        int[] integers = new int [numNode];
        int n = integers.length;
        //add desire number of nodes too array 
        for(int i = 0; i < n; i++) {
            integers[i] = r.nextInt(100) + 1;
        }
        
        //For testing purposes
        /*
        System.out.print("Unsorted: ");
        printArray(integers);
        System.out.println();
        */
        
        // Initial call to quicksort
        quicksort(integers, 0, n - 1);
        //For testing purposes
        /*
        System.out.print("Sorted: ");
        printArray(integers);
        System.out.println();
        */
        
        BSTFunctions tree = new BSTFunctions();
        tree.root = tree.sortedArrayToBST(integers, 0, n -1 );
        
        
        do{
            System.out.println();
            System.out.println("Please select from the following Binary Search Tree menu options:");
            System.out.println("1. Find the minimum value \n" +
                               "2. Find the maximum value \n" +
                               "3. Remove the minimum value \n" +
                               "4. Remove the maximum value \n" +
                               "5. Find a certain value \n" +
                               "6. Print inorder tree traversal \n" +
                               "7. Exit" );
            System.out.print("Enter your numerical menu selection: ");
            menuOption = keyboard.nextInt();
            System.out.println();
            
            while(menuOption < 1 || menuOption > 7){
                System.out.println("Invalid menu selction. Please try again: ");
                System.out.println("Enter your numerical menu selection: ");
                menuOption = keyboard.nextInt();
                System.out.println();
            }
        
        //Find the minimum value
        if (menuOption == 1){ 
            if (tree.root == null){
                System.out.println("The tree is empty. There are no min values.");
            }
            else if (tree.root != null){
                minValue = tree.minValue(tree.root);
                System.out.println("The lowest value in the tree is: " + minValue);
            }    
        }
        //Find the maximum value
        else if (menuOption == 2){
            if (tree.root == null){
                System.out.println("The tree is empty. There are no max values.");
            }
            else if (tree.root != null){
            maxValue = tree.maxValue(tree.root);
            System.out.println("The highest value in the tree is: " + maxValue);
            }
        }
        //delete min value
        else if (menuOption == 3){
            if (tree.root == null){
                System.out.println("The tree is empty. There are no nodes to delete");
            }
            else if (tree.root != null){
            tree.root = tree.deleteNode(tree.root,(minValue = tree.minValue(tree.root)));
            System.out.println("The minimum value of " + minValue + " has been deleted.");
            
            if (tree.root == null)
                System.out.println("The tree is now empty");
            }
        }
        //delete max value
        else if (menuOption == 4){
             if (tree.root == null){
                System.out.println("The tree is empty. There are no nodes to delete");
            }
            else if (tree.root != null){
            tree.root = tree.deleteNode(tree.root,(maxValue = tree.maxValue(tree.root)));
            System.out.println("The maximum value of " + maxValue + " has been deleted.");
            
            if (tree.root == null)
                System.out.println("The tree is now empty");
            }
        }
        //Find a given value
        else if (menuOption == 5){
            if (tree.root == null){
                System.out.println("The tree is empty. There is nothing to find");
            }
            else if (tree.root != null){
                System.out.print("Please enter the value between 1 - 100 that you would like me to search for: ");
                int key = keyboard.nextInt();
                
                while (key < 1 || key > 100){
                    System.out.println("Error: Value not within specified range.");
                    System.out.print("Please enter the value between 1 - 100 that you would like me to search for: ");
                    key = keyboard.nextInt();
                }
                boolean test = tree.BSTSearch(tree.root, key);
            
                    if (test == true)
                        System.out.println("Your value of " + key + " was found in the tree!");
                    else if (test == false)
                        System.out.println("Your value of " + key + " was not found in the tree.");
            }   
        }
        //show in order traversal
        else if (menuOption == 6){
            if (tree.root == null)
            {
                System.out.println("The tree is empty. There is nothing to traverse.");
            }
            else{
            System.out.print("InOrder traversal: ");
            tree.inOrder(tree.root);
            System.out.println();
            }
        }
        
                
        }while(menuOption != 7);
  
    }//main
/*****************************************************************************/ 
    static int partition(int integers[], int low, int high){
     int l = 0;
     int h = 0;
     int midpoint = 0;
     int pivot = 0;
     int temp = 0;
     boolean done = false;
     
     //Pick middle element as pivot
     midpoint = low + (high - low) /2;
     pivot = integers[midpoint];
     
     l = low;
     h = high;
     
     while (!done) {
         // Increment l while integers[l] < pivot
         while (integers[l] < pivot){
             ++l;
        }//inner while (low)
         // Decrement h while pivot < integers[h]
         while(pivot < integers[h]) {
             --h;
         }
     
     
     // If there are zero or one elements remaining, all numbers are
     // partitioned. Return h
     if (l >= h){
         done = true;
     }//if
     else {
         // Swap intergers[l] and integers [h] udate l and h
         temp = integers[l];
         integers[l] = integers[h];
         integers[h] = temp;
         
         ++l;
         --h;          
     }//else
     }
     return h;
    }//partition
    
    static void quicksort(int integers[], int low, int high){
       int j = 0;
       
       // Base case: If there are 1 or zero elements to sort,
       // partition is already sorted
       if(low >= high){
           return;
       }
       
       //Partition the data within the array, Value j returned from partition is 
       //location of last element in low partition.
       
      j = partition(integers, low, high);
       
       // Recursively sort low partition (low to mid(midpoint)) and
       // high partition (mid + 1 to high)
       quicksort(integers, low, j);
       quicksort(integers, j + 1, high);
       
    }//quicksort
    
    //this method was only for testing purposes
    /*
    static void printArray(int integers[]){
        int n = integers.length;
        for (int i = 0; i < n; ++i)
            System.out.print(integers[i] + " ");
        
    }//printArray */
}//fine
