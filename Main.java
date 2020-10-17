
import java.util.*; 
   
class Main { 
    //partitions the array around pivot=> last element
    static int partition(int numArray[], int low, int high)   { 
        int pivot = numArray[high]; 
        // smaller element index 
        int i = (low - 1); 
        for (int j = low; j <= high - 1; j++) { 
            // check if current element is less than or equal to pivot
            if (numArray[j] <= pivot) {
                i++; 
                // swap the elements
                int temp = numArray[i]; 
                numArray[i] = numArray[j]; 
                numArray[j] = temp; 
            } 
        } 
        // swap numArray[i+1] and numArray[high] (or pivot) 
        int temp = numArray[i + 1]; 
        numArray[i + 1] = numArray[high]; 
        numArray[high] = temp; 
        return i + 1; 
    } 
   
     
//sort the array using quickSort
    static void quickSort(int numArray[], int low, int high) 
    { 
        //auxillary stack
        int[] intStack = new int[high - low + 1]; 
   
        // top of stack initialized to -1
        int top = -1; 
   
        // push initial values of low and high to stack 
        intStack[++top] = low; 
        intStack[++top] = high; 
   
        // Keep popping from stack while is not empty 
        while (top >= 0) { 
            // Pop h and l 
            high = intStack[top--]; 
            low = intStack[top--]; 
   
            // Set pivot element at its correct position 
            // in sorted array 
            int pivot = partition(numArray, low, high); 
   
            // If there are elements on left side of pivot, 
            // then push left side to stack 
            if (pivot - 1 > low) { 
                intStack[++top] = low; 
                intStack[++top] = pivot - 1; 
            } 
   
            // If there are elements on right side of pivot, 
            // then push right side to stack 
            if (pivot + 1 < high) { 
                intStack[++top] = pivot + 1; 
                intStack[++top] = high; 
            } 
        } 
    }
 
public static void main(String args[]) 
    { 
        //define array to be sorted
        int numArray[] = { 3,2,6,-1,9,1,-6,10,5 }; 
        int n = 8; 
        System.out.println("Original Array:" + Arrays.toString(numArray)); 
        // call quickSort routine to sort the array 
        quickSort(numArray, 0, n - 1); 
        //print the sorted array
        System.out.println("\nSorted Array:" + Arrays.toString(numArray)); 
    } 
}