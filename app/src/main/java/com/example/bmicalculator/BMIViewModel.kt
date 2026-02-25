package com.example.bmicalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BMIViewModel : ViewModel() {

    // Member variables (states) for data that is asked from the user
    var heightInput by mutableStateOf("")
    var weightInput by mutableStateOf("")

    // Member variable for result (bmi) and implement get property which returns bmi
    val bmi: Float
        get() {
            val height = heightInput.replace(',', '.').toFloatOrNull() ?: 0f
            val weight = weightInput.replace(',', '.').toFloatOrNull() ?: 0f
            return if (height > 0f && weight > 0f) weight / (height * height) else 0f
        }
}
