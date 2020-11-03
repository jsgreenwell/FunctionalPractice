import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) throws IOException {
    String basicString = "I am a BAsiC String";

    // What functional programming have you already done involving those circuits?
    // That passing of values from 1 method to the next?

    //System.out.println(basicString.toLowerCase().indexOf("c")); // This is FP - METHOD CHAINING

    String line = "3,4,5,61,78,120";
    List<Integer> values = new ArrayList<>();
    int sum = 0;

    // Imperial (Procedural or OOP) style
    for (String field : line.split(",")) {
      int realField = Integer.parseInt(field);
      values.add(realField);
      sum += realField;
    }
    System.out.println("Sum = " + sum);

    for (int i : values) {
      System.out.println(i);
    }

    System.out.println("\n");

    List<Integer> fValues = Stream.of(line.split(","))
        .map(Integer::parseInt)
        .collect(Collectors.toList());

    // System.out.println("Sum = " + fValues.stream().reduce(0, Integer::sum));
    System.out.println("Sum of 2x each = " + fValues.stream().mapToInt(number -> number * 2).sum());
    //                                                                 para      body
    fValues.forEach(System.out::println);
    //                        :: DO TO ALL PARAMETERS

    Files.lines(Path.of("src/blah.txt"))
        .filter(curLine -> !curLine.isEmpty())
        .forEach(System.out::println);

    List<String> firstNames = Files.lines(Path.of("src/blah.txt"))
        .filter(curLine -> !curLine.isEmpty())
        .filter(name -> name.toLowerCase().startsWith("j"))
        .sorted()
        .collect(Collectors.toList());

    System.out.println("The good names are: ");
    firstNames.forEach(System.out::println);

    long numOfGoodNames = Files.lines(Path.of("src/blah.txt"))
        .filter(curLine -> !curLine.isEmpty())
        .filter(name -> name.toLowerCase().startsWith("j"))
        .count();

    System.out.printf("Which means theirs %d good names", numOfGoodNames);
  }
}
