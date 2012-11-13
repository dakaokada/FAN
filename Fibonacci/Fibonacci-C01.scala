object Fibonacci-C01 {
  def main(args: Array[String]) {
    // �Ƃ肠����100�Ԗڂ܂�
    val i = 100
    // �t�B�{�i�b�`����̐���
    val fibList = fib(Nil, i)
    // �C���f�b�N�X�����X�g�ɂ���
    val fibListWithIndex = fibList.zipWithIndex
    // println
    fibListWithIndex.foreach{case(f, n) => println(n + 1 + " : " + f)}
    // �������C�i�[ver
//    (fib(Nil, 100).zipWithIndex).foreach{case(f, n) => println(n + 1 + " : " + f)}
  }

  // Int ����42�Ԗڈȍ~�̃t�B�{�i�b�`���������ӂ�N�����̂�BigInt�ɂ��Ă���
  def fib(list : List[BigInt], n : Int) : List[BigInt] =
    // list �̗v�f����n�ȏ�Ȃ珇�Ԃ����ւ��ĕԋp
    if (list.size >= n) list.reverse else list.size match {
      // �v�f���� 0 or 1�@�̏ꍇ�͏�������
      case 0 => fib(List(BigInt(1)), n)
      case 1 => fib(list.::(BigInt(1)), n)
      // �v�f���� 0 or 1 �łȂ��ꍇ�A
      // 1�Ԗڂ�2�Ԗڂ̗v�f�𑫂������l�����X�g�ɉ����čċA����
      case _ => fib(list.::(list.head +  list.tail.head), n)
    }
}
