package com.soars.notes.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.ViewModelProvider
import androidx.room.Database
import com.soars.notes.R
import com.soars.notes.database.NoteDatabase
import com.soars.notes.repository.NoteRepository

class MainActivity : AppCompatActivity() {

    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
    }

    private fun setupViewModel(){
        val noteRepository = NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory = NoteViewModelFactory(application, noteRepository)
        noteViewModel = ViewModelProvider(this, viewModelProviderFactory)[NoteViewModel::class.java]
    }
}