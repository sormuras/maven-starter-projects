# Maven Starter Projects

This repository curates a list of example projects with minimal direct dependencies.
Each example project is stored as a Maven submodule in the [etc/](etc/) directory.
The `pom.xml` file of an example project usually contains a single `<dependency>` element.
All dependencies, including transitive dependencies, are then resolved by the standard [maven-dependency-plugin](https://maven.apache.org/plugins/maven-dependency-plugin/).
The log line of each resolved dependency is parsed for modular markers and summarized in the table below.
For example:
- 🧩 `G:A:V -- module foo` denotes a Java module that contains a compiled module descriptor. It therefore provides a stable module name and an explicit modular API using `exports`, `provides`, `opens` and other directives.
- 🟢 `G:A:V -- module bar [auto]` denotes an automatic Java module, with its stable module name derived from the `Automatic-Module-Name` manifest entry. Its API is derived from JAR content and therefore may not be stable.
- ⚪ `G:A:V -- module baz (auto)` denotes an automatic Java module, with its not stable module name derived from the JAR filename. Its API is derived from JAR content and therefore may not be stable.

An `<Name> | n | n | 0 | 0` row indicates a 100% modularized project:
its dependencies are at **Level 3** on the [Modular Maturity Model](https://nipafx.dev/java-modules-jpms-maturity-model/).

|Project| Dependencies | 🧩 | 🟢 | ⚪ |
|-------|-------------:|----:|----:|----:|
|[apache-commons-codec-1](#apache-commons-codec-1)| 1 | 0 | 1 | 0 |
|[apache-commons-exec-1](#apache-commons-exec-1)| 1 | 1 | 0 | 0 |
|[apache-commons-io-2](#apache-commons-io-2)| 1 | 1 | 0 | 0 |
|[apache-commons-lang-3](#apache-commons-lang-3)| 1 | 1 | 0 | 0 |
|[asm-9](#asm-9)| 1 | 1 | 0 | 0 |
|[gson-2](#gson-2)| 1 | 1 | 0 | 0 |
|[guava-33](#guava-33)| 7 | 0 | 4 | 3 |
|[helidon-se-4](#helidon-se-4)| 61 | 50 | 4 | 7 |
|[jackson-core-2](#jackson-core-2)| 1 | 1 | 0 | 0 |
|[jackson-databind-2](#jackson-databind-2)| 3 | 3 | 0 | 0 |
|[junit-4](#junit-4)| 2 | 0 | 1 | 1 |
|[junit-5](#junit-5)| 8 | 8 | 0 | 0 |
|[micronaut-4](#micronaut-4)| 35 | 7 | 28 | 0 |
|[picocli-4](#picocli-4)| 1 | 1 | 0 | 0 |
|[quarkus-3](#quarkus-3)| 102 | 32 | 29 | 41 |
|[slf4j-2](#slf4j-2)| 1 | 1 | 0 | 0 |
|[snakeyaml-2](#snakeyaml-2)| 1 | 1 | 0 | 0 |
|[spring-boot-3](#spring-boot-3)| 20 | 8 | 12 | 0 |
|[streamex-0](#streamex-0)| 1 | 1 | 0 | 0 |
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

## helidon-se-4
```
The following files have been resolved:
   io.helidon.webserver:helidon-webserver:jar:4.0.5:compile -- module io.helidon.webserver
   io.helidon.http:helidon-http:jar:4.0.5:compile -- module io.helidon.http
   io.helidon.common:helidon-common-configurable:jar:4.0.5:compile -- module io.helidon.common.configurable
   io.helidon.common:helidon-common-buffers:jar:4.0.5:compile -- module io.helidon.common.buffers
   io.helidon.common:helidon-common-mapper:jar:4.0.5:compile -- module io.helidon.common.mapper
   io.helidon.common:helidon-common-media-type:jar:4.0.5:compile -- module io.helidon.common.media.type
   io.helidon.common:helidon-common-uri:jar:4.0.5:compile -- module io.helidon.common.uri
   io.helidon.common:helidon-common-parameters:jar:4.0.5:compile -- module io.helidon.common.parameters
   io.helidon.common:helidon-common-socket:jar:4.0.5:compile -- module io.helidon.common.socket
   io.helidon.builder:helidon-builder-api:jar:4.0.5:compile -- module io.helidon.builder.api
   io.helidon.common:helidon-common-context:jar:4.0.5:compile -- module io.helidon.common.context
   io.helidon.common:helidon-common-key-util:jar:4.0.5:compile -- module io.helidon.common.pki
   io.helidon.common:helidon-common-security:jar:4.0.5:compile -- module io.helidon.common.security
   io.helidon.common:helidon-common-task:jar:4.0.5:compile -- module io.helidon.common.task
   io.helidon.common:helidon-common-tls:jar:4.0.5:compile -- module io.helidon.common.tls
   io.helidon.logging:helidon-logging-common:jar:4.0.5:compile -- module io.helidon.logging.common
   io.helidon.http.media:helidon-http-media:jar:4.0.5:compile -- module io.helidon.http.media
   io.helidon.http.encoding:helidon-http-encoding:jar:4.0.5:compile -- module io.helidon.http.encoding
   io.helidon.common.features:helidon-common-features:jar:4.0.5:compile -- module io.helidon.common.features
   io.helidon.common.features:helidon-common-features-api:jar:4.0.5:compile -- module io.helidon.common.features.api
   io.helidon.config:helidon-config-yaml:jar:4.0.5:compile -- module io.helidon.config.yaml
   io.helidon.config:helidon-config:jar:4.0.5:compile -- module io.helidon.config
   io.helidon.inject:helidon-inject-api:jar:4.0.5:compile -- module io.helidon.inject.api
   io.helidon.common:helidon-common-types:jar:4.0.5:compile -- module io.helidon.common.types
   jakarta.inject:jakarta.inject-api:jar:2.0.1:compile -- module jakarta.inject
   io.helidon.common:helidon-common:jar:4.0.5:compile -- module io.helidon.common
   org.yaml:snakeyaml:jar:2.0:compile -- module org.yaml.snakeyaml
   io.helidon.webserver.observe:helidon-webserver-observe-health:jar:4.0.5:compile -- module io.helidon.webserver.observe.health
   io.helidon.webserver.observe:helidon-webserver-observe:jar:4.0.5:compile -- module io.helidon.webserver.observe
   io.helidon.webserver:helidon-webserver-cors:jar:4.0.5:compile -- module io.helidon.webserver.cors
   io.helidon.cors:helidon-cors:jar:4.0.5:compile -- module io.helidon.cors
   io.helidon.health:helidon-health:jar:4.0.5:compile -- module io.helidon.health
   io.helidon.webserver:helidon-webserver-service-common:jar:4.0.5:compile -- module io.helidon.servicecommon
   io.helidon.http.media:helidon-http-media-jsonp:jar:4.0.5:compile -- module io.helidon.http.media.jsonp
   org.eclipse.parsson:parsson:jar:1.1.5:runtime -- module org.eclipse.parsson
   jakarta.json:jakarta.json-api:jar:2.1.3:compile -- module jakarta.json
   io.helidon.health:helidon-health-checks:jar:4.0.5:compile -- module io.helidon.health.checks
   io.helidon.common:helidon-common-config:jar:4.0.5:compile -- module io.helidon.common.config
   com.fasterxml.jackson.core:jackson-databind:jar:2.15.2:compile -- module com.fasterxml.jackson.databind
   com.fasterxml.jackson.core:jackson-annotations:jar:2.15.2:compile -- module com.fasterxml.jackson.annotation
   com.fasterxml.jackson.core:jackson-core:jar:2.15.2:compile -- module com.fasterxml.jackson.core
   io.helidon.http.media:helidon-http-media-jackson:jar:4.0.5:compile -- module io.helidon.http.media.jackson
   com.fasterxml.jackson.module:jackson-module-parameter-names:jar:2.15.2:compile -- module com.fasterxml.jackson.module.paramnames
   com.fasterxml.jackson.datatype:jackson-datatype-jdk8:jar:2.15.2:compile -- module com.fasterxml.jackson.datatype.jdk8
   com.fasterxml.jackson.datatype:jackson-datatype-jsr310:jar:2.15.2:compile -- module com.fasterxml.jackson.datatype.jsr310
   io.helidon.logging:helidon-logging-jul:jar:4.0.5:runtime -- module io.helidon.logging.jul
   io.helidon.webserver.observe:helidon-webserver-observe-metrics:jar:4.0.5:compile -- module io.helidon.webserver.observe.metrics
   io.helidon.metrics:helidon-metrics-api:jar:4.0.5:compile -- module io.helidon.metrics.api
   io.helidon.metrics.providers:helidon-metrics-providers-micrometer:jar:4.0.5:compile -- module io.helidon.metrics.providers.micrometer
   io.micrometer:micrometer-core:jar:1.11.3:compile -- module micrometer.core [auto]
   io.micrometer:micrometer-commons:jar:1.11.3:compile -- module micrometer.commons [auto]
   io.micrometer:micrometer-observation:jar:1.11.3:compile -- module micrometer.observation [auto]
   org.hdrhistogram:HdrHistogram:jar:2.1.12:runtime -- module HdrHistogram (auto)
   org.latencyutils:LatencyUtils:jar:2.0.3:runtime -- module LatencyUtils (auto)
   io.micrometer:micrometer-registry-prometheus:jar:1.11.3:compile -- module micrometer.registry.prometheus [auto]
   io.prometheus:simpleclient_common:jar:0.16.0:compile -- module simpleclient.common (auto)
   io.prometheus:simpleclient:jar:0.16.0:compile -- module simpleclient (auto)
   io.prometheus:simpleclient_tracer_otel:jar:0.16.0:compile -- module simpleclient.tracer.otel (auto)
   io.prometheus:simpleclient_tracer_otel_agent:jar:0.16.0:compile -- module simpleclient.tracer.otel.agent (auto)
   io.prometheus:simpleclient_tracer_common:jar:0.16.0:compile -- module simpleclient.tracer.common (auto)
   io.helidon.metrics:helidon-metrics-system-meters:jar:4.0.5:runtime -- module io.helidon.metrics.systemmeters
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

## micronaut-4
```
The following files have been resolved:
   io.micronaut:micronaut-http-server-netty:jar:4.3.4:compile -- module io.micronaut.http_server_netty [auto]
   org.slf4j:slf4j-api:jar:2.0.11:compile -- module org.slf4j
   io.micronaut:micronaut-http-server:jar:4.3.4:compile -- module io.micronaut.http_server [auto]
   io.micronaut:micronaut-http:jar:4.3.4:compile -- module io.micronaut.http [auto]
   io.micronaut:micronaut-core-reactive:jar:4.3.4:compile -- module io.micronaut.core_reactive [auto]
   io.micronaut:micronaut-context-propagation:jar:4.3.4:runtime -- module io.micronaut.context_propagation [auto]
   io.micronaut:micronaut-router:jar:4.3.4:compile -- module io.micronaut.router [auto]
   io.micronaut:micronaut-core:jar:4.3.4:compile -- module io.micronaut.core [auto]
   io.micronaut:micronaut-http-netty:jar:4.3.4:compile -- module io.micronaut.http_netty [auto]
   io.micronaut:micronaut-buffer-netty:jar:4.3.4:compile -- module io.micronaut.buffer_netty [auto]
   io.netty:netty-codec-http2:jar:4.1.106.Final:compile -- module io.netty.codec.http2 [auto]
   io.netty:netty-handler:jar:4.1.106.Final:compile -- module io.netty.handler [auto]
   io.netty:netty-resolver:jar:4.1.106.Final:compile -- module io.netty.resolver [auto]
   io.netty:netty-transport-native-unix-common:jar:4.1.106.Final:compile -- module io.netty.transport.unix.common [auto]
   io.netty:netty-codec-http:jar:4.1.106.Final:compile -- module io.netty.codec.http [auto]
   io.netty:netty-common:jar:4.1.106.Final:compile -- module io.netty.common [auto]
   io.netty:netty-buffer:jar:4.1.106.Final:compile -- module io.netty.buffer [auto]
   io.netty:netty-transport:jar:4.1.106.Final:compile -- module io.netty.transport [auto]
   io.netty:netty-codec:jar:4.1.106.Final:compile -- module io.netty.codec [auto]
   io.projectreactor:reactor-core:jar:3.5.11:runtime -- module reactor.core [auto]
   org.reactivestreams:reactive-streams:jar:1.0.4:compile -- module org.reactivestreams [auto]
   io.micronaut.serde:micronaut-serde-jackson:jar:2.8.1:compile -- module io.micronaut.serde.micronaut_serde_jackson [auto]
   io.micronaut:micronaut-inject:jar:4.3.4:compile -- module io.micronaut.inject [auto]
   jakarta.inject:jakarta.inject-api:jar:2.0.1:compile -- module jakarta.inject
   jakarta.annotation:jakarta.annotation-api:jar:2.1.1:compile -- module jakarta.annotation
   io.micronaut:micronaut-jackson-core:jar:4.3.4:compile -- module io.micronaut.jackson_core [auto]
   io.micronaut:micronaut-json-core:jar:4.3.4:compile -- module io.micronaut.json_core [auto]
   com.fasterxml.jackson.core:jackson-core:jar:2.16.1:compile -- module com.fasterxml.jackson.core
   com.fasterxml.jackson.core:jackson-annotations:jar:2.16.1:compile -- module com.fasterxml.jackson.annotation
   io.micronaut:micronaut-context:jar:4.3.4:compile -- module io.micronaut.context [auto]
   io.micronaut:micronaut-aop:jar:4.3.4:compile -- module io.micronaut.aop [auto]
   io.micronaut.serde:micronaut-serde-api:jar:2.8.1:compile -- module io.micronaut.serde.micronaut_serde_api [auto]
   io.micronaut.serde:micronaut-serde-support:jar:2.8.1:runtime -- module io.micronaut.serde.micronaut_serde_support [auto]
   ch.qos.logback:logback-classic:jar:1.4.14:runtime -- module ch.qos.logback.classic
   ch.qos.logback:logback-core:jar:1.4.14:runtime -- module ch.qos.logback.core
```

## picocli-4
```
The following files have been resolved:
   info.picocli:picocli:jar:4.7.5:compile -- module info.picocli
```

## quarkus-3
```
The following files have been resolved:
   io.quarkus:quarkus-arc:jar:3.7.2:compile -- module quarkus.arc (auto)
   io.quarkus.arc:arc:jar:3.7.2:compile -- module arc (auto)
   jakarta.enterprise:jakarta.enterprise.cdi-api:jar:4.0.1:compile -- module jakarta.cdi
   jakarta.enterprise:jakarta.enterprise.lang-model:jar:4.0.1:compile -- module jakarta.cdi.lang.model
   jakarta.el:jakarta.el-api:jar:5.0.1:compile -- module jakarta.el
   jakarta.interceptor:jakarta.interceptor-api:jar:2.1.0:compile -- module jakarta.interceptor
   jakarta.annotation:jakarta.annotation-api:jar:2.1.1:compile -- module jakarta.annotation
   jakarta.transaction:jakarta.transaction-api:jar:2.0.1:compile -- module jakarta.transaction
   io.smallrye.reactive:mutiny:jar:2.5.6:compile -- module io.smallrye.mutiny
   io.smallrye.common:smallrye-common-annotation:jar:2.1.2:compile -- module io.smallrye.common.annotation
   org.jboss.logging:jboss-logging:jar:3.5.3.Final:compile -- module org.jboss.logging
   io.quarkus:quarkus-core:jar:3.7.2:compile -- module quarkus.core (auto)
   jakarta.inject:jakarta.inject-api:jar:2.0.1:compile -- module jakarta.inject
   io.smallrye.common:smallrye-common-os:jar:2.1.2:compile -- module io.smallrye.common.os
   io.quarkus:quarkus-ide-launcher:jar:3.7.2:compile -- module quarkus.ide.launcher (auto)
   io.quarkus:quarkus-development-mode-spi:jar:3.7.2:compile -- module quarkus.development.mode.spi (auto)
   io.smallrye.config:smallrye-config:jar:3.5.4:compile -- module smallrye.config (auto)
   io.smallrye.config:smallrye-config-core:jar:3.5.4:compile -- module smallrye.config.core (auto)
   org.eclipse.microprofile.config:microprofile-config-api:jar:3.0.3:compile -- module microprofile.config.api (auto)
   io.smallrye.common:smallrye-common-classloader:jar:2.1.2:compile -- module io.smallrye.common.classloader
   io.smallrye.config:smallrye-config-common:jar:3.5.4:compile -- module smallrye.config.common (auto)
   org.jboss.logmanager:jboss-logmanager:jar:3.0.4.Final:compile -- module org.jboss.logmanager
   io.smallrye.common:smallrye-common-constraint:jar:2.1.2:compile -- module io.smallrye.common.constraint
   io.smallrye.common:smallrye-common-cpu:jar:2.1.2:compile -- module io.smallrye.common.cpu
   io.smallrye.common:smallrye-common-expression:jar:2.1.2:compile -- module io.smallrye.common.expression
   io.smallrye.common:smallrye-common-function:jar:2.1.2:compile -- module io.smallrye.common.function
   io.smallrye.common:smallrye-common-net:jar:2.1.2:compile -- module io.smallrye.common.net
   io.smallrye.common:smallrye-common-ref:jar:2.1.2:compile -- module io.smallrye.common.ref
   jakarta.json:jakarta.json-api:jar:2.1.3:compile -- module jakarta.json
   org.jboss.logging:jboss-logging-annotations:jar:2.2.1.Final:compile -- module jboss.logging.annotations (auto)
   org.jboss.threads:jboss-threads:jar:3.5.1.Final:compile -- module jboss.threads (auto)
   org.slf4j:slf4j-api:jar:2.0.6:compile -- module org.slf4j
   org.jboss.slf4j:slf4j-jboss-logmanager:jar:2.0.0.Final:compile -- module slf4j.jboss.logmanager (auto)
   org.wildfly.common:wildfly-common:jar:1.7.0.Final:compile -- module wildfly.common (auto)
   io.quarkus:quarkus-bootstrap-runner:jar:3.7.2:compile -- module quarkus.bootstrap.runner (auto)
   io.smallrye.common:smallrye-common-io:jar:2.1.2:compile -- module io.smallrye.common.io
   io.quarkus:quarkus-fs-util:jar:0.0.10:compile -- module quarkus.fs.util (auto)
   org.eclipse.microprofile.context-propagation:microprofile-context-propagation-api:jar:1.3:compile -- module microprofile.context.propagation.api (auto)
   io.quarkus:quarkus-resteasy-reactive:jar:3.7.2:compile -- module quarkus.resteasy.reactive (auto)
   io.quarkus:quarkus-resteasy-reactive-common:jar:3.7.2:compile -- module quarkus.resteasy.reactive.common (auto)
   io.quarkus.resteasy.reactive:resteasy-reactive-common:jar:3.7.2:compile -- module resteasy.reactive.common (auto)
   io.quarkus.resteasy.reactive:resteasy-reactive-common-types:jar:3.7.2:compile -- module resteasy.reactive.common.types (auto)
   org.reactivestreams:reactive-streams:jar:1.0.4:compile -- module org.reactivestreams [auto]
   io.smallrye.reactive:mutiny-zero-flow-adapters:jar:1.0.0:compile -- module mutiny.zero.flow.adapters
   io.quarkus:quarkus-mutiny:jar:3.7.2:compile -- module quarkus.mutiny (auto)
   io.quarkus:quarkus-smallrye-context-propagation:jar:3.7.2:compile -- module quarkus.smallrye.context.propagation (auto)
   io.smallrye:smallrye-context-propagation:jar:2.1.0:compile -- module smallrye.context.propagation (auto)
   io.smallrye:smallrye-context-propagation-api:jar:2.1.0:compile -- module smallrye.context.propagation.api (auto)
   io.smallrye:smallrye-context-propagation-storage:jar:2.1.0:compile -- module smallrye.context.propagation.storage (auto)
   io.smallrye.reactive:mutiny-smallrye-context-propagation:jar:2.5.6:compile -- module mutiny.smallrye.context.propagation (auto)
   io.quarkus:quarkus-vertx:jar:3.7.2:compile -- module quarkus.vertx (auto)
   io.quarkus:quarkus-netty:jar:3.7.2:compile -- module quarkus.netty (auto)
   io.netty:netty-codec:jar:4.1.106.Final:compile -- module io.netty.codec [auto]
   com.aayushatharva.brotli4j:brotli4j:jar:1.12.0:compile -- module com.aayushatharva.brotli4j
   com.aayushatharva.brotli4j:service:jar:1.12.0:compile -- module com.aayushatharva.brotli4j.service
   com.aayushatharva.brotli4j:native-windows-x86_64:jar:1.12.0:compile -- module com.aayushatharva.brotli4j.windows.x86_64
   io.netty:netty-codec-haproxy:jar:4.1.106.Final:compile -- module io.netty.codec.haproxy [auto]
   io.quarkus:quarkus-vertx-latebound-mdc-provider:jar:3.7.2:compile -- module quarkus.vertx.latebound.mdc.provider (auto)
   io.smallrye:smallrye-fault-tolerance-vertx:jar:6.2.6:compile -- module smallrye.fault.tolerance.vertx (auto)
   io.quarkus.resteasy.reactive:resteasy-reactive-vertx:jar:3.7.2:compile -- module resteasy.reactive.vertx (auto)
   io.vertx:vertx-web:jar:4.5.3:compile -- module io.vertx.web [auto]
   io.vertx:vertx-web-common:jar:4.5.3:compile -- module io.vertx.web.common [auto]
   io.vertx:vertx-auth-common:jar:4.5.3:compile -- module io.vertx.auth.common [auto]
   io.vertx:vertx-bridge-common:jar:4.5.3:compile -- module io.vertx.eventbusbridge.common [auto]
   io.smallrye.reactive:smallrye-mutiny-vertx-core:jar:3.8.0:compile -- module io.smallrye.mutiny.vertx.core [auto]
   io.smallrye.reactive:smallrye-mutiny-vertx-runtime:jar:3.8.0:compile -- module io.smallrye.mutiny.vertx.runtime [auto]
   io.smallrye.reactive:vertx-mutiny-generator:jar:3.8.0:compile -- module vertx.mutiny.generator (auto)
   io.vertx:vertx-codegen:jar:4.5.3:compile -- module io.vertx.codegen [auto]
   io.quarkus.resteasy.reactive:resteasy-reactive:jar:3.7.2:compile -- module resteasy.reactive (auto)
   jakarta.ws.rs:jakarta.ws.rs-api:jar:3.1.0:compile -- module jakarta.ws.rs
   org.jboss.logging:commons-logging-jboss-logging:jar:1.0.0.Final:compile -- module commons.logging.jboss.logging (auto)
   jakarta.xml.bind:jakarta.xml.bind-api:jar:4.0.1:compile -- module jakarta.xml.bind
   jakarta.activation:jakarta.activation-api:jar:2.1.2:compile -- module jakarta.activation
   io.quarkus:quarkus-vertx-http:jar:3.7.2:compile -- module quarkus.vertx.http (auto)
   io.quarkus:quarkus-security-runtime-spi:jar:3.7.2:compile -- module quarkus.security.runtime.spi (auto)
   io.quarkus:quarkus-credentials:jar:3.7.2:compile -- module quarkus.credentials (auto)
   io.smallrye.common:smallrye-common-vertx-context:jar:2.1.2:compile -- module io.smallrye.common.vertx
   io.quarkus.security:quarkus-security:jar:2.0.3.Final:compile -- module quarkus.security (auto)
   io.smallrye.reactive:smallrye-mutiny-vertx-web:jar:3.8.0:compile -- module io.smallrye.mutiny.vertx.web [auto]
   io.smallrye.reactive:smallrye-mutiny-vertx-web-common:jar:3.8.0:compile -- module io.smallrye.mutiny.vertx.web.common [auto]
   io.smallrye.reactive:smallrye-mutiny-vertx-auth-common:jar:3.8.0:compile -- module io.smallrye.mutiny.vertx.auth.common [auto]
   io.smallrye.reactive:smallrye-mutiny-vertx-bridge-common:jar:3.8.0:compile -- module io.smallrye.mutiny.vertx.bridge.common [auto]
   io.smallrye.reactive:smallrye-mutiny-vertx-uri-template:jar:3.8.0:compile -- module io.smallrye.mutiny.vertx.uri.template [auto]
   io.vertx:vertx-uri-template:jar:4.5.3:compile -- module io.vertx.uritemplate [auto]
   io.github.crac:org-crac:jar:0.1.3:compile -- module org.crac (auto)
   io.quarkus:quarkus-jsonp:jar:3.7.2:compile -- module quarkus.jsonp (auto)
   org.eclipse.parsson:parsson:jar:1.1.5:compile -- module org.eclipse.parsson
   io.quarkus:quarkus-virtual-threads:jar:3.7.2:compile -- module quarkus.virtual.threads (auto)
   io.vertx:vertx-core:jar:4.5.3:compile -- module io.vertx.core [auto]
   io.netty:netty-common:jar:4.1.106.Final:compile -- module io.netty.common [auto]
   io.netty:netty-buffer:jar:4.1.106.Final:compile -- module io.netty.buffer [auto]
   io.netty:netty-transport:jar:4.1.106.Final:compile -- module io.netty.transport [auto]
   io.netty:netty-handler:jar:4.1.106.Final:compile -- module io.netty.handler [auto]
   io.netty:netty-transport-native-unix-common:jar:4.1.106.Final:compile -- module io.netty.transport.unix.common [auto]
   io.netty:netty-handler-proxy:jar:4.1.106.Final:compile -- module io.netty.handler.proxy [auto]
   io.netty:netty-codec-socks:jar:4.1.106.Final:compile -- module io.netty.codec.socks [auto]
   io.netty:netty-codec-http:jar:4.1.106.Final:compile -- module io.netty.codec.http [auto]
   io.netty:netty-codec-http2:jar:4.1.106.Final:compile -- module io.netty.codec.http2 [auto]
   io.netty:netty-resolver:jar:4.1.106.Final:compile -- module io.netty.resolver [auto]
   io.netty:netty-resolver-dns:jar:4.1.106.Final:compile -- module io.netty.resolver.dns [auto]
   io.netty:netty-codec-dns:jar:4.1.106.Final:compile -- module io.netty.codec.dns [auto]
   com.fasterxml.jackson.core:jackson-core:jar:2.16.1:compile -- module com.fasterxml.jackson.core
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
   org.slf4j:slf4j-api:jar:2.0.7:compile -- module org.slf4j
   org.apache.logging.log4j:log4j-to-slf4j:jar:2.21.1:compile -- module org.apache.logging.log4j.to.slf4j
   org.apache.logging.log4j:log4j-api:jar:2.21.1:compile -- module org.apache.logging.log4j
   org.slf4j:jul-to-slf4j:jar:2.0.11:compile -- module jul.to.slf4j
   jakarta.annotation:jakarta.annotation-api:jar:2.1.1:compile -- module jakarta.annotation
   org.springframework:spring-core:jar:6.1.3:compile -- module spring.core [auto]
   org.springframework:spring-jcl:jar:6.1.3:compile -- module spring.jcl [auto]
   org.yaml:snakeyaml:jar:2.2:compile -- module org.yaml.snakeyaml
```

## streamex-0
```
The following files have been resolved:
   one.util:streamex:jar:0.8.2:compile -- module one.util.streamex
```
