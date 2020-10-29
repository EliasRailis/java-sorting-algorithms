
package sortingalgorithms;

/*
* For more information for each algorithm please visit the following links
* https://en.wikipedia.org/wiki/Insertion_sort
* https://en.wikipedia.org/wiki/Bubble_sort
* https://en.wikipedia.org/wiki/Selection_sort
* https://en.wikipedia.org/wiki/Merge_sort
* https://en.wikipedia.org/wiki/Quicksort
* And the implementation in Java here 
* https://stackabuse.com/sorting-algorithms-in-java/
*/

public class SortingAlgorithms {
    
    /*
    *  Insertion sort is a simple sorting algorithm that builds 
    *  the final sorted array (or list) one item at a time. It is much 
    *  less efficient on large lists than more advanced algorithms 
    *  such as quicksort, heapsort, or merge sort.
    */
    public static void insertionSort(Integer[] array){
        int temp;
        for(int i = 0; i < array.length; i++){
            for(int x = i; x > 0; x--){
                if(array[x] < array[x - 1]){
                    temp = array[x];
                    array[x] = array[x - 1];
                    array[x - 1] = temp;
                }
            }
        }
    }
    
    /*
    *  Bubble sort, sometimes referred to as sinking sort, is a simple 
    *  sorting algorithm that repeatedly steps through the list, compares 
    *  adjacent elements and swaps them if they are in the wrong order. 
    *  The pass through the list is repeated until the list is sorted.
    */
    public static void bubbleSort(Integer[] arr){
        boolean isSorted = false;
        int n = arr.length - 1;
        int temp;
        while(!isSorted){
            isSorted = true;
            for(int i = 0; i < n; i++){
                if(arr[i] > arr[i + 1]){
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSorted = false;
                }
            }
            n--;
        }
    }
    
    /*
    *  Selection sort is an in-place comparison sorting algorithm. It has 
    *  an O(n2) time complexity, which makes it inefficient on large lists, 
    *  and generally performs worse than the similar insertion sort.
    */
    public static void selectionSort(Integer[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int index = i;
            for(int x = i + 1; x < arr.length; x++){
                if(arr[x] < arr[index]){
                    index = x;
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }
    
    /*
    *  Merge sort is an efficient, general-purpose, comparison-based sorting 
    *  algorithm. Most implementations produce a stable sort, which means that 
    *  the order of equal elements is the same in the input and output. 
    *  Merge sort is a divide and conquer algorithm. 
    */
    public static void mergeSort(Integer[] array, Integer[] temp, int leftStart, int rightEnd){
        if(rightEnd <= leftStart){
            return;
        }
        int mid = (leftStart + rightEnd) / 2;
        mergeSort(array, temp, leftStart, mid);
        mergeSort(array, temp, mid + 1, rightEnd);
        merge(array, temp, leftStart, rightEnd);
    }
    
    public static void merge(Integer[] array, Integer[] temp, int leftStart, int rightEnd){
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;
        
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;
        
        while(left <= leftEnd && right <= rightEnd){
            if(array[left] <= array[right]){
                temp[index] = array[left];
                left++;
            } else{
                temp[index] = array[right];
                right++;
            }
            index++;
        }
        System.arraycopy(array, left, temp, index, leftEnd - left + 1);
        System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, array, leftStart, size);
    }
    
    /*
    *  Quicksort is a divide-and-conquer algorithm. It works by selecting a 
    * 'pivot' element from the array and partitioning the other elements into 
    *  two sub-arrays, according to whether they are less than or greater than 
    *  the pivot. The sub-arrays are then sorted recursively. 
    *  This can be done in-place, requiring small additional amounts of memory 
    *  to perform the sorting.
    */
    public static void quickSort(Integer[] array, int left, int right){
        if(left >= right){
            return;
        }
        int pivot = array[(left + right) / 2];
        int index = partition(array, left, right, pivot);
        quickSort(array, left, index - 1);
        quickSort(array, index, right);
    }
    
    public static int partition(Integer[] array, int left, int right, int pivot){
        while(left <= right){
            while(array[left] < pivot){
                left++;
            }
            while(array[right] > pivot){
                right--;
            }
            if(left <= right){
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}