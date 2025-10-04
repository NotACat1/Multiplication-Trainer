package com.example.lr2_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.lr2_2.ui.MultiplicationTrainerApp
import com.example.lr2_2.ui.theme.AppTheme

/**
 * Главная Activity приложения.
 * Отвечает за запуск главного экрана (MultiplicationTrainerApp),
 * где пользователь выбирает режим тренировки.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                MultiplicationTrainerApp()
            }
        }
    }
}