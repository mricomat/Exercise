package com.example.exercise.ui.base

/** Base class for all Presenters which will need to have an instance of the view related */

open class BasePresenterImpl<V : BaseView> : BasePresenter<V> {

    private var mMvpView: V? = null

    override fun onAttach(view: V) {
        mMvpView = view
    }

    override fun onDetach() {
        mMvpView = null
    }

    fun getMvpView(): V? {
        return mMvpView
    }

    fun isViewAttached(): Boolean {
        return mMvpView != null
    }
}