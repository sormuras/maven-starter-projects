import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;

class GenerateReadme {
  public static void main(String... args) throws Exception {
    System.out.println(
        """
        # maven-starter-projects

        Maven-based Starter Projects

        ```shell
        mvn --batch-mode --no-transfer-progress -DoutputFile=resolved.txt dependency:resolve
        ```
        ```shell
        java src/GenerateReadme.java > README.md
        ```
        """);
    var directories = new ArrayList<Path>();
    try (var stream = Files.newDirectoryStream(Path.of("etc"), GenerateReadme::isProjectDirectory)) {
      stream.forEach(directories::add);
    }
    directories.sort(Comparator.comparing(Path::toString));

    // project table
    System.out.println("|Project| Modules |");
    System.out.println("|-------|---------|");
    for (var directory : directories) {
      System.out.print("|[");
      System.out.print(directory.getFileName());
      System.out.print("](#");
      System.out.print(directory.getFileName());
      System.out.print(")|");
      var resolved = directory.resolve("resolved.txt");
      if (Files.isRegularFile(resolved)) {
        var lines = Files.readAllLines(resolved);
        var modules = lines.stream().filter(line -> line.contains(" module ")).toList();
        var manifested = modules.stream().filter(line -> line.endsWith(" [auto]")).toList();
        var filename = modules.stream().filter(line -> line.endsWith(" (auto)")).toList();
        System.out.print(modules.size() + " - " + manifested.size() + " - " + filename.size());
      } else {
        System.out.print(" - ");
      }
      System.out.println("|");
    }

    // project details
    for (var directory : directories) {
      System.out.println();
      System.out.println("## " + directory.getFileName());
      var resolved = directory.resolve("resolved.txt");
      if (Files.isRegularFile(resolved)) {
        System.out.println("```");
        Files.readAllLines(resolved).stream()
            .filter(line -> !line.isBlank())
            .forEach(System.out::println);
        System.out.println("```");
      } else {
        System.out.printf("_No such file: %s_%n", resolved);
      }
    }
  }

  static boolean isProjectDirectory(Path path) {
    return Files.isDirectory(path) && Files.isRegularFile(path.resolve("pom.xml"));
  }
}
