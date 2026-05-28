import module java.base;

class ForEachProject {
  public static void main(String... args) throws Exception {
    if (args.length == 0) {
      IO.println("""
      Usage:
        java src/ForEachProject.java <Shell Command>
      Example:
        java src/ForEachProject.java cmd /C dir
      """);
      System.exit(1);
    }
    try (var directories =
        Files.newDirectoryStream(
            Path.of("etc"),
            path -> Files.isDirectory(path) && Files.isRegularFile(path.resolve("pom.xml")))) {
      for (var directory : directories) {
        var replaced =
            Stream.of(args)
                .map(arg -> arg.replace("NAME", directory.getFileName().toString()))
                .toList();
        IO.println(String.join(" ", replaced));
        var process = new ProcessBuilder(replaced).inheritIO().start();
        var result = process.waitFor();
        if (result == 0) continue;
        System.exit(result); // fail fast
      }
    }
  }
}
