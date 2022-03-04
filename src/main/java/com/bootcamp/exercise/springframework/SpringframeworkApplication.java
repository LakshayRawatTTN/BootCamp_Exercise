package com.bootcamp.exercise.springframework;

import com.bootcamp.exercise.springframework.looseCoupled.LearningPortalLooseCoupled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringframeworkApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                SpringApplication.run(SpringframeworkApplication.class, args);

        LearningPortalLooseCoupled submittingExercise =
                applicationContext.getBean(LearningPortalLooseCoupled.class);

        submittingExercise.bootCampExercise();

    }

}
