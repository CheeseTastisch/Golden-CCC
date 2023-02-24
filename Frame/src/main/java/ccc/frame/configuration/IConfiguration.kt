package ccc.frame.configuration

interface IConfiguration {

    fun <T : Any> use(system: System<T>): T

}