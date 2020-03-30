package gradedexercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;



/**The GradedExercise class contains methods for linear search, binary search, selection sort, insertion sort, splitting a list, and a main method containing tests of the other methods.
 * 
 * @author katie
 * 
 * The linear search method was one of the easiest ones to make. It was straightforward and short, just a method to look at each integer in an 
 * ArrayList and see if it matches with the integer being searched for.
 * 
 * Making a binary search was much harder, and I originally had it performing too many actions to be efficient. I realized this and rewrote it to 
 * sort the given ArrayList and create narrower and narrower ranges until it found the desired integer, or the place where it would exist if 
 * present.
 * 
 * The selection sort method begins by creating a couple of variables and has a while-loop that will not break until the ArrayList newList has 
 * as many integers in it as the original given ArrayList to ensure that all the elements of the original list were moved over. The min variable 
 * starts with a value whatever the first element in the ArrayList is, but is changed to the next number if it is found to be smaller. After one 
 * iteration of the while-loop, the smallest integer has been found, added to a new list, and removed from the original list. The new list will 
 * continue to have the smallest number of the ArrayList added to the end of it, keeping it sorted. The while-loop repeats comparing the new 
 * minimum (first element of the ArrayList, second element of the original ArrayList) with the next element and replacing it as smaller numbers 
 * are found once the new list contains as many elements as the original list did, the while-loop breaks and the method returns the new sorted 
 * list.
 * 
 * The merge method combines two given ArrayLists into one using a for-loop to add each element individually. This method is meant to be used in 
 * mergeSort.
 * 
 * The mergeSort method is supposed to sort a given ArrayList using merge sort. I worked on it for hours but could not get this method to work. 
 * I have a hard time understanding recursion. Fortunately the point of this project is not to write perfect algorithms, although mine would
 * ideally at least work. I think the important thing is that I am now far more familiar with GitHub and java-doc now, and I learned more about
 * the language itself along the way.
 * 
 * The insertion sort method starts with the first two elements of the ArrayList and swaps them if they are not in ascending order. If they are 
 * in order, the method moves on to the next two elements. Each time the elements are swapped and it's not the first iteration through the
 * for-loop, the indexes of the two elements being checked move back one place. If they are in order, the loop continues by moving the indexes
 * forward by one. The for loop breaks just before the code tries to reach an index that does not exist in the ArrayList. This means that the 
 * indexes of the two numbers being checked has reached the end of the list, so everything before it has to have been sorted. The method then 
 * returns the sorted list.
 * 
 * splitList is a method that we were not assigned to make, but I made and used it previously for one of the assigned methods, and thought it 
 * might end up being useful. It splits an ArrayList down the middle into two ArrayLists, and returns them as one ArrayList containing both 
 * ArrayLists. It's a bit confusing to explain, but when the return value is printed, it is easier to understand. I think I originally used this
 * method when making my first version of binarySort, but realized that the efficiency that binary sort is meant to have was being negated by the
 * extra steps taken to keep track of the splits with smaller and smaller ArrayLists. It almost worked, but I had no easy way to return the index
 * of the number, I could only return the number itself.
 */
public class GradedExercise {
    
    /**
     * linearSearch uses a linear search on an ArrayList of integers to find the index of a given integer.
     * 
     * @param list an ArrayList of integers in which to search.
     * @param x integer to be searched for.
     * @return index of the integer that was searched for, or -1 if the integer was not in the ArrayList.
    */
    public static int linearSearch (ArrayList list, int x){
        int size = list.size();
        int index = -1;
        for (int i = 0; i < size; i++){
            int currentNumber = (int) list.get(i);
            if (currentNumber == x){
                index = i;
            }
        }
        return index;
    }
    
    /**
     * binarySearch uses a binary search on an ArrayList of integers to find the index of a given integer.
     * 
     * @param list ArrayList of integers in which to search.
     * @param x integer to be searched for.
     * @return index of the integer that was searched for, or -1 if the integer was not in the ArrayList.
    */    
    public static int binarySearch(ArrayList list, int x){ 
            list = insertionSort(list);
            int size = list.size();
            int minIndex = 0;
            int maxIndex = size-1;
            int returnValue = -1;
            while (maxIndex-minIndex > 1){
                int midNumIndex = (maxIndex + minIndex)/2;
                int midNum = (int) list.get(midNumIndex);
                if (x < midNum){
                    maxIndex = midNumIndex;
                }
                if (x > midNum){
                    minIndex = midNumIndex;
                }
                if (x == midNum){
                    returnValue = midNumIndex;
                    break;
                }
            }
            return returnValue;
    }
    
    /**
     *selectionSort uses selection sort to sort an ArrayList of integers.
     * 
     * @param list ArrayList of integers to be sorted.
     * @return ArrayList - Sorted ArrayList of integers.
     */
    public static ArrayList selectionSort(ArrayList list){
        ArrayList<Integer> newList = new ArrayList<>();
        int originalSize = list.size();
        while (newList.size() != originalSize){
            int minValue = (int) list.get(0);
            int minIndex = 0;
            for (int i = 1; i < list.size(); i++){
                int ivalue = (int) list.get(i);
                if (ivalue < minValue){
                    minValue = ivalue;
                    minIndex = i;   
                }
            }
            newList.add(minValue);
            list.remove(minIndex);
        }
        return newList;
    }

    /**merge combines two given ArrayLists into one.
     * 
     * @param list1 first ArrayList to be merged.
     * @param list2 second ArrayList to be merged.
     * @return list1 - ArrayList with the elements of list1 and list2.
     */
    public static ArrayList merge(ArrayList list1, ArrayList list2){
        int size = list2.size();
        for (int i = 0; i < size; i++){
            list1.add(list2.get(i));
        }
        return list1;
    }
    
