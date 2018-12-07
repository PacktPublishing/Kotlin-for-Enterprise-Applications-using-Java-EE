package org.rao.kotlin.designpatterns.decorator.concretedecorator.material

import org.rao.kotlin.designpatterns.decorator.component.Window
import org.rao.kotlin.designpatterns.decorator.decorator.WindowDecorator

class Clad(private val window: Window) : WindowDecorator(window) {
    internal var description: String
    internal var price: Double

    init {
        description = "Clad material"
        price = 25.00
    }

    override fun getDescription(): String {
        var desc = super.getDescription()
        return "$desc, $description"
    }


    override fun getPrice(): Double {

        return super.getPrice() + price
    }
}
