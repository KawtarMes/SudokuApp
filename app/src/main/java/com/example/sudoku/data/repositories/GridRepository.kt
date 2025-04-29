package com.example.sudoku.data.repositories

import com.example.sudoku.data.dtos.GridDto
import com.example.sudoku.utils.Level
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import javax.inject.Inject

class GridRepository @Inject constructor(
    val supabase: SupabaseClient
) {

    //get grids

    //get grid by level

    //correct the grid

    //get grid where user , completed false (join)


    /* suspend fun getAllGrids() {
         try {
             val grids = supabase
                 .from("grid")
                 .select()
                 .decodeList<GridDto>()

             Log.i("GridREPO", "GetALL : ${grids} ")
         } catch (e: Exception) {
             Log.i("GridRepoERR", "Get all error : ${e.message}")
         }

     }*/

    suspend fun getGridByLevel(levelChosen: Level): GridDto {
        val grid = supabase
            .from("grid")
            .select {
                filter {
                    eq("level", levelChosen)
                }
            }.decodeSingle<GridDto>() // que la premiere grille
        return grid
    }


}