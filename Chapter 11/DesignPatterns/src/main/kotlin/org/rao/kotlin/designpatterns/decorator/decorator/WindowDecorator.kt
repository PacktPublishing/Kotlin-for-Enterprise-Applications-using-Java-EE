package org.rao.kotlin.designpatterns.decorator.decorator

import org.rao.kotlin.designpatterns.decorator.component.Window



open class WindowDecorator(private val window: Window) : Window {

    override fun getDescription(): String {

        return window.getDescription()
    }

    override fun getPrice(): Double {

        return window.getPrice()
    }
}
