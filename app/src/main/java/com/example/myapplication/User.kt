package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.ui.main.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class User : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.data_activity)


        Toast.makeText(this, "Hi", Toast.LENGTH_LONG).show()

//        observeViewModel(savedInstanceState)
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, DataFragment.newInstance())
//                .commitNow()
//        }
    }

//    private fun observeViewModel(savedInstanceState:Bundle?) {
//        lifecycleScope.launch {
//            viewModel.state.collect {
//                when (it) {
//                    is MainState.Idle -> {
//
//                    }
//                    is MainState.Loading -> {
//                        progressBar.visibility = View.VISIBLE
//                    }
//                    is MainState.User -> {
//
//                        setContentView(R.layout.main_fragment)
////                        if (savedInstanceState == null) {
////                            supportFragmentManager.beginTransaction()
////                                .replace(R.id.container, DataFragment.newInstance())
////                                .commitNow()
////                        }
//
//                    }
//                    is MainState.Error -> {
//
//                    }
//                }
//            }
//        }
//    }
}
