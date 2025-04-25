package com.example.sudoku.data.repositories

import android.util.Log
import com.example.sudoku.data.dtos.GridDto
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


    suspend fun getALlgrid() {
        try {
            val grids = supabase
                .from("grid")
                .select()
                .decodeSingle<GridDto>()


            Log.i("GridREPO", "GetALL : $grids ")
        } catch (e: Exception) {
            Log.i("GridRepoERR", "Get all error : ${e.message}")
        }

    }

    suspend fun createGrid() {


    }
}