package Singleton;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
    private static DataStore instance;
    private List<Integer> dataBase;

    private DataStore() {
        this.dataBase = new ArrayList<>();
    }

    public static synchronized DataStore getInstance() { //връща единствената инстанция, тк коструктора е private
        if (instance == null) {
            instance = new DataStore();
        }
        return instance; //създава единствена инстанция!
    }

    public void add(int num){
        dataBase.add(num);
    }

    public int get(int index){
        return dataBase.get(index);
    }

}
