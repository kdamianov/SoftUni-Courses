package bg.softuni.automappingobjectsexercise.util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component//задължителна анотация, за да може да се inject-ва на различни места
public class ValidationUtilImpl implements ValidationUtil {
    private final Validator validator;// инциализираме Валидатор

    public ValidationUtilImpl() {
        this.validator = Validation
                .buildDefaultValidatorFactory()
                .getValidator();
    }

    @Override
    public <E> boolean isValid(E entity) {
        return validator.validate(entity).isEmpty();
        //.isEmpty(), за да върне празна колекция от нарушения, ако е валидно;
    }

    @Override
    public <E> Set<ConstraintViolation<E>> getViolations(E entity) {
        return validator.validate(entity);
    }
}
