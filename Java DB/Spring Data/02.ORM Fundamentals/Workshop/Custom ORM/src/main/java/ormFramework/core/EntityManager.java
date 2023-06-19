package ormFramework.core;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface EntityManager {

    <T> T findById(int id, Class<T> type) throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;

    // TODO: We try to implement part of this :)))


    <T> boolean persist(T entity) throws IllegalAccessException, SQLException;

    <T> boolean delete(T entity) throws IllegalAccessException, SQLException;

    <T> boolean alterTable(T entity) throws SQLException;

}
