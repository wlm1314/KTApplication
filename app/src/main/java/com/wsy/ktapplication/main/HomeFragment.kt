package com.wsy.ktapplication.main

import android.text.format.DateUtils
import android.util.Log
import com.wsy.ktapplication.R
import com.wsy.ktapplication.base.BaseFragment
import com.wsy.ktapplication.entity.LatestNews
import com.wsy.ktapplication.entity.Story
import com.wsy.ktapplication.network.HttpClient
import com.wsy.ktapplication.rx.DataTransformer
import com.wsy.ktapplication.rx.SchedulerTransformer
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import retrofit2.Response

class HomeFragment :BaseFragment(){
    override fun getLayout(): Int {
        return R.layout.content_main
    }

    override fun initView() {

    }

    override fun initData() {
        loadData(true)
    }

    private fun loadData(isFirst: Boolean) {
        var observable: Observable<Response<LatestNews>> = HttpClient.getInstance()
            .service()
            .latestNews()
        observable!!.compose(SchedulerTransformer<Response<LatestNews>>())
            .compose(DataTransformer<LatestNews>())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                    for (top_story in it.top_stories) {

                    }
                return@map it.stories
            }.subscribe {
                for (story in it){
                    Log.e("aaa", story.title)
                }
            }
    }

}