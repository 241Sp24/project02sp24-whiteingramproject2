/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package StudentDriver;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author S564997
 */
public class StudentDriver{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException  {
        StudentFees[] students = new StudentFees[12];
        File file = new File("input.csv");
        Scanner scan = new Scanner(file);
        Scanner scan1 = new Scanner(System.in);
        System.out.print("Enter the no of UG students: ");
        int ugS = scan1.nextInt();
        System.out.print("Enter the no of Graduate students: ");
        int gS = scan1.nextInt();
        System.out.print("Enter the no of online students: ");
        int oS = scan1.nextInt();
        int line = 0;
        
        while(scan.hasNext()){
            String[] v = scan.next().split(",");
            if(line < 5){
                students[line] = new UGStudent(Integer.parseInt(v[0]), v[1], Boolean.parseBoolean(v[2]), Integer.parseInt(v[3]), Boolean.parseBoolean(v[4]), Double.parseDouble(v[5]));
            }
            else if(line < 9 && v.length == 6){
               
                students[line] = new GraduateStudent(Integer.parseInt(v[0]), v[1], Boolean.parseBoolean(v[2]), Integer.parseInt(v[3]), Boolean.parseBoolean(v[4]), v[5]);
            }
            else if(line < 9 && v.length == 5){
                students[line] = new GraduateStudent(Integer.parseInt(v[0]), v[1], Boolean.parseBoolean(v[2]), Integer.parseInt(v[3]), Boolean.parseBoolean(v[4]));
            }
            else{
                students[line] = new OnlineStudent(Integer.parseInt(v[0]), v[1], Boolean.parseBoolean(v[2]), Integer.parseInt(v[3]));
            }
            line++;
        }
        double ugAvgFee;
        int ugScholCount = 0;
        int ugTotalCourses = 0;
        double  gAvgFee;
        int gAssistantCount = 0;
        int gTotalCourses = 0;
        double oAvgFee;
        
        System.out.println("*********Undergraduate students list*********");
        int line1 = 0;
        double temp1 = 0;
        for(int i=0; i<ugS; i++){
            System.out.println(students[line1].toString());
            if(((UGStudent) students[line1]).getCoursesEnrolled() > 0){
                temp1 += students[line1].getPayableAmount();
                if(((UGStudent) students[line1]).isHasScholarship()){
                    ugScholCount++;
                }
                ugTotalCourses+=((UGStudent) students[line1]).getCoursesEnrolled();
            }
            
            line1++;
            
        }
        ugAvgFee = temp1/ugS;
        temp1 = 0;
        
        System.out.println("*********Graduate students list*********");
        for(int i=0; i<gS; i++){
            System.out.println(students[line1].toString());
            if(((GraduateStudent) students[line1]).getCoursesEnrolled() > 0){
                temp1 += students[line1].getPayableAmount();
                if(((GraduateStudent) students[line1]).isIsGraduateAssistant()){
                    gAssistantCount++;
                }
                gTotalCourses+=((GraduateStudent) students[line1]).getCoursesEnrolled();
            }
            line1++;
        }
        gAvgFee = temp1/gS;
        temp1 = 0;
        
        System.out.println("*********Online students list*********");
        for(int i=0; i<oS; i++){
            System.out.println(students[line1].toString());
            temp1+= students[line1].getPayableAmount();
            line1++;
        }
        oAvgFee = temp1/oS;
       
        System.out.println("*********Undergraduate Students Details*********");
        System.out.println("Average Students fee: " + ugAvgFee + "\nScholarship count: " + ugScholCount + "\nTotal number of courses: " + ugTotalCourses);
        System.out.println("\n*********Graduate Students Details*********");
        System.out.println("Average Students fee: " + gAvgFee + "\nGraduate Assistantship count: " + gAssistantCount + "\nTotal number of courses: " + gTotalCourses);
        System.out.println("\n*********Online Students Details*********");
        System.out.println("Average Students fee: " + oAvgFee);
    }   
    
}
