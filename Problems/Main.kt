var playerOne = ""
var playerTwo = ""
var playersTurn = playerOne
var move = ""
var y1 = 0
var x1 = 0
var y2 = 0
var x2 = 0
var selectedPiece = "W"
var gameOn = true
var lastMoveColumn = -1
val board = mutableListOf(
    mutableListOf(" ", "a", "b", "c", "d", "e", "f", "g", "h"),
    mutableListOf("1", " ", " ", " ", " ", " ", " ", " ", " "),
    mutableListOf("2", "W", "W", "W", "W", "W", "W", "W", "W"),
    mutableListOf("3", " ", " ", " ", " ", " ", " ", " ", " "),
    mutableListOf("4", " ", " ", " ", " ", " ", " ", " ", " "),
    mutableListOf("5", " ", " ", " ", " ", " ", " ", " ", " "),
    mutableListOf("6", " ", " ", " ", " ", " ", " ", " ", " "),
    mutableListOf("7", "B", "B", "B", "B", "B", "B", "B", "B"),
    mutableListOf("8", " ", " ", " ", " ", " ", " ", " ", " "),
)

val regex = Regex("[a-h][1-8][a-h][1-8]")
val piece = Regex("[WB]")


fun main() {
    println("Pawns-Only Chess")
    enterPlayersName()
    displayBoard()
    turn()
}

fun enterPlayersName() {
    println("First Player's name:")
    playerOne = readLine()!!.toString()
    println("Second Player's name:")
    playerTwo = readLine()!!.toString()
}

fun displayBoard() {
    for (i in board.reversed()) {
        print("  ")
        repeat(8) { print("+---") }
        println("+")
        println(
            if (i != board.first()) {
                i.joinToString(" | ") + " |"
            } else {
                i.joinToString("   ")
            }
        )
    }
}

/**
 * Alternates turns until end of game
 */
fun turn() {
    playersTurn = playerOne
    while (gameOn) {
        println("$playersTurn's turn: ")
        move = readLine()!!.toString()

        if (move.matches(regex)) {
            y1 = convertLetterToNum(move[0])
            x1 = move[1].toString().toInt()
            y2 = convertLetterToNum(move[2])
            x2 = move[3].toString().toInt()
            selectedPiece = board[x1][y1]

            if (playersTurn == playerOne) whiteTurn() else blackTurn()

        } else {
            if (move.lowercase() == "exit") {
                println("Bye!")
                gameOn = false
            } else {
                println("Invalid input")
            }
        }
    }
}

/**
 * Converts the column letter into a number so data can be pulled about the board matrix.
 */
fun convertLetterToNum(letter: Char): Int {
    return when (letter) {
        'a' -> 1
        'b' -> 2
        'c' -> 3
        'd' -> 4
        'e' -> 5
        'f' -> 6
        'g' -> 7
        'h' -> 8
        else -> 0
    }
}

fun whiteTurn() {
    if (selectedPiece != "W") return noPawnSelected()

    when {
        // Blocking space
        board[x2][y2].matches(piece) && (x1 + 1 == x2 || x1 + 2 == x2) && y1 == y2 ->
            println("Invalid Input")

        // Capture
        board[x2][y2] == "B" && (y1 + 1 == y2 || y1 - 1 == y2) && x1 + 1 == x2 -> {
            endTurn()
        }

        // En passant
        x1 == 5 && lastMoveColumn != -1 && (lastMoveColumn == y2 && (y1 - 1 == y2 || y1 + 1 == y2)) -> {
            // remove back piece
            board[x2 - 1][y2] = " "
            endTurn()
        }

        // Move two spaces from starting position
        x1 == 2 && x2 == 4 -> {
            lastMoveColumn = y2
            endTurn()
        }

        // Move space one position
        x1 + 1 == x2 && y1 == y2 -> {
            lastMoveColumn = -1
            endTurn()
        }

        // Pawn can't move more than one space.
        else -> println("Invalid Input")
    }
}

fun blackTurn() {
    if (selectedPiece != "B") return noPawnSelected()

    when {
        // Blocking space
        board[x2][y2].matches(piece) && (x1 - 1 == x2 || x1 - 2 == x2) && y1 == y2 -> println("Invalid Input")

        // Capture
        board[x2][y2] == "W" && (y1 + 1 == y2 || y1 - 1 == y2) && x1 - 1 == x2 -> {
            endTurn()
        }

        // En passant
        x1 == 4 && lastMoveColumn != -1 && (lastMoveColumn == y2 && (y1 - 1 == y2 || y1 + 1 == y2)) -> {
            // remove back piece
            board[x2 + 1][y2] = " "
            endTurn()
        }

        // Move two spaces from starting position
        x1 == 7 && x2 == 5 -> {
            lastMoveColumn = y2
            endTurn()
        }

        // Move space one position
        x1 - 1 == x2 && y1 == y2 -> {
            lastMoveColumn = -1
            endTurn()
        }

        // Pawn can't move more than one space.
        else -> println("Invalid Input")
    }
}

fun endTurn() {
    val piece = if (playersTurn == playerOne) "W" else "B"
    updatePieceLocation(piece)

    // check win conditions
    winConditions()

    if (gameOn) {
        if (playersTurn == playerOne) checkForBlackStalemate()
        else checkForWhiteStalemate()

        // Change players turn
        playersTurn = if (playersTurn == playerOne) playerTwo
        else playerOne
    }
}

fun updatePieceLocation(piece: String) {
    board[x2][y2] = piece
    board[x1][y1] = " "
    displayBoard()
}

fun noPawnSelected() {
    val pawn = if (playersTurn == playerOne) "White" else "black"

    println("No $pawn pawn at ${move[0]}$x1")
}

fun winConditions() {
    var counterB = 0
    var counterW = 0
    val color = if (playersTurn == playerOne) "White" else "Black"
    val message = "$color Wins!"

    // If piece has made it to the last row.
    if (x2 == 8 || x2 == 1) endGame(message)

    // check if all pieces have been removed.
    for (x in 1 until board.size) {
        for (y in 0 until board[x].size) {
            when (board[x][y]) {
                "B" -> counterB++
                "W" -> counterW++
            }
        }
    }

    if (counterB == 0) endGame(message)

    if (counterW == 0) endGame(message)
}

fun endGame(message: String) {
    println(message)
    println("Bye!")
    gameOn = false
}

fun checkForWhiteStalemate() {
    var stalemate = true
    for (x in 1 until board.size) {
        for (y in 0 until board[x].size) {
            if (board[x][y] == "W") {
                val above: String = board[x + 1][y]
                val aboveLeft = board[x + 1][y - 1]

                // above
                if (above != "B") stalemate = false

                // capture
                if (aboveLeft == "B") stalemate = false

                if (y < board.size - 1) {
                    val aboveRight = board[x + 1][y + 1]
                    if (aboveRight == "B")
                        stalemate = false
                }
            }
        }
    }

    if (stalemate) endGame("Stalemate!")
}

fun checkForBlackStalemate() {
    var stalemate = true
    var counterB = 0


    for (x in 1 until board.size) {
        for (y in 1 until board[x].size) {
            if (board[x][y] == "B") {
                counterB++
                val above: String = board[x - 1][y]
                val aboveLeft = board[x + 1][y - 1]


                // above
                if (above != "W") stalemate = false

                // capture
                if (aboveLeft == "W") stalemate = false

                if (y < board.size - 1) {
                    val aboveRight = board[x + 1][y + 1]
                    if (aboveRight == "W") {
                        stalemate = false
                    }
                }
            }
        }
    }

    if (stalemate) endGame("Stalemate!")
}