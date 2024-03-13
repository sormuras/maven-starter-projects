import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;

class GenerateReadme {
  public static void main(String... args) throws Exception {
    System.out.println(
        // language=markdown
        """
        # Maven Starter Projects

        This repository curates a list of example projects with minimal direct dependencies.
        Each example project is stored as a Maven submodule in the [etc/](etc) directory.
        The `pom.xml` file of an example project usually contains a single `<dependency>` element.
        All dependencies, including transitive dependencies, are then resolved by the standard [maven-dependency-plugin](https://maven.apache.org/plugins/maven-dependency-plugin/).
        The log line of each resolved dependency is parsed for modular markers and summarized in the table below.
        For example:
        - 🧩 `G:A:V -- module foo` denotes a Java module that contains a compiled module descriptor. It therefore provides a stable module name and an explicit modular API using `exports`, `provides`, `opens` and other directives.
        - 🟢 `G:A:V -- module bar [auto]` denotes an automatic Java module, with its stable module name derived from the `Automatic-Module-Name` manifest entry. Its API is derived from JAR content and therefore may not be stable.
        - ⚪ `G:A:V -- module baz (auto)` denotes an automatic Java module, with its not stable module name derived from the JAR filename. Its API is derived from JAR content and therefore may not be stable.

        An `<Name> | n | n | 0 | 0` row indicates a 100% modularized project:
        its dependencies are at **Level 3** on the [Modular Maturity Model](https://nipafx.dev/java-modules-jpms-maturity-model/).
        """);
    var directories = new ArrayList<Path>();
    try (var stream =
        Files.newDirectoryStream(Path.of("etc"), GenerateReadme::isProjectDirectory)) {
      stream.forEach(directories::add);
    }
    directories.sort(Comparator.comparing(Path::toString));

    // project summary table
    System.out.println("|Project| Dependencies | 🧩 | 🟢 | ⚪ |");
    System.out.println("|-------|-------------:|----:|----:|----:|");
    for (var directory : directories) {
      System.out.print("|[");
      System.out.print(directory.getFileName());
      System.out.print("](#");
      System.out.print(directory.getFileName());
      System.out.print(")| ");
      var resolved = directory.resolve("resolved.txt");
      if (Files.isRegularFile(resolved)) {
        var lines = Files.readAllLines(resolved);
        var modules = lines.stream().filter(line -> line.contains(" module ")).toList();
        var manifested = modules.stream().filter(line -> line.endsWith(" [auto]")).toList();
        var filename = modules.stream().filter(line -> line.endsWith(" (auto)")).toList();
        System.out.print(modules.size());
        System.out.print(" | ");
        System.out.print(modules.size() - manifested.size() - filename.size());
        System.out.print(" | ");
        System.out.print(manifested.size());
        System.out.print(" | ");
        System.out.print(filename.size());
      } else {
        System.out.print(" ? | ? | ? ");
      }
      System.out.println(" |");
    }

    System.out.println(
        // language=markdown
        """
        ---
        Add a new project by running and edit the generated `etc/<Name>/pom.xml` file if required:
        - `<Name>` is short directory name describing the project
        - `<GroupId>:<ArtifactId>:<Version>` is a Maven coordinate to add as a dependency
        ```shell
        java src/AddProject.java <Name> <GroupId>:<ArtifactId>:<Version>
        ```
        ---
        Rebuild the `README.md` file by running the following commands:
        ```shell
        mvn --batch-mode --no-transfer-progress -DoutputFile=resolved.txt org.apache.maven.plugins:maven-dependency-plugin:3.6.1:resolve
        ```
        ```shell
        java src/GenerateReadme.java > README.md
        ```
        ---
        """);

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
