package com.example.sudoku.ui.game

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class GameVM @Inject constructor(

) : ViewModel() {

    // recupere le level choisi du screen level pour faire la requete avec
    // afficher que des grille non completé (join?)
    //grille
    //onclick comparé grilles initiale avec la solution
    //requete lorsque la grille completé -> reussi ou pas
    //naviguer vers result

}