package java8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chuck
 * @since 4/30/16
 */
public class HelloJava8 {

  public static void testCollectionStream() {
    List<String> list = new ArrayList<>();
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("e");
    list.stream().forEach(System.out::println);
    list.stream().filter(s -> s.equals("a"));
    list.stream().forEach(System.out::println);
    list.stream().anyMatch(s -> s.equals("c"));
  }

  public static void testFiles() {
    try {
      Files.list(new File("/tmp").toPath())
          .forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    testCollectionStream();

    testFiles();
  }
}
