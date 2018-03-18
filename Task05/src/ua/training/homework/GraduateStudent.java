package ua.training.homework;

/**
 * Максим
 * 18.03.2018
 */
public class GraduateStudent extends Student {
    private String thesis;

    public GraduateStudent(int id, String name, Course course, String thesis) {
        super(id, name, course);
        this.thesis = thesis;
    }

    public String getThesis() {
        return thesis;
    }

    public void setThesis(String thesis) {
        this.thesis = thesis;
    }

    @Marked
    public void study() {
        System.out.println(
                String.format("%s is writing diploma entitled \"%s\"", getName(), thesis));
    }

    @Marked
    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", course=" + getCourse() +
                ", thesis=" + thesis +
                '}';
    }
}
