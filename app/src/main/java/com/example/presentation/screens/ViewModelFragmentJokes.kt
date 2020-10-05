package com.example.presentation.screens

import android.text.Editable
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import com.example.app.App
import com.example.model.RestAPI
import com.example.model.entity.Joke
import com.example.presentation.screens.rvAfapter.AdaptRV
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ViewModelFragmentJokes : ViewModel() {
    var count = ObservableField<String>("0")
    private val dispose = CompositeDisposable()
    val adaptRV = AdaptRV()

    @Inject
    lateinit var restAPI: RestAPI

    init {
        App.appComponent.inject(this)
    }

    fun getJokes() {
        dispose.add(
            restAPI
                .loadJokes(count.get().toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    adaptRV.setJokes(it.list as MutableList<Joke>)
                }, {})
        )

    }

    fun setCount(edite: Editable) {
        count.set(edite.toString())
    }

    fun onDestroy() {
        if (!dispose.isDisposed) dispose.dispose()
    }
}