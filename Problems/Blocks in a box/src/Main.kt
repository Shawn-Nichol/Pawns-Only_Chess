class Block(val color: String) {

    object BlockProperties {
        var length = 0
        var width = 0

        fun blocksInBox(length: Int, width: Int): Int {
            return (length / BlockProperties.length) * (width / BlockProperties.width)
        }
    }
}
