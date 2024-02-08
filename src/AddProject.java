import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

class AddProject {
  public static void main(String... args) throws Exception {
    if (args.length != 2) {
      System.out.println("Usage:");
      System.out.println("  java src/AddProject.java <Name> <GroupId>:<ArtifactId>:<Version>");
      System.out.println("Example:");
      System.out.println("  java src/AddProject.java snakeyaml-2 org.yaml:snakeyaml:2.2");
      return;
    }
    var name = args[0];
    var root = Path.of("etc", name);
    if (Files.exists(root)) {
      throw new IllegalArgumentException("Project already exists: " + root);
    }
    var coordinates = args[1].split(":");
    if (coordinates.length != 3) {
      throw new IllegalArgumentException("Illegal Maven coordinates: " + args[1]);
    }
    var group = coordinates[0];
    var artifact = coordinates[1];
    var version = coordinates[2];

    Files.createDirectories(root);
    Files.writeString(
        root.resolve("pom.xml"),
        // language=xml
        """
        <?xml version="1.0" encoding="UTF-8"?>
        <project>
            <modelVersion>4.0.0</modelVersion>
            <groupId>org.example</groupId>
            <artifactId>${name}</artifactId>
            <version>1</version>
            <dependencies>
                <dependency>
                    <groupId>${group}</groupId>
                    <artifactId>${artifact}</artifactId>
                    <version>${version}</version>
                </dependency>
            </dependencies>
        </project>
        """
            .replace("${name}", name)
            .replace("${group}", group)
            .replace("${artifact}", artifact)
            .replace("${version}", version));
    // insert project as a Maven module and sort them all
    var path = Path.of("pom.xml");
    var lines = new ArrayList<>(Files.readAllLines(path));
    var start = lines.indexOf("    <modules>") + 1;
    lines.add(start, "        <module>etc/%s</module>".formatted(name));
    var end = lines.indexOf("    </modules>");
    Collections.sort(lines.subList(start, end));
    Files.write(path, lines);
  }
}
