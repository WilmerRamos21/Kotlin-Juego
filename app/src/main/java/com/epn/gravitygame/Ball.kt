package com.epn.gravitygame

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.math.max
import kotlin.math.min

class Ball(
    var position: Vector2 = Vector2(250f, 350f),
    private val radius: Float = 70f
) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.rgb(0, 122, 255)
    }

    private val shinePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.argb(190, 255, 255, 255)
    }

    fun radius(): Float = radius

    fun update(sensorX: Float, sensorY: Float, width: Int, height: Int) {
        // Aplicamos movimiento basándonos en los sensores
        position.x += sensorX * SPEED
        position.y += sensorY * SPEED

        // --- DETECTAR CHOQUE CON BORDES IZQUIERDO / DERECHO ---
        if (position.x - radius < 0) {
            position.x = radius // Mantiene la bola dentro
            // Aquí puedes agregar un efecto, sonido o rebote si usaras velocidades
        } else if (position.x + radius > width) {
            position.x = width - radius
        }

        // --- DETECTAR CHOQUE CON BORDES SUPERIOR / INFERIOR ---
        // Tomamos en cuenta el header del juego (aprox Y = 210f) para que no se meta arriba
        val topBorder = 210f + radius
        if (position.y - radius < topBorder) {
            position.y = topBorder
        } else if (position.y + radius > height) {
            position.y = height - radius
        }
    }

    fun draw(canvas: Canvas) {
        canvas.drawCircle(position.x, position.y, radius, paint)
        canvas.drawCircle(position.x - radius / 3, position.y - radius / 3, radius / 4, shinePaint)
    }

    companion object {
        private const val SPEED = 7.5f
    }
}
