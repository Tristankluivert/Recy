package com.kluivert.recy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kluivert.recy.fragments.FirstFrag
import com.kluivert.recy.fragments.SecondFrag
import com.kluivert.recy.fragments.ThirdFrag
import kotlinx.android.synthetic.main.slides_layout.view.*

class tabAdapter(
  fm : FragmentManager,
  lifecycle: Lifecycle,
  private var tabNo : Int
) : FragmentStateAdapter(fm,lifecycle){


    override fun createFragment(position: Int): Fragment {
               when(position){
                      0->{
                          val bundle = Bundle()
                          bundle.putString("fragmentName", "First Fragment")
                          val firstFrag = FirstFrag()
                          firstFrag.arguments = bundle
                          return firstFrag
                      }
                   1->{
                       val bundle = Bundle()
                       bundle.putString("fragmentName", "Second Fragment")
                       val secondFrag = SecondFrag()
                        secondFrag.arguments = bundle
                       return secondFrag
                   }
                   2->{
                       val bundle = Bundle()
                       bundle.putString("fragmentName", "Third Fragment")
                       val thirdFrag = ThirdFrag()
                      thirdFrag.arguments = bundle
                       return thirdFrag
                   }
                   else -> return FirstFrag()

               }
    }

    override fun getItemCount(): Int {
         return tabNo

    }
}