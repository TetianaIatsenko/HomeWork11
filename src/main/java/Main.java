import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<String> names = Arrays.asList("AMasha", "CPetya", "BGoscha", "ZGryscha", "DVasya");
        String[] numbers = {"1, 2, 0", "4, 5"};
        TasksClass task = new TasksClass();

        System.out.println(task.getUnPairedString(names));
        System.out.println(task.getSortedList(names));
        System.out.println(task.getSortedNumbers(numbers));
        task.getRandomLongStream(25214903917L, 11, (long) Math.pow(2, 48)).limit(10).forEach(x -> System.out.println(x));
        task.zip(names.stream(), Arrays.stream(numbers)).forEach(x -> System.out.println(x));
    }
}
