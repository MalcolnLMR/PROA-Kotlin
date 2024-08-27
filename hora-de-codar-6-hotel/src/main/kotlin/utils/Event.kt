package utils

import kotlin.reflect.KFunction0

class Event {
    private val observers = mutableSetOf<KFunction0<Unit>>()

    operator fun plusAssign(observer: KFunction0<Unit>) {
        observers.add(observer)
    }

    operator fun minusAssign(observer: KFunction0<Unit>) {
        observers.remove(observer)
    }

    operator fun invoke() {
        for (observer in observers)
            observer()
    }
}