package itamar.stern.backingtracks

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import itamar.stern.backingtracks.databinding.ActivityMainBinding
import itamar.stern.backingtracks.media_player.MyMediaPlayer
import itamar.stern.backingtracks.media_player.Track
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

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
    }

    private fun collectFlows() {
        collectChordButtonMode(Track.chordButtonMode)
    }

    private fun collectChordButtonMode(chordButtonMode: StateFlow<AddingNotesMode>) = lifecycleScope.launchWhenStarted {
        chordButtonMode.collect { buttonMode ->
            when(buttonMode) {
                AddingNotesMode.SINGLE -> {
                    binding.btnChord.setBackgroundColor(resources.getColor(R.color.purple_500, null))
                }
                AddingNotesMode.CHORD -> {
                    binding.btnChord.setBackgroundColor(Color.GREEN)
                }
            }
        }
    }
}

enum class AddingNotesMode {
    SINGLE,
    CHORD
}