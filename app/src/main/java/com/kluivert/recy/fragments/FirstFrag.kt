package com.kluivert.recy.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.kluivert.recy.R
import com.kluivert.recy.SlideAdapter
import com.kluivert.recy.Sliders
import kotlinx.android.synthetic.main.fragment_first.*
import xyz.sangcomz.indicatordecorator.IndicatorItemDecoration
import xyz.sangcomz.indicatordecorator.shape.CircleIndicator
import kotlin.math.roundToInt


class FirstFrag : Fragment() {

    lateinit var viewPager : ViewPager2



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

    return inflater.inflate(R.layout.fragment_first, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = view.findViewById(R.id.viewPager)


        var slides = mutableListOf(
            Sliders("Hello One","Hello one description",R.drawable.ic_home),
            Sliders("Hello Two","Hello two description",R.drawable.ic_message),
            Sliders("Hello Three","Hello three description",R.drawable.ic_alarm),
            Sliders("Hello Four ","Hello four description",R.drawable.ic_alarm)
        )



        var adapter = SlideAdapter(slides)
        viewPager.adapter = adapter


        viewPager.addItemDecoration(IndicatorItemDecoration().apply {
            indicatorShape = CircleIndicator().apply {
                colorActive = ContextCompat.getColor(context!!, R.color.colorPrimaryDark)
                colorInactive = ContextCompat.getColor(context!!,R.color.white)
            }
        })


        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)



            }
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }
        })


    }



}