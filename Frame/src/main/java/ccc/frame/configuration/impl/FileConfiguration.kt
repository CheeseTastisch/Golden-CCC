package ccc.frame.configuration.impl

import ccc.frame.configuration.IFileConfiguration
import ccc.frame.system.ISystem
import ccc.frame.system.file.FileSystem
import ccc.frame.system.file.Type
import java.io.File
import java.lang.IllegalStateException

class FileConfiguration : BaseConfiguration<IFileConfiguration>(), IFileConfiguration {

    private lateinit var type: Type
    private lateinit var dir: File

    override fun oneLine(): IFileConfiguration {
        this.type = Type.ONE_LINE
        return this
    }

    override fun multiLine(): IFileConfiguration {
        this.type = Type.MULTI_LINE
        return this
    }

    override fun directory(directory: String): IFileConfiguration {
        this.dir = File(".", directory)
        return this
    }

    override fun getInstance() = this

    override fun createSystem(): ISystem {
        if (!this::type.isInitialized) throw IllegalStateException("Type must be initialized to run the system.")
        if (!this::dir.isInitialized) throw IllegalStateException("Directory must be initialized to run the system.")

        return FileSystem(type, dir)
    }

}