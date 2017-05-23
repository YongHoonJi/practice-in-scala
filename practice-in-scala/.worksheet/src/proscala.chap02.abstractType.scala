package proscala.chap02

import java.io._
// 추상화 타
object abstractType {
  abstract class BulkReader {
    type In // 추상맴버
    val source: In // 추상맴버
    def read: String // 추상맴버
  }

  class StringBulkReader(val source: String) extends BulkReader {
    type In = String // 추상 맴버In을source를 String형으로 지정
    def read: String = source
  }

  class FileBulkReader(val source: File) extends BulkReader {
    type In = File // 추상 맴버In을source를File형으로 지정
    def read: String = {
      val in = new BufferedInputStream(new FileInputStream(source))
      val numBytes = in.available()
      val bytes = new Array[Byte](numBytes)
      in.read(bytes, 0, numBytes)
      new String(bytes)
    }
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(737); 
  
  println(new StringBulkReader("Hello").read);$skip(139); 
  println(new FileBulkReader(
  	new File("/Users/Justin/git/practice-in-scala/practice-in-scala/src/proscala/chap02/factorial.sc")).read)}
}
