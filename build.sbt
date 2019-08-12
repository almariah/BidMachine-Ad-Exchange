organization in ThisBuild := "com.appodeal"
scalaVersion in ThisBuild := "2.12.8"

scalacOptions in ThisBuild ++= Seq("-Ypartial-unification", "-feature", "-deprecation", "-language:higherKinds")

sources in (ThisBuild, Compile, doc) := Seq.empty
publishArtifact in (ThisBuild, packageDoc) := false

resolvers in ThisBuild ++= Seq(
  "Bintary JCenter" at "http://jcenter.bintray.com",
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Typesafe Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "Atlassian Releases" at "https://maven.atlassian.com/public/",
  Resolver.bintrayRepo("cakesolutions", "maven"),
  "Artifactory" at "https://mvnrepository.com/"
)

libraryDependencies in ThisBuild += compilerPlugin("org.spire-math" %% "kind-projector"     % "0.9.7")
libraryDependencies in ThisBuild += compilerPlugin("com.olegpy"     %% "better-monadic-for" % "0.3.0-M4")

libraryDependencies in ThisBuild ++= Seq(cats, macwire, monix, enumeratum)

// Typelevel
lazy val cats    = "org.typelevel"            %% "cats-core"  % "1.5.0"
lazy val macwire = "com.softwaremill.macwire" %% "macros"     % "2.3.1"
lazy val monix   = "io.monix"                 %% "monix-eval" % "3.0.0-RC2"

// Scala
lazy val `akka-http` = "com.typesafe.akka"      %% "akka-http-core" % "10.0.14" % Provided
lazy val `scala-xml` = "org.scala-lang.modules" %% "scala-xml"      % "1.1.1"

lazy val `scala-uri` = "io.lemonlabs" %% "scala-uri" % "1.4.1"

// Utils
lazy val `nv-i18n`     = "com.neovisionaries"    % "nv-i18n"     % "1.23"
lazy val `java-semver` = "com.github.zafarkhaja" % "java-semver" % "0.9.0"

lazy val `enumeratum`       = "com.beachape" %% "enumeratum"       % "1.5.13"
lazy val `enumeratum-circe` = "com.beachape" %% "enumeratum-circe" % "1.5.20"

// Play
lazy val `play-guard`  = "com.digitaltangible" %% "play-guard"  % "2.2.0"

lazy val `play-silhouette-version` = "5.0.6"

lazy val `play-silhouette`                 = "com.mohiva" %% "play-silhouette"                 % `play-silhouette-version`
lazy val `play-silhouette-password-bcrypt` = "com.mohiva" %% "play-silhouette-password-bcrypt" % `play-silhouette-version`
lazy val `play-silhouette-crypto-jca`      = "com.mohiva" %% "play-silhouette-crypto-jca"      % `play-silhouette-version`
lazy val `play-silhouette-persistence`     = "com.mohiva" %% "play-silhouette-persistence"     % `play-silhouette-version`

lazy val `play-slick-version` = "3.0.3"

lazy val `play-slick`            = "com.typesafe.play" %% "play-slick"            % `play-slick-version`
lazy val `play-slick-evolutions` = "com.typesafe.play" %% "play-slick-evolutions" % `play-slick-version`

// Slick
lazy val `slick-version`    = "3.2.3"
lazy val `slick-pg-version` = "0.16.3"

lazy val `slick`               = "com.typesafe.slick"  %% "slick"               % `slick-version` % Provided
lazy val `slick-pg`            = "com.github.tminglei" %% "slick-pg"            % `slick-pg-version`
lazy val `slick-pg-circe-json` = "com.github.tminglei" %% "slick-pg_circe-json" % `slick-pg-version`
lazy val `slick-pg-joda-time`  = "com.github.tminglei" %% "slick-pg_joda-time"  % `slick-pg-version`

// External clients
lazy val `rediscala`          = "com.github.etaty"  %% "rediscala"          % "1.8.0"
lazy val `scala-kafka-client` = "net.cakesolutions" %% "scala-kafka-client" % "2.0.0"

// Circe
lazy val `circe-version`    = "0.11.1"
lazy val `circe-core`       = "io.circe" %% "circe-core" % `circe-version`
lazy val `circe-parser`     = "io.circe" %% "circe-parser" % `circe-version`
lazy val `circe-java8`      = "io.circe" %% "circe-java8" % `circe-version`
lazy val `circe-derivation` = "io.circe" %% "circe-derivation" % "0.10.0-M1"
lazy val `play-circe`       = "com.dripower" %% "play-circe" % "2610.0"

// Jsoniter
lazy val `jsoniter-scala-version` = "0.36.10"
lazy val `jsoniter-scala-core`    = "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core" % `jsoniter-scala-version` % Compile
lazy val `jsoniter-scala-macros`  = "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % `jsoniter-scala-version` % Provided

