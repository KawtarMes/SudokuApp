package com.example.sudoku.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sudoku.data.dtos.GridDto
import com.example.sudoku.data.repositories.GridRepository
import com.example.sudoku.navigation.Screen
import com.example.sudoku.utils.Level
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class GameVM @Inject constructor(
    val gridRepository: GridRepository,
) : ViewModel() {

    // recupere le level choisi du screen level pour faire la requete avec
    // afficher que des grille non completé (join?)
    //grille
    //onclick comparé grilles initiale avec la solution
    //requete lorsque la grille completé -> reussi ou pas
    //naviguer vers result

    private val _gridStateFlow = MutableStateFlow<GridDto>(
        GridDto(
            "",
            Level.Intermediate,
            gridStart = listOf(
                listOf(5, 3, 0, 0, 7, 0, 0, 0, 0),
                listOf(6, 0, 0, 1, 9, 5, 0, 0, 0),
                listOf(0, 9, 8, 0, 0, 0, 0, 6, 0),
                listOf(8, 0, 0, 0, 6, 0, 0, 0, 3),
                listOf(4, 0, 0, 8, 0, 3, 0, 0, 1),
                listOf(7, 0, 0, 0, 2, 0, 0, 0, 6),
                listOf(0, 6, 0, 0, 0, 0, 2, 8, 0),
                listOf(0, 0, 0, 4, 1, 9, 0, 0, 5),
                listOf(0, 0, 0, 0, 8, 0, 0, 7, 9)
            ),
            gridSolution = listOf(
                listOf(5, 3, 4, 6, 7, 8, 9, 1, 2),
                listOf(6, 7, 2, 1, 9, 5, 3, 4, 8),
                listOf(1, 9, 8, 3, 4, 2, 5, 6, 7),
                listOf(8, 5, 9, 7, 6, 1, 4, 2, 3),
                listOf(4, 2, 6, 8, 5, 3, 7, 9, 1),
                listOf(7, 1, 3, 9, 2, 4, 8, 5, 6),
                listOf(9, 6, 1, 5, 3, 7, 2, 8, 4),
                listOf(2, 8, 7, 4, 1, 9, 6, 3, 5),
                listOf(3, 4, 5, 2, 8, 6, 1, 7, 9)
            )
        )
    )
    val gridMutableStateFlow get() = _gridStateFlow.asStateFlow()

    val gridSolution = gridMutableStateFlow.value.gridSolution
    val gridInitial = gridMutableStateFlow.value.gridStart

    private val _messageStateFlow = MutableStateFlow("")
    val messageStateFlow = _messageStateFlow.asStateFlow()

    private val _dialogStateFlow = MutableStateFlow("")
    val dialogStateFlow = _dialogStateFlow.asStateFlow()



    private val _navigateToNextScreen = MutableSharedFlow<String>()
    val navigateToNextScreen = _navigateToNextScreen.asSharedFlow()


    fun getGridByLevel(level: String) {
        try {
            viewModelScope.launch {
                val grid = withContext(Dispatchers.IO) {
                    gridRepository.getGridByLevel(levelChosen = Level.valueOf(level))
                }

                _gridStateFlow.value = grid
                Log.i(
                    "GetGRIDbyLevel",
                    "grid recuperé : $grid lvl recuperé: ${grid.level} , lvl demandé : $level"
                )
            }


        } catch (e: Exception) {
            _messageStateFlow.value = "Error getting grid try again"

            Log.i(
                "GetGRIDbyLevelERR",
                "grid erreur de recuperation  : ${e.message}"
            )

        }
    }


    //converting solving grids
    private fun gridListToArrayOfIntArray(grid: List<List<Int>>): Array<IntArray> {
        val array = grid.map {
            it.toIntArray()
        }.toTypedArray()
        return array
    }

    fun getGridIntialArray(): Array<IntArray> {
        return gridListToArrayOfIntArray(gridInitial)
    }

    fun solveGrid(grid: Array<IntArray>) {


        if (grid.contentEquals(
                gridListToArrayOfIntArray(gridSolution)
            )
        ) {
            viewModelScope.launch {
                _navigateToNextScreen.emit(Screen.Result.route)
            }
        } else {
            _dialogStateFlow.value = "OUPSIE , grid incorrect . Try again ?"

            Log.i("RESULT", "OUUUPSIE try again")
        }
    }



}