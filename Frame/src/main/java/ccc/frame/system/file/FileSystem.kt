package ccc.frame.system.file

import ccc.frame.caller.ICaller
import ccc.frame.system.ISystem
import org.apache.commons.io.FileUtils
import org.apache.commons.io.IOUtils
import java.io.File
import java.io.FileReader

class FileSystem(type: Type, directory: File) : ISystem {

    private val files = directory.listFiles()
        ?.filter { !it.isDirectory }
        ?.filter { !it.name.endsWith(".out") }
        ?.map { it to File(it.parentFile, "${it.name}.out") }
        ?.onEach { (_, out) -> if (out.exists()) out.delete() }
        ?.onEach { (_, out) -> FileUtils.touch(out) }
        ?.map { (input, output) -> IOUtils.readLines(FileReader(input)) to output }
        ?.map { (input, output) -> (if (type == Type.ONE_LINE && input.size >= 1) input.take(1) else input) to output }


    override fun run(caller: ICaller) {
        files?.forEach { (input, output) ->
            val converted = caller(input)
            FileUtils.writeLines(output, converted, true)
        }
    }


}