    /**mergeSort sorts a given ArrayList using merge sort.
     * 
     * @param list ArrayList to be sorted.
     * @return newList - sorted ArrayList
     */
    public static ArrayList mergeSort(ArrayList list){ //This method does not work.
        ArrayList<Integer> firstHalf = new ArrayList<>();
        ArrayList<Integer> secondHalf = new ArrayList<>();
        int size = list.size();
        ArrayList<Integer> newList = new ArrayList<>();
        ArrayList returnValue;
        if (size == 1){
            returnValue = list;
        }
        firstHalf = splitList(firstHalf);
        secondHalf = splitList(secondHalf);
        return newList;
//        int size = list.size();
//        ArrayList returnValue;
//        ArrayList<Integer> firstHalf = new ArrayList<>();
//        ArrayList<Integer> secondHalf = new ArrayList<>();
//        ArrayList<Integer> sortedList = new ArrayList<>();
//        if (size == 1){
//            return sortedList;
//        }
//        firstHalf.addAll(list.subList(0, size/2));
//        secondHalf.addAll(list.subList(size/2, size));
//        //firstHalf = list.subList(0, size/2);
//        //secondHalf = (ArrayList) list.subList(size/2+1, size-1);
//        ArrayList<Integer> firstHalfSorted = new ArrayList<>();
//        ArrayList<Integer> secondHalfSorted = new ArrayList<>();
//        firstHalfSorted.addAll(mergeSort(firstHalf));
//        secondHalfSorted.addAll(mergeSort(secondHalf));
//        while ((firstHalfSorted.size() > 0) && (secondHalfSorted.size() > 0)){
//            if ((int)firstHalfSorted.get(0) < (int)secondHalfSorted.get(0)){
//                sortedList.add((int) firstHalfSorted.get(0));
//                firstHalfSorted.remove(0);
//            }
//            else {
//                sortedList.add((int) secondHalfSorted.get(0));
//                secondHalfSorted.remove(0);
//            }
//        }
//        while (firstHalfSorted.size() > 0){
//            sortedList.add((int) firstHalfSorted.get(0));
//            firstHalfSorted.remove(0);
//        }
//        
//        while (secondHalfSorted.size() > 0){
//            sortedList.add((int)secondHalfSorted.get(0));
//            secondHalfSorted.remove(0);
//        }
//          System.out.println("firstHalf: "+firstHalf+" secondHalf: "+secondHalf+" sortedList: "+sortedList+" firstHalfSorted: "+firstHalfSorted+" secondHalfSorted: "+secondHalfSorted);
//    return sortedList;
//    }
    }      
      
    /**
    *insertionSort performs the insertion sort method on an ArrayList
     * 
     * @param list an ArrayList to be sorted
     * @return ArrayList - The sorted ArrayList
    */ 
    public static ArrayList insertionSort(ArrayList list){
        int size = list.size();
        for (int i = 0; i < size-1;){
            int min = (int) list.get(i);
            int next = (int) list.get(i+1);
            if (min>next){
                Collections.swap(list, i, i+1);
                if (i !=0){
                    i -=1;
                }
            }
            else{
                i += 1;
            }
        }
        return list;
    }
    
    /**
     * splitList splits an ArrayList into two ArrayLists and returns them in a single ArrayList.
     * 
     * @param list ArrayList to be split
     * @return bothLists - An ArrayList holding two ArrayLists that each contain one half of the original ArrayList
     */
    public static ArrayList splitList(ArrayList list){
        int size = list.size();
        int firstHalf;
        int secondHalf;
        if (size%2 == 0){
            firstHalf = size/2;
            secondHalf = firstHalf;
        }
        else {
            firstHalf = size/2;
            secondHalf = firstHalf + 1;
        }
        ArrayList<Integer> firstHalfList = new ArrayList<>();
        for (int i = 0; i < firstHalf; i++){
            firstHalfList.add((Integer) list.get(i));
        }
        ArrayList<Integer> secondHalfList = new ArrayList<>();
        for (int i = firstHalf; i < size; i++){
            secondHalfList.add((Integer) list.get(i));
        }
        ArrayList<ArrayList> bothLists = new ArrayList<>();
        bothLists.add(firstHalfList);
        bothLists.add(secondHalfList);
        return bothLists;
    }

    /**
     * main holds and runs the tests for the methods.
     */
    public static void main(String[] args) {
        ArrayList<Integer> linearSearchList = new ArrayList<>(Arrays.asList(2,7,9,1,10));
        System.out.println(linearSearch(linearSearchList, 7));
        System.out.println(linearSearch(linearSearchList, 3));
        
        ArrayList<Integer> binarySearchList = new ArrayList<>( Arrays.asList(2, 3, 1));
        System.out.println(binarySearch(binarySearchList, 2));
        System.out.println(binarySearch(binarySearchList, 6));
        
        ArrayList<Integer> selectionSortList = new ArrayList<>( Arrays.asList(9,5,7,2,10,1,3));
        System.out.println(selectionSort(selectionSortList));
        
        ArrayList<Integer> mergeSortList = new ArrayList<>( Arrays.asList(9,5,7,2,10,1,3,4));
        System.out.println(mergeSort(mergeSortList));

        ArrayList<Integer> list1 = new ArrayList<>( Arrays.asList(9,5,7));
        ArrayList<Integer> list2 = new ArrayList<>( Arrays.asList(2,6,4));
        System.out.println(merge(list1,list2));
        
        ArrayList<Integer> insertionSortList = new ArrayList<>( Arrays.asList(90,2,1,0,6,3,8));
        System.out.println(insertionSort(insertionSortList));
    }
}
