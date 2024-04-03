package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ConcreteMemberTest {

    @Test
    void update() {
        UndoableStringBuilder str = new UndoableStringBuilder();
        GroupAdmin observer = new GroupAdmin(str);

        // Create members.
        ConcreteMember observer1 = new ConcreteMember("Yael");
        observer.register(observer1);
        ConcreteMember observer2 = new ConcreteMember("Chen");
        observer.register(observer2);

        // Change with append the Status and see if update was successful.
        observer.append("hello world!");
        assertEquals("hello world!", observer.getStatus().toString());

        // Unsubscribe observer2 (Chen) and check who got the update.
        observer.unregister(observer2);
        observer.undo();
        assertEquals("", observer.getStatus().toString());
    }
}