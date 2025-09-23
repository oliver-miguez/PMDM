object CoffeMachine {

    object CoffeeMachine {
        private var currentState: CoffeeMachineState = CoffeeMachineState.Idle // Al current states se le atribuye el valor de la clase sealed anterior

        fun makeCoffee() {
            println("Estado actual: $currentState")

            when (currentState) { // El when obliga a meter todas las opciones de la sealed class, es decir todos los estados
                is CoffeeMachineState.Idle -> {
                    println("Máquina encendida. Empezando a hacer café...")
                    currentState = CoffeeMachineState.MakingCoffee
                    Thread.sleep(2000)
                    // Simula un proceso de preparación
                    currentState = CoffeeMachineState.ServingCoffee("Nescafé")
                    println("¡Café listo! Estado: $currentState")
                }
                is CoffeeMachineState.MakingCoffee -> {
                    println("¡Espera! La máquina ya está haciendo café.")
                }
                is CoffeeMachineState.ServingCoffee -> {
                    println("Ya hay café servido. Por favor, toma tu café.")
                }
                is CoffeeMachineState.Error -> {
                    println("La máquina tiene un error: ${(currentState as CoffeeMachineState.Error).message}")
                }
            }
        }

        fun clean() {
            println("Limpiando la máquina...")
            currentState = CoffeeMachineState.Idle
            println("Máquina limpia. Estado: $currentState")
        }
    }


}