package com.example.sudoku.data.dtos

import com.example.sudoku.utils.Level
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
class GridStart(
    @SerialName("grid_start")
    val gridStart: List<List<Int>>
)

@Serializable
class GridSolution(
    @SerialName("grid_solution")
    val gridSolution: Array<Array<Int>>
)

@Serializable
data class GridDto(
    @SerialName("id")
    val id: String,
    @SerialName("level")
    val level: Level,
    @SerialName("grid_start")
    val gridStart: List<List<Int>>,
    @SerialName("grid_solution")
    val gridSolution: List<List<Int>>,
)

