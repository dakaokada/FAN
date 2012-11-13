import scala.util.control.Exception._

object Fibonacci-D03 {
// 昨日までのループ
//    val e = (0 until 10).foldLeft(op) { (ab, x) =>
//      Pair[BigInt, BigInt](ab._2, ab._2 + ab._1)
//    }
// e は (89,144)


// 修正版のループ
//    val e = (0 until 10).scanLeft(op) { (ab, x) =>
//      Pair[BigInt, BigInt](ab._2, ab._2 + ab._1)
//    }
// e は ((1,1), (1,2), (2,3), (3,5), (5,8), (8,13), (13,21), (21,34), (34,55), (55,89), (89,144))


// 途中経過
//  def fibs(k: Int) = {
//    val op = Pair[BigInt, BigInt](1, 1)
//    (0 until k).scanLeft(op) { (ab, x) =>
//      (ab._2, ab._2 + ab._1)
//    }
//  }


  def fibs(k: Int) = (0 until k).scanLeft(Pair[BigInt, BigInt](1, 1)) { (ab, x) => (ab._2, ab._2 + ab._1) }

  def main(args:Array[String]){
    println("showColumnsCount=" + args(0))

    allCatch.either{ args(0).toInt } match {
      case Left(e)  => e.printStackTrace()
      case Right(k) => fibs(k).foreach { x => println(x._1) }
    }
  }
}
