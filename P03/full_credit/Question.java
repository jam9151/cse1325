//written by Jesse McNary 1/30/23

public class Question{
    
    private String question;
    private String[] answers;
    private int rightAnswer;
    
    private final int questionNumber;
    private static int nextQuestionNumber = 1;

    public Question(String question, String[] answers, int rightAnswer){
        if (rightAnswer < 1 || rightAnswer > answer.length){
            throw new IllegalArguementException("Right Answer must be greater or equal to 1 and less than the number of answers!\n");
         
        }else{
            question.self = question;
            answers.self = answers;
            rightAnswer.self = rightAnswer;
            questionNumber.self = nextQuestionNumber++;



        }
    }
    public boolean checkAnswer(int answer){
        

    }

    @Override
    public String toString() {

        return ("1." + question + "\n 1) " + answers[0] + "/n 2)" + answers[1] +"\n 3) " + answers[2] + "/n 4) " + answers[4] + "\n");
    
    }




}