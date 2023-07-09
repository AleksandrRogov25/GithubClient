package com.example.githubclient.mvp.model


import io.reactivex.rxjava3.core.Observable

class GithubUsersRepo {
    private val users = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5")
    )

    fun getUsers(): Observable<GithubUser> {
        return Observable.fromIterable(users)
    }

    fun getUser(login: String): GithubUser {
        return GithubUser(login)
    }

}