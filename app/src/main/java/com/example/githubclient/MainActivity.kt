package com.example.githubclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubclient.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {
    private var vb: ActivityMainBinding? = null
    val presenter = MainPresenter(this)

    val counters = mutableListOf(0, 0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        vb?.btnCounter1?.setOnClickListener { presenter.counterClick(presenter.btnOne) }
        vb?.btnCounter2?.setOnClickListener { presenter.counterClick(presenter.btnTwo) }
        vb?.btnCounter3?.setOnClickListener { presenter.counterClick(presenter.btnThree) }
    }
    override fun setBtnOneText(text: String) {
        vb?.btnCounter1?.text = text
    }
    override fun setBtnTwoText(text: String) {
        vb?.btnCounter2?.text = text
    }
    override fun setBtnThreeText(text: String) {
        vb?.btnCounter3?.text = text
    }


}
