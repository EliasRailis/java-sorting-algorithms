
package sortingalgorithms;

import java.util.*;

public class AlgorithmsMain {

    public static void main(String[] args) {
        
        // Creating the header for the application
        System.out.println("-------------------------------------------------");
        System.out.println("                Sorting Algorithms               ");
        System.out.println("                Author: Elias Railis             ");
        System.out.println("-------------------------------------------------");
        
        // A new Scanner object to get input from the user
        Scanner input = new Scanner(System.in);
        boolean runAgain = true;
        
        do{
            try{
                System.out.print("Enter the number of element in the array: ");
                int numberOfElements = input.nextInt();

                System.out.print("Enter the minimum range number of the array: ");
                int min = input.nextInt();

                System.out.print("Enter the maximum range number of the array: ");
                int max = input.nextInt();

                System.out.println("Generating array...");
                ArrayList<Integer> list = generateRandomArray(numberOfElements, min, max);
                Integer[] array = list.toArray(new Integer[list.size()]);

                System.out.println("\nUnsorted Array:");
                System.out.println(Arrays.toString(array) + "\n");

                printOutOptions();
                System.out.print("Select the algorithm by entering the corresponding number: ");
                int selectedAlgorithm = input.nextInt();

                getTheSelectedSortingAlgorithm(selectedAlgorithm, array);
                
                System.out.print("Would you like to try again?(Y/N): ");
                String goAgain = input.next().toUpperCase();
                runAgain = (goAgain.equals("Y") ? true : false);
                System.out.println();
            } 
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            
        } while(runAgain);
    }
    
    // This method will generate an array that will contain random integer values
    // that will be returned from the generateRandomNumbersInRange method
    public static ArrayList<Integer> generateRandomArray(int numberOfElements, int min, int max){
        if(numberOfElements <= 0){
            throw new IllegalArgumentException("Please enter again.");
        }
        
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int i = 0; i <= numberOfElements; i++){
            int uniqueNumber = generateRandomNumbersInRange(min, max);
            if(!array.contains(uniqueNumber)){
                array.add(uniqueNumber);
            }
        }
        return array;
    }
    
    // The generateRandomNumbersInRange will return random integer values
    // based on the minimum and maximum range entered by the user
    public static int generateRandomNumbersInRange(int min, int max){
        if(min >= max){
            throw new IllegalArgumentException("Max value must be greater then"
                    + "minimum value.");
        }
        Random randomNumber = new Random();
        return randomNumber.nextInt((max - min) + 1) + min;
    }
    
    // The printOutOptions will print out all the sorting algorithms names that
    // the user can choose to sort the array with
    public static void printOutOptions(){
        String[] sortingOptions = {"Insertion Sort","Bubble Sort","Selection Sort",
            "Merge Sort","Quicksort"};
        
        for(int i = 0; i < sortingOptions.length; i++){
            System.out.println("["+ i +"] " + sortingOptions[i]);
        }
    }
    
    // The getTheSelectedSortingAlgorithm will call the corresponding algorithm
    // from the SortingAlgorithms class to sort the array with based on the selected
    // option from the user
    public static void getTheSelectedSortingAlgorithm(int selectedAlgorithm, Integer[] array){
        if(selectedAlgorithm < 0 || selectedAlgorithm > 4){
            throw new IllegalArgumentException("Please select a value between 0 - 4.");
        }
        
        switch(selectedAlgorithm){
            case 0:
                SortingAlgorithms.insertionSort(array);
                System.out.println("\nArray sorted by using Insertion Sort");
                System.out.println(Arrays.toString(array));
                break;
            case 1:
                SortingAlgorithms.bubbleSort(array);
                System.out.println("\nArray sorted by using Bubble Sort");
                System.out.println(Arrays.toString(array));
                break;
            case 2:
                SortingAlgorithms.selectionSort(array);
                System.out.println("\nArray sorted by using Selection Sort");
                System.out.println(Arrays.toString(array));
                break;
            case 3:
                SortingAlgorithms.mergeSort(array, new Integer[array.length], 0, array.length - 1);
                System.out.println("\nArray sorted by using Merge Sort");
                System.out.println(Arrays.toString(array));
                break;
            case 4:
                SortingAlgorithms.quickSort(array, 0, array.length - 1);
                System.out.println("\nArray sorted by using Quicksort");
                System.out.println(Arrays.toString(array));
                break;
            default:
                break;
        }
    }
}