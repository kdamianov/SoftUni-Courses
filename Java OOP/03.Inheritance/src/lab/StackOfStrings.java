package lab;

import java.util.ArrayDeque;
import java.util.Deque;
//75/100 , защото иска полето да е тип List ->нонсенс!!!!
public class StackOfStrings {
    private Deque<String> data;

    public StackOfStrings(Deque<String> data) {
        this.data = new ArrayDeque<>();
    }

    public void push(String element){
        data.push(element);
    }
    public String pop(){
        return data.pop();
    }
    public String peek(){
        return data.peek();
    }
    public boolean isEmpty(){
        return data.isEmpty();
    }

}
