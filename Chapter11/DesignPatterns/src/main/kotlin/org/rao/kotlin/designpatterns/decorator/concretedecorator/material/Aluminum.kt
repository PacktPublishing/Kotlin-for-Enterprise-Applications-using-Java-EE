package org.rao.kotlin.designpatterns.decorator.concretedecorator.material

import org.rao.kotlin.designpatterns.decorator.component.Window
import org.rao.kotlin.designpatterns.decorator.decorator.WindowDecorator

class Aluminum(window: Window) : WindowDecorator(window) {
    internal var description: String
    internal var price: Double

    init {
        description = "Aluminum material"
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
