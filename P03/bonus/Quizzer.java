//written by Jesse McNary 1/30/23
public class Quizzer{
    public static void main(String[] args){
    
    try{


    
        Quiz quiz = new Quiz();
        double gradeScore = quiz.takeQuiz();

        System.out.println("Your Grade was " + gradeScore);
    }   
    catch (Exception e){

        System.err.println("Error has occured." + e.getMessage());
        System.exit(-1);


    }

        
    }

}

