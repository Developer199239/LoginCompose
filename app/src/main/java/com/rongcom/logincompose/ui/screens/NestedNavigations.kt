package com.rongcom.logincompose.ui.screens

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rongcom.logincompose.ui.screens.dashboard.DashboardScreen
import com.rongcom.logincompose.ui.screens.login.LoginScreen
import com.rongcom.logincompose.ui.screens.registration.RegistrationScreen

fun NavGraphBuilder.unauthenticatedGraph(navController: NavController) {

    navigation(
        route = NavigationRoutes.Unauthenticated.NavigationRoute.route,
        startDestination = NavigationRoutes.Unauthenticated.Login.route
    ) {

        // Login
        composable(route = NavigationRoutes.Unauthenticated.Login.route) {
            LoginScreen(
                onNavigateToRegistration = {
                    navController.navigate(route = NavigationRoutes.Unauthenticated.Registration.route)
                },
                onNavigateToForgotPassword = {},
                onNavigateToAuthenticatedRoute = {
                    navController.navigate(route = NavigationRoutes.Authenticated.NavigationRoute.route) {
                        popUpTo(route = NavigationRoutes.Unauthenticated.NavigationRoute.route) {
                            inclusive = true
                        }
                    }
                },
            )
        }

        // Registration
        composable(route = NavigationRoutes.Unauthenticated.Registration.route) {
            RegistrationScreen(
                onNavigateBack = {
                    navController.navigateUp()
                },
                onNavigateToAuthenticatedRoute = {
                    navController.navigate(route = NavigationRoutes.Authenticated.NavigationRoute.route) {
                        popUpTo(route = NavigationRoutes.Unauthenticated.NavigationRoute.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}


fun NavGraphBuilder.authenticatedGraph(navController: NavController) {
    navigation(
        route = NavigationRoutes.Authenticated.NavigationRoute.route,
        startDestination = NavigationRoutes.Authenticated.Dashboard.route
    ) {
        // Dashboard
        composable(route = NavigationRoutes.Authenticated.Dashboard.route) {
            DashboardScreen()
        }
    }
}