package ru.startandroid.testing.lesson_4_Mock_объекты.presenter

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