package io.github.mnote.validation;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class UserTest {

    @Test(expected = ConstraintViolationException.class)
    public void validateOfBlankElement(){

        User user = new User();
        user.setWorking(true);
        user.setAboutMe("Its all about me!");
        user.setAge(50);

        user.addPreferences("movies");
        user.addPreferences("");

    }

    @Test(expected = ConstraintViolationException.class)
    public void validateOfNullElement(){

        User user = new User();
        user.setWorking(true);
        user.setAboutMe("Its all about me!");
        user.setAge(50);

        user.addPreferences("movies");
        user.addPreferences(null);

    }

    @Test(expected = ConstraintViolationException.class)
    public void validateOfNullFiled(){

        User user = new User();
        user.setWorking(true);
        user.setAboutMe("Its all about me!");
        user.setAge(50);

        user.addPreferences("movies");

        System.out.println(user);
        System.out.println(user.getAge());

        System.out.println(user.getName());

    }


    @Test
    public void validateOfCodeCall(){

        User user = new User();
        user.setWorking(true);
        user.setAboutMe("Its all about me!");
        user.setAge(50);

        user.addPreferences("123");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        for (ConstraintViolation<User> violation : violations) {
            System.out.println(violation.getMessage());
        }

    }

}
