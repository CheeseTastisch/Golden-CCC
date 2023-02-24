package ccc.frame.configuration.impl

import ccc.frame.configuration.IConfiguration
import ccc.frame.configuration.System

class Configuration : IConfiguration {

    override fun <T : Any> use(system: System<T>) = system.create()

}