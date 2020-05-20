package com.example.codingmim.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.codingmim.R
import kotlinx.android.synthetic.main.fragment_first.view.*

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this com.example.codingmim.fragment

        val view : View = inflater.inflate(R.layout.fragment_first, container, false)

        val list_array = arrayListOf<ContentListModel>(

            ContentListModel("a", "b", 1, "d"),
            ContentListModel("a", "b", 1, "d"),
            ContentListModel("a", "b", 1, "d"),
            ContentListModel("a", "b", 1, "d")
        )

        val list_adapter = FirstFragAdapter(requireContext(), list_array)
        view.listView_first_fragment.adapter = list_adapter

        return view
    }

}
