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

|Project| Modules |
|-------|---------|
|[apache-commons-codec-1](#apache-commons-codec-1)|1 - 1 - 0|
|[apache-commons-exec-1](#apache-commons-exec-1)|1 - 0 - 0|
|[apache-commons-io-2](#apache-commons-io-2)|1 - 0 - 0|
|[apache-commons-lang-3](#apache-commons-lang-3)|1 - 0 - 0|
|[asm-9](#asm-9)|1 - 0 - 0|
|[gson-2](#gson-2)|1 - 0 - 0|
|[guava-33](#guava-33)|7 - 4 - 3|
|[jackson-core-2](#jackson-core-2)|1 - 0 - 0|
|[jackson-databind-2](#jackson-databind-2)|3 - 0 - 0|
|[junit-4](#junit-4)|2 - 1 - 1|
|[junit-5](#junit-5)|8 - 0 - 0|
|[picocli-4](#picocli-4)|1 - 0 - 0|
|[slf4j-2](#slf4j-2)|1 - 0 - 0|
|[snakeyaml-2](#snakeyaml-2)|1 - 0 - 0|
|[spring-boot-3](#spring-boot-3)|20 - 12 - 0|
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


## apache-commons-codec-1
```
The following files have been resolved:
   commons-codec:commons-codec:jar:1.16.0:compile -- module org.apache.commons.codec [auto]
```

## apache-commons-exec-1
```
The following files have been resolved:
   org.apache.commons:commons-exec:jar:1.4.0:compile -- module org.apache.commons.exec
```

## apache-commons-io-2
```
The following files have been resolved:
   commons-io:commons-io:jar:2.15.1:compile -- module org.apache.commons.io
```

## apache-commons-lang-3
```
The following files have been resolved:
   org.apache.commons:commons-lang3:jar:3.14.0:compile -- module org.apache.commons.lang3
```

## asm-9
```
The following files have been resolved:
   org.ow2.asm:asm:jar:9.6:compile -- module org.objectweb.asm
```

## gson-2
```
The following files have been resolved:
   com.google.code.gson:gson:jar:2.10.1:compile -- module com.google.gson
```

## guava-33
```
The following files have been resolved:
   com.google.guava:guava:jar:33.0.0-jre:compile -- module com.google.common [auto]
   com.google.guava:failureaccess:jar:1.0.2:compile -- module com.google.common.util.concurrent.internal [auto]
   com.google.guava:listenablefuture:jar:9999.0-empty-to-avoid-conflict-with-guava:compile -- module listenablefuture (auto)
   com.google.code.findbugs:jsr305:jar:3.0.2:compile -- module jsr305 (auto)
   org.checkerframework:checker-qual:jar:3.41.0:compile -- module org.checkerframework.checker.qual [auto]
   com.google.errorprone:error_prone_annotations:jar:2.23.0:compile -- module com.google.errorprone.annotations [auto]
   com.google.j2objc:j2objc-annotations:jar:2.8:compile -- module j2objc.annotations (auto)
```

## jackson-core-2
```
The following files have been resolved:
   com.fasterxml.jackson.core:jackson-core:jar:2.16.1:compile -- module com.fasterxml.jackson.core
```

## jackson-databind-2
```
The following files have been resolved:
   com.fasterxml.jackson.core:jackson-databind:jar:2.16.1:compile -- module com.fasterxml.jackson.databind
   com.fasterxml.jackson.core:jackson-annotations:jar:2.16.1:compile -- module com.fasterxml.jackson.annotation
   com.fasterxml.jackson.core:jackson-core:jar:2.16.1:compile -- module com.fasterxml.jackson.core
```

## junit-4
```
The following files have been resolved:
   junit:junit:jar:4.13.2:compile -- module junit [auto]
   org.hamcrest:hamcrest-core:jar:1.3:compile -- module hamcrest.core (auto)
```

## junit-5
```
The following files have been resolved:
   org.junit.jupiter:junit-jupiter:jar:5.10.2:compile -- module org.junit.jupiter
   org.junit.jupiter:junit-jupiter-api:jar:5.10.2:compile -- module org.junit.jupiter.api
   org.opentest4j:opentest4j:jar:1.3.0:compile -- module org.opentest4j
   org.junit.platform:junit-platform-commons:jar:1.10.2:compile -- module org.junit.platform.commons
   org.apiguardian:apiguardian-api:jar:1.1.2:compile -- module org.apiguardian.api
   org.junit.jupiter:junit-jupiter-params:jar:5.10.2:compile -- module org.junit.jupiter.params
   org.junit.jupiter:junit-jupiter-engine:jar:5.10.2:runtime -- module org.junit.jupiter.engine
   org.junit.platform:junit-platform-engine:jar:1.10.2:runtime -- module org.junit.platform.engine
```

## picocli-4
```
The following files have been resolved:
   info.picocli:picocli:jar:4.7.5:compile -- module info.picocli
```

## slf4j-2
```
The following files have been resolved:
   org.slf4j:slf4j-api:jar:2.0.12:compile -- module org.slf4j
```

## snakeyaml-2
```
The following files have been resolved:
   org.yaml:snakeyaml:jar:2.2:compile -- module org.yaml.snakeyaml
```

## spring-boot-3
```
The following files have been resolved:
   org.springframework.boot:spring-boot-starter:jar:3.2.2:compile -- module spring.boot.starter [auto]
   org.springframework.boot:spring-boot:jar:3.2.2:compile -- module spring.boot [auto]
   org.springframework:spring-context:jar:6.1.3:compile -- module spring.context [auto]
   org.springframework:spring-aop:jar:6.1.3:compile -- module spring.aop [auto]
   org.springframework:spring-beans:jar:6.1.3:compile -- module spring.beans [auto]
   org.springframework:spring-expression:jar:6.1.3:compile -- module spring.expression [auto]
   io.micrometer:micrometer-observation:jar:1.12.2:compile -- module micrometer.observation [auto]
   io.micrometer:micrometer-commons:jar:1.12.2:compile -- module micrometer.commons [auto]
   org.springframework.boot:spring-boot-autoconfigure:jar:3.2.2:compile -- module spring.boot.autoconfigure [auto]
   org.springframework.boot:spring-boot-starter-logging:jar:3.2.2:compile -- module spring.boot.starter.logging [auto]
   ch.qos.logback:logback-classic:jar:1.4.14:compile -- module ch.qos.logback.classic
   ch.qos.logback:logback-core:jar:1.4.14:compile -- module ch.qos.logback.core
   org.slf4j:slf4j-api:jar:2.0.11:compile -- module org.slf4j
   org.apache.logging.log4j:log4j-to-slf4j:jar:2.21.1:compile -- module org.apache.logging.log4j.to.slf4j
   org.apache.logging.log4j:log4j-api:jar:2.21.1:compile -- module org.apache.logging.log4j
   org.slf4j:jul-to-slf4j:jar:2.0.11:compile -- module jul.to.slf4j
   jakarta.annotation:jakarta.annotation-api:jar:2.1.1:compile -- module jakarta.annotation
   org.springframework:spring-core:jar:6.1.3:compile -- module spring.core [auto]
   org.springframework:spring-jcl:jar:6.1.3:compile -- module spring.jcl [auto]
   org.yaml:snakeyaml:jar:2.2:compile -- module org.yaml.snakeyaml
```
