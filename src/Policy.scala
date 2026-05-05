case class Signal(demand: Int, capacity: Int, latency: Int, risk: Int, weight: Int)

object Policy {
  private val threshold = 170
  private val riskPenalty = 7
  private val latencyPenalty = 2
  private val weightBonus = 6

  def score(signal: Signal): Int =
    signal.demand * 2 + signal.capacity + signal.weight * weightBonus -
      signal.latency * latencyPenalty - signal.risk * riskPenalty

  def classify(signal: Signal): String =
    if (score(signal) >= threshold) "accept" else "review"
}
