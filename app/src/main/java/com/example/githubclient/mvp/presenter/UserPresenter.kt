package com.example.githubclient.mvp.presenter

import com.example.githubclient.mvp.model.GithubUsersRepo
import com.example.githubclient.mvp.view.list.UserView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserPresenter(
    private val login: String?,
    private val usersRepo: GithubUsersRepo,
    private val router: Router
) : MvpPresenter<UserView>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        setUser()
    }

    private fun setUser() {
        login?.let {
            viewState.setUser(usersRepo.getUser(login))
        }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}
