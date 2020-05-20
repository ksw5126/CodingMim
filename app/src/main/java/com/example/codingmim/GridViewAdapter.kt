package com.example.codingmim

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.gridview_item.view.*

class GridViewAdapter (val context: Context, val imgList : Array<Int>, val textList : Array<String>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view : View = LayoutInflater.from(context).inflate(R.layout.gridview_item, null)

        view.gridview_text.text = textList[position]
        view.gridview_img.setImageResource(imgList[position])

        return view
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return imgList.size
    }

}