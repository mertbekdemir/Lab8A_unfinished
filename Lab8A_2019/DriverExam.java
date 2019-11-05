
/**
 * Write a description of class DriverExam here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class DriverExam
{
    //Symbolic constant
    public static final String[] ANSWERS = {"B","D","A","A","C","A","B","A","C","D","B","C","D","A","D","C","C","B","D","A"}; 

    
    //Fields
    private String[] driverAnswers;
    private InputReader reader; // WHY VARIABLE NAME NEEDS TO BE reader?

    private int numberOfQuestions = ANSWERS.length;

    //Constructor
    public DriverExam(String [] driverAnswersGiven){

        driverAnswers = driverAnswersGiven;
    }

    public void promptStudentAnswers(String [] driverAnswers){
        //reader.InputReader(); // WHY?
        Scanner keyboard  = new Scanner(System.in);
        int index = 0;
        while(index < driverAnswers.length){ // WHY I USED driverAnswers instead of ANSWERS?
            String userResponse;

            System.out.println("Answer for question " + (index + 1));
            //userResponse = reader.readString();
            userResponse = keyboard.nextLine();

            while(!userResponse.equalsIgnoreCase("A") && !userResponse.equalsIgnoreCase("B") && !userResponse.equalsIgnoreCase("C") &&
            !userResponse.equalsIgnoreCase("D")){
                System.out.println("Please enter a valid answer for question " + (index + 1));
                userResponse = keyboard.nextLine();
            }
            index++;
        }
    }

    public int getTotalCorrectAnswers(){
        int index = 0;
        int correctAnswers = 0;
        while(index < ANSWERS.length ){

            if(ANSWERS[ index ].equalsIgnoreCase(driverAnswers[ index ] )){
                correctAnswers = correctAnswers + 1;
            }
            index++;
        }
        return correctAnswers;
    }

    public boolean passed(){
        int passingScore = 15;

        if(getTotalCorrectAnswers() >= passingScore){
            return true;
        }
        return false;
    }

    public int getTotalIncorrectAnswers(){
        int incorrectAnswers = 0;
        int index = 0;
        while(index < ANSWERS.length ){

            if(!(ANSWERS[ index ].equalsIgnoreCase(driverAnswers[ index ] ))){
                incorrectAnswers = incorrectAnswers + 1;
            }
            index++;
        }
        return incorrectAnswers;
    }

    public static void showTestResults(DriverExam driverExamObject){//why i created driverExam type object? // Why I can't access methods without creating object?
        String [] driverAnswers = new String [ANSWERS.length];
        driverExamObject.promptStudentAnswers(driverAnswers);
        
        System.out.println("You got " + driverExamObject.getTotalCorrectAnswers() + " correct answers and " + driverExamObject.getTotalIncorrectAnswers() + " incorrect answers");

        if(driverExamObject.passed()){
            System.out.println("You passed");
        }else{
            System.out.println("You failed");
        }

    }

    public static void main(String[] args){

        String [] driverAnswers = new String [ANSWERS.length];

        DriverExam driverTest = new DriverExam(driverAnswers);

        showTestResults(driverTest);

        
        
    }
}
