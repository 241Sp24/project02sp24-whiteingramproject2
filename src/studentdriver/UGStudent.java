/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentDriver;

/**
 *
 * @author S564997
 */
public class UGStudent extends StudentFees{
    
    private double scholarshipAmount;
    private int coursesEnrolled;
    private boolean hasScholarship;
    private double ADDITIONAL_FEE = 820.70;
    
    public UGStudent( int studentID, String studentName, boolean isEnrolled, int coursesEnrolled, boolean hasScholarship, double scholarshipAmount){
        super(studentName, studentID, isEnrolled);
        this.scholarshipAmount = scholarshipAmount;
        this.coursesEnrolled = coursesEnrolled;
        this.hasScholarship = hasScholarship;
    }
    
    public boolean isHasScholarship(){
        return hasScholarship;
    }
    
    public double getScholarshipAmount(){
        return scholarshipAmount;
    }
    
    public int getCoursesEnrolled(){
        return coursesEnrolled;
    }
    
    public double getPayableAmount(){
        double temp = (coursesEnrolled * super.getCREDITS_PER_COURSE() * super.getPER_CREDIT_FEE()) + ADDITIONAL_FEE;
        if(hasScholarship){
            temp -= scholarshipAmount;
        }
        return temp;
    }
    
    public String toString(){
        if(!hasScholarship){
            scholarshipAmount = 0;
        }
        return "Student name: " + super.getStudentName() + "\nStudent id: " + super.getStudentID() + "\nEnrolled: " + isIsEnrolled() + "\nScholarship: " + hasScholarship + "\nScholarship amount: " + scholarshipAmount + "\nCourses enrolled: " + coursesEnrolled + "\nPayable amount: " + getPayableAmount() + "\n";
    }
    
}

