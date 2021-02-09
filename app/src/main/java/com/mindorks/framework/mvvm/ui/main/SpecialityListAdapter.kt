package com.mindorks.framework.mvvm.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.mindorks.framework.mvvm.R
import com.mindorks.framework.mvvm.ui.listing.view.EmployeeListActivity
import com.mindorks.framework.mvvm.data.db.model.SpecialtyModel

class SpecialityListAdapter(
    private val parentActivity: AppCompatActivity,
    private val twoPane: Boolean
) :
    RecyclerView.Adapter<SpecialityListAdapter.ViewHolder>() {

    private var specialities: List<SpecialtyModel> = arrayListOf()
    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->

            val item = v.tag as SpecialtyModel
            v.context.startActivity(EmployeeListActivity.createIntent(parentActivity, item.specialty_id))
//            val item = v.tag as EmployeeModel
//            if (twoPane) {
//                val fragment = ItemDetailFragment().apply {
//                    arguments = Bundle().apply {
//                        putSerializable(ItemDetailFragment.ARG_ITEM_ID, item)
//                    }
//                }
//                parentActivity.supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.item_detail_container, fragment)
//                    .commit()
//            } else {
//                val intent = Intent(v.context, ItemDetailActivity::class.java).apply {
//                    putExtra(ItemDetailFragment.ARG_ITEM_ID, item)
//                }
//                v.context.startActivity(intent)
//            }
        }
    }

    internal fun setData(employeeList: List<SpecialtyModel>) {
        specialities = employeeList
        Log.i("qqqqq", "setData specialities = ${ specialities.size}")
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_content, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = specialities[position]
        holder.idView.text = item.name
        holder.contentView.text = item.specialty_id.toString()
        with(holder.itemView) {
            tag = item
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount() = specialities.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.id_text)
        val contentView: TextView = view.findViewById(R.id.content)
    }
}
