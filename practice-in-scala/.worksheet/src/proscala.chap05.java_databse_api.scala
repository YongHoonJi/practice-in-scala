//p255
package proscala.chap05

import java.lang.RuntimeException


	package proscala2.impicits {
		package database_api {
		
			class InvalidColumnName{
				def error(n: String){
					println("error : "+ n)
				}
			}
			
			trait Row {
				def getInt(colName: String): Int
				def getDougle(colName: String): Double
				def getText(colName: String): String
			}
		}
	
		package javadb{
			import database_api._
			
		}
	}
	
object java_databse_api {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(465); 

	println("")}
	
	
}
