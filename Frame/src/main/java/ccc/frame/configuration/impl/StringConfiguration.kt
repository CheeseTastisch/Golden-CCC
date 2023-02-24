package ccc.frame.configuration.impl

import ccc.frame.configuration.IStringConfiguration
import ccc.frame.system.ISystem
import ccc.frame.system.string.StringSystem
import ccc.frame.system.string.Type
import java.lang.IllegalStateException

class StringConfiguration : BaseConfiguration<IStringConfiguration>(), IStringConfiguration {

    private lateinit var inputs: Array<out String>
    private lateinit var type: Type
    private var separator: String? = null

    override fun strings(vararg strings: String): IStringConfiguration {
        this.inputs = strings
        return this
    }

    override fun join(separator: String): IStringConfiguration {
        this.type = Type.JOINED
        this.separator = separator
        return this
    }

    override fun keepSplit(): IStringConfiguration {
        this.type = Type.SPLIT
        return this
    }

    override fun getInstance() = this

    override fun createSystem(): ISystem {
        if (!this::inputs.isInitialized) throw IllegalStateException("Strings must be initialized to run the system.")
        if (!this::type.isInitialized) throw IllegalStateException("Type must be initialized to run the system.")

        return StringSystem(inputs.toList(), type, separator)
    }

}