package ccc.frame.configuration

interface IStringConfiguration : IBaseConfiguration<IStringConfiguration> {

    fun strings(vararg strings: String): IStringConfiguration
    fun join(separator: String): IStringConfiguration
    fun keepSplit(): IStringConfiguration

}