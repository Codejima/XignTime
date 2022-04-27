package com.example.xigntime.presentation.entry_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.xigntime.data.entities.WorkEntry

//TODO: placeholder atm: needs better layout
@Composable
fun EntryItem(
    workEntry: WorkEntry,
    onEvent: (EntryListEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .background(color = Color.Red)
            .fillMaxWidth()
            .heightIn(50.dp)
    ) {

        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = workEntry.entryTitle,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Column {
                    Row {
                        Text(
                            text = workEntry.entryTimeStarted.toString(),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = workEntry.entryTimeEnded.toString(),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = workEntry.entryTimeElapsed.toString(),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                    }

                }

            }
        }
    }
}


@Composable
fun EntryItemPreview(

) {


    Column(
        modifier = Modifier
            .background(color = Color.DarkGray)
            .fillMaxWidth()
            .heightIn(50.dp)
    ) {
        Text(
            text = "Meeting",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Row(modifier = Modifier
            ) {

            Text(
                text = "11:00",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "13:00",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "2 h",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla turpis ligula, tempor et felis at, interdum fringilla orci. Aenean commodo justo augue, in faucibus odio sodales at. In semper finibus dolor ut aliquam. Donec molestie tincidunt mauris, vitae consectetur dolor dignissim ullamcorper. Lorem ipsum dolor sit amet, consectetur adipiscing elit. ",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
@Preview
@Composable
fun WorkEntryItem(
/*    entry: WorkEntry,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 10.dp,
    cutCornerSize: Dp = 30.dp,
    onDeleteClick: () -> Unit*/
) {
    Box(
        modifier = Modifier
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(end = 32.dp)
                .background(Color.Magenta)
        ) {
            Text(
                text = "Meeting",
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "entry.content",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
                maxLines = 10,
                overflow = TextOverflow.Ellipsis
            )
        }
        IconButton(
            onClick = {},
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete note",
                tint = MaterialTheme.colors.onSurface
            )
        }
    }
}



