package lab;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayList<T> extends ArrayList<T> {
    public Object getRandomElement(){
        int index = ThreadLocalRandom.current().nextInt(0, super.size()); //A random number generator (with period 264) isolated to the current thread. Like the global Random generator used by the Math class,

        return get(index);
    }
}
