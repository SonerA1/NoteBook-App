package com.soneralci.notebookapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.soneralci.notebookapp.database.NoteDatabase
import com.soneralci.notebookapp.databinding.ActivityMainBinding
import com.soneralci.notebookapp.repository.NoteRepository
import com.soneralci.notebookapp.viewmodel.NoteViewModel
import com.soneralci.notebookapp.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)



        setUpViewModel()





    }

    private fun setUpViewModel() {
        val noteRepository = NoteRepository(NoteDatabase(this))

        val viewModelProviderFactory = NoteViewModelFactory(application, noteRepository)

        noteViewModel = ViewModelProvider(this,viewModelProviderFactory).get(NoteViewModel::class.java)
    }
}