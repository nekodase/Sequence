import java.util.Arrays;
import java.util.Random;


class NotYetImplementedException extends Exception {
    public NotYetImplementedException(String s) {
        super("NotYetImplementedException: " + s);
    }
}


/**
 *  A class that implements integer sequencing, such as indexing, swapping, and subsequencing. Made by me.
 *  Designed to replace the java array indexing system that is absolutely bullshit and user-unfriendly by a functional python-style indexing system.
 */
public class Sequence {
    public int[] sequence = {};
    public int length = 0;

    /**
     *  Default initialisation. Boolean argument initialise_random will initialise a random sequence.
     */
    public Sequence(int sequence_length, boolean initialise_random) {
        this.sequence = new int[sequence_length];
        this.length = sequence_length;
        if (initialise_random){
            Random r = new Random();
            for (int i = 0; i < this.length; i++) this.sequence[i] = r.nextInt(sequence_length*10);
        }
    }

    /**
     *  Will override the default constructor and set the sequence with a custom array you provide.
     */
    public Sequence(int[] arr) {
        this.sequence = arr;
        this.length = arr.length;
    }

    /**
     *  Will override the default constructor and set the sequence with a custom sequence object you provide.
     */
    public Sequence(Sequence seq) {
        this.sequence = seq.sequence;
        this.length = seq.length;
    }

    /**
     *  This will construct an empty sequence object.
     */
    public Sequence() {
    }

    /**
     *  Returns the element at index i.
     */
    public int at(int i) {
        try {
            return this.sequence[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("Index " + i + " is out of bounds for sequence length " + this.sequence.length + ". Terminating now.");
            System.exit(1);
            return 0;
        }
    }

    /**
     *  Returns the element at index i. 
     *  Alias of Sequence.at(int i) method.
     */
    public int index(int i) {
        return this.at(i);
    }

    /**
     *  Appends a new element.
     */
    public Sequence append(int e) {
        if (this.length == 0) {
            int[] temp = {e};
            return new Sequence(temp);
        }
        int[] temp = new int[this.length+1];
        System.arraycopy(this.sequence, 0, temp, 0, this.length);
        temp[this.length] = e;
        this.sequence = temp;
        this.length++;
        return this;
    }

    /**
     *  Joins two sequence objects inplace(to the original instance).
     */
    public Sequence append(Sequence seq) {
        int[] temp = new int[this.length + seq.length];
        System.arraycopy(this.sequence, 0, temp, 0, this.length);
        System.arraycopy(seq.sequence, 0, temp, this.length, seq.length);
        this.sequence = temp;
        this.length += seq.length;
        return this;
    }

    /**
     *  Joins two sequence objects inplace(to the original instance).
     */
    public Sequence append(int[] arr) {
        int[] temp = new int[this.length + arr.length];
        System.arraycopy(this.sequence, 0, temp, 0, this.length);
        System.arraycopy(arr, 0, temp, this.length, arr.length);
        this.sequence = temp;
        this.length += arr.length;
        return this;
    }

    /**
     *  Returns a new sequence object with two sequences joined.
     */
    public Sequence joined(Sequence seq) {
        int[] temp = new int[this.length + seq.length];
        System.arraycopy(this.sequence, 0, temp, 0, this.length);
        System.arraycopy(seq.sequence, 0, temp, this.length, seq.length);
        return new Sequence(temp);
    }

    /**
     *  Returns a new sequence object with two sequences joined.
     */
    public Sequence joined(int[] arr) {
        int[] temp = new int[this.length + arr.length];
        System.arraycopy(this.sequence, 0, temp, 0, this.length);
        System.arraycopy(arr, 0, temp, this.length, arr.length);
        return new Sequence(temp);
    }

    /**
     *  Swaps elements index i and j inplace.
     */
    public Sequence swap(int i, int j) {
        try {
            boolean a = (this.sequence[i] == this.sequence[j]);
            if (a) return this;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("Indices " + i + ", " + j + " is out of bounds for sequence length " + this.sequence.length + ". Terminating now.");
            System.exit(1);
        }

        int temp = this.sequence[i];
        this.sequence[i] = this.sequence[j];
        this.sequence[j] = temp;

        return this;
    }

    /**
     *  Returns a new sequence object with the indices i, j swapped.
     */
    public Sequence swapped(int i, int j) {
        try {
            boolean a = (this.sequence[i] == this.sequence[j]);
            if (a) return this;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("Indices " + i + ", " + j + " is out of bounds for sequence length " + this.sequence.length + ". Terminating now.");
            System.exit(1);
        }

        int[] temp = new int[this.length];
        System.arraycopy(this.sequence, 0, temp, 0, this.length);
        
        int x = temp[i];
        temp[i] = temp[j];
        temp[j] = x;

        return new Sequence(temp);
    }

    /**
     *  Returns a new Sequence object that is a subsequence of the original instance from index i to j. 
     *  Python-style indexing.
     */
    public Sequence subSequence(int i, int j) {
        try {
            boolean unused = (this.sequence[i] == this.sequence[j]);
            if (i == j) {
                int[] b = {this.at(i)};
                return new Sequence(b);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("Indices " + i + ", " + j + " is out of bounds for sequence length " + this.sequence.length + ". Terminating now.");
            System.exit(1);
        }

        if (i > j) {
            try {throw new NotYetImplementedException("Python-style reverse indexing is not implemented yet.");}
            catch (NotYetImplementedException e) {
                System.out.print(e.getMessage() + " Given indices are " + i + ", " + j + " with sequence " + this.toString() + ".");
                System.exit(1);
            }
        }

        int[] temp = new int[j-i];
        System.arraycopy(this.sequence, i, temp, 0, j-i);
        return new Sequence(temp);
    }

    /**
     *   Returns a new Sequence object that is a subsequence of the original instance from index i to j. 
     *   Python-style indexing.
     *   Alias of Sequence.at(int i) method.
     */
    public Sequence index(int i, int j) {
        return this.subSequence(i, j);
    }

    /**
     *  Creates a string-ified sequence. What did you expect?
     */
    public String toString() {
        return Arrays.toString(this.sequence);
    }

    /**
     *  Prints the sequence. What did you expect?
     */
    public void println() {
        System.out.println(this.toString());
    }

    /**
     *  Prints the sequence. What did you expect?
     */
    public void print() {
        System.out.print(this.toString());
    }
}