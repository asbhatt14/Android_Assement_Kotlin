package com.example.ankur.android_assementtest

import android.app.Application
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val customView = LayoutInflater.from(parent.context).inflate(R.layout.activity_main,parent,false)
        return MainRecyclerHolder(customView)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        var textToCheck:String = ""

        holder.itemView.edtbox1.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

                if(s.length == 1){
                    textToCheck = holder.itemView.edtbox1.text.toString()
                    holder.itemView.edtbox2.requestFocus()
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })
        holder.itemView.edtbox2.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

                if(s.length == 1){
                    textToCheck += holder.itemView.edtbox2.text.toString()
                    holder.itemView.edtbox3.requestFocus()
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })
        holder.itemView.edtbox3.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

                if(s.length == 1){
                    textToCheck += holder.itemView.edtbox3.text.toString()
                    holder.itemView.edtbox4.requestFocus()
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })
        holder.itemView.edtbox4.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

                if(s.length == 1){
                    textToCheck += holder.itemView.edtbox4.text.toString()
                    Toast.makeText(holder.itemView.context, textToCheck, Toast.LENGTH_SHORT).show()
                    if(textToCheck.equals("eyes",true)){
                        Toast.makeText(holder.itemView.context, "Success", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(holder.itemView.context, "Failure", Toast.LENGTH_SHORT).show()
                    }

                    textToCheck = ""
                    holder.itemView.edtbox1.text.clear()
                    holder.itemView.edtbox2.text.clear()
                    holder.itemView.edtbox3.text.clear()
                    holder.itemView.edtbox4.text.clear()
                    holder.itemView.edtbox1.requestFocus()
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
            user.grade = "Grade 11"
            user.schoolName = "Louis Vincent High School"
            if(i%2==0){
                user.imageUrl = "https://images.unsplash.com/photo-1542841366-d551dd4a57f8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80"
            }else{
                user.imageUrl = "https://images.unsplash.com/photo-1547624643-3bf761b09502?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80"
            }
            userList.add(user)
            userList1.add(user)
        }

        holder.itemView.recyclerViewAdded.layoutManager = LinearLayoutManager(holder.itemView.context, OrientationHelper.HORIZONTAL, false)
        holder.itemView.recyclerViewAdded.adapter = AddFriendAdapter(userList)

        holder.itemView.recyclerViewSuggested.layoutManager = LinearLayoutManager(holder.itemView.context)
        holder.itemView.recyclerViewSuggested.adapter = SuggestedFriendAdapter(userList1)
    }

    class MainRecyclerHolder(v: View) : RecyclerView.ViewHolder(v){
        private  var view : View = v

    }
}