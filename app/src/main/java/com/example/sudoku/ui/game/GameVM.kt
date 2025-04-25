package com.example.sudoku.ui.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sudoku.data.repositories.GridRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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

    fun getAllGrid() {
        viewModelScope.launch(Dispatchers.IO) {
            gridRepository.getALlgrid()
        }


    }

    fun createGrid() {
        viewModelScope.launch(Dispatchers.IO) {
            gridRepository.createGrid()
        }
    }


}