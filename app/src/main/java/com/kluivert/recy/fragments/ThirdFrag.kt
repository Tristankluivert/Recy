package com.kluivert.recy.fragments

import android.app.Activity
import android.content.ClipData
import android.content.ClipDescription
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.DragEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.kluivert.recy.R


class ThirdFrag : Fragment() {

    lateinit var ivPick : ImageView
    lateinit var linTop : LinearLayout
    lateinit var linBot : LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivPick = view.findViewById(R.id.ivPick)
        linTop = view.findViewById(R.id.linTop)
        linBot = view.findViewById(R.id.linBot)

        linTop.setOnDragListener(dragView)
        linBot.setOnDragListener(dragView)

        ivPick.setOnClickListener {
               Intent(Intent.ACTION_GET_CONTENT).also {
                   it.type = "image/*"
                   startActivityForResult(it,0)
               }
        }

        ivPick.setOnLongClickListener {
            val clipText = "This is a clipData"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText,mimeTypes,item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data,dragShadowBuilder,it,0)
            it.visibility = View.INVISIBLE
            true
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == 0){
            var uri = data?.data
            ivPick.setImageURI(uri)
        }
    }

    val dragView = View.OnDragListener { view, event ->
        when(event.action){
            DragEvent.ACTION_DRAG_STARTED -> {
            event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
        }
            DragEvent.ACTION_DRAG_ENTERED -> {
            view.invalidate()
            true
        }
            DragEvent.ACTION_DRAG_LOCATION -> true
            DragEvent.ACTION_DRAG_EXITED -> {
            view.invalidate()
            true
        }
            DragEvent.ACTION_DROP ->{

            val item = event.clipData.getItemAt(0)
            val dragData = item.text
            Toast.makeText(context!!,dragData,Toast.LENGTH_SHORT).show()
            view.invalidate()
            val v = event.localState as View
            val owner = v.parent as ViewGroup
            owner.removeView(v)
            val destination = view as LinearLayout
            destination.addView(v)
            v.visibility = View.VISIBLE
            true

        }
            DragEvent.ACTION_DRAG_ENDED ->{
            view.invalidate()
            true
        }else -> false

        }

    }


}