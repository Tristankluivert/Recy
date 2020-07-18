package com.kluivert.recy

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        btnAddImage.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                startActivityForResult(it,0)
            }
        }



        btnalertOne.setOnClickListener {
            alertOne()

        }

        btnalertTwo.setOnClickListener {
            alertTwo()
        }

        btnalertThree.setOnClickListener {
            alertThree()
        }


        val list = listOf("Bada","Bada","Boom","Boom")
        val adapter = ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list)
        spAnime.adapter = adapter

       spAnime.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
           override fun onNothingSelected(parent: AdapterView<*>?) {

           }

           override fun onItemSelected(
               parent: AdapterView<*>?,
               view: View?,
               position: Int,
               id: Long
           ) {

               Toast.makeText(this@SecondActivity,"You picked ${parent?.getItemAtPosition(position).toString()}",Toast.LENGTH_SHORT).
                       show()

           }

       }

    }

    private fun alertOne(){
       val alertOne = AlertDialog.Builder(this)
            .setTitle("First dialog")
            .setMessage("Do you like coding?")
            .setIcon(R.drawable.ic_fav)
            .setPositiveButton("Yes"){dialog, which ->
              Toast.makeText(this,"Great",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){dialog, which ->
                Toast.makeText(this,"Booh for you",Toast.LENGTH_SHORT).show()
            }.create()

        alertOne.show()
    }

    private fun alertTwo(){
        val options = arrayOf("Boruto","HunterXHunter","Jojo","Dice")
        val alertTwo = AlertDialog.Builder(this)
            .setTitle("Choose an anime")
            .setSingleChoiceItems(options,0){dialog, which ->
                    Toast.makeText(this,"You selected ${options[which]}",Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept"){dialog, which ->
                Toast.makeText(this,"Great",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline"){dialog, which ->
                Toast.makeText(this,"Good for you",Toast.LENGTH_SHORT).show()
            }.create()

        alertTwo.show()
    }

    private fun alertThree(){
        val options = arrayOf("Boruto","HunterXHunter","Jojo")
        val alertThree = AlertDialog.Builder(this)
            .setTitle("Choose an anime")
            .setMultiChoiceItems(options, booleanArrayOf(false,false,false)){_, which, isChecked ->
                if (isChecked){
                    Toast.makeText(this,"You checked ${options[which]}",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"You unchecked ${options[which]}",Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Accept"){_, _ ->
                Toast.makeText(this,"Great",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline"){_, _ ->
                Toast.makeText(this,"Good for you",Toast.LENGTH_SHORT).show()
            }.create()

        alertThree.show()
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK && requestCode == 0){
            var uri =  data?.data
            imgIcon.setImageURI(uri)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_layout,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.miFav -> Toast.makeText(this,"You clicked ${item.title}",Toast.LENGTH_SHORT).show()
            R.id.miAlarm -> Toast.makeText(this,"You clicked ${item.title}",Toast.LENGTH_SHORT).show()
            R.id.miSettings -> Toast.makeText(this,"You clicked ${item.title}",Toast.LENGTH_SHORT).show()
            R.id.miContact -> Toast.makeText(this,"You clicked ${item.title}",Toast.LENGTH_SHORT).show()
            R.id.miExit -> finish()
        }

        return true
    }
}