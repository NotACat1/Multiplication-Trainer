package com.example.lr2_2.ui.exercises

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlin.random.Random
import com.example.lr2_2.ui.screens.ResultsScreen

/**
 * Экран выборочной тренировки умножения.
 * Одно число задаётся пользователем (2–9),
 * второе генерируется случайно (2–9).
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectiveExercise(selectedNumber: Int) {
    var currentQuestion by remember { mutableStateOf(1) }  // номер текущего вопроса
    var score by remember { mutableStateOf(0) }            // количество правильных ответов
    var userAnswer by remember { mutableStateOf("") }      // ответ пользователя
    var feedback by remember { mutableStateOf("") }        // текст обратной связи
    var showResults by remember { mutableStateOf(false) }  // флаг отображения итогов

    val randomNumber = remember { mutableStateOf(Random.nextInt(2, 10)) }
    val context = LocalContext.current

    if (showResults) {
        // Показ итогов после 20 вопросов
        ResultsScreen(
            score = score,
            totalQuestions = 20,
            onRestart = {
                currentQuestion = 1
                score = 0
                userAnswer = ""
                feedback = ""
                showResults = false
                randomNumber.value = Random.nextInt(2, 10)
            },
            onBackToMain = { (context as? ComponentActivity)?.finish() }
        )
    } else {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Прогресс
                Text("Вопрос ${currentQuestion}/20", style = MaterialTheme.typography.titleMedium)
                LinearProgressIndicator(
                    progress = currentQuestion / 20f,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
                )

                // Вопрос
                Text(
                    text = "Сколько будет $selectedNumber × ${randomNumber.value}?",
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Ввод ответа
                OutlinedTextField(
                    value = userAnswer,
                    onValueChange = { newValue ->
                        if (newValue.isEmpty() || newValue.toIntOrNull() != null) {
                            userAnswer = newValue
                        }
                    },
                    label = { Text("Ваш ответ") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Проверка ответа
                Button(
                    onClick = {
                        val correctAnswer = selectedNumber * randomNumber.value
                        val userAnswerInt = userAnswer.toIntOrNull()

                        if (userAnswerInt == correctAnswer) {
                            score++
                            feedback = "Правильный ответ!"
                        } else {
                            feedback = "Неверный ответ. Правильный: $correctAnswer"
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = userAnswer.isNotEmpty()
                ) {
                    Text("Проверить ответ")
                }

                // Результат проверки + кнопка "Следующий вопрос"
                if (feedback.isNotEmpty()) {
                    Text(
                        text = feedback,
                        style = MaterialTheme.typography.bodyLarge,
                        color = if (feedback.startsWith("Правильный"))
                            MaterialTheme.colorScheme.primary
                        else
                            MaterialTheme.colorScheme.error
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            if (currentQuestion < 20) {
                                currentQuestion++
                                randomNumber.value = Random.nextInt(2, 10)
                                userAnswer = ""
                                feedback = ""
                            } else {
                                showResults = true
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(if (currentQuestion < 20) "Следующий вопрос" else "Завершить")
                    }
                }
            }
        }
    }
}
