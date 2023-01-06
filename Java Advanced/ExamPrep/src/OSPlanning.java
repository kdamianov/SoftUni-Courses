import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //contains all the tasks LIFO
        ArrayDeque<Integer> tasks = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).forEach(tasks::push);

        //contains all the thread FIFO
        ArrayDeque<Integer> threads = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(threads::offer);

        int endTask = Integer.parseInt(scanner.nextLine());

        int task = tasks.peek();
        int thread = threads.peek();

        while(task != endTask) {

            if (thread >= task) {
                tasks.pop();
            }

            threads.poll();


            task = tasks.peek();
            thread = threads.peek();
        }
        System.out.println("Thread with value " + threads.peek() + " killed task " + endTask);

        String leftThreads = threads.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(leftThreads);
    }
}
