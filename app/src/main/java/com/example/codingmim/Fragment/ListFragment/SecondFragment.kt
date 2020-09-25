package com.example.codingmim.Fragment.ListFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.codingmim.R
import kotlinx.android.synthetic.main.fragment_first.view.*
import kotlinx.android.synthetic.main.fragment_second.view.*

/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view : View = inflater.inflate(R.layout.fragment_second, container, false)

        val list_array = arrayListOf<ContentListModel>(
            ContentListModel(R.drawable.list1, "Lang1", 1, "d"),
            ContentListModel(R.drawable.list2, "Lang2", 1, "d"),
            ContentListModel(R.drawable.list3, "Lang3", 1, "d"),
            ContentListModel(R.drawable.list4, "Lang4", 1, "d")

        )

        val list_adapter =
            FirstFragAdapter(
                requireContext(),
                list_array
            )
        view.listView_second_fragment.adapter = list_adapter

        // Inflate the layout for this com.example.codingmim.fragment
        return view
    }

}
