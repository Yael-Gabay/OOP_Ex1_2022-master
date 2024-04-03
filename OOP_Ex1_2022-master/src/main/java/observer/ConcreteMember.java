package observer;

/**
 * The following class implements the Member class
 * as part of Ex1 OOP 2022
 *
 * @author Chen Lipschitz, Yael Gabay
 */

public class ConcreteMember implements Member{

    private UndoableStringBuilder usbConcreteMember;
    private String nameUsbCM = "";

    //Constructor method
    public ConcreteMember(String name){
        this.usbConcreteMember = new UndoableStringBuilder();
        this.nameUsbCM = name;
    }

    /**
     * Update usbConcreteMember
     * @param usb an object, UndoableStringBuilder type
     */
    //@Override
    public void update(UndoableStringBuilder usb) {
        usbConcreteMember = usb;
    }

    /**
     * Returns the object's name
     * @return name
     */
    public String getNameUsbCM() {
        return nameUsbCM;
    }
    
    /**
     * Returns usbConcreteMember
     * @return UndoableStringBuilder object
     */
    public UndoableStringBuilder getUsbConcreteMember() {
        return usbConcreteMember;
    }

    /**
     * Returns the object's details as a string
     * @return string
     */
    @Override
    public String toString() {
        return "ConcreteMember{" +
                "usbConcreteMember=" + usbConcreteMember +
                ", nameUsbCM='" + nameUsbCM + '\'' +
                '}';
    }
}
