package ua.training.homework;

import ua.training.homework.entity.Course;
import ua.training.homework.entity.GraduateStudent;
import ua.training.homework.entity.Student;

import java.lang.reflect.InvocationTargetException;

/**
 * Максим
 * 18.03.2018
 */
public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        // #1 Show usage of classes
        Student student = new Student(1, "Igor", Course.SECOND);
        Student graduateStudent = new GraduateStudent(1, "Maksym", Course.FIFTH, "Content Marketing");
        System.out.println("=================================");

        // #2 traverse through all the methods of the class and invoke ones with annotation
        ReflectionUtility utility = new ReflectionUtility(graduateStudent);
        utility.invokeAllMarkedMethods();
        System.out.println("=================================");

        // #3 print class and super class name, print all class methods with modifiers and parameter types
        utility.printClassName();
        utility.printSuperClassName();
        utility.printMethodsWithAccessModifiersAndParameterTypes();
        System.out.println("=================================");
    }
}
