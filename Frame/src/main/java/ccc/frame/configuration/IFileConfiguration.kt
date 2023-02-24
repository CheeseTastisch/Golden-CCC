package ccc.frame.configuration

interface IFileConfiguration : IBaseConfiguration<IFileConfiguration> {

    fun oneLine(): IFileConfiguration
    fun multiLine(): IFileConfiguration

    fun directory(directory: String): IFileConfiguration

}