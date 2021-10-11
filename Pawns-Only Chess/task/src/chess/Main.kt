var playerOne = ""
var playerTwo = ""
var playersTurn = playerOne
var lastMoveColumn = -1
val board = mutableListOf(
    mutableListOf(" ", "a", "b", "c", "d", "e", "f", "g", "h"),
    mutableListOf("1", " ", " ", " ", " ", " ", " ", " ", " "),
    mutableListOf("2", "B", "W", "W", "W", "W", "W", "W", "W"),
    mutableListOf("3", " ", " ", " ", " ", " ", " ", " ", " "),
    mutableListOf("4", " ", " ", " ", " ", " ", " ", " ", " "),
    mutableListOf("5", " ", " ", " ", " ", " ", " ", " ", " "),
    mutableListOf("6", " ", " ", " ", " ", " ", " ", " ", " "),
    mutableListOf("7", "W", "B", "B", "B", "B", "B", "B", "B"),
    mutableListOf("8", " ", " ", " ", " ", " ", " ", " ", " "),
)

val regex = Regex("[a-h][1-8][a-h][1-8]")
val piece = Regex("[WB]")
var move = ""
var y1 = 0
var x1 = 0
var y2 = 0
var x2 = 0
var selectedPiece = "W"
var gameOn = true

fun startGame() {
    println("Pawns-Only Chess")
    println("First Player's name:")
    playerOne = readLine()!!.toString()
    println("Second Player's name:")
    playerTwo = readLine()!!.toString()
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
    // Alternates turns until end of game.
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
            if (move.toLowerCase() == "exit") {
                println("Bye!")
                gameOn = false
            } else {
                println("Invalid input")
            }
        }
    }
}

fun whiteTurn() {
    if (selectedPiece != "W") return noPawn()

    when {
        // Blocking space
        board[x2][y2].matches(piece) && (x1 + 1 == x2 || x1 + 2 == x2) && y1 == y2 -> println("Invalid Input")

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
    if (selectedPiece != "B") return noPawn()

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
    updatePieceLocation(
        if (playersTurn == playerOne) "W" else "B"
    )
    winConditions()
    playersTurn = if (playersTurn == playerOne) playerTwo else playerOne
}

fun updatePieceLocation(piece: String) {
    board[x2][y2] = piece
    board[x1][y1] = " "
    displayBoard()
}

fun noPawn() {
    println(
        "No " + if (playersTurn == playerOne) {
            "white pawn"
        } else {
            "black pawn"
        } + " at ${move[0]}$x1"
    )
}

fun winConditions() {
    if (y2 == 8 || y2 == 1) {
        println("$playersTurn wins")
        gameOn = false
    }
}


fun main() {
    startGame()
    displayBoard()
    turn()
}

