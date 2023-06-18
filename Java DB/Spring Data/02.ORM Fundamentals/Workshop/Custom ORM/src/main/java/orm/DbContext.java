package orm;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface DbContext<E> {
    boolean persist(E entity) throws IllegalAccessException, SQLException; //insert or update the entity depending if it is attached to the context

    Iterable<E> find(Class<E> table); //returns collection of all entity objects of type E

    Iterable<E> find(Class<E> table, String where); //returns collection of all entity objects of type T matching the criteria given in "where"

    E findFirst(Class<E> table) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException; //returns the first entity object of type E

    E findFirst(Class<E> table, String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException; //returns the first entity object of type E matching the criteria given in "where"

}
