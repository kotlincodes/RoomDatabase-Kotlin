package com.kotlincodes.roomdatabasekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlincodes.roomdatabasekotlin.adapter.RecyAdapter
import com.kotlincodes.roomdatabasekotlin.database.AppDatabase
import com.kotlincodes.roomdatabasekotlin.model.UserModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    lateinit var locaDb:AppDatabase
    lateinit var adapter: RecyAdapter
    private val listData:ArrayList<UserModel> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        locaDb= AppDatabase.getAppDatabase(this)!!
        adapter= RecyAdapter(this,listData)

        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(this)

        btnAdd.setOnClickListener{
            when {
                edtName.editableText.isEmpty() -> {
                    edtName.error = "Please enter name"
                    return@setOnClickListener
                }
                edtMobile.editableText.isEmpty() -> {
                    edtMobile.error = "Please enter mobile"
                    return@setOnClickListener
                }
                else -> {
                    val user=UserModel(name = edtName.editableText.toString(),mobile = edtMobile.editableText.toString())

                    thread {
                        locaDb.users().insert(user)
                    }
                }
            }
        }

        btnFetch.setOnClickListener {
            listData.clear()
            thread {
                listData.addAll(locaDb.users().getAllUsers())
                runOnUiThread {
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }


}
