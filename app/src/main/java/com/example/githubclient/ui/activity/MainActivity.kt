package com.example.githubclient.ui.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubclient.App
import com.example.githubclient.R
import com.example.githubclient.mvp.presenter.MainPresenter
import com.example.githubclient.databinding.ActivityMainBinding
import com.example.githubclient.mvp.model.GithubUsersRepo
import com.example.githubclient.mvp.view.MainView
import com.example.githubclient.navigation.AndroidScreens
import com.example.githubclient.ui.adapter.UsersRVAdapter
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private var vb: ActivityMainBinding? = null

    private val presenter by moxyPresenter {
        MainPresenter(App.instance.router, AndroidScreens())
    }

    val navigator = AppNavigator(this, R.id.container)

    private var adapter: UsersRVAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()

        App.instance.navigatorHolder.setNavigator(navigator)

    }

    override fun onPause() {
        super.onPause()

        App.instance.navigatorHolder.removeNavigator()

    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }

        presenter.backClicked()

    }

}
