package com.kluivert.recy

import android.content.res.Resources
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.kluivert.recy.fragments.FirstFrag
import com.kluivert.recy.fragments.SecondFrag
import com.kluivert.recy.fragments.ThirdFrag
import kotlinx.android.synthetic.main.activity_page.*

class PageActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)

        val firstFrag = FirstFrag()
        val secFrag = SecondFrag()
        val thirdFrag = ThirdFrag()

        getFragment(firstFrag)

        btmNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miHome -> getFragment(firstFrag)
                R.id.miMessage -> getFragment(secFrag)
                R.id.miNotifs -> getFragment(thirdFrag)

            }
              true
        }

        btmNav.getOrCreateBadge(R.id.miNotifs).apply {
            number = 15
            backgroundColor = getColor(R.color.colorAccent)
        }


    }

    private fun getFragment(fragment : Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.frLayout,fragment)
        commit()
    }

}