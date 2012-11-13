object Fibonacci-B01 {
  def main(args:Array[String]){
    try{
      println("showColumnsCount=" + args(0))

      var a:BigInt = 1
      var b:BigInt = 1

      for(x <- 0 to args(0).toInt - 1) println({
        val aa: BigInt = a
        a = b
        b += aa
        aa
      })
    }catch{
      case e: Exception => e.printStackTrace()
    }
  }
}
