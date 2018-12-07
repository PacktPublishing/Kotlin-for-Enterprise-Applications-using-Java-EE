package org.rao.kotlin.designpatterns.observer

interface Subject {

    fun registerObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers()
}
