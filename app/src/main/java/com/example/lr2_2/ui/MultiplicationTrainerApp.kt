package com.example.lr2_2.ui

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.lr2_2.AllNumbersActivity
import com.example.lr2_2.R
import androidx.compose.foundation.isSystemInDarkTheme
import com.example.lr2_2.SelectiveActivity

/**
 * Главный экран приложения (UI).
 * Содержит:
 * - заголовок и иллюстрацию таблицы умножения;
 * - запуск тренировки на все числа;
 * - ввод числа и запуск выборочной тренировки.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MultiplicationTrainerApp() {
    var selectedNumber by remember { mutableStateOf("") }
    val context = LocalContext.current

    // Определяем текущую тему
    val isDarkTheme = isSystemInDarkTheme()
    val imageRes = if (isDarkTheme) {
        R.drawable.multiplication_table_dark
    } else {
        R.drawable.multiplication_table_light
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Заголовок
            Text(
                text = "Тренажёр умножения",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Иллюстрация
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainer)
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "Таблица умножения",
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    contentScale = ContentScale.Fit
                )
            }

            // Кнопка запуска общего упражнения
            Button(
                onClick = {
                    val intent = Intent(context, AllNumbersActivity::class.java)
                    startActivity(context, intent, null)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Упражнение для всех чисел")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Ввод числа для выборочной тренировки
            OutlinedTextField(
                value = selectedNumber,
                onValueChange = { newValue ->
                    if (newValue.isEmpty() || (newValue.toIntOrNull() != null && newValue.toInt() in 2..9)) {
                        selectedNumber = newValue
                    }
                },
                label = { Text("Число от 2 до 9") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Кнопка запуска выборочного упражнения
            Button(
                onClick = {
                    val number = selectedNumber.toIntOrNull()
                    if (number != null && number in 2..9) {
                        val intent = Intent(context, SelectiveActivity::class.java).apply {
                            putExtra("SELECTED_NUMBER", number)
                        }
                        startActivity(context, intent, null)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = selectedNumber.toIntOrNull() in 2..9
            ) {
                Text("Упражнение выборочно")
            }
        }
    }
}
