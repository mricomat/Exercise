package com.example.exercise.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercise.R
import com.example.exercise.data.model.TransactionModel
import com.example.exercise.ui.list.adapter.ListAdapter
import kotlinx.android.synthetic.main.list_fragment.*
import java.util.*
import kotlin.collections.ArrayList

/** View only in charge to show all data in the screen and control all the UI components
 *
 *  TODO Implement data injections, to don't have to worry about the instance of the Presenter
 *
 * */

class ListViewFragment : Fragment(), ListView {

    /** Singleton pattern for the ListFragment, to guaranty the only one instance of the fragment   */

    companion object {
        private const val INSTANCE_ID = "instance_id"

        private var INSTANCE: ListViewFragment? = null

        fun getInstance(): ListViewFragment =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildFragment().also { INSTANCE = it }
            }

        private fun buildFragment(): ListViewFragment {
            val bundle = Bundle()
            bundle.putString(INSTANCE_ID, UUID.randomUUID().toString())
            val fragment = ListViewFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var mPresenter: ListPresenter<ListView>
    private lateinit var mAdapter: ListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = ListPresenterImpl()
    }

    /** We attach the view all time in the OnResume to the presenter  */

    override fun onResume() {
        super.onResume()
        mPresenter.onAttach(this)
    }

    override fun onDetach() {
        mPresenter.onDetach()
        super.onDetach()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillViews()
    }

    private fun fillViews() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        mAdapter = ListAdapter(ArrayList())
        recycler_view!!.adapter = mAdapter
        recycler_view!!.layoutManager = LinearLayoutManager(context)
    }

    override fun showTransactionsList(transactionsList: ArrayList<TransactionModel>) {
        mAdapter.addList(transactionsList)
        hideLoading()
    }

    override fun showLoading() {
        progressBarContainer.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBarContainer.visibility = View.GONE
    }

    override fun showError() {
        hideLoading()
        // TODO
    }
}