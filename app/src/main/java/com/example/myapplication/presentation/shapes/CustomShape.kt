package com.example.myapplication.presentation.shapes

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import java.util.*

class CustomShape(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    init {
        setupPaint();
    }
    private var shapes= LinkedList<Shape>()
    private lateinit var drawPaint: Paint
    private var canvas: Canvas? = null

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        this.canvas = canvas;
        for (shape in shapes) {
            if (shape.type == SHAPE_CIRCLE) drawCircle(shape)
            else drawSquire(shape)
        }
    }

    fun setShapes(shapes : LinkedList<Shape>) {
        this.shapes = shapes
    }

    private fun setupPaint() {
        drawPaint = Paint()
        drawPaint.color = Color.BLUE
        drawPaint.isAntiAlias = true
        drawPaint.strokeWidth = 5f
        drawPaint.style = Paint.Style.FILL_AND_STROKE
        drawPaint.strokeJoin = Paint.Join.ROUND
        drawPaint.strokeCap = Paint.Cap.ROUND
    }
    private fun drawSquire(shape: Shape) {
        canvas?.drawRect(shape.x, shape.y, shape.x + shape.size, shape.y + shape.size, drawPaint)
    }

    private fun drawCircle(shape: Shape) {
        canvas?.drawCircle(shape.x, shape.y, shape.radius, drawPaint)
    }
}