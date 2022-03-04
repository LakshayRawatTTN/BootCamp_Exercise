package com.bootcamp.exercise.springframework.tightlyCoupled;

class SubmitExercise {
    public void submitAssignment() {
        SubmitByDoc submitByDoc = new SubmitByDoc();
        submitByDoc.submit();
    }
}

class SubmitByDoc {
    public void submit() {
        System.out.println("Submitted By Google Docs");
    }
}

class SubmitByGithub {
    public void submit() {
        System.out.println("Submitted By Github Repository");
    }
}

public class LearningPortal {
    public void bootCampExercise() {
        SubmitExercise submitExercise = new SubmitExercise();
        submitExercise.submitAssignment();
    }

    public static void main() {
        LearningPortal learningPortal = new LearningPortal();
        learningPortal.bootCampExercise();
    }

}
