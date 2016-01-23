name := "sangria-json4s-jackson"
organization := "org.sangria-graphql"
version := "0.1.0-SNAPSHOT"

description := "Sangria json4s-jackson marshalling"
homepage := Some(url("http://sangria-graphql.org"))
licenses := Seq("Apache License, ASL Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))

scalaVersion := "2.11.7"
scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies ++= Seq(
  "org.sangria-graphql" %% "sangria-marshalling-api" % "0.1.0-SNAPSHOT",
  "org.json4s" %% "json4s-jackson" % "3.3.0",

  "org.sangria-graphql" %% "sangria-marshalling-testkit" % "0.1.0-SNAPSHOT" % "test",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)

resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
git.remoteRepo := "git@github.com:sangria-graphql/sangria-json4s-jackson.git"

// Publishing

publishMavenStyle := true
publishArtifact in Test := false
pomIncludeRepository := (_ => false)
publishTo := Some(
  if (version.value.trim.endsWith("SNAPSHOT"))
    "snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  else
    "releases" at "https://oss.sonatype.org/service/local/staging/deploy/maven2")

// Site and docs

site.settings
site.includeScaladoc()
ghpages.settings

// nice *magenta* prompt!

shellPrompt in ThisBuild := { state =>
  scala.Console.MAGENTA + Project.extract(state).currentRef.project + "> " + scala.Console.RESET
}

// Additional meta-info

startYear := Some(2016)
organizationHomepage := Some(url("https://github.com/sangria-graphql"))
developers := Developer("OlegIlyenko", "Oleg Ilyenko", "", url("https://github.com/OlegIlyenko")) :: Nil
scmInfo := Some(ScmInfo(
  browseUrl = url("https://github.com/sangria-graphql/sangria-json4s-jackson.git"),
  connection = "scm:git:git@github.com:sangria-graphql/sangria-json4s-jackson.git"
))