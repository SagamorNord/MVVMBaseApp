package com.mindorks.framework.mvvm.ui.listing.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mindorks.framework.mvvm.R
import com.mindorks.framework.mvvm.data.model.EmployeeModel
import com.mindorks.framework.mvvm.ui.feature_details.ItemDetailActivity
import com.mindorks.framework.mvvm.ui.feature_details.ItemDetailFragment
import com.mindorks.framework.mvvm.utils.convertDate
import com.mindorks.framework.mvvm.utils.stringFormatting
import kotlinx.android.synthetic.main.employee_card.view.*

class EmployeesAdapter(
    private val users: ArrayList<EmployeeModel>
) : RecyclerView.Adapter<EmployeesAdapter.DataViewHolder>() {

    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->

            val item = v.tag as EmployeeModel
            val intent = Intent(v.context, ItemDetailActivity::class.java).apply {
                putExtra(ItemDetailFragment.ARG_ITEM_ID, item)
            }
            v.context.startActivity(intent)
        }
    }
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: EmployeeModel) {
            itemView.firstName.text = user.f_name.stringFormatting()
            itemView.lastName.text = user.l_name.stringFormatting()
            Glide.with(itemView.imageAvatar.context)
                .load(user.avatr_url)
                .into(itemView.imageAvatar)
            itemView.birthday.text = convertDate(user.birthday, "dd.MM.yyyy")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.employee_card, parent,
                false
            )
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val item = users[position]
        holder.bind(users[position])
        with(holder.itemView) {
            tag = item
            setOnClickListener(onClickListener)
        }
    }

    fun addData(list: List<EmployeeModel>) {
        users.addAll(list)
    }

}
