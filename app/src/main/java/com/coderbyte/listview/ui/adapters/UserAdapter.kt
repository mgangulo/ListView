package com.coderbyte.listview.ui.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.coderbyte.listview.R
import com.coderbyte.listview.pojo.User


class UserAdapter(val userList: List<User>, val context:Context) : BaseAdapter() {
    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return userList.size
    }

    override fun getItem(position: Int): User {
        return userList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return userList.get(position).id
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.user_list_item, parent, false)
        val textView = rowView.findViewById<TextView>(R.id.name);
        textView.setText(getItem(position).name);
        return rowView
    }
}