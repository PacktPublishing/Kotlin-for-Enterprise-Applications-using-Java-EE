package org.rao.kotlin.designpatterns.observer

class LupinTradeObserver internal constructor(internal var stockData: StockData) : Observer {
    init {
        stockData.registerObserver(this)

    }

    override fun update() {
        val price = stockData.price
        val symbol = stockData.symbol
        if (symbol.equals(TradeEnum.LUPIN.name, ignoreCase = true)) {
            println("The new price for ${TradeEnum.LUPIN.name}: " + price!!)
        }

    }
}
