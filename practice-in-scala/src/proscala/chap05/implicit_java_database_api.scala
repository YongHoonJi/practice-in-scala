package proscala.chap05

package proscala2.implicits {
  package scaladb {
    package database_api {
			case class InvalidColumnName(n: String) extends RuntimeException(s"Invalid column name $n")
			
			trait Row {
				def getInt(colName: String): Int
				def getDouble(colName: String): Double
				def getText(colName: String): String
			}
		}
	
		package javadb{
			import database_api._
			
			case class JRow(rep: Map[String, Any]) extends Row {
				private def get(c : String): Any = rep.getOrElse(c, throw InvalidColumnName(c))
				
				def getInt(c: String): Int = get(c).asInstanceOf[Int]
				def getDouble(c: String): Double = get(c).asInstanceOf[Double]
				def getText(c: String): String = get(c).asInstanceOf[String]
			}
			
			object JRow {
			    def apply(pairs: (String, Any)*) = new JRow(Map(pairs:_*))
			}
		}
		
		import javadb.JRow
    object implicts {
      implicit class SRow(jrow: JRow) {
        def get[T](c: String)(implicit toT: (JRow, String) => T): T =
          toT(jrow, c)
      }

      implicit val jrowToInt: (JRow, String) => Int =
        (jrow: JRow, c: String) => jrow.getInt(c)
      implicit val jrowToDouble: (JRow, String) => Double = 
        (jrow: JRow, c: String) => jrow.getDouble(c)
      implicit val jrowToString: (JRow, String) => String = 
        (jrow: JRow, c: String) => jrow.getText(c)
    }
  }
}