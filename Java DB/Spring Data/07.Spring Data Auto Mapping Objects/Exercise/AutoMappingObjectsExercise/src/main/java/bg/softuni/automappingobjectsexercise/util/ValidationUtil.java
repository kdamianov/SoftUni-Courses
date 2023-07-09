package bg.softuni.automappingobjectsexercise.util;

import jakarta.validation.ConstraintViolation;

import java.util.Set;

public interface ValidationUtil {
    <E> boolean isValid(E entity);

    <E> Set<ConstraintViolation<E>> getViolations(E entity);
    //валидира дали дадено entity е валидно и връща колекция от нарушения
}
