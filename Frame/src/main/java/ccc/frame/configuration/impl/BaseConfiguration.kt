package ccc.frame.configuration.impl

import ccc.frame.caller.ICaller
import ccc.frame.configuration.IBaseConfiguration
import ccc.frame.system.ISystem
import java.lang.IllegalStateException

abstract class BaseConfiguration<Configuration : IBaseConfiguration<Configuration>> : IBaseConfiguration<Configuration> {

    private lateinit var caller: ICaller

    override fun call(call: ICaller): Configuration {
        this.caller = call
        return this.getInstance()
    }

    override fun run() {
        if (!this::caller.isInitialized) throw IllegalStateException("Caller must be initialized to run the system.")
        this.createSystem().run(caller)
    }

    abstract fun getInstance(): Configuration

    abstract fun createSystem(): ISystem


}