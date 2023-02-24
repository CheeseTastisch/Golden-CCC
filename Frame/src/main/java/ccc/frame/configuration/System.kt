package ccc.frame.configuration

import ccc.frame.configuration.impl.FileConfiguration
import ccc.frame.configuration.impl.StringConfiguration

abstract class System<T : Any> {

    internal abstract fun create(): T

    companion object {

        val FILE = object : System<IFileConfiguration>() {
            override fun create() = FileConfiguration()
        }

        val STRING = object : System<IStringConfiguration>() {
            override fun create() = StringConfiguration()
        }

    }

}