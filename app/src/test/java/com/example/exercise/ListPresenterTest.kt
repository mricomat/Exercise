package com.example.exercise

import com.example.exercise.data.AppDataManager
import com.example.exercise.data.model.TransactionModel
import com.example.exercise.data.network.OnResultCallback
import com.example.exercise.ui.list.ListPresenterImpl
import com.example.exercise.ui.list.ListView
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.then
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class ListPresenterTest {


    lateinit var listPresenterImpl: ListPresenterImpl<ListView>

    @Mock
    lateinit var mockView: ListView

    @Mock
    lateinit var appDataManager: AppDataManager

    @Mock
    lateinit var callback: OnResultCallback<ArrayList<TransactionModel>>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        this.listPresenterImpl = ListPresenterImpl(appDataManager)
    }

    @Test
    fun test_onAttach() {
        assertNull(listPresenterImpl.getMvpView())
        listPresenterImpl.onAttach(mockView)
        assertNotNull(listPresenterImpl.getMvpView())
    }

    @Test
    fun test_onDetach() {
        listPresenterImpl.onAttach(mockView)
        assertNotNull(listPresenterImpl.getMvpView())
        listPresenterImpl.onDetach()
        assertNull(listPresenterImpl.getMvpView())
    }

    @Test
    fun when_onAttach_called_loadServices_isCalled() {
        listPresenterImpl.onAttach(mockView)
        then(mockView).should().showLoading()
        verify(appDataManager).getTransactionsList(any())
    }

    @Test
    fun when_callbackService_call_success() {
        // TODO
    }

    @Test
    fun when_callbackService_call_error() {
        // TODO
    }

    @Test
    fun call_isCorrectDateFormat_wrongFormat_false() {
        val wrongFormat = "07-22T13:51:12.000Z"
        val isCorrectDateFormatMethod =
            listPresenterImpl.javaClass.getDeclaredMethod("isCorrectDateFormat", String::class.java)
        isCorrectDateFormatMethod.isAccessible = true

        val parameters = arrayOfNulls<Any>(1)
        parameters[0] = wrongFormat

        assertEquals(
            "Result",
            isCorrectDateFormatMethod.invoke(listPresenterImpl, *parameters),
            false
        )
    }

    @Test
    fun call_isCorrectDateFormat_correctFormat_true() {
        val correctFormat = "2018-07-22T13:48:48.000Z"

        val isCorrectDateFormatMethod =
            listPresenterImpl.javaClass.getDeclaredMethod("isCorrectDateFormat", String::class.java)
        isCorrectDateFormatMethod.isAccessible = true

        val parameters = arrayOfNulls<Any>(1)
        parameters[0] = correctFormat

        assertEquals(
            "Result",
            isCorrectDateFormatMethod.invoke(listPresenterImpl, *parameters),
            false
        )
    }

    @Test
    fun call_formatDate_correctFormat_orderedResult() {
        // TODO
    }

    @Test
    fun call_formatDate_allWrongFormat_noResults() {
        // TODO
    }

    @Test
    fun call_formatDate_disorderedSomeWrongFormat_orderedResult() {
        // TODO
    }

}