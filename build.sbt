enablePlugins(ScalaJSPlugin)

name := "vicomte"

version := "0.0.1"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.codeborne" % "phantomjsdriver" % "1.2.1",
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
  "org.json4s" %% "json4s-jackson" % "3.3.0"
)