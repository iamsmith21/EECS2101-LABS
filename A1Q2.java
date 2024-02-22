/**
 * EECS 2101 N, Winter 2024
 * Assignment 1, Question 2 starter code.
 * Please read carefully the instructions in the assignment handout
 * and the starter code.
 */
package A1;
// Do NOT modify the package declaration

import java.util.ArrayList;

// Do NOT add any import
class Stack {

    ArrayList<Integer> newList = new ArrayList<>();

    void push(int a) {
        newList.add(a);
    }

    int pop() {
        int a = peek();
        newList.remove(newList.size() - 1);
        return a;
    }

    int peek() {
        int a = newList.get(newList.size() - 1);
        return a;
    }

    int size() {
        return newList.size();
    }

}

// You may implement a new class here, such as a Stack or a Queue.
// Any additional class that you use must be included in THIS file.

public class A1Q2 extends Stack {

    /**
     * The function that you need to implement.
     * Read the assignment handout for the specification.
     *
     * DO NOT MODIFY the declaration of the function (its parameter types and return
     * type).
     */
    public static int solve(int[] arr) {
        // TODO: implement this function
        Stack bufferline = new Stack();
        Stack finalStack = new Stack();

        int min = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) {

                finalStack.push(arr[i]);
                min++;
            } else if (bufferline.size() != 0 && bufferline.peek() == min) {
                finalStack.push(bufferline.pop());
                i--;
                min++;
            } else {
                bufferline.push(arr[i]);
            }
        }

        int size = bufferline.size();
        for (int i = 0; i < size; i++) {
            if (bufferline.peek() == finalStack.peek() + 1) {
                finalStack.push(bufferline.pop());
            }
        }
        return finalStack.size();
    }

    /**
     * This main function contains a few test cases that can be used to check
     * that your code compiles and runs. Note that these test cases are NOT
     * complete,
     * and you need to test your code thoroughly with more cases.
     */
    public static void main(String[] args) {

        // Printing "true" means the return value is correct.

        int[] arr = { 4, 5, 2, 1, 3 };
        System.out.println(3 == solve(arr));

        arr = new int[] { 5, 4, 3, 1, 2 };
        System.out.println(5 == solve(arr));

        arr = new int[] { 1 };
        System.out.println(1 == solve(arr));

        arr = new int[] { 2, 3, 1 };
        System.out.println(1 == solve(arr));

        arr = new int[] { 7, 1, 5, 4, 3, 2, 8, 10, 9, 6 };
        System.out.println(6 == solve(arr));
    }
}
