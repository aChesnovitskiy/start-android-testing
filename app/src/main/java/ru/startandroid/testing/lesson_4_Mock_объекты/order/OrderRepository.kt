package ru.startandroid.testing.lesson_4_Mock_объекты.order

import io.reactivex.Observable

interface OrderRepository {
    fun getOrders(): Observable<List<Order>>
}