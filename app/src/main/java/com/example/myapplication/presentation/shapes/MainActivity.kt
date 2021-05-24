package com.example.myapplication.presentation.shapes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myapplication.R
import java.util.*

class MainActivity : AppCompatActivity() {
    private var shapes = LinkedList<Shape>()
    private lateinit var customShape: CustomShape
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customShape = findViewById(R.id.custom_shape)
    }

    fun onRect(view: View) {
        val rect = Shape(0f, 0f, SHAPE_RECT, size = RECT_SIZE)
        getNonCollideShape(rect)
        shapes.add(rect)
        customShape.setShapes(shapes)
        customShape.invalidate()
    }

    private fun getNonCollideShape(shape: Shape) {
        var x = Math.random() * (customShape.width - RECT_SIZE)
        var y = Math.random() * (customShape.height - RECT_SIZE)
        if (shape.type == SHAPE_CIRCLE) {
            //to make circle inside boundaries
            x += CIRCLE_RADIUS
            y += CIRCLE_RADIUS
        }

        shape.x = x.toFloat()
        shape.y = y.toFloat()
    }

    fun onUndo(view: View) {
        if (shapes.size == 0) {
            Toast.makeText(this, "No shapes now.", Toast.LENGTH_SHORT).show()
            return
        }
        shapes.removeLast()
        customShape.setShapes(shapes)
        customShape.invalidate()

    }

    fun onNext(view: View) {
        startActivity(Intent(this, PhotosActivity::class.java))
    }

    fun onCircle(view: View) {
        val circle = Shape(0F, 0F, SHAPE_CIRCLE, radius = CIRCLE_RADIUS)
        getNonCollideShape(circle)
        shapes.add(circle)
        customShape.setShapes(shapes)
        customShape.invalidate()
    }
}