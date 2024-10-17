package com.example.flightsearch

@Composable
fun FlightSearchApp() {
    val navController = rememberNavController()
    Scaffold() { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = SearchDestination.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = SearchDestination.route) {
                SearchScreen(
                    modifier = Modifier,
                    onSelectCode = {
                        navController.navigate("${FlightScreenDestination.route}/${it}")
                    }
                )
            }
            composable(
                route = FlightScreenDestination.routeWithArgs,
                arguments = listOf(navArgument(FlightScreenDestination.codeArg) {
                    type = NavType.StringType
                }
                )
            ) { navBackStackEntry ->
                // Retrieve the passed argument
                //val code =
                //    navBackStackEntry.arguments?.getString(FlightScreenDestination.codeArg)
                FlightScreen()

            }
        }
    }
}