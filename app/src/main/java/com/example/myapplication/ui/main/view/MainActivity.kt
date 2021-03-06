package com.example.myapplication.ui.main.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.api.ApiHelperImpl
import com.example.myapplication.api.RetrofitBuilder
import com.example.myapplication.data.ListOfPosts
import com.example.myapplication.data.UserModel

import com.example.myapplication.ui.main.adapter.MainAdapter
import com.example.myapplication.ui.main.adapter.PostsAdapter
import com.example.myapplication.ui.main.intent.MainIntent
import com.example.myapplication.ui.main.viewmodel.MainViewModel
import com.example.myapplication.ui.main.viewstate.MainState
import com.example.myapplication.utils.ViewModelFactory


import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {


    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawerLayout: DrawerLayout



    private lateinit var mainViewModel: MainViewModel
    private var adapter = MainAdapter(arrayListOf())
    private  var adapterp = PostsAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupViewModel()
        observeViewModel()
        setupClicks()


        navController =findNavController(R.id.fragment)
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView.setupWithNavController(navController)



        appBarConfiguration= AppBarConfiguration(navController.graph,drawerLayout)
        setupActionBarWithNavController(navController,appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController= findNavController(R.id.fragment)

        return navController.navigateUp(appBarConfiguration)
                ||super.onSupportNavigateUp()
    }

    private fun setupClicks() {
       // buttonFetchUser.setOnClickListener {
            lifecycleScope.launch {
                mainViewModel.userIntent.send(MainIntent.FetchPosts)
            }
        //}
    }


    private fun setupUI() {
        val rv :RecyclerView = findViewById(R.id.recyclerView)
        rv.layoutManager = LinearLayoutManager(this)
        rv.run {
            addItemDecoration(
                DividerItemDecoration(
                    rv.context,
                    (rv.layoutManager as LinearLayoutManager).orientation
                )
            )
        }
        rv.adapter = adapterp
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
                      //  buttonFetchUser.visibility = View.GONE
                        progressBar.visibility = View.VISIBLE
                    }

                    is MainState.GetUsers -> {
                        progressBar.visibility = View.GONE
                       // buttonFetchUser.visibility = View.GONE
                       // renderList(it.user)
                        //Toast.makeText(this@MainActivity, it.user.data[0].email, Toast.LENGTH_SHORT).show()

                    }
                    is MainState.GetPosts -> {
                        progressBar.visibility =View.GONE
                        renderList(it.post)

                    }
                    is MainState.Error -> {
                        progressBar.visibility = View.GONE
                      //  buttonFetchUser.visibility = View.VISIBLE
                        Toast.makeText(this@MainActivity, it.error, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun renderList(posts :ListOfPosts) {
        recyclerView.visibility = View.VISIBLE
        posts.let { listOfUsers -> listOfUsers.let { adapterp.addData(it) } }
        adapterp.notifyDataSetChanged()
    }
}
