object Fibonacci-A01 {
	def main(args:Array[String]){
		try{
			val showColumnsCount = args(0).toInt
			println("showColumnsCount=" + args(0))

			var fibonacciValueArray = new Array[Int](showColumnsCount)

			for(i <- 0 to fibonacciValueArray.size - 1){
				if(i == 0){
					fibonacciValueArray(i) = 0
				}else if(i == 1){
					fibonacciValueArray(i) = 1
				}else{
					fibonacciValueArray(i) = fibonacciValueArray(i-1) + fibonacciValueArray(i-2)
				}
				println(i + " : " + fibonacciValueArray(i))
			}

		println(fibonacciValueArray(fibonacciValueArray.size)) // to raise exception

		}catch{
			case e: Exception => println(e.toString)
		}
	}
}