# maven-starter-projects

Maven-based Starter Projects

```shell
mvn --batch-mode --no-transfer-progress -DoutputFile=resolved.txt dependency:resolve
```
```shell
java src/GenerateReadme.java > README.md
```

|Project| Modules |
|-------|---------|
|[apache-commons-io-2](#apache-commons-io-2)|1 - 0 - 0|
|[apache-commons-lang-3](#apache-commons-lang-3)|1 - 0 - 0|
|[jackson-json-2](#jackson-json-2)|1 - 0 - 0|
|[junit-4](#junit-4)|2 - 1 - 1|
|[junit-5](#junit-5)|8 - 0 - 0|
|[picocli-4](#picocli-4)|1 - 0 - 0|

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

## jackson-json-2
```
The following files have been resolved:
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
