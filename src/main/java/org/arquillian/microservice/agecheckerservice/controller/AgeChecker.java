package org.arquillian.microservice.agecheckerservice.controller;

import javax.enterprise.context.ApplicationScoped;
import java.util.Objects;

@ApplicationScoped
public class AgeChecker {

    public boolean isOldEnough(int userAge, String pegi) {
        Objects.requireNonNull(pegi);
        return userAge >= extractAge(pegi);
    }

    private int extractAge(String pegi) {
        final String age = pegi.substring(pegi.lastIndexOf('_') + 1);
        return Integer.parseInt(age);
    }

}
