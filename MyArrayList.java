/**
 * Name: Sahil Gathe    
 * ID: A16840774
 * Email: sgathe@ucsd.edu
 * File description: This file implemnts an Arraylist
 */

/**
 * TODO: Add class header
 */
public class MyArrayList<E> implements MyReverseList<E> {
    static final int DEFAULT_CAPACITY = 5;
    
    Object[] data;
    int size;

    //IMPORTANT: DO NOT MODIFY THIS CONSTRUCTOR!
    //IMPORTANT: DO NOT ADD ANY MORE CONSTRUCTORS!

    /**
     * Constructor to create an array list with the given array's elements
     * @param arr - array of elements to be used to construct the ArrayList
     */
    public MyArrayList(E[] arr) {
        if (arr == null) {
            this.data = new Object[DEFAULT_CAPACITY];
        } else {
            this.data = arr.clone();
            this.size = arr.length;
        }
    }

    /**
	 * TODO: A methoid that reverse the arraylist form a 
     * given index to another given index
	 */
    public void reverseRegion(int fromIndex, int toIndex){

        //Exeptions 
        if(fromIndex < 0 || toIndex == 0 || toIndex > size || fromIndex > toIndex){
            throw new IndexOutOfBoundsException("Arraylist reverseRegion index");
        }

        //create a temp array that is reversed
        Object[] tempArray = new Object[toIndex - fromIndex + 1];
        int tempItter = 0;
        for(int i = toIndex; i > fromIndex - 1; i--){
            tempArray[tempItter] = data[i];
            tempItter++;
        }

        //replace the orginal arraylist with the temp
        int tempItter2 = 0;
        for(int i = fromIndex; i < toIndex + 1; i++){
            data[i] = tempArray[tempItter2];
            tempItter2++;
        }
    }

    @Override
    /**
     * A method that returns the number of valid elements
     * in the ArrayList 
     * @return - number of valid elements in the arraylist
     */
    public int size() {
        return this.size;
    }

    @Override
    /**
     * A method that returns an Element at the specified index
     * @param index - the index of the return Element
     * @return Element at specified index
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) data[index];
    }
}
