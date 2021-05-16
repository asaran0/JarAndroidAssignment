package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myapplication.presentation.shapes.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private var shapes= LinkedList<Shape>()
    private lateinit var customShape: CustomShape
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customShape = findViewById(R.id.custom_shape)
    }

    fun onRect(view: View) {


        val rect = Shape(0f, 0f, SHAPE_RECT, size = 50f)
        getNonCollideShape(rect)
        shapes.add(rect)
        customShape.invalidate()
    }

    private fun getNonCollideShape(shape: Shape) {
        val x = Math.random()*customShape.width
        val y = Math.random()*customShape.height

        shape.x = x.toFloat()
        shape.y = y.toFloat()
    }
    fun onUndo(view: View) {
        if (shapes.size == 0){
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
        val x = Math.random()*100
        val y = Math.random()*200

        val rect = Shape(x.toFloat(), y.toFloat(), SHAPE_CIRCLE, radius = 25f)
        shapes.add(rect)
        customShape.setShapes(shapes)
        customShape.invalidate()
    }
}