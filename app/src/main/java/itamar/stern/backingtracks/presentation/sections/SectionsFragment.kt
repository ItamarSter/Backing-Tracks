package itamar.stern.backingtracks.presentation.sections

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import itamar.stern.backingtracks.R
import itamar.stern.backingtracks.databinding.SectionsFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SectionsFragment : Fragment() {

    private lateinit var binding: SectionsFragmentBinding
    private val viewModel by viewModel<SectionsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SectionsFragmentBinding.inflate(layoutInflater)
        return binding.root
    }
}