package ccc.frame.caller

class StringToStringCaller(val toCall: (String) -> String) : ICaller {

    override fun invoke(list: List<String>) = listOf(toCall(list[0]))

}