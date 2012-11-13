object Fibonacci-C01 {
  def main(args: Array[String]) {
    // とりあえず100番目まで
    val i = 100
    // フィボナッチ数列の生成
    val fibList = fib(Nil, i)
    // インデックスつきリストにする
    val fibListWithIndex = fibList.zipWithIndex
    // println
    fibListWithIndex.foreach{case(f, n) => println(n + 1 + " : " + f)}
    // ワンライナーver
//    (fib(Nil, 100).zipWithIndex).foreach{case(f, n) => println(n + 1 + " : " + f)}
  }

  // Int だと42番目以降のフィボナッチ数が桁あふれ起こすのでBigIntにしておく
  def fib(list : List[BigInt], n : Int) : List[BigInt] =
    // list の要素数がn以上なら順番を入れ替えて返却
    if (list.size >= n) list.reverse else list.size match {
      // 要素数が 0 or 1　の場合は初期処理
      case 0 => fib(List(BigInt(1)), n)
      case 1 => fib(list.::(BigInt(1)), n)
      // 要素数が 0 or 1 でない場合、
      // 1番目と2番目の要素を足した数値をリストに加えて再帰する
      case _ => fib(list.::(list.head +  list.tail.head), n)
    }
}
