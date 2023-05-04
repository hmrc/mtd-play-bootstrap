
import play.core.PlayVersion
import play.sbt.PlayImport._
import sbt._

object LibDependencies {

  val bootstrapPlayVersion = "5.24.0"


  def mtdBootstrapCommon(): Seq[ModuleID] = List(
    ws,
    "org.typelevel"                %% "cats-core"                 % "2.7.0",
    "com.chuusai"                  %% "shapeless"                 % "2.4.0-M1",
    "com.fasterxml.jackson.module" %% "jackson-module-scala"      % "2.13.1"
  )

  def mtdBootstrapLibrary(): Seq[ModuleID] = List(
    "uk.gov.hmrc"                  %% "bootstrap-backend-play-28" % bootstrapPlayVersion
  )

  def mtdBootstrapTest(scope: String = "test"): Seq[ModuleID] = List(
    "org.scalatest"         %% "scalatest"              % "3.2.12"             % scope,
    "org.scalacheck"        %% "scalacheck"             % "1.16.0"             % scope,
    "com.vladsch.flexmark"   % "flexmark-all"           % "0.62.2"             % scope,
    "org.scalamock"         %% "scalamock"              % "5.2.0"              % scope,
    "com.typesafe.play"     %% "play-test"              % PlayVersion.current  % scope,
    "uk.gov.hmrc"           %% "bootstrap-test-play-28" % bootstrapPlayVersion % scope,
    "com.github.tomakehurst" % "wiremock-jre8"          % "2.33.2"             % scope,
    "io.swagger.parser.v3"   % "swagger-parser-v3"      % "2.0.24"             % scope
  )

}
