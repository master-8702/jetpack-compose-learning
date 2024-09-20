package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    var myList = mutableStateListOf<String>()
    var item = mutableStateOf("")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            JetpackComposeTheme {

                // a column to list composables in a vertical manner
                  Column (
                      horizontalAlignment = Alignment.CenterHorizontally,
//                      verticalArrangement = Arrangement.Center ,
                      modifier = Modifier
                          .fillMaxSize()
                          .padding(all = 20.dp)){

                      // a row to list composables in a horizontal manner
                      Row (
                          verticalAlignment = Alignment.CenterVertically,
                          modifier = Modifier.fillMaxWidth()){
                          TextField(modifier = Modifier.weight(1f),
                              value = item.value,
                              onValueChange = { newText: String -> item.value = newText},
                              placeholder = { Text(text = "add item")},
                              label = { Text(text = "Item Name")},
                              singleLine = true,

                              )
                          // to add white space between composables
                          Spacer(modifier = Modifier.width(12.dp))
                          Button(onClick = {
                              if (item.value.isNotBlank()){
                                  myList.add(item.value)
                                  item.value=""
                              }
                             }
                          ) {
                              Text(text = "Add")
                          }
                      }
                      // vertically scrollable list (ListView in flutter), that builds only the visible
                      // list items
                     LazyColumn (){
                         items(count = myList.count()){i ->
                             Text(text = myList[i],
                                 modifier = Modifier
                                     .fillMaxWidth()
                                     .padding(16.dp)
                             )
                             HorizontalDivider()
                         }
                     }
                  }

            }
        }
    }
}

