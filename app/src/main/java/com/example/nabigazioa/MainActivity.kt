package com.example.nabigazioa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.nabigazioa.ui.theme.NabigazioaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NabigazioaTheme {
                NireAplikazioa()
            }
        }
    }
}

@Composable
fun NireAplikazioa() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavBar(navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") {
                HomeScreen()
            }

            composable("aukera1") {
                Aukera1Screen()
            }

            composable("aukera2") {
                Aukera2Screen()
            }

            composable("aukera3") {
                Aukera3Screen()
            }
        }
    }
}

@Composable
fun BottomNavBar(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        NavigationBarItem(
            icon = { Icon(painterResource(R.drawable.home), contentDescription = "Home") },
            selected = currentRoute == "home",
            onClick = { navController.navigate("home")},
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = currentRoute == "aukera1",
            onClick = { navController.navigate("aukera1") },
            icon = { Icon(painterResource(R.drawable.counter_1), contentDescription = "Aukera 1") },
            label = { Text("Aukera 1") }
        )
        NavigationBarItem(
            selected = currentRoute == "aukera2",
            onClick = { navController.navigate("aukera2") },
            icon = { Icon(painterResource(R.drawable.counter_2), contentDescription = "Aukera 2") },
            label = { Text("Aukera 2") }
        )
        NavigationBarItem(
            selected = currentRoute == "aukera3",
            onClick = { navController.navigate("aukera3") },
            icon = { Icon(painterResource(R.drawable.counter_3), contentDescription = "Aukera 3") },
            label = { Text("Aukera 3") }
        )
    }
}

@Composable
fun HomeScreen() {
    Text("Home", modifier = Modifier.padding(24.dp), fontSize = 28.sp)
}

@Composable
fun Aukera1Screen() {
    Text("Aukera 1", modifier = Modifier.padding(24.dp), fontSize = 28.sp)
}

@Composable
fun Aukera2Screen() {
    Text("Aukera 2", modifier = Modifier.padding(24.dp), fontSize = 28.sp)
}

@Composable
fun Aukera3Screen() {
    Text("Aukera 3", modifier = Modifier.padding(24.dp), fontSize = 28.sp)
}
