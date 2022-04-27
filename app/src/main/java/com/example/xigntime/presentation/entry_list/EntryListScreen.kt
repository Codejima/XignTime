package com.example.xigntime.presentation.entry_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.xigntime.R
import com.example.xigntime.presentation.components.StandardTextField
import com.example.xigntime.presentation.destinations.EntryDetailScreenDestination
import com.example.xigntime.presentation.theme.SpaceLarge
import com.example.xigntime.presentation.theme.SpaceMedium
import com.example.xigntime.presentation.theme.SpaceSmall
import com.example.xigntime.presentation.util.Screen
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

//generic placeholder for the time being
@RootNavGraph(start = true)
@Destination
@Composable
fun MainScreen( //EntryListScreen
    //navigator: DestinationsNavigator,
    navController: NavController,
    viewModel: EntryListViewModel = hiltViewModel()
) {
    //val entries = viewModel.entries.collectAsState(initial = emptyList())
    val scaffoldState = rememberScaffoldState()
    //val state = viewModel.state

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(
            start = SpaceLarge,
            end = SpaceLarge,
            top = SpaceLarge,
            bottom = 50.dp
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                //.padding(SpaceMedium)
                .align(Alignment.Center),
        ) {
            Text(
                text = stringResource(id = R.string.login),
                style = MaterialTheme.typography.h1
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = "",
                onValueChange = {
                    //viewModel.setUsernameText(it)
                },
                hint = stringResource(id = R.string.login_hint)
            )
            Spacer(modifier = Modifier.height(SpaceSmall))
            StandardTextField(
                text = "viewModel.passwordText.value",
                onValueChange = {
                    //viewModel.setPasswordText(it)
                },
                hint = stringResource(id = R.string.password_hint),
                keyboardType = KeyboardType.Password
            )
        }
        Text(
            text = buildAnnotatedString {
                append(stringResource(id = R.string.no_account_yet))
                append(" ")
                val registerText = stringResource(id = R.string.create_account)
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.secondary
                    )
                ) {
                    append(registerText)
                }
            },

            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .align(Alignment.BottomCenter)

        )
        //Button(onClick = { navController.navigate(Screen.DetailScreen.route) })

        Spacer(modifier = Modifier.height(SpaceSmall))
    }


    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(EntryListEvent.OnStartTimeMeasurement)
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {

            items(viewModel.entries) { entry ->
                EntryItem(
                    workEntry = entry,
                    onEvent = viewModel::onEvent,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            //navigator.navigate(EntryDetailScreenDestination())
                            //viewModel.onEvent(EntryListEvent.OnEntryClick(entry))
                        }
                        .padding(16.dp)
                )
            }

        }

/*        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.workEntries.size) { i ->
                val workEntry = state.workEntries[i]
                EntryItem(
                    workEntry = workEntry,
                    onEvent = viewModel::onEvent,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navigator.navigate(EntryDetailScreenDestination())
                        }
                        .padding(16.dp)
                )
                if (i < state.workEntries.size) {
                    Divider(
                        modifier = Modifier.padding(
                            horizontal = 16.dp
                        )
                    )
                }
            }

        }*/
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                //navigator.navigate(EntryDetailScreenDestination())
            }) {
                Text("Go to Entry Detail Screen")
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {
            Button(onClick = {
                viewModel.onEvent(EntryListEvent.OnStartTimeMeasurement)
            }) {
                Text("Start")
            }
        }
    }
}

@Composable
fun MyButton() = Button(onClick = { /*TODO*/ }) {

}

@Composable
fun MyTextField() = Text("")

