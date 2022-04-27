package com.example.xigntime.presentation.util

sealed class Screen(val route: String) {
    object  SplashScreen : Screen("splash_screen")
    object  LoginScreen : Screen("login_screen")
    object  RegisterScreen : Screen("register_screen")
    object  MainScreen : Screen("main_screen")
    object  DetailScreen : Screen("detail_screen")
    object  OverviewWeekScreen : Screen("overview_week_screen")
    object  OverviewMonthScreen : Screen("overview_month_screen")
}
