package com.example.ankur.android_assementtest

import android.app.AlertDialog
import android.app.Application
import android.app.ProgressDialog
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_addedlayout.view.*
import kotlinx.android.synthetic.main.rowsuggestedlayout.view.*
import java.util.*
import java.util.logging.Handler
import kotlin.concurrent.schedule

class SuggestedFriendAdapter(private val user : ArrayList<User>) : RecyclerView.Adapter<SuggestedFriendAdapter.SuggestFriendHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestFriendHolder {
        val customView = LayoutInflater.from(parent.context).inflate(R.layout.rowsuggestedlayout,parent,false)
        return SuggestedFriendAdapter.SuggestFriendHolder(customView)
    }

    override fun getItemCount(): Int {
        return user.size
    }

    override fun onBindViewHolder(holder: SuggestFriendHolder, position: Int) {
        var itemUser = user[position]
        holder.bindData(itemUser)
        holder.itemView.imgDeleteRow.setOnClickListener {
            user.removeAt(position)
            notifyItemRemoved(position)
            notifyDataSetChanged()
            notifyItemRangeChanged(position,user.size)
        }

        holder.itemView.txtAddNow.setOnClickListener {
            holder.itemView.txtAddNow.visibility = View.GONE
            holder.itemView.imgDeleteRow.visibility = View.GONE

            holder.itemView.txtAdded.visibility = View.VISIBLE
        }
    }

    class  SuggestFriendHolder(v: View) : RecyclerView.ViewHolder(v){
        private  var view : View = v
        private var user : User? = null

        fun bindData(user:User){
            this.user = user
            view.txtSuggestedName.text = user.name
            view.txtSchool.text = user.schoolName
            view.txtGrade.text = user.grade

            Picasso.get()
                    .load(user.imageUrl)
                    .error(R.drawable.ic_launcher_background)
                    .into(view.profile_imageSuggest);

            if(adapterPosition == 0){
                view.imgHeart.visibility = View.VISIBLE
                view.imgPhone.visibility = View.VISIBLE
                view.imgSocial.visibility = View.VISIBLE
                view.imgStar.visibility = View.VISIBLE
                view.imgbubble.visibility = View.VISIBLE
            }else if(adapterPosition == 1){
                view.imgHeart.visibility = View.VISIBLE
                view.imgPhone.visibility = View.GONE
                view.imgSocial.visibility = View.VISIBLE
                view.imgStar.visibility = View.GONE
                view.imgbubble.visibility = View.VISIBLE
            } else if(adapterPosition == 2){
                view.imgHeart.visibility = View.GONE
                view.imgPhone.visibility = View.VISIBLE
                view.imgSocial.visibility = View.GONE
                view.imgStar.visibility = View.VISIBLE
                view.imgbubble.visibility = View.VISIBLE
            }else {
                view.imgHeart.visibility = View.VISIBLE
                view.imgPhone.visibility = View.GONE
                view.imgSocial.visibility = View.VISIBLE
                view.imgStar.visibility = View.VISIBLE
                view.imgbubble.visibility = View.GONE
            }
        }
    }
}