package ccc.frame.caller

class ListToStringCaller(val toCall: (MutableList<String>) -> String) : ICaller {

    override fun invoke(list: List<String>) = listOf(toCall(list.toMutableList()))

}