package com.bootcamp.exercise.springframework.looseCoupled;

import com.bootcamp.exercise.springframework.tightlyCoupled.LearningPortal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

interface SubmitExercise {

    void submit();

}

@Component
class SubmitByDoc implements SubmitExercise {
    public void submit() {
        System.out.println("Submitted By Google Docs ");
    }
}

@Component
@Primary
class SubmitByGitHub implements SubmitExercise {
    public void submit() {
        System.out.println("Submitted By GitHub");
    }
}

@Component
public class LearningPortalLooseCoupled {

    @Autowired
    private SubmitExercise submitExercise;

    LearningPortalLooseCoupled(SubmitExercise submitExercise) {

        this.submitExercise = submitExercise;
    }

    public void bootCampExercise() {

        submitExercise.submit();

    }

}