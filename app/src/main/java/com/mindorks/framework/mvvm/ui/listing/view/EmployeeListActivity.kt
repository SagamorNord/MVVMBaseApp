package com.mindorks.framework.mvvm.ui.listing.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mindorks.framework.mvvm.R
import com.mindorks.framework.mvvm.data.model.EmployeeModel
import com.mindorks.framework.mvvm.ui.base.ViewModelFactory
import com.mindorks.framework.mvvm.ui.listing.adapter.EmployeesAdapter
import com.mindorks.framework.mvvm.ui.listing.viewmodel.ListingViewModel
import com.mindorks.framework.mvvm.utils.Status
import com.mindorks.framework.mvvm.utils.calculateNumOfColumns
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_employee_list.*
import kotlinx.android.synthetic.main.employee_list.*

import javax.inject.Inject

class EmployeeListActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val mainViewModel: ListingViewModel by viewModels(factoryProducer = { viewModelFactory })
    private lateinit var adapter: EmployeesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_list)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val mode = intent.getIntExtra(SPEC_ID, DEFAULT_SPEC_ID)

        setupUI()
        setupObserver(mode)
    }

    private fun setupUI() {
        recyclerView.layoutManager = GridLayoutManager(this, calculateNumOfColumns(this))
        adapter = EmployeesAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObserver(mode: Int) {
        mainViewModel.getUsers(mode).observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { users -> renderList(users) }
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(users: List<EmployeeModel>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }

    companion object {
        const val SPEC_ID = "speciality_id"
        const val DEFAULT_SPEC_ID = 101

        fun createIntent(context: Context, specialtyId: Int): Intent {
            return Intent(context, EmployeeListActivity::class.java)
                .putExtra(SPEC_ID, specialtyId)
        }
    }
}
