package com.kluivert.recy

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_tab.*

class TabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)

        setCustomTabTitles()


       tabLayout.setSelectedTabIndicatorColor(Color.WHITE)
        tabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
        tabLayout.tabTextColors = ContextCompat.getColorStateList(this, android.R.color.white)

        val numberOfTabs = 3
        tabLayout.tabMode = TabLayout.MODE_FIXED
      tabLayout.isInlineLabel = true


        val adapter = tabAdapter(supportFragmentManager, lifecycle, numberOfTabs)
       viewPager2.adapter = adapter

        // Enable Swipe
        viewPager2.isUserInputEnabled = true

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "First"
                    tab.setIcon(R.drawable.ic_alarm)
                }
                1 -> {
                    tab.text = "Second"
                    tab.setIcon(R.drawable.ic_message)

                }
                2 -> {
                    tab.text = "Third"
                    tab.setIcon(R.drawable.ic_fav)
                }

            }
            // Change color of the icons
            tab.icon?.colorFilter =
                BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                    Color.WHITE,
                    BlendModeCompat.SRC_ATOP
                )
        }.attach()



    }

    private fun setCustomTabTitles() {
        val vg = tabLayout.getChildAt(0) as ViewGroup
        val tabsCount = vg.childCount

        for (j in 0 until tabsCount) {
            val vgTab = vg.getChildAt(j) as ViewGroup

            val tabChildCount = vgTab.childCount

            for (i in 0 until tabChildCount) {
                val tabViewChild = vgTab.getChildAt(i)
                if (tabViewChild is TextView) {

                    // Change Font and Size
                    tabViewChild.typeface = Typeface.DEFAULT_BOLD
//                    val font = ResourcesCompat.getFont(this, R.font.myFont)
//                    tabViewChild.typeface = font
//                    tabViewChild.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25f)
                }
            }
        }
    }



}

