package observer;

import java.util.ArrayList;
import java.util.List;


/**
 * The following class is implementation of the StringBuilder class as
 * part of Ex0 OOP 2022
 *
 * @author Chen Lipschitz, Yael Gabay
 */

class UndoableStringBuilder {
    // index-> represents the index of the last string in the list

    private int index;
    private List<String> operationsList;
    private StringBuilder stringBuilder;

    /**
     * default constructor
     */
    public UndoableStringBuilder() {
        this("");
    }

    /**
     * UndoableStringBuilder Constructor
     */
    public UndoableStringBuilder(String str) {
        this.index = 0;
        this.stringBuilder = new StringBuilder(str);
        this.operationsList = new ArrayList<String>();
        this.operationsList.add(this.toString());
    }

    /**
     * toString override
     * @return text
     */
    @Override
    public String toString(){   //overriding the toString() method

        return this.stringBuilder.toString();
    }

    /**
     * Appends the specified string to this character sequence.
     * The characters of the String argument are appended,
     * in order, increasing the length of this sequence by the length of the argument.
     * If str is null, then the four characters "null" are appended.
     * @param str the added string
     * @return a reference to this object.
     */
    public UndoableStringBuilder append(String str){

        try {
            this.stringBuilder.append(str);
        } catch (Exception ex) {
            throw ex;
        }

        this.operationsList.add(this.stringBuilder.toString());
        this.index++;

        return this;
    }

    /**
     * Removes the characters in a substring of this sequence.
     * The substring begins at the specified start and extends to the character at index end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     * @param start The beginning index, inclusive.
     * @param end The ending index, exclusive.
     * @return This object
     */
    public UndoableStringBuilder delete(int start, int end) {
        try {
            this.stringBuilder.delete(start, end);
        } catch (Exception ex) {
            throw ex;
        }

        this.operationsList.add(this.stringBuilder.toString());
        this.index++;

        return this;
    }


    /**
     * Causes this character sequence to be replaced by the reverse of the sequence.
     * If there are any surrogate pairs included in the sequence, these are treated as single characters for the reverse operation.
     * Thus, the order of the high-low surrogates is never reversed.
     * Let n be the character length of this character sequence (not the length in char values) just prior to execution of the reverse method.
     * Then the character at index k in the new character sequence is equal to the character at index n-k-1 in the old character sequence.
     * @return the UndoableStringBuilder object
     */
    public UndoableStringBuilder reverse() {

        this.stringBuilder.reverse();
        this.operationsList.add(this.stringBuilder.toString());
        this.index++;

        return this;
    }

    /**
     * Replaces the characters in a substring of this sequence with characters in the specified String.
     * The substring begins at the specified start and extends to the character at index end - 1 or to the end of the sequence if no such character exists.
     * First the characters in the substring are removed and then the specified String is inserted at start.
     * (This sequence will be lengthened to accommodate the specified String if necessary.)
     * @param start The beginning index, inclusive.
     * @param end The ending index, exclusive.
     * @param str String that will replace previous contents.
     * @return the UndoableStringBuilder object
     */
    public UndoableStringBuilder replace(int start, int end, String str){
        try {
            this.stringBuilder.replace(start, end, str);
        } catch (Exception ex) {
            throw ex;
        }

        this.operationsList.add(this.stringBuilder.toString());
        this.index++;

        return this;
    }

    /**
     * Inserts the string into this character sequence.
     * The characters of the String argument are inserted, in order, into this sequence at the indicated offset,
     * moving up any characters originally above that position and increasing the length of this sequence by the length of the argument.
     * If str is null, then the four characters "null" are inserted into this sequence.
     * @param offset the offset.
     * @param str a string
     * @return a reference to this object
     */
    public UndoableStringBuilder insert(int offset, String str){
        try {
            this.stringBuilder.insert(offset, str);
        } catch (Exception ex) {
            throw ex;
        }

        this.operationsList.add(this.stringBuilder.toString());
        this.index++;

        return this;
    }

    /**
     * The method reverts the last command
     */
    public void undo(){
        if (this.index > 0) {
            this.operationsList.remove(this.index);
            String newStr = this.operationsList.get(this.index - 1);
            this.stringBuilder = new StringBuilder(newStr);
            this.index--;
        }
    }
}
