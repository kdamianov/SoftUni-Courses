package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //get the class
        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        //get the constructor
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        //set the c-tor accessible
        constructor.setAccessible(true);
        //make instance ot BlackBoxInt with the c-tor
        BlackBoxInt blackBoxInt = constructor.newInstance();

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        //get the "innerValue" field
        Field hiddenValue = clazz.getDeclaredField("innerValue");
        //set it accessible
        hiddenValue.setAccessible(true);

        while(!"END".equals(command)) {
            String[] commandParts = command.split("_");
            String methodName = commandParts[0];
            int argument = Integer.parseInt(commandParts[1]);
            //get the corresponding method
            Method method = clazz.getDeclaredMethod(methodName, int.class);
            //set it accessible
            method.setAccessible(true);
            //invoke the current method
            method.invoke(blackBoxInt, argument);

            System.out.println(hiddenValue.get(blackBoxInt));

            command = scanner.nextLine();
        }
    }
}
