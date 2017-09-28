organization := "com.egfbank"
name         := "tfemp-app"
version      := "1.0"

scalaVersion := "2.11.8"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked")

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

//------------------------------------------------------------------------------

// http://mvnrepository.com/artifact/org.specs2/specs2-core_2.11
// libraryDependencies += "org.specs2" % "specs2-core_2.11" % "3.7.2" % "test"

// libraryDependencies += "org.specs2" %% "specs2-core" % "3.6.4" % "test"

// http://mvnrepository.com/artifact/commons-beanutils/commons-beanutils
// libraryDependencies += "commons-beanutils" % "commons-beanutils" % "1.9.2"

// http://mvnrepository.com/artifact/org.apache.commons/commons-dbcp2
// libraryDependencies += "org.apache.commons" % "commons-dbcp2" % "2.0.1"

// http://mvnrepository.com/artifact/commons-dbutils/commons-dbutils
// libraryDependencies += "commons-dbutils" % "commons-dbutils" % "1.6"


// libraryDependencies += "tv.cntt" %% "xitrum" % "3.26.0"

// libraryDependencies +=  "org.scalaj" %% "scalaj-http" % "2.3.0"

// Xitrum uses SLF4J, an implementation of SLF4J is needed
//libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3"

// For writing condition in logback.xml
// libraryDependencies += "org.codehaus.janino" % "janino" % "2.7.8"

// libraryDependencies += "org.webjars" % "bootstrap" % "3.3.6"

// Scalate template engine config for Xitrum -----------------------------------

// libraryDependencies += "tv.cntt" %% "xitrum-scalate" % "2.5"

// Precompile Scalate templates
seq(scalateSettings:_*)

ScalateKeys.scalateTemplateConfig in Compile := Seq(TemplateConfig(
  baseDirectory.value / "src" / "main" / "scalate",
  Seq(),
  Seq(Binding("helper", "xitrum.Action", true))
))

// xgettext i18n translation key string extractor is a compiler plugin ---------

autoCompilerPlugins := true
addCompilerPlugin("tv.cntt" %% "xgettext" % "1.3")
scalacOptions += "-P:xgettext:xitrum.I18n"


// For "sbt console"
unmanagedClasspath in Compile <+= (baseDirectory) map { bd => Attributed.blank(bd / "config") }

// For "sbt run"
unmanagedClasspath in Runtime <+= (baseDirectory) map { bd => Attributed.blank(bd / "config") }

// Put config directory in classpath for easier development --------------------

// Copy these to target/xitrum when sbt xitrum-package is run
XitrumPackage.copy("config", "public", "script", "module")
