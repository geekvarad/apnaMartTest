package com.example.myapplication

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.getSystemService
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.myapplication.adapters.GitHubAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        if((this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetwork!=null)
        {
            binding.frame.noInternet.visibility=View.GONE
            viewModel.getData(this)
        }
        else
        {
            binding.frame.loader.visibility=View.GONE
            binding.frame.noInternet.visibility=View.VISIBLE
        }
    }

    override fun onStart() {
        super.onStart()
        setObservers()
    }

    private fun setObservers() {
        viewModel.elements.observe(this) {
            if (it.isNotEmpty()) {
                binding.frame.loader.visibility = View.GONE
                binding.frame.rvRepoList.adapter = GitHubAdapter(it)
                binding.frame.rvRepoList.visibility = View.VISIBLE
            } else {
                binding.frame.rvRepoList.visibility = View.GONE
                binding.frame.loader.visibility = View.VISIBLE
            }
        }
    }


}