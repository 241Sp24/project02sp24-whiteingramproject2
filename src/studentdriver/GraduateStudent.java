/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentDriver;

/**
 *
 * @author S564997
 */
public class GraduateStudent extends StudentFees{
    private int coursesEnrolled;
    private boolean isGraduateAssistant;
    private String graduateAssistantType;
    private double ADDITIONAL_FEES = 654.45;
    
    public GraduateStudent(int studentID, String studentName, boolean isEnrolled, int coursesEnrolled, boolean isGraduateAssistant, String graduateAssistantType){
        super(studentName, studentID, isEnrolled);
        this.isGraduateAssistant = isGraduateAssistant;
        this.graduateAssistantType = graduateAssistantType;
        this.coursesEnrolled = coursesEnrolled;
    }
    
    public GraduateStudent(int studentID, String studentName, boolean isEnrolled, int coursesEnrolled, boolean isGraduateAssistant){
        super(studentName, studentID, isEnrolled);
        this.isGraduateAssistant = isGraduateAssistant;
        this.coursesEnrolled = coursesEnrolled;
        this.graduateAssistantType = "";
    }
    
    public boolean isIsGraduateAssistant(){
        return isGraduateAssistant;
    }
    
    public int getCoursesEnrolled(){
        return coursesEnrolled;
    }
    
    public double getPayableAmount(){
        double temp = coursesEnrolled * super.getCREDITS_PER_COURSE() * super.getPER_CREDIT_FEE();
        if(graduateAssistantType.equals("full")){
            temp = 0;
        }
        else if(graduateAssistantType.equals("half")){
            temp /= 2;
        }
        return temp + ADDITIONAL_FEES;
        
    }
    
    public String toString(){
        return "Student name: " + super.getStudentName() + "\nStudent id: " + super.getStudentID() + "\nEnrolled: " + isIsEnrolled() + "\nGraduate Assistant: " + isGraduateAssistant + "\nGraduate assistant type: " + graduateAssistantType + "\nCourses Enrolled: " + coursesEnrolled + "\nPayable amount: " + getPayableAmount() + "\n";
    }
}

