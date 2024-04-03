# OOP_Ex1_2022

The following project focus on design patterns.

In this project we have implemented UndoableStringBuilder in Java by using the Observer design pattern.
In Fact, there are 3 main classes- Gruop Admin, Member, UndoableStringBuilder.

The group admin class contains a collection of members and whenever a change in the UndoableStringBuilder object is made the group admin notifies all the members-
sends them the updated value/content of the UndoableStringBuilder object.

### Extra Info About The Observer Design Pattern: 
Observer Pattern is one of the behavioral design patterns.
The observer pattern is a software design pattern in which an object, named the subject, maintains a list of its dependents, called observers,
and notifies them automatically of any state changes, usually by calling one of their methods. (for more information click <a href="https://en.wikipedia.org/wiki/Observer_pattern">here</a>)

![image](https://github.com/ChenLipschitz/OOP_Ex1_2022/blob/master/notificationsSmallIMG.jpg)


## The Project's Files:

* Member, Interface-
Represents the member.

* Sender, Interface-
Represents the sender.

* UndoableStringBuilder, Class-
Represents an UndoanleStringBuilder object (using Java's StringBuilder).

* ConcreteMember, Class -
Implements the Member interface.
Represents the observer in the Observer design pattern.

* GroupAdmin, Class-
Implements the Sender interface.
Represents the subject in the Observer design pattern.

* ConcreteMemberTest, Test-
Tests the ConcreteMember class.

* GroupAdminTest, Test-
Tests the GroupAdmin class.

* JvmUtilities, Class-
Utility class for tracking the Java Virtual Machine resources allocated by the Operating System.

The Results:
![image](https://github.com/ChenLipschitz/OOP_Ex1_2022/blob/master/Jvm-%20before%20appending.jpeg)
![image](https://github.com/ChenLipschitz/OOP_Ex1_2022/blob/master/Jvm-%20after%20appending.jpeg)


## How To Run?
Download the project and run on your own IDE.

Enjoy!

## Bibliography
* <a href="https://en.wikipedia.org/wiki/Observer_pattern">Wikipedia</a>

## Authors
* @YaelGabay
* @ChenLipschitz
