package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GroupAdminTest {

    @Test
    void notifyClients() {
        UndoableStringBuilder str = new UndoableStringBuilder();
        GroupAdmin observer = new GroupAdmin(str);

        ConcreteMember observer1 = new ConcreteMember("Yeal");
        observer.register(observer1);
        observer.append("hello");
        assertEquals("hello", observer.getStatus().toString());
        ConcreteMember observer2 = new ConcreteMember("Chen");
        observer.register(observer2);
        assertEquals("", observer2.getUsbConcreteMember().toString());
        observer.notifyClients();
        assertEquals("hello", observer2.getUsbConcreteMember().toString());
    }

    @Test
    void register() {
        UndoableStringBuilder str = new UndoableStringBuilder();
        GroupAdmin observer = new GroupAdmin(str);

        ConcreteMember observer1 = new ConcreteMember("Yael");
        observer.register(observer1);
        ConcreteMember observer2 = new ConcreteMember("Chen");
        observer.register(observer2);
        ConcreteMember observer3 = new ConcreteMember("Chen");
        observer.register(observer3);
        observer.register(observer3);
        System.out.println(observer);
    }

    @Test
    void unregister() {
        UndoableStringBuilder str = new UndoableStringBuilder();
        GroupAdmin observer = new GroupAdmin(str);

        ConcreteMember observer1 = new ConcreteMember("Yael");
        observer.register(observer1);
        ConcreteMember observer2 = new ConcreteMember("Chen");
        observer.register(observer2);

        observer.append("Observer");
        assertEquals("Observer", observer.getStatus().toString());
        observer.unregister(observer1);
        observer.unregister(observer1);
        observer.delete(6,8);
        observer.append("able");
        assertEquals("Observable", observer2.getUsbConcreteMember().toString());
    }

    @Test
    void insert() {
        UndoableStringBuilder str = new UndoableStringBuilder();
        GroupAdmin observer = new GroupAdmin(str);

        ConcreteMember observer1 = new ConcreteMember("Yael");
        observer.register(observer1);
        observer.insert(0, "hello");
        assertEquals("hello", observer.getStatus().toString());
        observer.insert(5, "!");
        assertEquals("hello!", observer.getStatus().toString());
        assertThrows(StringIndexOutOfBoundsException.class, ()-> {
            observer.insert(-2, "he");
        });
    }

    @Test
    void append() {
        UndoableStringBuilder str = new UndoableStringBuilder();
        GroupAdmin observer = new GroupAdmin(str);

        ConcreteMember observer1 = new ConcreteMember("Yael");
        observer.register(observer1);
        observer.append("");
        assertEquals("", observer.getStatus().toString());
        observer.append("hello");
        assertEquals("hello", observer.getStatus().toString());
        ConcreteMember observer2 = new ConcreteMember("Chen");
        observer.register(observer2);
        observer.append("!");
        assertEquals("hello!", observer.getStatus().toString());
    }

    @Test
    void delete() {
        UndoableStringBuilder str = new UndoableStringBuilder();
        GroupAdmin observer = new GroupAdmin(str);

        // Create member and register him.
        ConcreteMember observer1 = new ConcreteMember("Yael");
        observer.register(observer1);
        observer.delete(0,1);
        assertEquals("", observer.getStatus().toString());

        observer.append("hello");
        assertEquals("hello", observer.getStatus().toString());
        observer.delete(1,3);
        assertEquals("hlo", observer.getStatus().toString());

        assertThrows(StringIndexOutOfBoundsException.class, ()-> {
            observer.delete(-3, 1);
        });


    }

    @Test
    void undo() {
        UndoableStringBuilder str = new UndoableStringBuilder();
        GroupAdmin observer = new GroupAdmin(str);
        assertEquals("", observer.getStatus().toString());

        ConcreteMember observer1 = new ConcreteMember("Yael");
        observer.register(observer1);
        ConcreteMember observer2 = new ConcreteMember("Chen");
        observer.register(observer2);
        observer.undo();
        assertEquals("", observer.getStatus().toString());
        observer.append("hello members");
        observer.append("");
        assertEquals("hello members", observer.getStatus().toString());
        observer.undo();
        assertEquals("hello members", observer.getStatus().toString());
        observer.undo();
        assertEquals("", observer.getStatus().toString());
    }
}