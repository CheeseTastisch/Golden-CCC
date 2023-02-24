package test

import ccc.frame.Frame
import ccc.frame.configuration.System

fun main() {
    Frame.createFrame()
        .use(System.FILE)
        .directory("lvl1")
        .multiLine()
        .callListToList {
            it.map { it.uppercase() }
        }
        .run()
}