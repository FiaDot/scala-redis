package ScalaExam

import redis.RedisClient
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object RedisExam {

	def main(args: Array[String]): Unit = {
		implicit val akkaSystem = akka.actor.ActorSystem()

		val redis = RedisClient("192.168.229.134", 6379)		
		
		val futurePong = redis.ping()
		println("Ping sent!")
		futurePong.map(pong => {
			println(s"Redis replied with a $pong")
		})
		Await.result(futurePong, 5 seconds)
		
		
		val req = redis.set("scalaredis", "100")	
		
		req.map( request => { 
			println(s"req = $request")
		})
		
		
		val res = redis.get("scalaredis")
			
		var result = res.map(_.get)
		var result2 = res.map(_.get).map(_.utf8String).map( response => println(s"res = $response"))
		
		println(s"$result")
		println(s"$result2")
		// .map( result => println(s"$result") )
		//var result = res.map(_.get).map(_.utf8String)
		
		
		//println(s"$result")
		
	
				
/*		
		val futurePong = redis.ping()
		println("Ping sent!")
		futurePong.map(pong => {
			println(s"Redis replied with a $pong")
		})
		Await.result(futurePong, 5 seconds)
*/
		akkaSystem.shutdown()
		
	}

}