package com.example.githubclient.mvp.presenter.list

import com.example.githubclient.mvp.view.list.IItemView
import com.example.githubclient.mvp.view.list.UserItemView

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((UserItemView) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}