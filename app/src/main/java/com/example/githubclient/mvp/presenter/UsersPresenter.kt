package com.example.githubclient.mvp.presenter

import com.example.githubclient.mvp.model.GithubUser
import com.example.githubclient.mvp.model.GithubUsersRepo
import com.example.githubclient.mvp.presenter.list.IUserListPresenter
import com.example.githubclient.mvp.view.UsersView
import com.example.githubclient.mvp.view.list.UserItemView
import com.example.githubclient.navigation.AndroidScreens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter

class UsersPresenter(private val usersRepo: GithubUsersRepo, private val router: Router) :
    MvpPresenter<UsersView>() {
    class UserListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()

        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }

        override fun getCount() = users.size
    }

    private var disposable: Disposable? = null

    val userListPresentr = UserListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()

        loadData()

        userListPresentr.itemClickListener = {
            val login = userListPresentr.users[it.pos].login
            router.navigateTo(AndroidScreens().user(login))
        }
    }


    fun loadData() {
        disposable = usersRepo.getUsers().subscribe { user ->
            userListPresentr.users.add(user)
        }
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}