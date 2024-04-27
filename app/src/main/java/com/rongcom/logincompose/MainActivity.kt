package com.rongcom.logincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.rongcom.logincompose.ui.screens.NavigationRoutes
import com.rongcom.logincompose.ui.screens.authenticatedGraph
import com.rongcom.logincompose.ui.screens.unauthenticatedGraph
import com.rongcom.logincompose.ui.theme.LoginComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginComposeTheme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        MainAppNavHosts()
    }
}

@Composable
fun MainAppNavHosts(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavigationRoutes.Unauthenticated.NavigationRoute.route
    ) {
       unauthenticatedGraph(navController = navController)
        authenticatedGraph(navController = navController)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginComposeTheme {
        MainApp()
    }
}