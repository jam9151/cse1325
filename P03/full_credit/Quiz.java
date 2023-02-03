//written by Jesse McNary 1/30/23
import java.util.Scanner;


public class Quiz{
    
    private Question[] questions = new Question[5];

    public Quiz(){
        loadQuiz();

    }

    private void loadQuiz(){
        
        //question 1
        String firstQuestion = "What does logical 1 + 1 equal?";
        String[] firstAnswer = {"0", "1", "2", "3"};
        int firstRightAnswer = 1;
        
        //question 2
        String secondQuestion = "What is the best programming language to learn OOP in?";
        String[] secondAnswer = {"python", "C", "C++", "Java"};
        int secondRightAnswer = 3;
        
        //question 3
        String thirdQuestion = "Who created Linux?";
        String[] thirdAnswer = {"Linus Torvald", "Jeff Bezos", "Elon Musk", "Mark Zukerberg"};
        int thirdRightAnswer = 1;
        
        //question 4
        String fourthQuestion = "What does print(Hello World) do in Java?))";
        String[] fourthAnswer = {"Nothing", "Prints Hello World", "Prints ABCD", "Shuts down OS"};
        int fourthRightAnswer = 1;
        
        //question 5
        String fifthQuestion = "How do you print to System.err?";
        String[] fifthAnswer = {"System.err.println()", "err.println()", "System.err()", "println()"};
        int fifthRightAnswer = 1;



        //Sets Question objects to correct index in questions[]
        this.questions[0] = new Question(firstQuestion, firstAnswer, firstRightAnswer);
        
        this.questions[1] = new Question(secondQuestion, secondAnswer, secondRightAnswer);
        
        this.questions[2] = new Question(thirdQuestion, thirdAnswer, thirdRightAnswer);
        
        this.questions[3] = new Question(fourthQuestion, fourthAnswer, fourthRightAnswer);
        
        this.questions[4] = new Question(fifthQuestion, fifthAnswer, fifthRightAnswer);

        // Question firstQuestion = new Question();
        



        
    }
    public double takeQuiz(){
        
        
        double gradeCounter = 0.00;
        

        System.out.println("\nWelcome to the quiz, you will be presented with 5 questions\n");




        for(Question i: questions){
            
            System.out.println(i + "\nEnter your choice(1,2,3,4): ");
            
            Scanner choice = new Scanner(System.in);
            
            int myChoice = choice.nextInt();

            if(i.checkAnswer(myChoice)){
                gradeCounter = gradeCounter + 100.00;
            }

        }

        double totalGrade = gradeCounter / 5;



        return gradeCounter;
    }





}