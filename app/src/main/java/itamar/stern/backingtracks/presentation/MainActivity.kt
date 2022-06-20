package itamar.stern.backingtracks.presentation

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import androidx.annotation.RequiresApi
import androidx.lifecycle.lifecycleScope
import itamar.stern.backingtracks.R
import itamar.stern.backingtracks.core.TabsManager
import itamar.stern.backingtracks.databinding.ActivityMainBinding
import itamar.stern.backingtracks.core.Track
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        collectFlows()
    }

    private fun initViews() = binding.apply {
        btnStartSet.setOnClickListener {
            viewModel.startSetClicked()
        }
        btnPauseSet.setOnClickListener {
            viewModel.pauseSetClicked()
        }
        btnResetSet.setOnClickListener {
            viewModel.resetSetClicked()
        }
        btnDeleteStep.setOnClickListener {
            viewModel.deleteStepClicked()
        }
        btnChord.setOnClickListener {
            viewModel.chordBtnClicked()
        }
        btnSpace.setOnClickListener {
            viewModel.spaceBtnClicked()
        }
        btnSaveSet.setOnClickListener {
            editTextSectionName.text?.let {
                viewModel.saveBtnClicked(it.toString())
                editTextSectionName.text.clear()
            }
        }
        btnOpenSet.setOnClickListener {
            editTextSectionName.text?.let {
                viewModel.openSetClicked(it.toString())
                editTextSectionName.text.clear()
            }
        }
        tempoPicker.maxValue = 500
        tempoPicker.minValue = 50
        tempoPicker.value = 250
        tempoPicker.setOnValueChangedListener { _, _, newVal ->
            viewModel.tempoChanged(newVal)
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun collectFlows() {
        collectChordButtonMode(Track.chordButtonMode)
        collectTabs(TabsManager.tabLinesMap)
    }

    private fun collectChordButtonMode(chordButtonMode: StateFlow<AddingNotesMode>) =
        lifecycleScope.launchWhenStarted {
            chordButtonMode.collect { buttonMode ->
                when (buttonMode) {
                    AddingNotesMode.SINGLE -> {
                        binding.btnChord.setBackgroundColor(
                            resources.getColor(
                                R.color.purple_500,
                                null
                            )
                        )
                    }
                    AddingNotesMode.CHORD -> {
                        binding.btnChord.setBackgroundColor(Color.GREEN)
                    }
                }
            }
        }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun collectTabs(tabLinesMap: HashMap<String, MutableStateFlow<String>>) =
        lifecycleScope.launchWhenStarted {
            launch {
                tabLinesMap["1"]?.collect { binding.tabLine1.text = it }
            }
            launch {
                tabLinesMap["2"]?.collect { binding.tabLine2.text = it }
            }
            launch {
                tabLinesMap["3"]?.collect { binding.tabLine3.text = it }
            }
            launch {
                tabLinesMap["4"]?.collect { binding.tabLine4.text = it }
            }
            launch {
                tabLinesMap["5"]?.collect { binding.tabLine5.text = it }
            }
            launch {
                tabLinesMap["6"]?.collect { binding.tabLine6.text = it }
            }
        }
}

enum class AddingNotesMode {
    SINGLE,
    CHORD
}