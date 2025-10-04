package com.example.lr2_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.lr2_2.ui.exercises.AllNumbersExercise
import com.example.lr2_2.ui.theme.AppTheme

/**
 * Экран тренировки на все числа (2–9).
 * Вопросы формируются случайным образом для обеих множителей.
 */
class AllNumbersActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                AllNumbersExercise()
            }
        }
    }
}
