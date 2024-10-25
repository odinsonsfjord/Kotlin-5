package ru.otus.cars.gas_station

import ru.otus.cars.Car
import ru.otus.cars.fuel_system.LpgMouth
import ru.otus.cars.fuel_system.PetrolMouth

class GasStation {

     fun getFuel(car: Car, liters: Int){
        val mouth = car.mouth
           when(mouth){
                is PetrolMouth -> mouth.fuelPetrol(liters)
                is LpgMouth -> mouth.fuelLpg(liters)
            }
    }

    fun safeRefill(car: Car, liters: Int) {
        try {
        getFuel(car, liters)
    }
        catch (e: NotImplementedError) {
        println("Бак взорвался, но никто не пострадал")
    }
    }
}
