class Fabric(var color: String) {
    var pattern: String = "none"
    var patternColor: String = "none"
    init {
        println("$color fabric is created")
    }

    constructor() {
    }
}