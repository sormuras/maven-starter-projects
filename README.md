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

|Project| Dependencies | 🧩 | 🟢 | ⚪ |
|-------|-------------:|----:|----:|----:|
|[apache-commons-codec-1](#apache-commons-codec-1)| 1 | 1 | 0 | 0 |
|[apache-commons-exec-1](#apache-commons-exec-1)| 1 | 1 | 0 | 0 |
|[apache-commons-io-2](#apache-commons-io-2)| 1 | 1 | 0 | 0 |
|[apache-commons-lang-3](#apache-commons-lang-3)| 1 | 1 | 0 | 0 |
|[asm-9](#asm-9)| 1 | 1 | 0 | 0 |
|[gson-2](#gson-2)| 2 | 2 | 0 | 0 |
|[guava-33](#guava-33)| 6 | 5 | 0 | 1 |
|[helidon-se-4](#helidon-se-4)| 72 | 54 | 10 | 8 |
|[jackson-core-2](#jackson-core-2)| 1 | 1 | 0 | 0 |
|[jackson-databind-2](#jackson-databind-2)| 3 | 3 | 0 | 0 |
|[javalin-2](#javalin-2)| 21 | 20 | 0 | 1 |
|[junit-4](#junit-4)| 2 | 0 | 1 | 1 |
|[junit-5](#junit-5)| 8 | 8 | 0 | 0 |
|[junit-framework](#junit-framework)| 16 | 16 | 0 | 0 |
|[micronaut-4](#micronaut-4)| 36 | 17 | 19 | 0 |
|[picocli-4](#picocli-4)| 1 | 1 | 0 | 0 |
|[quarkus-3](#quarkus-3)| 37 | 25 | 0 | 12 |
|[slf4j-2](#slf4j-2)| 1 | 1 | 0 | 0 |
|[snakeyaml-2](#snakeyaml-2)| 1 | 1 | 0 | 0 |
|[spring-boot-3](#spring-boot-3)| 34 | 17 | 17 | 0 |
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
| Dependencies | 🧩 | 🟢 | ⚪ |
|-------------:|----:|----:|----:|
| 1 | 1 | 0 | 0 |
```
   commons-codec:commons-codec:jar:1.18.0:compile -- module org.apache.commons.codec
```

## apache-commons-exec-1
| Dependencies | 🧩 | 🟢 | ⚪ |
|-------------:|----:|----:|----:|
| 1 | 1 | 0 | 0 |
```
   org.apache.commons:commons-exec:jar:1.4.0:compile -- module org.apache.commons.exec
```

## apache-commons-io-2
| Dependencies | 🧩 | 🟢 | ⚪ |
|-------------:|----:|----:|----:|
| 1 | 1 | 0 | 0 |
```
   commons-io:commons-io:jar:2.19.0:compile -- module org.apache.commons.io
```

## apache-commons-lang-3
| Dependencies | 🧩 | 🟢 | ⚪ |
|-------------:|----:|----:|----:|
| 1 | 1 | 0 | 0 |
```
   org.apache.commons:commons-lang3:jar:3.17.0:compile -- module org.apache.commons.lang3
```

## asm-9
| Dependencies | 🧩 | 🟢 | ⚪ |
|-------------:|----:|----:|----:|
| 1 | 1 | 0 | 0 |
```
   org.ow2.asm:asm:jar:9.8:compile -- module org.objectweb.asm
```

## gson-2
| Dependencies | 🧩 | 🟢 | ⚪ |
|-------------:|----:|----:|----:|
| 2 | 2 | 0 | 0 |
```
   com.google.code.gson:gson:jar:2.13.1:compile -- module com.google.gson
   com.google.errorprone:error_prone_annotations:jar:2.38.0:compile -- module com.google.errorprone.annotations
```

## guava-33
| Dependencies | 🧩 | 🟢 | ⚪ |
|-------------:|----:|----:|----:|
| 6 | 5 | 0 | 1 |
```
   com.google.errorprone:error_prone_annotations:jar:2.36.0:compile -- module com.google.errorprone.annotations
   com.google.guava:failureaccess:jar:1.0.3:compile -- module com.google.common.util.concurrent.internal
   com.google.guava:guava:jar:33.4.8-jre:compile -- module com.google.common
   com.google.guava:listenablefuture:jar:9999.0-empty-to-avoid-conflict-with-guava:compile -- module listenablefuture (auto)
   com.google.j2objc:j2objc-annotations:jar:3.0.0:compile -- module com.google.j2objc.annotations
   org.jspecify:jspecify:jar:1.0.0:compile -- module org.jspecify
```

## helidon-se-4
| Dependencies | 🧩 | 🟢 | ⚪ |
|-------------:|----:|----:|----:|
| 72 | 54 | 10 | 8 |
```
   com.fasterxml.jackson.core:jackson-annotations:jar:2.18.1:compile -- module com.fasterxml.jackson.annotation
   com.fasterxml.jackson.core:jackson-core:jar:2.18.1:compile -- module com.fasterxml.jackson.core
   com.fasterxml.jackson.core:jackson-databind:jar:2.18.1:compile -- module com.fasterxml.jackson.databind
   com.fasterxml.jackson.datatype:jackson-datatype-jdk8:jar:2.18.1:compile -- module com.fasterxml.jackson.datatype.jdk8
   com.fasterxml.jackson.datatype:jackson-datatype-jsr310:jar:2.18.1:compile -- module com.fasterxml.jackson.datatype.jsr310
   com.fasterxml.jackson.module:jackson-module-parameter-names:jar:2.18.1:compile -- module com.fasterxml.jackson.module.paramnames
   io.helidon.builder:helidon-builder-api:jar:4.2.2:compile -- module io.helidon.builder.api
   io.helidon.common.concurrency:helidon-common-concurrency-limits:jar:4.2.2:compile -- module io.helidon.common.concurrency.limits
   io.helidon.common.features:helidon-common-features-api:jar:4.2.2:compile -- module io.helidon.common.features.api
   io.helidon.common.features:helidon-common-features:jar:4.2.2:compile -- module io.helidon.common.features
   io.helidon.common:helidon-common-buffers:jar:4.2.2:compile -- module io.helidon.common.buffers
   io.helidon.common:helidon-common-config:jar:4.2.2:compile -- module io.helidon.common.config
   io.helidon.common:helidon-common-configurable:jar:4.2.2:compile -- module io.helidon.common.configurable
   io.helidon.common:helidon-common-context:jar:4.2.2:compile -- module io.helidon.common.context
   io.helidon.common:helidon-common-key-util:jar:4.2.2:compile -- module io.helidon.common.pki
   io.helidon.common:helidon-common-mapper:jar:4.2.2:compile -- module io.helidon.common.mapper
   io.helidon.common:helidon-common-media-type:jar:4.2.2:compile -- module io.helidon.common.media.type
   io.helidon.common:helidon-common-parameters:jar:4.2.2:compile -- module io.helidon.common.parameters
   io.helidon.common:helidon-common-resumable:jar:4.2.2:compile -- module io.helidon.common.resumable
   io.helidon.common:helidon-common-security:jar:4.2.2:compile -- module io.helidon.common.security
   io.helidon.common:helidon-common-socket:jar:4.2.2:compile -- module io.helidon.common.socket
   io.helidon.common:helidon-common-task:jar:4.2.2:compile -- module io.helidon.common.task
   io.helidon.common:helidon-common-tls:jar:4.2.2:compile -- module io.helidon.common.tls
   io.helidon.common:helidon-common-types:jar:4.2.2:compile -- module io.helidon.common.types
   io.helidon.common:helidon-common-uri:jar:4.2.2:compile -- module io.helidon.common.uri
   io.helidon.common:helidon-common:jar:4.2.2:compile -- module io.helidon.common
   io.helidon.config:helidon-config-yaml:jar:4.2.2:compile -- module io.helidon.config.yaml
   io.helidon.config:helidon-config:jar:4.2.2:compile -- module io.helidon.config
   io.helidon.cors:helidon-cors:jar:4.2.2:compile -- module io.helidon.cors
   io.helidon.health:helidon-health-checks:jar:4.2.2:compile -- module io.helidon.health.checks
   io.helidon.health:helidon-health:jar:4.2.2:compile -- module io.helidon.health
   io.helidon.http.encoding:helidon-http-encoding:jar:4.2.2:compile -- module io.helidon.http.encoding
   io.helidon.http.media:helidon-http-media-jackson:jar:4.2.2:compile -- module io.helidon.http.media.jackson
   io.helidon.http.media:helidon-http-media-jsonp:jar:4.2.2:compile -- module io.helidon.http.media.jsonp
   io.helidon.http.media:helidon-http-media:jar:4.2.2:compile -- module io.helidon.http.media
   io.helidon.http:helidon-http:jar:4.2.2:compile -- module io.helidon.http
   io.helidon.logging:helidon-logging-common:jar:4.2.2:compile -- module io.helidon.logging.common
   io.helidon.logging:helidon-logging-jul:jar:4.2.2:runtime -- module io.helidon.logging.jul
   io.helidon.metadata:helidon-metadata-hson:jar:4.2.2:compile -- module io.helidon.metadata.hson
   io.helidon.metrics.providers:helidon-metrics-providers-micrometer:jar:4.2.2:compile -- module io.helidon.metrics.providers.micrometer
   io.helidon.metrics:helidon-metrics-api:jar:4.2.2:compile -- module io.helidon.metrics.api
   io.helidon.metrics:helidon-metrics-system-meters:jar:4.2.2:runtime -- module io.helidon.metrics.systemmeters
   io.helidon.service:helidon-service-metadata:jar:4.2.2:compile -- module io.helidon.service.metadata
   io.helidon.service:helidon-service-registry:jar:4.2.2:compile -- module io.helidon.service.registry
   io.helidon.webserver.observe:helidon-webserver-observe-health:jar:4.2.2:compile -- module io.helidon.webserver.observe.health
   io.helidon.webserver.observe:helidon-webserver-observe-metrics:jar:4.2.2:compile -- module io.helidon.webserver.observe.metrics
   io.helidon.webserver.observe:helidon-webserver-observe:jar:4.2.2:compile -- module io.helidon.webserver.observe
   io.helidon.webserver:helidon-webserver-cors:jar:4.2.2:compile -- module io.helidon.webserver.cors
   io.helidon.webserver:helidon-webserver-service-common:jar:4.2.2:compile -- module io.helidon.servicecommon
   io.helidon.webserver:helidon-webserver:jar:4.2.2:compile -- module io.helidon.webserver
   io.helidon:helidon:jar:4.2.2:compile -- module io.helidon
   io.micrometer:micrometer-commons:jar:1.13.4:compile -- module micrometer.commons [auto]
   io.micrometer:micrometer-core:jar:1.13.4:compile -- module micrometer.core [auto]
   io.micrometer:micrometer-observation:jar:1.13.4:compile -- module micrometer.observation [auto]
   io.micrometer:micrometer-registry-prometheus-simpleclient:jar:1.13.4:compile -- module micrometer.registry.prometheus.simpleclient [auto]
   io.micrometer:micrometer-registry-prometheus:jar:1.13.4:compile -- module micrometer.registry.prometheus [auto]
   io.prometheus:prometheus-metrics-config:jar:1.2.1:compile -- module io.prometheus.metrics.config [auto]
   io.prometheus:prometheus-metrics-core:jar:1.2.1:compile -- module io.prometheus.metrics.core [auto]
   io.prometheus:prometheus-metrics-exposition-formats:jar:1.2.1:runtime -- module io.prometheus.metrics.expositionformats [auto]
   io.prometheus:prometheus-metrics-model:jar:1.2.1:compile -- module io.prometheus.metrics.model [auto]
   io.prometheus:prometheus-metrics-shaded-protobuf:jar:1.2.1:runtime -- module prometheus.metrics.shaded.protobuf (auto)
   io.prometheus:prometheus-metrics-tracer-common:jar:1.2.1:compile -- module io.prometheus.metrics.tracer.common [auto]
   io.prometheus:simpleclient:jar:0.16.0:compile -- module simpleclient (auto)
   io.prometheus:simpleclient_common:jar:0.16.0:compile -- module simpleclient.common (auto)
   io.prometheus:simpleclient_tracer_common:jar:0.16.0:compile -- module simpleclient.tracer.common (auto)
   io.prometheus:simpleclient_tracer_otel:jar:0.16.0:compile -- module simpleclient.tracer.otel (auto)
   io.prometheus:simpleclient_tracer_otel_agent:jar:0.16.0:compile -- module simpleclient.tracer.otel.agent (auto)
   jakarta.json:jakarta.json-api:jar:2.1.3:compile -- module jakarta.json
   org.eclipse.parsson:parsson:jar:1.1.7:runtime -- module org.eclipse.parsson
   org.hdrhistogram:HdrHistogram:jar:2.2.2:runtime -- module HdrHistogram (auto)
   org.latencyutils:LatencyUtils:jar:2.0.3:runtime -- module LatencyUtils (auto)
   org.yaml:snakeyaml:jar:2.4:compile -- module org.yaml.snakeyaml
```

## jackson-core-2
| Dependencies | 🧩 | 🟢 | ⚪ |
|-------------:|----:|----:|----:|
| 1 | 1 | 0 | 0 |
```
   com.fasterxml.jackson.core:jackson-core:jar:2.19.1:compile -- module com.fasterxml.jackson.core
```

## jackson-databind-2
| Dependencies | 🧩 | 🟢 | ⚪ |
|-------------:|----:|----:|----:|
| 3 | 3 | 0 | 0 |
```
   com.fasterxml.jackson.core:jackson-annotations:jar:2.19.0:compile -- module com.fasterxml.jackson.annotation
   com.fasterxml.jackson.core:jackson-core:jar:2.19.0:compile -- module com.fasterxml.jackson.core
   com.fasterxml.jackson.core:jackson-databind:jar:2.19.0:compile -- module com.fasterxml.jackson.databind
```

## javalin-2
| Dependencies | 🧩 | 🟢 | ⚪ |
|-------------:|----:|----:|----:|
| 21 | 20 | 0 | 1 |
```
   io.javalin:javalin:jar:6.7.0:compile -- module io.javalin
   org.eclipse.jetty.toolchain:jetty-jakarta-servlet-api:jar:5.0.2:compile -- module jetty.servlet.api
   org.eclipse.jetty.websocket:websocket-core-common:jar:11.0.25:compile -- module org.eclipse.jetty.websocket.core.common
   org.eclipse.jetty.websocket:websocket-core-server:jar:11.0.25:compile -- module org.eclipse.jetty.websocket.core.server
   org.eclipse.jetty.websocket:websocket-jetty-api:jar:11.0.25:compile -- module org.eclipse.jetty.websocket.jetty.api
   org.eclipse.jetty.websocket:websocket-jetty-common:jar:11.0.25:compile -- module org.eclipse.jetty.websocket.jetty.common
   org.eclipse.jetty.websocket:websocket-jetty-server:jar:11.0.25:compile -- module org.eclipse.jetty.websocket.jetty.server
   org.eclipse.jetty.websocket:websocket-servlet:jar:11.0.25:compile -- module org.eclipse.jetty.websocket.servlet
   org.eclipse.jetty:jetty-http:jar:11.0.25:compile -- module org.eclipse.jetty.http
   org.eclipse.jetty:jetty-io:jar:11.0.25:compile -- module org.eclipse.jetty.io
   org.eclipse.jetty:jetty-security:jar:11.0.25:compile -- module org.eclipse.jetty.security
   org.eclipse.jetty:jetty-server:jar:11.0.25:compile -- module org.eclipse.jetty.server
   org.eclipse.jetty:jetty-servlet:jar:11.0.25:compile -- module org.eclipse.jetty.servlet
   org.eclipse.jetty:jetty-util:jar:11.0.25:compile -- module org.eclipse.jetty.util
   org.eclipse.jetty:jetty-webapp:jar:11.0.25:compile -- module org.eclipse.jetty.webapp
   org.eclipse.jetty:jetty-xml:jar:11.0.25:compile -- module org.eclipse.jetty.xml
   org.jetbrains.kotlin:kotlin-stdlib-jdk7:jar:1.9.25:compile -- module kotlin.stdlib.jdk7
   org.jetbrains.kotlin:kotlin-stdlib-jdk8:jar:1.9.25:compile -- module kotlin.stdlib.jdk8
   org.jetbrains.kotlin:kotlin-stdlib:jar:1.9.25:compile -- module kotlin.stdlib
   org.jetbrains:annotations:jar:13.0:compile -- module annotations (auto)
   org.slf4j:slf4j-api:jar:2.0.17:compile -- module org.slf4j
```

## junit-4
| Dependencies | 🧩 | 🟢 | ⚪ |
|-------------:|----:|----:|----:|
| 2 | 0 | 1 | 1 |
```
   junit:junit:jar:4.13.2:compile -- module junit [auto]
   org.hamcrest:hamcrest-core:jar:1.3:compile -- module hamcrest.core (auto)
```

## junit-5
| Dependencies | 🧩 | 🟢 | ⚪ |
|-------------:|----:|----:|----:|
| 8 | 8 | 0 | 0 |
```
   org.apiguardian:apiguardian-api:jar:1.1.2:compile -- module org.apiguardian.api
   org.junit.jupiter:junit-jupiter-api:jar:5.13.2:compile -- module org.junit.jupiter.api
   org.junit.jupiter:junit-jupiter-engine:jar:5.13.2:runtime -- module org.junit.jupiter.engine
   org.junit.jupiter:junit-jupiter-params:jar:5.13.2:compile -- module org.junit.jupiter.params
   org.junit.jupiter:junit-jupiter:jar:5.13.2:compile -- module org.junit.jupiter
   org.junit.platform:junit-platform-commons:jar:1.13.2:compile -- module org.junit.platform.commons
   org.junit.platform:junit-platform-engine:jar:1.13.2:runtime -- module org.junit.platform.engine
   org.opentest4j:opentest4j:jar:1.3.0:compile -- module org.opentest4j
```

## junit-framework
| Dependencies | 🧩 | 🟢 | ⚪ |
|-------------:|----:|----:|----:|
| 16 | 16 | 0 | 0 |
```
   org.apiguardian:apiguardian-api:jar:1.1.2:compile -- module org.apiguardian.api
   org.jspecify:jspecify:jar:1.0.0:compile -- module org.jspecify
   org.junit.jupiter:junit-jupiter-api:jar:6.0.0-M1:compile -- module org.junit.jupiter.api
   org.junit.jupiter:junit-jupiter-engine:jar:6.0.0-M1:runtime -- module org.junit.jupiter.engine
   org.junit.jupiter:junit-jupiter-params:jar:6.0.0-M1:compile -- module org.junit.jupiter.params
   org.junit.jupiter:junit-jupiter:jar:6.0.0-M1:compile -- module org.junit.jupiter
   org.junit.platform:junit-platform-commons:jar:6.0.0-M1:compile -- module org.junit.platform.commons
   org.junit.platform:junit-platform-engine:jar:6.0.0-M1:compile -- module org.junit.platform.engine
   org.junit.platform:junit-platform-launcher:jar:6.0.0-M1:compile -- module org.junit.platform.launcher
   org.junit.platform:junit-platform-reporting:jar:6.0.0-M1:compile -- module org.junit.platform.reporting
   org.junit.platform:junit-platform-suite-api:jar:6.0.0-M1:compile -- module org.junit.platform.suite.api
   org.junit.platform:junit-platform-suite-commons:jar:6.0.0-M1:runtime -- module org.junit.platform.suite.commons
   org.junit.platform:junit-platform-suite-engine:jar:6.0.0-M1:runtime -- module org.junit.platform.suite.engine
   org.junit.platform:junit-platform-suite:jar:6.0.0-M1:compile -- module org.junit.platform.suite
   org.opentest4j.reporting:open-test-reporting-tooling-spi:jar:0.2.4:runtime -- module org.opentest4j.reporting.tooling.spi
   org.opentest4j:opentest4j:jar:1.3.0:compile -- module org.opentest4j
```

## micronaut-4
| Dependencies | 🧩 | 🟢 | ⚪ |
|-------------:|----:|----:|----:|
| 36 | 17 | 19 | 0 |
```
   ch.qos.logback:logback-classic:jar:1.5.18:runtime -- module ch.qos.logback.classic
   ch.qos.logback:logback-core:jar:1.5.18:runtime -- module ch.qos.logback.core
   com.fasterxml.jackson.core:jackson-annotations:jar:2.19.1:compile -- module com.fasterxml.jackson.annotation
   com.fasterxml.jackson.core:jackson-core:jar:2.19.1:compile -- module com.fasterxml.jackson.core
   io.micronaut.serde:micronaut-serde-api:jar:2.15.0:compile -- module io.micronaut.serde.micronaut_serde_api [auto]
   io.micronaut.serde:micronaut-serde-jackson:jar:2.15.0:compile -- module io.micronaut.serde.micronaut_serde_jackson [auto]
   io.micronaut.serde:micronaut-serde-support:jar:2.15.0:runtime -- module io.micronaut.serde.micronaut_serde_support [auto]
   io.micronaut:micronaut-aop:jar:4.9.5:compile -- module io.micronaut.micronaut_aop [auto]
   io.micronaut:micronaut-buffer-netty:jar:4.9.5:compile -- module io.micronaut.micronaut_buffer_netty [auto]
   io.micronaut:micronaut-context-propagation:jar:4.9.5:compile -- module io.micronaut.micronaut_context_propagation [auto]
   io.micronaut:micronaut-context:jar:4.9.5:compile -- module io.micronaut.micronaut_context [auto]
   io.micronaut:micronaut-core-reactive:jar:4.9.5:compile -- module io.micronaut.micronaut_core_reactive [auto]
   io.micronaut:micronaut-core:jar:4.9.5:compile -- module io.micronaut.micronaut_core [auto]
   io.micronaut:micronaut-http-netty:jar:4.9.5:compile -- module io.micronaut.micronaut_http_netty [auto]
   io.micronaut:micronaut-http-server-netty:jar:4.9.5:compile -- module io.micronaut.micronaut_http_server_netty [auto]
   io.micronaut:micronaut-http-server:jar:4.9.5:compile -- module io.micronaut.micronaut_http_server [auto]
   io.micronaut:micronaut-http:jar:4.9.5:compile -- module io.micronaut.micronaut_http [auto]
   io.micronaut:micronaut-inject:jar:4.9.5:compile -- module io.micronaut.micronaut_inject [auto]
   io.micronaut:micronaut-jackson-core:jar:4.9.5:compile -- module io.micronaut.micronaut_jackson_core [auto]
   io.micronaut:micronaut-json-core:jar:4.9.5:compile -- module io.micronaut.micronaut_json_core [auto]
   io.micronaut:micronaut-router:jar:4.9.5:compile -- module io.micronaut.micronaut_router [auto]
   io.netty:netty-buffer:jar:4.2.2.Final:compile -- module io.netty.buffer
   io.netty:netty-codec-base:jar:4.2.2.Final:compile -- module io.netty.codec
   io.netty:netty-codec-compression:jar:4.2.2.Final:compile -- module io.netty.codec.compression
   io.netty:netty-codec-http2:jar:4.2.2.Final:compile -- module io.netty.codec.http2
   io.netty:netty-codec-http:jar:4.2.2.Final:compile -- module io.netty.codec.http
   io.netty:netty-common:jar:4.2.2.Final:compile -- module io.netty.common
   io.netty:netty-handler:jar:4.2.2.Final:compile -- module io.netty.handler
   io.netty:netty-resolver:jar:4.2.2.Final:compile -- module io.netty.resolver
   io.netty:netty-transport-native-unix-common:jar:4.2.2.Final:compile -- module io.netty.transport.unix.common
   io.netty:netty-transport:jar:4.2.2.Final:compile -- module io.netty.transport
   io.projectreactor:reactor-core:jar:3.7.7:runtime -- module reactor.core [auto]
   jakarta.annotation:jakarta.annotation-api:jar:2.1.1:compile -- module jakarta.annotation
   jakarta.inject:jakarta.inject-api:jar:2.0.1:compile -- module jakarta.inject
   org.reactivestreams:reactive-streams:jar:1.0.4:compile -- module org.reactivestreams [auto]
   org.slf4j:slf4j-api:jar:2.0.17:compile -- module org.slf4j
```

## picocli-4
| Dependencies | 🧩 | 🟢 | ⚪ |
|-------------:|----:|----:|----:|
| 1 | 1 | 0 | 0 |
```
   info.picocli:picocli:jar:4.7.7:compile -- module info.picocli
```

## quarkus-3
| Dependencies | 🧩 | 🟢 | ⚪ |
|-------------:|----:|----:|----:|
| 37 | 25 | 0 | 12 |
```
   io.github.crac:org-crac:jar:0.1.3:compile -- module org.crac (auto)
   io.quarkus.arc:arc:jar:3.24.1:compile -- module arc (auto)
   io.quarkus:quarkus-arc:jar:3.24.1:compile -- module quarkus.arc (auto)
   io.quarkus:quarkus-bootstrap-runner:jar:3.24.1:compile -- module quarkus.bootstrap.runner (auto)
   io.quarkus:quarkus-classloader-commons:jar:3.24.1:compile -- module quarkus.classloader.commons (auto)
   io.quarkus:quarkus-core:jar:3.24.1:compile -- module quarkus.core (auto)
   io.quarkus:quarkus-development-mode-spi:jar:3.24.1:compile -- module quarkus.development.mode.spi (auto)
   io.quarkus:quarkus-fs-util:jar:1.0.0:compile -- module quarkus.fs.util (auto)
   io.quarkus:quarkus-ide-launcher:jar:3.24.1:compile -- module quarkus.ide.launcher (auto)
   io.smallrye.common:smallrye-common-annotation:jar:2.12.0:compile -- module io.smallrye.common.annotation
   io.smallrye.common:smallrye-common-constraint:jar:2.12.0:compile -- module io.smallrye.common.constraint
   io.smallrye.common:smallrye-common-cpu:jar:2.12.0:compile -- module io.smallrye.common.cpu
   io.smallrye.common:smallrye-common-expression:jar:2.12.0:compile -- module io.smallrye.common.expression
   io.smallrye.common:smallrye-common-function:jar:2.12.0:compile -- module io.smallrye.common.function
   io.smallrye.common:smallrye-common-io:jar:2.12.0:compile -- module io.smallrye.common.io
   io.smallrye.common:smallrye-common-net:jar:2.12.0:compile -- module io.smallrye.common.net
   io.smallrye.common:smallrye-common-os:jar:2.12.0:compile -- module io.smallrye.common.os
   io.smallrye.common:smallrye-common-ref:jar:2.12.0:compile -- module io.smallrye.common.ref
   io.smallrye.config:smallrye-config:jar:3.13.2:compile -- module smallrye.config (auto)
   io.smallrye.reactive:mutiny:jar:2.9.0:compile -- module io.smallrye.mutiny
   jakarta.annotation:jakarta.annotation-api:jar:3.0.0:compile -- module jakarta.annotation
   jakarta.el:jakarta.el-api:jar:6.0.1:compile -- module jakarta.el
   jakarta.enterprise:jakarta.enterprise.cdi-api:jar:4.1.0:compile -- module jakarta.cdi
   jakarta.enterprise:jakarta.enterprise.lang-model:jar:4.1.0:compile -- module jakarta.cdi.lang.model
   jakarta.inject:jakarta.inject-api:jar:2.0.1:compile -- module jakarta.inject
   jakarta.interceptor:jakarta.interceptor-api:jar:2.2.0:compile -- module jakarta.interceptor
   jakarta.json:jakarta.json-api:jar:2.1.3:compile -- module jakarta.json
   jakarta.transaction:jakarta.transaction-api:jar:2.0.1:compile -- module jakarta.transaction
   org.eclipse.microprofile.context-propagation:microprofile-context-propagation-api:jar:1.3:compile -- module microprofile.context.propagation.api (auto)
   org.eclipse.parsson:parsson:jar:1.1.7:compile -- module org.eclipse.parsson
   org.jboss.logging:jboss-logging:jar:3.6.1.Final:compile -- module org.jboss.logging
   org.jboss.logmanager:jboss-logmanager:jar:3.1.2.Final:compile -- module org.jboss.logmanager
   org.jboss.slf4j:slf4j-jboss-logmanager:jar:2.0.0.Final:compile -- module slf4j.jboss.logmanager (auto)
   org.jboss.threads:jboss-threads:jar:3.9.1:compile -- module org.jboss.threads
   org.jctools:jctools-core:jar:4.0.5:compile -- module org.jctools.core
   org.slf4j:slf4j-api:jar:2.0.6:compile -- module org.slf4j
   org.wildfly.common:wildfly-common:jar:2.0.1:compile -- module org.wildfly.common
```

## slf4j-2
| Dependencies | 🧩 | 🟢 | ⚪ |
|-------------:|----:|----:|----:|
| 1 | 1 | 0 | 0 |
```
   org.slf4j:slf4j-api:jar:2.1.0-alpha1:compile -- module org.slf4j
```

## snakeyaml-2
| Dependencies | 🧩 | 🟢 | ⚪ |
|-------------:|----:|----:|----:|
| 1 | 1 | 0 | 0 |
```
   org.yaml:snakeyaml:jar:2.2:compile -- module org.yaml.snakeyaml
```

## spring-boot-3
| Dependencies | 🧩 | 🟢 | ⚪ |
|-------------:|----:|----:|----:|
| 34 | 17 | 17 | 0 |
```
   ch.qos.logback:logback-classic:jar:1.5.18:compile -- module ch.qos.logback.classic
   ch.qos.logback:logback-core:jar:1.5.18:compile -- module ch.qos.logback.core
   com.fasterxml.jackson.core:jackson-annotations:jar:2.19.1:compile -- module com.fasterxml.jackson.annotation
   com.fasterxml.jackson.core:jackson-core:jar:2.19.1:compile -- module com.fasterxml.jackson.core
   com.fasterxml.jackson.core:jackson-databind:jar:2.19.1:compile -- module com.fasterxml.jackson.databind
   com.fasterxml.jackson.datatype:jackson-datatype-jdk8:jar:2.19.1:compile -- module com.fasterxml.jackson.datatype.jdk8
   com.fasterxml.jackson.datatype:jackson-datatype-jsr310:jar:2.19.1:compile -- module com.fasterxml.jackson.datatype.jsr310
   com.fasterxml.jackson.module:jackson-module-parameter-names:jar:2.19.1:compile -- module com.fasterxml.jackson.module.paramnames
   io.micrometer:micrometer-commons:jar:1.15.1:compile -- module micrometer.commons [auto]
   io.micrometer:micrometer-observation:jar:1.15.1:compile -- module micrometer.observation [auto]
   jakarta.annotation:jakarta.annotation-api:jar:2.1.1:compile -- module jakarta.annotation
   org.apache.logging.log4j:log4j-api:jar:2.24.3:compile -- module org.apache.logging.log4j
   org.apache.logging.log4j:log4j-to-slf4j:jar:2.24.3:compile -- module org.apache.logging.log4j.to.slf4j
   org.apache.tomcat.embed:tomcat-embed-core:jar:10.1.42:compile -- module org.apache.tomcat.embed.core
   org.apache.tomcat.embed:tomcat-embed-el:jar:10.1.42:compile -- module org.apache.tomcat.embed.el
   org.apache.tomcat.embed:tomcat-embed-websocket:jar:10.1.42:compile -- module org.apache.tomcat.embed.websocket
   org.slf4j:jul-to-slf4j:jar:2.0.17:compile -- module jul.to.slf4j
   org.slf4j:slf4j-api:jar:2.0.17:compile -- module org.slf4j
   org.springframework.boot:spring-boot-autoconfigure:jar:3.5.3:compile -- module spring.boot.autoconfigure [auto]
   org.springframework.boot:spring-boot-starter-json:jar:3.5.3:compile -- module spring.boot.starter.json [auto]
   org.springframework.boot:spring-boot-starter-logging:jar:3.5.3:compile -- module spring.boot.starter.logging [auto]
   org.springframework.boot:spring-boot-starter-tomcat:jar:3.5.3:compile -- module spring.boot.starter.tomcat [auto]
   org.springframework.boot:spring-boot-starter-web:jar:3.5.3:compile -- module spring.boot.starter.web [auto]
   org.springframework.boot:spring-boot-starter:jar:3.5.3:compile -- module spring.boot.starter [auto]
   org.springframework.boot:spring-boot:jar:3.5.3:compile -- module spring.boot [auto]
   org.springframework:spring-aop:jar:6.2.8:compile -- module spring.aop [auto]
   org.springframework:spring-beans:jar:6.2.8:compile -- module spring.beans [auto]
   org.springframework:spring-context:jar:6.2.8:compile -- module spring.context [auto]
   org.springframework:spring-core:jar:6.2.8:compile -- module spring.core [auto]
   org.springframework:spring-expression:jar:6.2.8:compile -- module spring.expression [auto]
   org.springframework:spring-jcl:jar:6.2.8:compile -- module spring.jcl [auto]
   org.springframework:spring-web:jar:6.2.8:compile -- module spring.web [auto]
   org.springframework:spring-webmvc:jar:6.2.8:compile -- module spring.webmvc [auto]
   org.yaml:snakeyaml:jar:2.4:compile -- module org.yaml.snakeyaml
```

## streamex-0
| Dependencies | 🧩 | 🟢 | ⚪ |
|-------------:|----:|----:|----:|
| 1 | 1 | 0 | 0 |
```
   one.util:streamex:jar:0.8.3:compile -- module one.util.streamex
```
