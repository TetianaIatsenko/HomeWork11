import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TasksClass {
    public String getUnPairedString(List<String> names){
        if(names == null)
            return "";
        String result = IntStream
                        .range(0, names.size())
                        .filter(i -> i % 2 != 0)
                        .mapToObj(i -> i + ". " + names.get(i))
                        .collect(Collectors.joining(", "));
        return result;
    }
    public List<String> getSortedList(List<String> list){
        return list.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
    //["1, 2, 0", "4, 5"]
    public String getSortedNumbers(String [] numbers){
        if(numbers == null)
            return "";
        IntStream result = IntStream.range(0, numbers.length)
                .flatMap(i -> Arrays.stream(numbers[i].split(", ")).mapToInt(num -> Integer.parseInt(num)));
        return result.sorted().mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(", "));
    }

    public Stream<Long> getRandomLongStream(long a, long c, long m){
        return Stream.iterate(0L, n -> (a * n + c) % m);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        Stream stream = Stream.of();
        if (first == null || second == null)
            return stream;
        Iterator<T> iteratorFirst = first.iterator();
        Iterator<T> iteratorSecond = second.iterator();
        while (iteratorFirst.hasNext() && iteratorSecond.hasNext()){
            stream = Stream.concat(stream, Stream.concat(Stream.of(iteratorFirst.next()), Stream.of(iteratorSecond.next())));
        }
        return stream;
    }
}
