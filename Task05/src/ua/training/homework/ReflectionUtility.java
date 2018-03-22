package ua.training.homework;

import ua.training.homework.entity.Student;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Максим
 * 21.03.2018
 */
public class ReflectionUtility {
    private Student student;
    private Class studentClass;

    public ReflectionUtility(Student student) {
        this.student = student;
        this.studentClass = student.getClass();
    }

    public void invokeAllMarkedMethods()
            throws InvocationTargetException, IllegalAccessException {
        for (Method method : studentClass.getDeclaredMethods()) {
            for (Annotation annotation : method.getDeclaredAnnotations()) {
                if (annotation instanceof Marked) {
                    method.invoke(student);
                }
            }
        }
    }

    public void printClassName() {
        System.out.println(studentClass.getSimpleName());
    }

    public void printSuperClassName() {
        System.out.println(studentClass.getSuperclass().getSimpleName());
    }

    public void printMethodsWithAccessModifiersAndParameterTypes() {
        for (Method method : studentClass.getDeclaredMethods()) {
            String[] parameterTypes = Arrays.stream(method.getParameterTypes())
                    .map(Class::getSimpleName)
                    .toArray(String[]::new);
            System.out.println(String.format("%s %s %s", Modifier.toString(method.getModifiers()),
                    method.getName(), Arrays.toString(parameterTypes)));
        }
    }
}
