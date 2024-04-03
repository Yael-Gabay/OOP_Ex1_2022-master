package observer;
import java.util.ArrayList;

/**
 * The following class implements the Sender class
 * as part of Ex1 OOP 2022
 *
 * @author Chen Lipschitz, Yael Gabay
 */

public class GroupAdmin implements Sender{

    private final ArrayList <Member> clients;
    private final UndoableStringBuilder status;

    /**
     * Constructor method
     */
    public GroupAdmin() {
        this.clients = new ArrayList<Member>();
        this.status = new UndoableStringBuilder();
    }

    /**
     * Registers the new given client by adding him to the clients list
     * @param obj a new client (Member type)
     */
    //@Override
    public void register(Member obj) {
        this.clients.add(obj);
    }

    /**
     * Unregisters the given client by removing him from the clients list
     * @param obj the to be removed client
     */
    //@Override
    public void unregister(Member obj) {
        this.clients.remove(obj);
    }

    /**
     * Loop all clients and notify each one about the last operation that was made
     */
    public void notifyClients(){
        for (Member client : this.clients) {
            client.update(status);
        }
    }

    /**
     * Inserts the string into this character sequence, by using the append method from UndoableStringBuilder
     * After appending the relevant string, notify all clients about the operation
     * @param offset the offset
     * @param obj a string
     */
    //@Override
    public void insert(int offset, String obj) {
        this.status.insert(offset, obj);
        notifyClients();
    }

    /**
     * Appends the given string to the status, by using the append method from UndoableStringBuilder
     * After appending the relevant string, notify all clients about the operation
     * @param obj the added string
     */
    //@Override
    public void append(String obj) {
        this.status.append(obj);
        notifyClients();
    }

    /**
     * Removes the characters in a substring of this sequence, by using the delete method from UndoableStringBuilder
     * After appending the relevant string, notify all clients about the operation
     * @param start The deleting beginning index, inclusive.
     * @param end The deleting ending index, exclusive.
     */
    //@Override
    public void delete(int start, int end) {
        this.status.delete(start, end);
        notifyClients();
    }

    /**
     * The method reverts the last command
     */
    //@Override
    public void undo() {
        this.status.undo();
        notifyClients();
    }

    /**
     * Returns the clients array list
     * @return a collection of members
     */
    public ArrayList<Member> getClients() {
        return this.clients;
    }

    /**
     * Gets the status
     * @return an UndoableStringBuilder type
     */
    public UndoableStringBuilder getStatus() {
        return this.status;
    }

    /**
     * Returns the objects info
     * @return String
     */
    @Override
    public String toString() {
        return "GroupAdmin{" +
                "situations=" + this.status +
                '}';
    }

}
