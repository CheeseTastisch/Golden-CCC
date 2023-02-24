package ccc.frame.configuration

import ccc.frame.caller.ICaller
import ccc.frame.caller.ListToListCaller
import ccc.frame.caller.ListToStringCaller
import ccc.frame.caller.StringToStringCaller

interface IBaseConfiguration<Configuration : IBaseConfiguration<Configuration>> {

    fun call(call: ICaller): Configuration

    fun callListToList(call: (MutableList<String>) -> List<String>) = call(ListToListCaller(call))
    fun callListToString(call: (MutableList<String>) -> String) = call(ListToStringCaller(call))
    fun callStringToString(call: (String) -> String) = call(StringToStringCaller(call))

    fun run()

}
