package com.mindorks.framework.mvvm.ui.main

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.mindorks.framework.mvvm.R
import com.mindorks.framework.mvvm.data.model.EmployeeModel
import com.mindorks.framework.mvvm.ui.base.ViewModelFactory
import com.mindorks.framework.mvvm.ui.main.viewmodel.MainViewModel
import com.mindorks.framework.mvvm.utils.Status
import com.sagamore.testapplication.feature_main_list.ItemListPresenter
import com.mindorks.framework.mvvm.data.db.model.SpecialtyModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_employee_list.*
import javax.inject.Inject

class MainListActivity : DaggerAppCompatActivity(), ItemListView {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private var twoPane: Boolean = false

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val mainViewModel: MainViewModel by viewModels(factoryProducer = { viewModelFactory })

    private val presenter: ItemListPresenter = ItemListPresenter(this)

    private lateinit var recyclerView: RecyclerView

    private var adapter = SpecialityListAdapter(this, twoPane)

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list)

        recyclerView = findViewById<View>(R.id.item_list) as RecyclerView
        recyclerView.adapter = adapter

        //presenter.loadSpecialities()

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.title = title

        if (findViewById<NestedScrollView>(R.id.item_detail_container) != null) {
            twoPane = true
        }

        mainViewModel.getSpecialities().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    Log.i("qqqqq", "onCreate: Status.SUCCESS")
                    progressBar.visibility = View.GONE
                    it.data?.let { list -> renderList(list) }
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    Log.i("qqqqq", "onCreate: Status.ERROR")
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(list: List<SpecialtyModel>) {
        Log.i("qqqqq", "renderList")
        adapter.setData(list)
        adapter.notifyDataSetChanged()
    }

    override fun onDataLoaded(list: List<SpecialtyModel>) {
        adapter.setData(list)
    }

    override fun onEmployeeLoaded(list: List<EmployeeModel>) {
        Log.i("11111", "onEmployeeLoaded: ")
    }

    override fun onNotFound() {
        Toast.makeText(
            this, "NO RESULTS FOUND",
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onError(t: Throwable) {
        Toast.makeText(
            this, "ERROR IN FETCHING API RESPONSE. Try again",
            Toast.LENGTH_LONG
        ).show()
    }

    companion object {
        const val BASE_URL = "https://gitlab.65apps.com/"
    }
}
