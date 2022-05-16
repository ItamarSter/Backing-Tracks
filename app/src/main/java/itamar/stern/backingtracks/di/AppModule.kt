package itamar.stern.backingtracks.di

import itamar.stern.backingtracks.MainViewModel
import itamar.stern.backingtracks.media_player.MyMediaPlayer
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        MyMediaPlayer(get())
    }
    viewModel {
        MainViewModel(get())
    }
}