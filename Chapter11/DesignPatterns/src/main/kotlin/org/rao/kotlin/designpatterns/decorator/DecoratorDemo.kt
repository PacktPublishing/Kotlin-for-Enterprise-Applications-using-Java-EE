package org.rao.kotlin.designpatterns.decorator

import org.rao.kotlin.designpatterns.decorator.component.Window
import org.rao.kotlin.designpatterns.decorator.concretecomponent.LargeWindow
import org.rao.kotlin.designpatterns.decorator.concretedecorator.color.BrightSilver
import org.rao.kotlin.designpatterns.decorator.concretedecorator.material.Glass
import org.rao.kotlin.designpatterns.decorator.concretedecorator.shape.Arched

object DecoratorDemo {
    @JvmStatic
    fun main(args: Array<String>) {

        var window: Window = LargeWindow()
        window = Arched(window)
        window = Glass(window)
        window = BrightSilver(window)


        println("Window description: ${window.getDescription()}")
        println("Window price: $${window.getPrice()}")


    }
}
