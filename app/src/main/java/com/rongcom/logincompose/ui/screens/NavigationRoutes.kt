package com.rongcom.logincompose.ui.screens

sealed class NavigationRoutes {
    sealed class Unauthenticated(val route: String) : NavigationRoutes(){
        object NavigationRoute : Unauthenticated(route = "unauthenticated")
        object Login : Unauthenticated(route = "login")
        object Registration : Unauthenticated(route = "registration")
    }

    sealed class Authenticated(val route: String) : NavigationRoutes() {
        object NavigationRoute : Authenticated(route = "authenticated")
        object Dashboard : Authenticated(route = "Dashboard")
    }
}