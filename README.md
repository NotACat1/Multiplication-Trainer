# 📘 Multiplication Trainer

Приложение на **Android (Kotlin, Jetpack Compose)** для тренировки навыков умножения.
Оно предназначено для школьников и всех, кто хочет прокачать таблицу умножения в игровой форме.

---

## 🚀 Возможности

- 📑 **Два режима тренировки:**

  - **Все числа (2–9)** → последовательная генерация случайных примеров.
  - **Выборочное упражнение** → пользователь сам выбирает одно число (от 2 до 9).

- 🎯 **20 вопросов за одну сессию** с подсчётом правильных и неправильных ответов.
- ✅ **Мгновенная обратная связь** после ответа.
- 📊 **Экран результатов**: количество правильных ответов и процент успеха.
- 🎨 **Поддержка светлой и тёмной темы**, включая разные изображения таблицы умножения.
- ⚡ **Современный UI** на основе **Material 3 + Jetpack Compose**.

---

## 🖼️ Скриншоты

| Главное меню | Тренировка    | Результаты   |
| ------------ | ------------- | ------------ |
| ![Main](https://github.com/user-attachments/assets/62511c2f-287d-4963-931e-1d5dd5392b4f)    | ![Exercise](https://github.com/user-attachments/assets/116a4d2f-d840-4b6e-96be-f98913784a34) | ![Results](https://github.com/user-attachments/assets/57acee00-b730-472f-9565-36a1fe8be0c5) |

---

## 📂 Структура проекта

```
app/src/main/java/com/example/lr2_2/
│
├── MainActivity.kt           # Главное меню и запуск упражнений
├── AllNumbersActivity.kt     # Упражнения на все числа (2–9)
├── SelectiveActivity.kt      # Упражнения на выбранное число
├── ResultsScreen.kt          # Экран отображения результатов
│
└── ui/theme/                 # Оформление и тема (Material 3)
```

---

## ⚙️ Установка и запуск

1. Клонировать проект:

   ```bash
   git clone https://github.com/NotACat1/Multiplication-Trainer.git
   ```

2. Открыть в **Android Studio**.
3. Собрать и запустить на эмуляторе или устройстве с **Android 8.0 (API 26)+**.

---

## 🖌️ Темы и изображения

Приложение поддерживает **разные изображения таблицы умножения** в светлой и тёмной теме:

- `res/drawable/multiplication_table_light.png`
- `res/drawable/multiplication_table_dark.png`

Выбор изображения происходит автоматически через `isSystemInDarkTheme()`.

---

## 🛠️ Технологии

- [Kotlin](https://kotlinlang.org/)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Material 3](https://m3.material.io/)
- [Android Studio](https://developer.android.com/studio)
