package com.example.githubclient

class MainPresenter(private val view: MainView) {
    val btnOne = 1
    val btnTwo = 2
    val btnThree = 3
    val model = CountersModel()

    fun counterClick(btn: Int) {
        when (btn) {
            btnOne -> {

                view.setBtnOneText(model.next(FERST).toString())
            }

            btnTwo -> {

                view.setBtnTwoText(model.next(SECOND).toString())
            }

            btnThree -> {

                view.setBtnThreeText(model.next(THIRD).toString())
            }
        }
    }
}