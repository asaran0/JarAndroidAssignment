package com.example.myapplication.presentation.shapes

const val SHAPE_RECT = "rect"
const val SHAPE_CIRCLE = "circle"
const val CIRCLE_RADIUS = 25f
const val RECT_SIZE = 50f
data class Shape (var x: Float, var y: Float, var type: String, var radius: Float = 0.0f, var size : Float = 0f)