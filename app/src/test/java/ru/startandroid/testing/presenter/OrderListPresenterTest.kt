package ru.startandroid.testing.presenter

import io.reactivex.Observable.error
import io.reactivex.Observable.just
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.never
import ru.startandroid.testing.data.order.Order
import ru.startandroid.testing.data.order.OrderListContract
import ru.startandroid.testing.data.order.OrderRepository

class OrderListPresenterTest {
    private val mockOrderRepository = Mockito.mock(OrderRepository::class.java)
    private val mockView = Mockito.mock(OrderListContract.View::class.java)
    private val presenter =
        OrderListPresenter(mockOrderRepository, Schedulers.trampoline(), Schedulers.trampoline())

    private fun getFakeOrderList(): List<Order> =
        mutableListOf<Order>().apply {
            add(Order(1, 100F, "Order 1"))
            add(Order(2, 200F, "Order 2"))
        }

    @Before
    fun setUp() {
        presenter.attachView(mockView)
    }

    @Test
    fun refreshSuccess() {
        val fakeOrders = getFakeOrderList()

        Mockito.`when`(mockOrderRepository.getOrders()).thenReturn(just(fakeOrders))

        presenter.refresh()

        Mockito.verify(mockView).showProgress()
        Mockito.verify(mockView).hideProgress()
        Mockito.verify(mockView).showOrders(fakeOrders)
        Mockito.verify(mockView, never()).showError(ArgumentMatchers.anyString())
    }

    @Test
    fun refreshFailed() {
        val error = "Network error"

        Mockito.`when`(mockOrderRepository.getOrders()).thenReturn(error(Exception(error)))

        presenter.refresh()

        Mockito.verify(mockView).showProgress()
        Mockito.verify(mockView).hideProgress()
        Mockito.verify(mockView).showError(error)
        Mockito.verify(mockView, never()).showOrders(ArgumentMatchers.anyList())
    }

    @Test
    fun refreshWithoutView() {
        with(presenter) {
            detachView()
            refresh()
        }

        Mockito.verify(mockOrderRepository, never()).getOrders()
        Mockito.verify(mockView, never()).showProgress()
        Mockito.verify(mockView, never()).showOrders(ArgumentMatchers.anyList())
    }
}