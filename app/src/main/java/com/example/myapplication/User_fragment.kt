package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.UserModel
import com.example.myapplication.ui.main.adapter.MainAdapter
import com.example.myapplication.ui.main.view.User
import kotlinx.android.synthetic.main.fragment_users.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Users.newInstance] factory method to
 * create an instance of this fragment.
 */
class Users : Fragment() {
    // TODO: Rename and change types of parameters
    private var adapter = MainAdapter(arrayListOf())


    private lateinit var test: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootview = inflater.inflate(R.layout.fragment_users, container, false)
//        setupUI()

//        recyclerView!!.ada = RestaurantMenuAdapter(activity)
//        recyclerView!!.layoutManager = LinearLayoutManager(activity)
        val args = arguments
        // val rv = view?.findViewById<RecyclerView>(R.id.recyclerView3)
        val response: UserModel? = args?.getParcelable("users")
        if (response != null) {
            Toast.makeText(activity, response.user[0].id.toString(), Toast.LENGTH_LONG).show()
            renderList(response)
        }

        return rootview

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val rv: RecyclerView? = view?.findViewById(R.id.recyclerView3)
        rv!!.layoutManager= LinearLayoutManager(User().applicationContext)
        rv.adapter = adapter
    }

    private fun renderList(users: UserModel) {

//        recyclerView3.visibility = View.VISIBLE
        users.let { listOfUsers -> listOfUsers.let { adapter.addData(it) } }
        adapter.notifyDataSetChanged()
    }
    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(users: UserModel): Users {
            val args = Bundle()
            args.putParcelable("users", users)
            val fragment = Users()
            fragment.arguments = args
            return fragment
        }
    }
}