package ccc.frame.system.string

import ccc.frame.caller.ICaller
import ccc.frame.system.ISystem

class StringSystem(
    private val strings: List<String>,
    private val type: Type,
    private val separator: String? = null
) : ISystem {

    override fun run(caller: ICaller) {
        val converted = when (type) {
            Type.JOINED -> listOf(caller(listOf(strings.joinToString(separator ?: "\n"))))
            Type.SPLIT -> strings.map { caller(listOf(it)) }
        }

        println(converted.flatten().joinToString("\n"))
    }

}