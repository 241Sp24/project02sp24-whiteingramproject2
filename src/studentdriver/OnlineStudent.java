
package studentdriver;

/**
 *
 * @author S564997
 */
public class OnlineStudent extends StudentFees{
    private int noOfMonths;
    private double MONTHLY_FEE = 1245.25;
    
    public OnlineStudent(int studentID, String studentName, boolean isEnrolled, int noOfMonths){
        super(studentName, studentID, isEnrolled);
        this.noOfMonths = noOfMonths;
    }
    
    public double getPayableAmount(){
        return noOfMonths * MONTHLY_FEE;
    }
    
    public String toString(){
        return "Student name: " + super.getStudentName() + "\nStudent id: " + super.getStudentID() + "\nEnrolled: " + isIsEnrolled() + "\nNo of months: " + noOfMonths + "\nPayable amount: " + getPayableAmount() + "\n";
    }
}