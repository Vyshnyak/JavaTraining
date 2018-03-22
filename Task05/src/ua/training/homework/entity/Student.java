package ua.training.homework.entity;

import ua.training.homework.Marked;

/**
 * Максим
 * 18.03.2018
 */
public class Student {
    private int id;
    private String name;
    private Course course;

    public Student(int id, String name, Course course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Marked
    public void study() {
        System.out.println(name + " is studying!");
    }

    @Marked
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}
