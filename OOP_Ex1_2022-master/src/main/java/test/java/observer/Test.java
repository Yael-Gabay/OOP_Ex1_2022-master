package observer;

public class Test {
    @org.junit.jupiter.api.Test
    public void test(){
        UndoableStringBuilder str = new UndoableStringBuilder();
        GroupAdmin observer = new GroupAdmin(str);

        // Create members.
        ConcreteMember observer1 = new ConcreteMember("Yael");
        observer.register(observer1);
        ConcreteMember observer2 = new ConcreteMember("Chen");
        observer.register(observer2);
        System.out.println("\n Before Appending \n");
        System.out.println("observer memory-" + JvmUtilities.objectFootprint(observer));
        System.out.println("observer1 memory-" + JvmUtilities.objectTotalSize(observer1));
        System.out.println("observer2 memory-" + JvmUtilities.objectTotalSize(observer2));


        observer.append("hello new members...");
        System.out.println("\n After Appending \n");
        System.out.println("observer memory-" + JvmUtilities.objectFootprint(observer));
        System.out.println("observer1 memory-" + JvmUtilities.objectTotalSize(observer1));
        System.out.println("observer2 memory-" + JvmUtilities.objectTotalSize(observer2));
        System.out.println("\n Total memory-" + JvmUtilities.jvmInfo());
    }
}
