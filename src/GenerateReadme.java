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

        This repository curates a list of projects with minimal dependencies.
        Each project is stored as a Maven submodule in the [etc/](etc/) directory.
        The `pom.xml` file of a project usually contains a single `<dependency>` element.
        All dependencies, including transitive ones, are then resolved by the standard [maven-dependency-plugin](https://maven.apache.org/plugins/maven-dependency-plugin/).

        The numbers in the Modules columns, for example `8 - 3 - 2`, are in order of appearance:
        - `8` is the total amount of resolved artifacts
        - `3` automatic modules, with their **stable** name derived from an `Automatic-Module-Name` manifest entry
        - `2` automatic modules, with their **not** stable name derived from the archive filename

        An `* - 0 - 0` indicates an 100% modularized project:
        its dependencies are at **Level 3** on the [Modular Maturity Model](https://nipafx.dev/java-modules-jpms-maturity-model/).
        """);
    var directories = new ArrayList<Path>();
    try (var stream =
        Files.newDirectoryStream(Path.of("etc"), GenerateReadme::isProjectDirectory)) {
      stream.forEach(directories::add);
    }
    directories.sort(Comparator.comparing(Path::toString));

    // project summary table
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

    System.out.println(
        // language=markdown
        """
        ---
        Add a new project by running:
        ```shell
        java src/AddProject.java <Name> <GroupId>:<ArtifactId>:<Version>
        ```
        - `<Name>` is short directory name describing the project
        - `<GroupId>:<ArtifactId>:<Version>` is a Maven coordinate to add as a dependency

        Edit the generated `etc/<Name>/pom.xml` file as required. 
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
