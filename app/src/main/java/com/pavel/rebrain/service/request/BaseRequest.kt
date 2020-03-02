package com.pavel.rebrain.service.request

/**
 * интерфейс для преобразования объектов domain layer в service layer
 */
interface BaseRequest<T> {
    fun fromDomainModel(data: T)
}