scalaVersion := "2.11.8"

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-mock" % "3.0" % "test",
  "org.specs2" %% "specs2-core" % "3.0" % "test"
)

scalacOptions in Test ++= Seq("-Yrangepos")
