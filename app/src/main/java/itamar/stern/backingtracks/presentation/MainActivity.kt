package itamar.stern.backingtracks.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import itamar.stern.backingtracks.R
import itamar.stern.backingtracks.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupWithNavController(binding.navView, navController)
    }
}