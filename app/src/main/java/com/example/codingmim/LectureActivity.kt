package com.example.codingmim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.codingmim.Fragment.FragmentAdapter
import kotlinx.android.synthetic.main.activity_lecture.*

class LectureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecture)

        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        list_viewpager.adapter = fragmentAdapter
    }
}