package ru.startandroid.testing.presenter

open class BasePresenter<V> {
    private var view: V? = null

    fun attachView(view: V) {
        this.view = view
    }

    fun getView() = view

    fun detachView() {
        view = null
    }
}