package com.example.lr2_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.lr2_2.ui.exercises.SelectiveExercise
import com.example.lr2_2.ui.theme.AppTheme

/**
 * Экран выборочной тренировки.
 * Пользователь заранее задаёт одно число (2–9),
 * второе число подбирается случайным образом.
 */
class SelectiveActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Число, выбранное пользователем в MainActivity
        val selectedNumber = intent.getIntExtra("SELECTED_NUMBER", 2)

        setContent {
            AppTheme {
                SelectiveExercise(selectedNumber = selectedNumber)
            }
        }
    }
}
