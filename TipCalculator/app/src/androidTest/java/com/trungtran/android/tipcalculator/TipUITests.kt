package com.trungtran.android.tipcalculator

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
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
        // When
        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")
        composeTestRule.onNodeWithText("Tip (%)")
            .performTextInput("20")

        // Then
        composeTestRule.onNodeWithText("Tip amount/person: $2.00")
            .assertExists()
    }

    @Test
    fun calculate_20_percent_tip_with_2_people() {
        // When
        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")
        composeTestRule.onNodeWithText("Tip (%)")
            .performTextInput("20")
        composeTestRule.onNodeWithText("Number of people")
            .performTextReplacement("2")

        // Then
        composeTestRule.onNodeWithText("Tip amount/person: $1.00")
            .assertExists()
    }

    @Test
    fun calculate_20_percent_tip_with_2_people_not_round_up() {
        // When
        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("25")
        composeTestRule.onNodeWithText("Tip (%)")
            .performTextInput("23")
        composeTestRule.onNodeWithText("Number of people")
            .performTextReplacement("2")

        // Then
        composeTestRule.onNodeWithText("Tip amount/person: $2.88")
            .assertExists()
    }

    @Test
    fun calculate_20_percent_tip_with_2_people_round_up() {
        // When
        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("25")
        composeTestRule.onNodeWithText("Tip (%)")
            .performTextInput("23")
        composeTestRule.onNodeWithText("Number of people")
            .performTextReplacement("2")
        composeTestRule.onNodeWithTag("roundUpSwitcher")
            .performClick()

        // Then
        composeTestRule.onNodeWithText("Tip amount/person: $3.00")
            .assertExists()
    }
}