package com.example.xigntime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.xigntime.data.AppDatabase
//import com.example.xigntime.ui.entry_detail.EntryDetailScreen
//import com.example.xigntime.ui.entry_list.EntryListScreen
import com.example.xigntime.ui.theme.XignTimeTheme
import com.example.xigntime.util.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setContent {
            XignTimeTheme {
                val navController = rememberNavController()
                NavHost(navController = navController,
                    startDestination = Routes.ENTRY_LIST
                ) {
                    /*composable(Routes.ENTRY_LIST) {
                        EntryListScreen(
                            onNavigate = {
                                navController.navigate(it.route)
                            }
                        )
                    }*/
                    /*composable(
                        route = Routes.ENTRY_DETAIL + "?entryId={entryId}",
                        arguments =  listOf(
                            navArgument(name = "entryId") {
                                type = NavType.IntType
                                defaultValue = -1
                            }
                        )
                    ) {
                        EntryDetailScreen(onPopBackStack = {
                            navController.popBackStack()
                        })
                    }*/
                }
            }
        }


        //TODO: necessito éso?
        //val userDao = AppDatabase.getInstance(this).userDao
    }
}