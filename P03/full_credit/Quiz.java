//written by Jesse McNary 1/30/23
import java.util.Scanner;


public class Quiz{
    
    private Question[] questions = new Question[2];

    public Quiz(){
        loadQuiz();

    }

    private void loadQuiz(){
        
        //question 1
        String firstQuestion = "What does logical 1 + 1 equal?";
        String[] firstAnswer = {"0", "1", "2", "3"};
        int firstRightAnswer = 2;
        
        //question 2
        String secondQuestion = "What is the best programming language to learn OOP in?";
        String[] secondAnswer = {"python", "C", "C++", "Java"};
        int secondRightAnswer = 4;
        
        



        //Sets Question objects to correct index in questions[]
        this.questions[0] = new Question(firstQuestion, firstAnswer, firstRightAnswer);
        
        this.questions[1] = new Question(secondQuestion, secondAnswer, secondRightAnswer);
        
        

        // Question firstQuestion = new Question();
        



        
    }
    public double takeQuiz(){
        
        
        double gradeCounter = 0.00;
        

        System.out.println("\nWelcome to the quiz, you will be presented with 5 questions\n");

        // System.out.println(questions[0]);
        // System.out.println(questions[1]);
        // System.out.println(questions[2]);
        // System.out.println(questions[3]);
        // System.out.println(questions[4]);



        for(Question i: questions){
            
            System.out.println(i + "\nEnter your choice(1,2,3,4): ");
            
            Scanner choice = new Scanner(System.in);
            
            int myChoice = choice.nextInt();

            if(i.checkAnswer(myChoice)){
                gradeCounter = gradeCounter + 100.00;
            }

        }

        double totalGrade = gradeCounter / 2;



        return totalGrade;
    }





}