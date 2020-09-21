package com.example.myapplication.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.Users
import com.example.myapplication.api.ApiHelperImpl
import com.example.myapplication.api.RetrofitBuilder
import com.example.myapplication.ui.main.adapter.MainAdapter
import com.example.myapplication.ui.main.intent.MainIntent
import com.example.myapplication.ui.main.viewmodel.MainViewModel
import com.example.myapplication.ui.main.viewstate.MainState
import com.example.myapplication.utils.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.progressBar
import kotlinx.android.synthetic.main.activity_main.recyclerView
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class User_Activity : AppCompatActivity() {


    private lateinit var mainViewModel: MainViewModel
    private var adapter = MainAdapter(arrayListOf())




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.data_activity)

//        setupUI()
        setupViewModel()
        observeViewModel()
        setupClicks()
            }



    private fun setupClicks() {
//        buttonFetchUser.setOnClickListener {
            lifecycleScope.launch {
                mainViewModel.userIntent.send(MainIntent.FetchUser)
            }
    }


    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.run {
            addItemDecoration(
                DividerItemDecoration(
                    recyclerView.context,
                    (recyclerView.layoutManager as LinearLayoutManager).orientation
                )
            )
        }
        recyclerView.adapter = adapter
    }


    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(
                ApiHelperImpl(
                    RetrofitBuilder.apiService
                )
            )
        ).get(MainViewModel::class.java)
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            mainViewModel.state.collect {
                when (it) {
                    is MainState.Idle -> {

                    }
                    is MainState.Loading -> {
                        // buttonFetchUser.visibility = View.GONE
                        progressBar.visibility = View.VISIBLE
                    }

                    is MainState.GetUsers -> {
                        progressBar.visibility = View.GONE
                      //  buttonFetchUser.visibility = View.GONE
//                        renderList(it.user)

                        val arguments = Bundle()
                        arguments.putParcelable("users", it.user)
                        val usersFragment = Users()

                        usersFragment.arguments = arguments;

                        supportFragmentManager.beginTransaction()
                            .add(R.id.data_class, usersFragment, "UserFragment").commit()
                        //Toast.makeText(this@MainActivity, it.user.data[0].email, Toast.LENGTH_SHORT).show()

                    }
                    is MainState.Error -> {
                        progressBar.visibility = View.GONE
                     //   buttonFetchUser.visibility = View.VISIBLE
                        Toast.makeText(this@User_Activity, it.error, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

}
