package ru.startandroid.testing.lesson_4_Mock_объекты.presenter

import io.reactivex.Scheduler
import io.reactivex.observers.DisposableObserver
import ru.startandroid.testing.lesson_4_Mock_объекты.order.Order
import ru.startandroid.testing.lesson_4_Mock_объекты.order.OrderListContract
import ru.startandroid.testing.lesson_4_Mock_объекты.order.OrderRepository

class OrderListPresenter(
        private val orderRepository: OrderRepository,
        private val workScheduler: Scheduler,
        private val resultScheduler: Scheduler
) : BasePresenter<OrderListContract.View>(), OrderListContract.Presenter {
    override fun refresh() {
        if (getView() == null) return

        getView()?.showProgress()

        orderRepository.getOrders()
                .subscribeOn(workScheduler)
                .observeOn(resultScheduler)
                .subscribe(object : DisposableObserver<List<Order>>() {
                    override fun onNext(orders: List<Order>) {
                        if (getView() == null) return
                        getView()?.hideProgress()
                        getView()?.showOrders(orders)
                    }

                    override fun onError(e: Throwable) {
                        if (getView() == null) return
                        getView()?.hideProgress()
                        getView()?.showError(e.message)
                    }

                    override fun onComplete() {
                    }

                })
    }
}