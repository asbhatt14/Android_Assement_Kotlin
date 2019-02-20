package com.example.ankur.android_assementtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.mainlayout_recyclerview.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainlayout_recyclerview)

        recyclerViewMain.layoutManager = LinearLayoutManager(this)
        recyclerViewMain.adapter = MainRecyclerAdapter()

     /*   var textToCheck:String = ""

        edtbox1.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

                if(s.length == 1){
                    textToCheck = edtbox1.text.toString()
                    edtbox2.requestFocus()
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })
        edtbox2.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

                if(s.length == 1){
                    textToCheck += edtbox2.text.toString()
                    edtbox3.requestFocus()
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })
        edtbox3.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

                if(s.length == 1){
                    textToCheck += edtbox3.text.toString()
                    edtbox4.requestFocus()
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })
        edtbox4.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

                if(s.length == 1){
                    textToCheck += edtbox4.text.toString()
                    Toast.makeText(this@MainActivity, textToCheck, Toast.LENGTH_SHORT).show()
                    if(textToCheck.equals("eyes",true)){
                        Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@MainActivity, "Failure", Toast.LENGTH_SHORT).show()
                    }

                    textToCheck = ""
                    edtbox1.text.clear()
                    edtbox2.text.clear()
                    edtbox3.text.clear()
                    edtbox4.text.clear()
                    edtbox1.requestFocus()
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })

        var userList : ArrayList<User> = ArrayList<User>()
        var userList1 : ArrayList<User> = ArrayList<User>()
        for (i in 1..5){
            var user = User()
            user.name = "Ankur"
            user.grade = "11"
            user.schoolName = "Louis Vincent High School"

            userList.add(user)
            userList1.add(user)
        }

        recyclerViewAdded.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        recyclerViewAdded.adapter = AddFriendAdapter(userList)

        recyclerViewSuggested.layoutManager = LinearLayoutManager(this)
        recyclerViewSuggested.adapter = SuggestedFriendAdapter(userList1)
*/
    }
}
