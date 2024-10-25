package ru.otus.cars.fuel_system

interface Tank {

fun getContents(): Int

fun receiveFuel(liters: Int)

}

   class TankBuilder (val capacity: Int): Tank {

      private var contents = 0

     override fun getContents(): Int = contents

     override fun receiveFuel(liters: Int) {
        contents += liters
         if (contents >= capacity) println("Полный бак")
     }
 }
