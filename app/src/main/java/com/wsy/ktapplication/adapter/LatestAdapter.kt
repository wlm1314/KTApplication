package com.wsy.ktapplication.adapter

import android.text.TextUtils
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wsy.ktapplication.R
import com.wsy.ktapplication.entity.Story

class LatestAdapter : RecyclerView.Adapter<LatestAdapter.LatestViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestViewHolder {
        var contentView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_latest, parent, false)
        return LatestViewHolder(contentView)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: LatestViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class LatestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var mTvContent: TextView? = null
        var mTvType: TextView? = null
        var mTvTime: TextView? = null
        var mImgPic: ImageView? = null
        var map: HashMap<Int, String>? = null

        init {
            mTvContent = itemView.findViewById<TextView>(R.id.tv_content)
            mTvType = itemView.findViewById<TextView>(R.id.tv_type)
            mTvTime = itemView.findViewById<TextView>(R.id.tv_time)
            mImgPic = itemView.findViewById<ImageView>(R.id.img_pic)
        }
    }

}