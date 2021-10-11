class Player(val id: Int, val name: String, val hp: Int) {
    companion object {
        fun create(name: String): Player {
            var id =  kotlin.random.Random.nextInt()
            var hp = 100
            return Player(id, name, hp)
        }
    }
}