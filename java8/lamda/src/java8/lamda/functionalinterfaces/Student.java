package java8.lamda.functionalinterfaces;

import java.util.List;

public class Student {
    private String name;
    private int gradeLeve;
    private double gpa;
    private String gender;
    private List<String> activities;

    public Student() {

    }

    public Student(String name) {
        this.name =name;
    }

    public void printListOfActivites(){
        System.out.println(activities);
    }

    public Student(String name, int gradeLeve, double gpa, String gender, List<String> activities) {
        this.name = name;
        this.gradeLeve = gradeLeve;
        this.gpa = gpa;
        this.gender = gender;
        this.activities =activities;
    }

    public String getName() {
        return name;
    }

    public int getGradeLevel() {
        return gradeLeve;
    }

    public double getGpa() {
        return gpa;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGradeLeve(int gradeLeve) {
        this.gradeLeve = gradeLeve;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gradeLeve=" + gradeLeve +
                ", gpa=" + gpa +
                ", gender='" + gender + '\'' +
                ", activities=" + activities +
                '}';
    }
}
