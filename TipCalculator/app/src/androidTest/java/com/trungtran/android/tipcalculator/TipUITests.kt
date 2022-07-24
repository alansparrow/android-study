package com.trungtran.android.tipcalculator

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import com.trungtran.android.tipcalculator.ui.theme.TipCalculatorTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TipUITests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        // Given
        composeTestRule.setContent {
            TipCalculatorTheme {
                TipTimeScreen()
            }
        }
    }

    @Test
    fun calculate_20_percent_tip() {
        // Given
        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")
        composeTestRule.onNodeWithText("Tip (%)")
            .performTextInput("20")

        // When, Then
        composeTestRule.onNodeWithText("Tip amount/person: $2.00")
            .assertExists()
    }

    @Test
    fun calculate_20_percent_tip_with_2_people() {
        // Given
        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")
        composeTestRule.onNodeWithText("Tip (%)")
            .performTextInput("20")
        composeTestRule.onNodeWithText("Number of people")
            .performTextReplacement("2")

        // When, Then
        composeTestRule.onNodeWithText("Tip amount/person: $1.00")
            .assertExists()
    }
}