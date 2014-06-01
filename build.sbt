name := "scala-redis"

version := "0.1.0"

scalaVersion := "2.11.1"

resolvers += "repo.codahale.com" at "http://repo.codahale.com"

libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.2.9"
libraryDependencies += "net.debasishg" %% "redisclient" % "2.13"