package org.rao.kotlin.designpatterns.decorator.concretedecorator.color

import org.rao.kotlin.designpatterns.decorator.component.Window
import org.rao.kotlin.designpatterns.decorator.decorator.WindowDecorator

class BrightSilver(private val window: Window) : WindowDecorator(window) {
    internal var description: String
    internal var price: Double

    init {
        description = "BrightSilver color"
        price = 20.00
    }

    override fun getDescription(): String {
        var desc = super.getDescription()
        return "$desc, $description"
    }

    override fun getPrice(): Double {

        return super.getPrice() + price
    }
}
