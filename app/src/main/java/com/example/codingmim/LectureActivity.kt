package com.example.codingmim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.codingmim.Fragment.FragmentAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_lecture.*
import kotlinx.android.synthetic.main.custom_tab.view.*

class LectureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecture)

        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        list_viewpager.adapter = fragmentAdapter

        tab_layout.addTab(tab_layout.newTab().setCustomView(createTableView("AI")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTableView("CSS")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTableView("HTML")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTableView("ID")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTableView("JPG")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTableView("JS")))

        list_viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                if (p0 != null) {
                    list_viewpager.currentItem = p0.position
                }
            }


        })
    }

    private fun createTableView(tabName : String) : View {

        val tabView = LayoutInflater.from(baseContext).inflate(R.layout.custom_tab, null)
        tabView.text_name.text = tabName

        return tabView

    }
}
