package org.rao.kotlin.designpatterns.observer

object Test {
    @Throws(InterruptedException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val stockData = StockData()
        val daxTradeObserver = DAXTradeObserver(stockData)
        val lupinTradeObserver = LupinTradeObserver(stockData)

        val sampleData = SampleData()
        for (stock in sampleData.latestStockData) {

            stockData.setStockData(stock.symbol!!, stock.price)
            println("---------------------------------------")
            Thread.sleep(1000)
        }

    }
}
