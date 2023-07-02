package com.example.githubclient.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.githubclient.App
import com.example.githubclient.R
import com.example.githubclient.databinding.FragmentUserBinding
import com.example.githubclient.databinding.FragmentUsersBinding
import com.example.githubclient.mvp.model.GithubUser
import com.example.githubclient.mvp.model.GithubUsersRepo
import com.example.githubclient.mvp.presenter.UserPresenter
import com.example.githubclient.mvp.view.list.UserView
import com.example.githubclient.ui.activity.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

const val ARG_USER = "ARG_USER_LOGIN"

class UserFragment : MvpAppCompatFragment(), UserView, BackButtonListener {

    companion object {
        fun newInstance(login: String) =
            UserFragment().apply { arguments = bundleOf(ARG_USER to login) }
    }
    private val login: String? by lazy {
        arguments?.getString(ARG_USER,"login 1")
    }
    private var _binding: FragmentUserBinding? = null
    private val binding
        get() = _binding!!
    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            login,
            GithubUsersRepo(),
            App.instance.router
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = FragmentUserBinding.inflate(inflater, container, false).also { _binding = it }.root


    override fun backPressed() = presenter.backPressed()

    override fun setUser(user: GithubUser) {
        _binding?.rvUser?.text  = user.login
    }



}
