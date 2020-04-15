import java.util.Arrays;

public class Chapter2 {
    int[] A = {0, 0, 0, 0, 0};

    public static void main(String[] args) {
        Chapter2 problems = new Chapter2();

        /** Problem 1 */
        problems.towerOfHanoi(3, 'A', 'B', 'C');

        /**
         * Problem 2 : Check if the array is sorted.
         * 
         * In case problem is extended to any order "ASC" or "DESC".
         * Algorithm: 
         *  1. Compare first and last element of check what order
         *     in case both are equal use default as ASC
         *  2. In below code add if condition for checking orde 
         */
        int arr[] = { 0, 5, 3, 4 };
        System.out.println("Array is sorted " + problems.checkIfSorted(arr, arr.length - 1));

        /**
         * Problem 3: 
         */
        
        problems.generateBitsOfSizeN(0);

        /**
         * Problem 4: extending previous question, instead of 2 bits, now generate n length distinct string from k bits. 
         */

        problems.generateKStrings(5, 3);

    }

    /**
     * TODO: Problem 1: Tower of Hanoi
     */
    public void towerOfHanoi(int n, char from, char aux, char to) {
        if (n == 1) {
            System.out.println("Moved disk 1 from " + from + " to " + to);
            return;
        }
        towerOfHanoi(n - 1, from, aux, to);
        System.out.println("Moving disk from " + from + " to " + to);
        towerOfHanoi(n - 1, aux, to, from);
    }

    /**
     * Problem 2: Check where array is sort using recursion.
     */
    public boolean checkIfSorted(int[] arr, int index) {
        if (index == 1) {
            return arr[index] > arr[index - 1];
        }
        return (arr[index] > arr[index - 1]) && checkIfSorted(arr, index - 1);
    }

    /**
     * Problem 3: Generate all the string of n bits. A[0,n-1] is an array of Size n
     */
    private void generateBitsOfSizeN(int n) {
        if(n == A.length) {
            System.out.println(Arrays.toString(A));
            return;
        }
        A[n] = 0;
        generateBitsOfSizeN(n+1);
        A[n] = 1;
        generateBitsOfSizeN(n+1);
    }

    /**
     * Problem 4: Generate all the Strings of lengh n drawn from 0 to k-1
     * 
     */

     private void generateKStrings(int n, int k) {
         if(n < 1) {
             System.out.println(Arrays.toString(A));
         }
         else {
             for(int j = 0; j < k; j++) {
                 A[n-1] = j;
                 generateKStrings(n-1, k);
             }
         }
     }
}
