package ru.otus.cars

import ru.otus.cars.fuel_system.PetrolMouth
import ru.otus.cars.fuel_system.Tank
import ru.otus.cars.fuel_system.TankBuilder
import ru.otus.cars.fuel_system.TankMouth
import kotlin.random.Random

/**
 * Восьмерка
 */
class Vaz2108 private constructor(color: String) : VazPlatform(color) {
    /**
     * Сам-себе-сборщик ВАЗ 2108.
     */
    companion object : CarBuilder {
        private fun getRandomEngine(): VazEngine {
            return when (Random.nextInt(0, 3)) {
                0 -> VazEngine.SAMARA_2108(1100)
                1 -> VazEngine.SAMARA_2108(1300)
                else -> VazEngine.SAMARA_2108(1500)
            }
        }

        override fun build(plates: Car.Plates): Vaz2108 =
            Vaz2108("Красный").apply {
                this.engine = getRandomEngine()
                this.plates = plates
                this.mouth = PetrolMouth(tank)
        }

        fun alignWheels(vaz2108: Vaz2108) {
            println("Ваз 2108 выравнивает колёса... ")
            vaz2108.wheelAngle = 0
        }

        /**
         * Используем вместо STATIC
         */
        const val MODEL = "2108"
    }

    // Переопределяем свойство родителя
    override lateinit var engine: VazEngine
        private set

    /**
     * Восьмерка едет так
     */
    fun zhzhzhzh() {
        println("Помчали на ${MODEL}:")
        println("Ж-ж-ж-ж....")
    }

    // Переопределяем метод родителя
    override fun getEquipment(): String {
        // Добавляем музыку к оборудованию
        return super.getEquipment() + ", музыка"
    }


    private val tank: Tank = TankBuilder(50)
    private var currentSpeed: Int = 0 // Скока жмёт

    /**
     * Доступно сборщику
     * @see [build]
     */
    override lateinit var plates: Car.Plates
        private set

    override lateinit var mouth: TankMouth
        private set

    // Выводим состояние машины
    override fun toString(): String {
        return "Vaz2108(plates=$plates, wheelAngle=$wheelAngle, currentSpeed=$currentSpeed)"
    }

    /**
     * Делегируем приборы внутреннему классу
     */
    override val carOutput: CarOutput = VazOutput()

    /**
     * Имеет доступ к внутренним данным ЭТОГО ВАЗ-2108!
     */
    inner class VazOutput : CarOutput {
        override fun getCurrentSpeed(): Int {
            return this@Vaz2108.currentSpeed
        }

        override fun getFuelContents(): Int {
            return this@Vaz2108.tank.getContents()
        }
    }
}
