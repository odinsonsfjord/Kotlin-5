package ru.otus.cars

import ru.otus.cars.fuel_system.TankMouth

/**
 * Машина целиком
 */
interface Car : CarInput {
    /**
     * Номерной знак
     */
    val plates: Plates

    /**
     * Цвет машины
     */
    val color: String

    /**
     * Следит за машиной
     */
    val carOutput: CarOutput

    val mouth: TankMouth

    /**
     * Получить оборудование
     */
    fun getEquipment(): String

    /**
     * Внутренний статический класс - номерой знак
     */
    data class Plates(val number: String, val region: Int)
}
