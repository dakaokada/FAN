import scala.util.control.Exception._

object Fibonacci-D02 {

  // この１文の意味がさっぱりわかりません。
  // ストリームというものの説明はこの辺で
  // http://eed3si9n.github.com/scala-collections-doc-ja/collections_14.html
  // http://www.scala-lang.org/api/current/scala/collection/immutable/Stream.html
  val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map { n => n._1 + n._2 }

  def main(args:Array[String]){
    allCatch.either(args(0).toInt) match {
      case Left(e)  => println(e.toString)
      case Right(i) => fibs.take(i + 1).zipWithIndex.foreach{ x => println(x._2 + " : " + x._1) }
    }
  }
}

