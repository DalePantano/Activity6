package com.example.activity6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.activity6.ui.theme.Activity6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Activity6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScrollableList()
                }
            }
        }
    }
}

@Composable
fun ScrollableList() {
    // Sample data to be displayed in the list
    val itemsList = List(100) { "Item #$it" }
    val imageList = listOf(
        R.drawable.pic1,
        R.drawable.pic2,
        R.drawable.pic3,
        R.drawable.pic4,
        R.drawable.pic5,
    )

    // Creating a LazyColumn for the scrollable list
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(itemsList) { item ->
            val imageRes = if (item.takeLastWhile { it.isDigit() }.toInt() < 5) {
                imageList[item.takeLastWhile { it.isDigit() }.toInt()]
            } else {
                R.drawable.pic1 // Use a default image if needed
            }
            ListItem(item, imageRes)
        }
    }
}

@Composable
fun ListItem(item: String, imageRes: Int) {
    Row(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = item,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ScrollableListPreview() {
    Activity6Theme {
        ScrollableList()
    }
}
