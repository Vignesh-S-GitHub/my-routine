# My Routine

A minimal, Android-first personal routine app built with Kotlin and Jetpack Compose.

## Product idea

The app is intentionally focused on a small set of daily routines:

- Morning routine
- Meals
- Water
- Movement / sitting breaks
- Exercise
- Night routine
- Sleep

The core interaction is:

**Flexible time window → reminder → Done / Snooze / Skip → simple history**

The visual direction is a modern Android app that feels like a physical notebook: warm paper, subtle ruled lines, handwritten-style visual cues, simple cards, and Material 3 interaction patterns.

## V1 screens

1. Today
2. Routines
3. History
4. Settings

V1 is local-first and does not require an account, backend, subscription, or internet connection.

## Development

This repository is being scaffolded as a native Android project using:

- Kotlin
- Jetpack Compose
- Material 3
- Android Gradle Plugin 9.4
- Compose BOM 2026.09

Database, notifications, WorkManager/AlarmManager, and Health Connect will be added after the UI prototype is running.

## Preview

After cloning the project and opening it in a current Android Studio version:

1. Let Gradle sync.
2. Open `app/src/main/java/com/vignesh/myroutine/MyRoutineApp.kt`.
3. Open **Design / Split** view to see the Compose preview.
4. Run the app on an emulator or a connected Android phone when ready.
