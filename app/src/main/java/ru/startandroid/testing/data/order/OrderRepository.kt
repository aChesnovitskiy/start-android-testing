package ru.startandroid.testing.data.order

import io.reactivex.Observable

interface OrderRepository {
    fun getOrders(): Observable<List<Order>>
}