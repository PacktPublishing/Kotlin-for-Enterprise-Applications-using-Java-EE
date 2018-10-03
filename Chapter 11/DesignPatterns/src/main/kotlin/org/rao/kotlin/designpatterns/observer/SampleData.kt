package org.rao.kotlin.designpatterns.observer

import java.util.ArrayList
import java.util.Arrays

class SampleData {
    internal var priceList: MutableList<Float> = ArrayList()
    internal var companyList: MutableList<String> = ArrayList()
    val latestStockData: List<Stock>
        get() {
            val stockList = ArrayList<Stock>()
            for (i in priceList.indices) {
                val stock = Stock()
                stock.price = priceList[i]
                stock.symbol = companyList[i]
                stockList.add(stock)
            }
            return stockList

        }

    init {
        priceList.addAll(Arrays.asList(100.05f, 105.12f, 110.03f, 120.29f, 150.25f))
        companyList.addAll(Arrays.asList("DAX", "DAX", "LUPIN", "LUPIN", "DAX"))

    }

}
