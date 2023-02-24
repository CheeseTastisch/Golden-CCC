package ccc.frame.caller

interface ICaller {

    operator fun invoke(list: List<String>): List<String>

}