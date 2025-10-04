package com.example.lr2_2.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * Экран с результатами тренировки.
 * Отображает:
 * - количество правильных ответов;
 * - итоговый процент;
 * - кнопки "Начать заново" и "В меню".
 */
@Composable
fun ResultsScreen(
    score: Int,
    totalQuestions: Int,
    onRestart: () -> Unit,
    onBackToMain: () -> Unit
) {
    val percentage = (score * 100) / totalQuestions

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Заголовок
            Text(
                text = "Результаты",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Количество правильных ответов
            Text(
                text = "Правильных ответов: $score из $totalQuestions",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )

            // Итоговый процент
            Text(
                text = "Успеваемость: $percentage%",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
                color = if (percentage >= 70) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Кнопки управления
            Button(
                onClick = onRestart,
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
            ) {
                Text("Начать заново")
            }

            OutlinedButton(
                onClick = onBackToMain,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("В меню")
            }
        }
    }
}