// Parboiled
lazy val `parboiled-version` = "2.1.5"
lazy val `parboiled` = "org.parboiled" %% "parboiled" % `parboiled-version`

// ScalaPB
lazy val `scalapb-runtime`          = "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion
lazy val `scalapb-runtime-protobuf` = "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"
lazy val `google-protobuf`          = "com.google.protobuf"  % "protobuf-java"    % "3.6.1"

// Cache
lazy val `scalacache-version` = "0.27.0"

lazy val `scalacache-core`     = "com.github.cb372" %% "scalacache-core"     % `scalacache-version`
lazy val `scalacache-monix`    = "com.github.cb372" %% "scalacache-monix"    % `scalacache-version`
lazy val `scalacache-circe`    = "com.github.cb372" %% "scalacache-circe"    % `scalacache-version`
lazy val `scalacache-redis`    = "com.github.cb372" %% "scalacache-redis"    % `scalacache-version`
lazy val `scalacache-caffeine` = "com.github.cb372" %% "scalacache-caffeine" % `scalacache-version`

// Kamon telemetry
lazy val `kamon-core`       = "io.kamon" %% "kamon-core"       % "1.1.3"
lazy val `kamon-prometheus` = "io.kamon" %% "kamon-prometheus" % "1.1.1"

// Test
lazy val `scalatestplus-play` = "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2"  % Test
lazy val `scalatest`          = "org.scalatest"          %% "scalatest"          % "3.0.5"  % Test
lazy val `scalamock`          = "org.scalamock"          %% "scalamock"          % "4.1.0"  % Test
lazy val `scalacheck`         = "org.scalacheck"         %% "scalacheck"         % "1.14.0" % Test

lazy val dockerSettings = Seq(
  dockerBaseImage := "openjdk:8-jre"
)

lazy val exchange = (project in file("."))
  .aggregate(
    `api-gateway`,
    `auction-gateway`,
    `common`,
    `common-db`,
    `common-proto`,
    `common-service-locator`,
    `druid-service`,
    `druid-service-api`,
    `openrtb`,
    `settings-service`,
    `settings-service-api`,
    `tracker-gateway`,
  )

lazy val `common` = (project in file("src/common"))
  .dependsOn(`common-db`, openrtb, `common-proto`)
  .settings(
    name := "common",
    sources in (Compile, doc) := Seq.empty,
    libraryDependencies += lagomScaladslApi,
    libraryDependencies ++= Seq(
      `scalacache-core`,
      `scalacache-monix`,
      `scalacache-circe`,
      `scalacache-redis`,
      `scalacache-caffeine`
    ),
    libraryDependencies ++= Seq(
      `akka-http`,
      `java-semver`,
      `circe-core`,
      `enumeratum-circe`,
      `jsoniter-scala-core`,
      `jsoniter-scala-macros`,
      `scala-kafka-client`,
      `nv-i18n`,
      `scala-xml`,
      `slick`,
      `scala-uri`
    )
  )

lazy val `openrtb` = (project in file("src/openrtb"))
  .dependsOn(`common-proto`)
  .settings(
    libraryDependencies ++= Seq(`circe-core`, `circe-derivation`)
  )

lazy val `common-db` = (project in file("src/common-db"))
  .settings(libraryDependencies += `enumeratum`,
            libraryDependencies ++= Seq(`play-slick`, `slick-pg`, `slick-pg-circe-json`, `slick-pg-joda-time`))

lazy val `common-service-locator` = (project in file("src/common-service-locator"))
  .settings(
    libraryDependencies += lagomScaladslApi,
    libraryDependencies += macwire
  )

lazy val `druid-service-api` = (project in file("src/druid-service-api"))
  .enablePlugins(LagomScala)
  .dependsOn(common, `settings-service-api`)
  .settings(
    libraryDependencies += "io.swagger" %% "swagger-play2" % "1.7.1",
    libraryDependencies += lagomScaladslApi
  )

lazy val `druid-service` = (project in file("src/druid-service"))
  .enablePlugins(LagomScala)
  .dependsOn(`druid-service-api`, `settings-service-api`, `common-service-locator`)
  .settings(dockerSettings: _*)
  .settings(
    libraryDependencies += lagomScaladslApi,
    libraryDependencies += "ing.wbaa.druid"     %% "scruid"  % "2.1.0",
    libraryDependencies += "com.github.melrief" %% "purecsv" % "0.1.1"
  )

