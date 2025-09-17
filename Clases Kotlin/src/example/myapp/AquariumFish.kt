package example.myapp

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}


interface FishColor{
    val color: String
}

interface FisheAction {
    fun eat()
}

class Shark:FishAction , FishColor{
    override val color = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus(fishColor: FishColor = GoldColor):
    FishColor by fishColor,
    FishAction by PrintingFishAction("eat algae")



