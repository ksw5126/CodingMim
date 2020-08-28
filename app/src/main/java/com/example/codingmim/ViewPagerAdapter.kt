package com.example.codingmim

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

open class ViewPagerAdapter (private val context: Context, private var images : ArrayList<Int>) : PagerAdapter() {

    private var layoutInflater : LayoutInflater? = null


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return images.size
    }

    // 이미지가 생성하는 부분과 없어지는 부분 생성
    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = layoutInflater!!.inflate(R.layout.viewpager_activity, null)
        val image = v.findViewById<View>(R.id.imageview) as ImageView


        image.setImageResource(images[position])
        val vp = container as ViewPager
        vp.addView(v, 0)

        return v
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        val vp = container as ViewPager
        val v = `object` as View
        vp.removeView(v)
    }
}