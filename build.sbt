val scala2_13 = "2.13.10"

lazy val commonSettings = List(
  organization := "uk.gov.hmrc",
  version := "1.0.0",
  //majorVersion := 1,
  isPublicArtefact := true,
  scalaVersion := scala2_13,
  crossScalaVersions := List(scala2_13),
  scalacOptions ++= List("-feature")
)

lazy val library = (project in file("."))
  .settings(
    commonSettings,
    publish / skip := true
  )
  .aggregate(
    mtdBootstrapCommon, mtdBootstrapTest, mtdBootstrapLibrary
  )

lazy val mtdBootstrapCommon = Project("mtd-bootstrap-common", file("mtd-bootstrap-common"))
  .settings(
    commonSettings,
    libraryDependencies ++= LibDependencies.mtdBootstrapCommon(),
    Compile / unmanagedSourceDirectories   += baseDirectory.value / "../mtd-bootstrap-common/src/main/scala",
    Compile / unmanagedResourceDirectories += baseDirectory.value / "../mtd-bootstrap-common/src/main/resources",
    Test    / unmanagedSourceDirectories   += baseDirectory.value / "../mtd-bootstrap-common/src/test/scala",
    Test    / unmanagedResourceDirectories += baseDirectory.value / "../mtd-bootstrap-common/src/test/resources"
  )

lazy val mtdBootstrapTest = Project("mtd-bootstrap-test", file("mtd-bootstrap-test"))
  .settings(
    commonSettings,
    libraryDependencies ++= LibDependencies.mtdBootstrapTest()
  )
  .dependsOn(mtdBootstrapCommon)

lazy val mtdBootstrapLibrary = Project("mtd-bootstrap-library", file("mtd-bootstrap-library"))
  .settings(
    commonSettings,
    libraryDependencies ++= LibDependencies.mtdBootstrapLibrary()
  ).dependsOn(
    mtdBootstrapCommon,
    mtdBootstrapTest % "test->test"
  )
