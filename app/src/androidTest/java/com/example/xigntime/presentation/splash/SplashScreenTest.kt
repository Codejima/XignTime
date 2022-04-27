package com.example.xigntime.presentation.splash

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.xigntime.presentation.MainActivity
import com.example.xigntime.presentation.theme.XignTimeTheme
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class SplashScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @RelaxedMockK
    lateinit var navController: NavController

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun splashScreen_displaysAndDisappears(): Unit = runBlocking {
        composeTestRule.setContent {
            XignTimeTheme {
                SplashScreen(navController = navController
                )
            }
        }

        composeTestRule
            .onNodeWithContentDescription("logo")
            .assertExists()

/*        verify {
            navController.popBackStack()
            navController.navigate(Screen.LoginScreen.route)
        }*/
    }
}
