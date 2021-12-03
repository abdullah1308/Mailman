package model

class Payload {
    private val headers: MutableList<Header>? = null

    fun getDate(): String {
        return headers?.find { it.name == "Date" }?.value ?: ""
    }

    fun getFrom(): String {
        return headers?.find { it.name == "From" }?.value ?: ""
    }

    fun getSubject(): String {
        return headers?.find { it.name == "Subject" }?.value ?: ""
    }
}