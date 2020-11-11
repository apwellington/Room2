package com.gibittec.room2.ui.fragment.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gibittec.room2.R
import com.gibittec.room2.model.User
import com.gibittec.room2.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class addFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.AddButton.setOnClickListener {
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        val fName = addFirstName.text.toString()
        val lName = addLastName.text.toString()
        val age = addAge.text

        if(inpuctCheck(fName, lName, age)){
            //create user
            val user = User(0, fName, lName, Integer.parseInt(age.toString()))
            //add data
            userViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFrangmet)

        }else{
            Toast.makeText(requireContext(), "Please fill out all filds", Toast.LENGTH_LONG).show()
        }
    }

    private fun inpuctCheck(firstName:String, lastName:String, age: Editable) : Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }

}