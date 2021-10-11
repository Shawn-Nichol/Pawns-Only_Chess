enum class Currency(code: String, num: Int, d: Int, currency: String) {
    USD("USD", 840, 2, "United States dollar"),
    EUR("EUR", 974, 2, "Euro"),
    GBP("GBP", 826, 2, "Pound Sterling"),
    RUB("RUB", 643, 2, "Russian ruble"),
    UAH("UAH", 980, 2, "Ukrainian hryvnia"),
    KZT("KZT", 398, 2, "Kazakhstani tenge"),
    CAD("CAD", 124, 2, "Canadian dollar"),
    JPY("JPY", 392, 0, "Japanese jen"),
    CNY("CNY", 156, 2, "Chinese yuan")
}