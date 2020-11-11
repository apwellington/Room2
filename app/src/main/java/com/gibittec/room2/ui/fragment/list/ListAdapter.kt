package com.gibittec.room2.ui.fragment.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.gibittec.room2.R
import com.gibittec.room2.model.User
import kotlinx.android.synthetic.main.customer_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()



    class MyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.customer_row, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val customerItem = userList[position]
        holder.itemView.id_txt.text = customerItem.id.toString()
        holder.itemView.first_name_txt.text = customerItem.firstName
        holder.itemView.last_name_txt.text = customerItem.lastName
        holder.itemView.age_txt.text = customerItem.age.toString()

        holder.itemView.rowLayout.setOnClickListener {
            val action = ListFrangmetDirections.actionListFrangmetToUpdateFragment(customerItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }

}