package com.example.logindemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


/**
 * A simple [Fragment] subclass.
 */
class Login : Fragment(), View.OnClickListener {
    private lateinit var userName: EditText
    private lateinit var passWord: EditText
    private lateinit var login: Button
    private lateinit var signUp: Button


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_login, container, false)
        initViews(view)
        login.setOnClickListener(this);
        signUp.setOnClickListener(this)
        return view
    }

    // Initiate Views
    private fun initViews(view: View) {
        userName = view.findViewById(R.id.username)
        passWord = view.findViewById(R.id.password)
        login = view.findViewById(R.id.login)
        signUp = view.findViewById(R.id.signUp)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.signUp -> {
                val signUp = signUp()
                val fragmentManager: FragmentManager = activity!!.supportFragmentManager
                val fragmentTransition: FragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransition.replace(R.id.frameContainer, signUp)
                fragmentTransition.commit()

            }
        }
    }
}































































