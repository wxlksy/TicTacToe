import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.control.Button
import javafx.scene.layout.GridPane
import javafx.stage.Stage
import kotlin.random.Random

class TicTacToeApp : Application() {

    private val board = Array(3) { Array(3) { Button() } }
    private var currentPlayer = if (Random.nextBoolean()) "X" else "O"
    private var gameEnded = false

    override fun start(stage: Stage) {
        val grid = GridPane()

        for (i in 0..2) {
            for (j in 0..2) {
                val button = Button("")
                button.minWidth = 100.0
                button.minHeight = 100.0
                button.setOnMouseClicked {
                    if (button.text.isEmpty() && !gameEnded) {
                        button.text = currentPlayer
                        if (checkWin()) {
                            showWinMessage("$currentPlayer победил!")
                            gameEnded = true
                        } else if (isBoardFull()) {
                            showWinMessage("Ничья!")
                            gameEnded = true
                        } else {
                            currentPlayer = if (currentPlayer == "X") "O" else "X"
                        }
                    }
                }
                board[i][j] = button
                grid.add(button, i, j)
            }
        }

        val scene = Scene(grid, 300.0, 300.0)
        stage.title = "Крестики-нолики"
        stage.scene = scene
        stage.show()
    }

    private fun checkWin(): Boolean {
        // Проверка строк, столбцов и диагоналей
        for (i in 0..2) {
            if (board[i][0].text == currentPlayer && board[i][1].text == currentPlayer && board[i][2].text == currentPlayer) {
                return true
            }
            if (board[0][i].text == currentPlayer && board[1][i].text == currentPlayer && board[2][i].text == currentPlayer) {
                return true
            }
        }

        if (board[0][0].text == currentPlayer && board[1][1].text == currentPlayer && board[2][2].text == currentPlayer) {
            return true
        }

        if (board[0][2].text == currentPlayer && board[1][1].text == currentPlayer && board[2][0].text == currentPlayer) {
            return true
        }

        return false
    }

    private fun isBoardFull(): Boolean {
        for (row in board) {
            for (button in row) {
                if (button.text.isEmpty()) {
                    return false
                }
            }
        }
        return true
    }

    private fun showWinMessage(message: String) {
        val alert = Alert(Alert.AlertType.INFORMATION)
        alert.title = "Игра окончена"
        alert.headerText = message
        alert.showAndWait()
    }
}

fun main() {
    Application.launch(TicTacToeApp::class.java)
}