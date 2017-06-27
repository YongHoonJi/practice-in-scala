//p255
package proscala.chap05

import java.lang.RuntimeException


	package proscala2.impicits {
		package database_api {
		
			case class InvalidColumnName(n: String) extends RuntimeException("")
			
			trait Row {
				def getInt(colName: String): Int
				def getDougle(colName: String): Double
				def getText(colName: String): String
			}
		}
	
		package javadb{
			import database_api._
			
			case class JRow(rep: Map[String, Any]) extends Row {
				private def get(c : String): Any = rep.getOrElse(c, new InvalidColumnName())
			}
		}
	}
	
object java_databse_api {

	println("")
	
	
}