lazy val `api-gateway` = (project in file("src/api-gateway"))
  .enablePlugins(PlayScala && LagomPlay)
  .dependsOn(`common-db`,
             `settings-service-api`,
             `common-service-locator`,
             `druid-service-api`)
  .settings(dockerSettings: _*)
  .settings(
    routesImport ++= Seq(
      "com.appodealx.exchange.settings.models.seller._",
      "com.appodealx.exchange.settings.models.buyer._",
      "com.appodealx.exchange.settings.models.binders._",
      "com.appodealx.exchange.common.models._",
      "com.appodealx.exchange.common.models.binders._",
      "silhouette._",
      "silhouette.binders._"
    )
  )
  .settings(
    libraryDependencies += cats,
    libraryDependencies ++= Seq(`circe-core`, `play-circe`),
    libraryDependencies += macwire,
    libraryDependencies += "io.swagger"  %% "swagger-play2" % "1.7.1",
    libraryDependencies += "org.webjars" % "swagger-ui"     % "3.2.2",
    libraryDependencies ++= Seq(`play-silhouette`,
                                `play-silhouette-password-bcrypt`,
                                `play-silhouette-crypto-jca`,
                                `play-silhouette-persistence`),
    libraryDependencies ++= Seq(`play-guard`, `play-slick-evolutions`),
    libraryDependencies ++= Seq(
      `scalacache-core`,
      `scalacache-monix`,
      `scalacache-circe`,
      `scalacache-redis`,
      `scalacache-caffeine`
    )
  )

lazy val `auction-gateway` = (project in file("src/auction-gateway"))
  .enablePlugins(PlayScala && LagomPlay)
  .dependsOn(
    common,
    openrtb,
    `common-proto`,
    `settings-service`,
    `common-service-locator`
  )
  .settings(dockerSettings: _*)
  .settings(
    test in Test := Def.sequential(test in Test dependsOn (test in Test in `common`)).value,
    parallelExecution in Test := false,
    aggregateReverseRoutes := Seq(trackerGatewayRef),
    libraryDependencies ++= Seq(`circe-core`, `circe-derivation`, `play-circe`),
    libraryDependencies ++= Seq(`kamon-core`, `kamon-prometheus`),
    libraryDependencies ++= Seq(`java-semver`, `scala-kafka-client`, `rediscala`, `scalapb-runtime`),
    libraryDependencies += "org.codehaus.janino"   % "janino"                   % "3.0.10",
    libraryDependencies += "com.snowplowanalytics" %% "scala-maxmind-iplookups" % "0.5.0",
    libraryDependencies += `parboiled`,
    libraryDependencies ++= Seq(
      `scalatest`,
      `scalamock`,
      `scalatestplus-play`,
      "com.github.sebruck"       %% "scalatest-embedded-redis" % "0.3.0" % Test,
      "de.leanovate.play-mockws" %% "play-mockws"              % "2.6.6" % Test
    ),
    libraryDependencies += "com.lihaoyi" %% "pprint" % "0.5.3"
  )

lazy val `tracker-gateway` = (project in file("src/tracker-gateway"))
  .enablePlugins(PlayScala && LagomPlay)
  .dependsOn(common, openrtb, `settings-service-api`)
  .settings(dockerSettings: _*)
  .settings(
    parallelExecution in Test := false,
    sources in (Compile, doc) := Seq.empty,
    publishArtifact in (Compile, packageDoc) := false,
    publishArtifact in packageDoc := false,
    libraryDependencies ++= Seq(
      `scalatest`,
      `scalatestplus-play`,
      `rediscala`
    )
  )
lazy val trackerGatewayRef = LocalProject("tracker-gateway")

lazy val `settings-service-api` = (project in file("src/settings-service-api"))
  .enablePlugins(LagomScala)
  .dependsOn(common)
  .settings(
    libraryDependencies += lagomScaladslApi
  )

lazy val `settings-service` = (project in file("src/settings-service"))
  .enablePlugins(LagomScala)
  .dependsOn(common, openrtb, `settings-service-api`, `common-service-locator`)
  .settings(dockerSettings: _*)
  .settings(
    libraryDependencies ++= Seq(cats, macwire, `enumeratum`, `java-semver`),
    libraryDependencies ++= Seq(`play-slick`, `play-slick-evolutions`),
    libraryDependencies ++= Seq(`slick-pg`, `slick-pg-circe-json`, `slick-pg-joda-time`)
  )

lazy val `common-proto` = (project in file("src/common-proto"))
  .settings(
    libraryDependencies ++= Seq(`scalapb-runtime-protobuf`, `google-protobuf`),
    PB.targets in Compile := Seq(scalapb.gen(flatPackage = true) -> (sourceManaged in Compile).value),
    PB.protocOptions in Compile := Seq(
      "--descriptor_set_out=" +
        (baseDirectory in Compile).value / "src" / "main" / "protobuf" / "bidmachine.desc"
    )
  )
