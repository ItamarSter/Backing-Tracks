package itamar.stern.backingtracks.di

import com.google.gson.Gson
import itamar.stern.backingtracks.core.DialogsManager
import itamar.stern.backingtracks.core.database.SectionsDB
import itamar.stern.backingtracks.core.repository.SectionsRepository
import itamar.stern.backingtracks.presentation.MainViewModel
import itamar.stern.backingtracks.media_player.MyMediaPlayer
import itamar.stern.backingtracks.presentation.guitar.GuitarViewModel
import itamar.stern.backingtracks.presentation.sections.SectionsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        MyMediaPlayer(get())
    }
    viewModel {
        MainViewModel()
    }
    viewModel {
        GuitarViewModel(get(), get(), get())
    }
    viewModel {
        SectionsViewModel()
    }
    single {
        SectionsDB.create(get())
    }
    single {
        SectionsRepository(get(), get())
    }
    single {
        Gson()
    }
    single {
        DialogsManager(get())
    }
}