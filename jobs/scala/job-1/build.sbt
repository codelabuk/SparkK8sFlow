name := "Job-1-codelabuk"
organization := "org.codelabuk"
version := "0.1"
scalaVersion := "2.12.19"
autoScalaLibrary := false

val sparkVersion = "3.5.1"

val sparkDependencies  = Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-sql" % sparkVersion % "provided"
)

val testDependencies = Seq(
  "org.scalatest" %% "scalatest" % "3.2.18" % Test
)

libraryDependencies ++= sparkDependencies ++ testDependencies
