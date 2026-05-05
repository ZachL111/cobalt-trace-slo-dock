object TestRunner {
  def main(args: Array[String]): Unit = {
    val signalcase_1 = Signal(65, 97, 15, 8, 11)
    assert(Policy.score(signalcase_1) == 207)
    assert(Policy.classify(signalcase_1) == "accept")
    val signalcase_2 = Signal(87, 102, 22, 11, 6)
    assert(Policy.score(signalcase_2) == 191)
    assert(Policy.classify(signalcase_2) == "accept")
    val signalcase_3 = Signal(100, 85, 15, 5, 12)
    assert(Policy.score(signalcase_3) == 292)
    assert(Policy.classify(signalcase_3) == "accept")
  }
}
