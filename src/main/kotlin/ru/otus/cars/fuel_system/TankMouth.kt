package ru.otus.cars.fuel_system

sealed class TankMouth(protected val tank: Tank){
     private var isOpened = false
     fun open(){
        when(isOpened){
            true -> println("Горловина бака уже открыта")
            else -> {
                isOpened = true
                println("Горловина бака открыта")
            }
        }
    }

     fun close(){
         when(isOpened){
             false -> print("Горловина бака уже закрыта")
             else -> {
                 isOpened = false
                 println("Горловина бака закрыта")
             }
         }
     }

    }
      class PetrolMouth(tank: Tank) : TankMouth(tank){

          fun fuelPetrol(liters: Int){
                 open()
                 println("Начинается заправка")
                 tank.receiveFuel(liters)
                 println("Заправка окончена")
                 close()
          }
      }


     class LpgMouth(tank: Tank): TankMouth(tank) {

         fun fuelLpg(liters: Int){
                 open()
                 println("Начинается заправка")
                 tank.receiveFuel(liters)
                 println("Заправка окончена")
                 close()

         }
    }
