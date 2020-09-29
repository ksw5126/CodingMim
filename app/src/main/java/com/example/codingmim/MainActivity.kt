package com.example.codingmim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.codingmim.Auth.LoginActivity
import com.example.codingmim.Auth.MyCominActivity
import com.example.codingmim.Fragment.ListFragment.FirstFragment
import com.example.codingmim.Fragment.ListFragment.SecondFragAdapter
import com.example.codingmim.Fragment.ListFragment.SecondFragment
import com.example.codingmim.Fragment.MarketInfo.MarketInfoActivity2
import com.example.codingmim.Zzim.ZzimActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom.*
import pl.pzienowicz.autoscrollviewpager.AutoScrollViewPager

class MainActivity : AppCompatActivity() {

    lateinit var viewpager: ViewPager

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 메인페이지에서 윗부분 오토스크롤뷰
        val images = ArrayList<Int>()
        images.add(R.drawable.ai)
        images.add(R.drawable.css)
        images.add(R.drawable.html)

        viewPager.adapter = ImagesAdapter(this, images)
        viewPager.setInterval(2000)
        viewPager.setDirection(AutoScrollViewPager.Direction.RIGHT)
        viewPager.setCycle(false)
        viewPager.setBorderAnimation(true)
        viewPager.setSlideBorderMode(AutoScrollViewPager.SlideBorderMode.TO_PARENT)
        viewPager.startAutoScroll()

        auth = FirebaseAuth.getInstance()


        // gridview_item.xml 에서 이미지와 텍스트 연결
        val img = arrayOf(
            R.drawable.ai, R.drawable.css, R.drawable.html,
            R.drawable.id, R.drawable.jpg, R.drawable.js,
            R.drawable.mp4, R.drawable.pdf, R.drawable.php,
            R.drawable.png, R.drawable.psd, R.drawable.tiff
        )

        val text = arrayOf(
            "ai", "css", "html", "id",
            "jpg", "js", "mp4", "pdf",
            "php", "png", "psd", "tiff"
        )

        val gridViewAdapter = GridViewAdapter(this, img, text)
        gridview.adapter = gridViewAdapter

        gridview.setOnItemClickListener { parent, view, position, id ->

            val intent = Intent(this, LectureActivity::class.java)
            startActivity(intent)

            Toast.makeText(applicationContext,""+ position, Toast.LENGTH_SHORT).show();

            if (position == 1) {
                val intent = Intent(this, SecondFragAdapter::class.java)
                startActivity(intent)

            }


        }

        my_page.setOnClickListener {
            // 로그인 여부 확인
            if (auth.currentUser == null) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, MyCominActivity::class.java)
                startActivity(intent)
            }
        }

        zzim_icon.setOnClickListener {

            val intent = Intent(this, ZzimActivity::class.java)
            startActivity(intent)
        }


    }


}

