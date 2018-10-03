package org.rao.kotlin.designpatterns.decorator.concretedecorator.shape

import org.rao.kotlin.designpatterns.decorator.component.Window
import org.rao.kotlin.designpatterns.decorator.decorator.WindowDecorator

class Round(private val window: Window) : WindowDecorator(window) {
    internal var description: String
    internal var price: Double = 0.toDouble()
    init {
        description = "Round shape"
        price = 10.00
    }

    override fun getDescription(): String {
        var desc = super.getDescription()
        return "$desc, $description"
    }

    override fun getPrice(): Double {

        return super.getPrice() + price
    }
}
