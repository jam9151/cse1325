//written by Jesse McNary 1/30/23

public class Question{
    
    private String question;
    private String[] answers;
    private int rightAnswer;
    
    private final int questionNumber;
    private static int nextQuestionNumber = 1;

    public Question(String question, String[] answers, int rightAnswer){
        if (rightAnswer < 1 || rightAnswer > answers.length){
            throw new IllegalArgumentException("Right Answer must be greater or equal to 1 and less than the number of answers!\n");
         
        }else{
            this.question = question;
            this.answers = answers;
            this.rightAnswer = rightAnswer;
            this.questionNumber = nextQuestionNumber++;
        }
    }
    
    public boolean checkAnswer(int answer){
        
        if(answer == this.rightAnswer){
            return true;

        }
        else{
            return false;
        }

    }

    @Override
    public String toString() {

        return ("" + questionNumber + ". " + question + "\n   1) " + answers[0] + "\n   2) " + answers[1] +"\n   3) " + answers[2] + "\n   4) " + answers[3] + "\n\n");
    
    }




}