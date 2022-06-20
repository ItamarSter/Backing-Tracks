package itamar.stern.backingtracks.di

import com.google.gson.Gson
import itamar.stern.backingtracks.core.database.SectionsDB
import itamar.stern.backingtracks.core.repository.SectionsRepository
import itamar.stern.backingtracks.presentation.MainViewModel
import itamar.stern.backingtracks.media_player.MyMediaPlayer
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        MyMediaPlayer(get())
    }
    viewModel {
        MainViewModel(get(), get())
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
}