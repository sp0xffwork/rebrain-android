package com.pavel.rebrain.service.response

/**
 * интерфейс для конвертации обектов класса *Response сервисного слоя в объекты доменного слоя
 */
interface BaseResponse<T> {
    fun convertToDomainModel(): T
}