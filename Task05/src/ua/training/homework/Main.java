package ua.training.homework;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Максим
 * 18.03.2018
 */
public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        // #1 Show usage of classes
        Student[] students = {new Student(1, "Igor", Course.SECOND),
                new GraduateStudent(1, "Maksym", Course.FIFTH, "Content Marketing")};
        teach(students);
        System.out.println("=================================");

        // #2 traverse through all the methods of the class and invoke ones with annotation
        Student graduateStudent = students[1];
        Class studentClass = graduateStudent.getClass();
        Method[] methods = studentClass.getDeclaredMethods();
        invokeAllMarkedMethods(graduateStudent, methods);
        System.out.println("=================================");

        // #3 print class and super class name, print all class methods with modifiers and parameter types
        printClassName(studentClass);
        printClassName(studentClass.getSuperclass());
        printMethodsWithAccessModifiersAndParameterTypes(methods);
        System.out.println("=================================");
    }

    private static void teach(Student... students) {
        for (Student student : students) {
            student.study();
        }
    }

    private static void invokeAllMarkedMethods(Student student, Method... methods)
            throws InvocationTargetException, IllegalAccessException {
        for (Method method : methods) {
            for (Annotation annotation : method.getDeclaredAnnotations()) {
                if (annotation instanceof Marked) {
                    method.invoke(student);
                }
            }
        }
    }

    private static void printClassName(Class studentClass) {
        System.out.println(studentClass.getSimpleName());
    }

    private static void printMethodsWithAccessModifiersAndParameterTypes(Method... methods) {
        for (Method method : methods) {
            String[] parameterTypes = Arrays.stream(method.getParameterTypes())
                    .map(Class::getSimpleName)
                    .toArray(String[]::new);
            System.out.println(String.format("%s %s %s", Modifier.toString(method.getModifiers()),
                    method.getName(), Arrays.toString(parameterTypes)));
        }
    }
}
