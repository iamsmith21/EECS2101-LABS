/**
 * EECS 2101 N, Winter 2024.
 * Assignment 2, Question 2 starter code.
 * Please read carefully the instructions in the assignment handout
 * and the starter code.
 */
//Name: Smith Patel
//Student No. 219347301
package A2;
// Do NOT change the package!

import java.util.ArrayList;

// Do NOT add any import!
/**
 * The A2Q2 class
 */
public class A2Q2 {

    /**
     * A class representing a single move in the TOH solution,
     * i.e., moving the disk at the top of fromPeg to the top of toPeg
     * Note: a move is invalid if it results in a larger disk being above a smaller
     * disk.
     *
     * DO NOT MODIFY THIS CLASS.
     */
    public static class Move {

        private final int fromPeg;
        private final int toPeg;

        public Move(int from, int to) {
            this.fromPeg = from;
            this.toPeg = to;
        }

        public String toString() {
            return String.format("%d to %d", this.fromPeg, this.toPeg);
        }

        public int getFromPeg() {
            return this.fromPeg;
        };

        public int getToPeg() {
            return this.toPeg;
        };
    }

    /**
     * Return the sequence of moves that solves the 3-peg TOH problem with n disks.
     * Assumptions:
     * - The pegs are numbered 1, 2, 3
     * - The origin peg is 1.
     * - The destination peg is 2.
     * - n > 0
     */
    public static ArrayList<Move> threePegTOH(int n) {
        // TODO: Complete this method
        ArrayList<Move> moves = new ArrayList<>();
        moveDisk(n, 1, 2, 3, moves);
        // System.out.println(moves.size());
        return moves; // Placeholder return statement. Should be changed when the method is
                      // implemented..
    }

    public static void moveDisk(int n, int start, int destination, int intermediate, ArrayList<Move> moves) {
        if (n == 1) {
            moves.add(new Move(start, destination));
        } else {
            moveDisk(n - 1, start, intermediate, destination, moves);
            moves.add(new Move(start, destination));
            moveDisk(n - 1, intermediate, destination, start, moves);
        }
    }

    /**
     * Return the sequence of moves that solves the 4-peg TOH problem with n disks,
     * with the strategy described in the assignment handout
     * Assumptions:
     * - The pegs are numbered 1, 2, 3, 4
     * - The origin peg is 1.
     * - The destination peg is 2.
     * - n > 0
     */
    public static ArrayList<Move> fourPegTOH(int n) {

        // TODO: Complete this method
        ArrayList<Move> moves4 = new ArrayList<>();
        moveDisk4(n, 1, 2, 3, 4, moves4);
        // System.out.println(moves4.size());
        return moves4; // Placeholder return statement. Should be changed when the method is
                       // implemented..
    }

    public static void moveDisk4(int n, int source, int destination, int i1, int i2, ArrayList<Move> moves) {
        if (n == 1) {
            moves.add(new Move(source, destination));
        } else {
            int k = (int) Math.ceil(Math.log(n) / Math.log(2));
            // int k = (n / 2);
            moveDisk4(n - k, source, i1, destination, i2, moves);
            moveDisk(k, source, destination, i2, moves);
            moveDisk4(n - k, i1, destination, source, i2, moves);
        }
    }

    public static void main(String[] args) {

        System.out.println(threePegTOH(3));
        System.out.println(fourPegTOH(3));
    }
}
