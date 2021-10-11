enum class Countries(private val currency: String) {
    GERMANY("Euro"),
    MALI("CFA franc"),
    DOMINICA("Eastern Caribbean dollar"),
    CANADA("Canadian dollar"),
    SPAIN("Euro"),
    AUSTRALIA("Australian dollar"),
    BRAZIL("Brazilian real"),
    SENEGAL("CFA franc"),
    FRANCE("Euro"),
    GRENADA("Eastern Caribbean dollar"),
    KIRIBATI("Australian dollar"),
    NULL("");

    companion object {
        fun findCountry(country: String): Countries {
            for (enum in Countries.values()) {
                if (country == enum.name) return enum
            }
            return NULL
        }
    }

    fun getCurrency(): String = currency
}

fun main() {
    val (i1, i2) = readLine()!!.toUpperCase().split(" ")
    val c1 = Countries.findCountry(i1).name
    val c2 = Countries.findCountry(i2).name

    println(Countries.valueOf(c1).getCurrency() == Countries.valueOf(c2).getCurrency())
}