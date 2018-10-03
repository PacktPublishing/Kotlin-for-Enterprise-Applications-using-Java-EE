package org.rao.kotlin.designpatterns.observer

import java.util.ArrayList

class StockData : Subject {
    internal var observerList: MutableList<Observer> = ArrayList()
    var symbol: String ?= null

    var price: Float? = null


    override fun registerObserver(observer: Observer) {
        observerList.add(observer)

    }

    override fun removeObserver(observer: Observer) {
        val i = observerList.indexOf(observer)
        if (i >= 0) {
            observerList.removeAt(i)
        }
        observerList.remove(observer)

    }

    override fun notifyObservers() {
        for (i in observerList.indices) {
            observerList[i].update()
        }

    }

    fun setStockData(symbol: String, price: Float?) {
        this.symbol = symbol
        this.price = price
        notifyObservers()
    }
}
