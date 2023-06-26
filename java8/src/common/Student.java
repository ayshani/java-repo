package common;

import streams.Bike;

import java.util.List;
import java.util.Optional;

public class Student {
    private String name;
    private int gradeLevel;
    private double gpa;
    private String gender;
    private List<String> activities;
    private int noteBookes;
    private Optional<Bike> bike = Optional.empty();


    public Student(String name, int gradeLeve, double gpa, String gender, List<String> activities, int noteBookes) {
        this.name = name;
        this.gradeLevel = gradeLeve;
        this.gpa = gpa;
        this.gender = gender;
        this.activities = activities;
        this.noteBookes = noteBookes;
    }

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
        this.gradeLevel = gradeLeve;
        this.gpa = gpa;
        this.gender = gender;
        this.activities =activities;
    }

    public String getName() {
        return name;
    }

    public int getGradeLevel() {
        return gradeLevel;
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
        this.gradeLevel = gradeLeve;
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

    public int getNoteBookes() {
        return noteBookes;
    }

    public void setNoteBookes(int noteBookes) {
        this.noteBookes = noteBookes;
    }

    public Optional<Bike> getBike() {
        return bike;
    }

    public void setBike(Optional<Bike> bike) {
        this.bike = bike;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gradeLevel=" + gradeLevel +
                ", gpa=" + gpa +
                ", gender='" + gender + '\'' +
                ", activities=" + activities +
                ", noteBookes=" + noteBookes +
                ", bike=" + bike +
                '}';
    }
}
