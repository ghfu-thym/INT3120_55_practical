fun main() {
    val steps = 4000
    val caloriesBurned = pedometerStepToCalories(steps);
    println("Walking $steps steps burns $caloriesBurned calories")
}

fun pedometerStepToCalories(numberOfSteps: Int): Double {
    val caloriesBurnedForEachStep = 0.04
    val totalCaloriesBurned = numberOfSteps * caloriesBurnedForEachStep
    return totalCaloriesBurned
}