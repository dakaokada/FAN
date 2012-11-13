import scala.util.control.Exception._
import scala.collection.mutable.Map

object Fibonacci-D01 {

  def fibs(showColumnsCount: Int): Map[Int, BigInt] = {

    // import文を見ればわかりますが、ミュータブルなMapです（本当はイミュータブルなマップを使うのが良いです）。
    // keyが0, 1, 2, 3, 4, 5...、va;ueが0, 1, 1, 2, 3, 5, 8...
    val valueMap: Map[Int, BigInt] = Map(0 -> 0)

    // このあのテーションをつけると末尾再帰になってないときにエラーにしてくれる。
    @scala.annotation.tailrec
    def fibsSub(a: BigInt, b: BigInt, c: Int): BigInt = {
      valueMap += (showColumnsCount - c) -> a
      c match {
        case 0 => 0
        case _ => fibsSub(a + b, a, c - 1)
      }
    }

    if (showColumnsCount > 0) {
      fibsSub(1, 0, showColumnsCount - 1)
    }

    // return XXって書いてないけど、メソッドの最後の式の値が戻り値になる。
    valueMap
  }

  def main(args:Array[String]){

    // args(0)をInt型に変換するときに例外発生するかもしれないのでallCatch.eitherで囲む。
    // このallCatch.eitherの戻り値はEither[Throwable, Int] 。
    // Either型は右側か左側のどちらかにだけ値を入れられるクラスです。
    // allCatch.eitherの中の式を実行して、
    // 例外が発生した場合は左側に例外が入ります（右側は空）
    // 例外が発生しなかった場合は右側に式の値が入ります（左側は空）
    // で、その結果をパターンマッチにかけてそれぞれ処理を実行してます。



    allCatch.either{ args(0).toInt } match {
      case Left(e)  => println(e.toString)
      case Right(i) => fibs(i).toSeq.sortBy(_._1).foreach{ x => println(x._1 + " : " + x._2) }

      // fibs(i)の戻り値がMap[Int, BigInt]
      // toSeqをつけるとSeq[(Int, BigInt)]
      // (Int, BigInt)の部分がタプル。Intの部分が_._1で、BigIntの部分が_._2でアクセスできます。
      // sortBy(_._1)で、Mapのキーの部分でソートします。

    }
  }
}

