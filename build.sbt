name := "scala-redis"

version := "0.1.0"

scalaVersion := "2.11.1"

resolvers += "repo.codahale.com" at "http://repo.codahale.com"
resolvers += "rediscala" at "http://dl.bintray.com/etaty/maven"

libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.2.9"

libraryDependencies += "com.etaty.rediscala" %% "rediscala" % "1.3.1"
