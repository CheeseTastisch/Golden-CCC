package ccc.frame.caller

class ListToListCaller(val toCall: (MutableList<String>) -> List<String>) : ICaller {

    override fun invoke(list: List<String>) = toCall(list.toMutableList())

}