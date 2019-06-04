package com.codesign.karenbarreto.getintouch.di

import com.codesign.karenbarreto.getintouch.fragments.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(application: AndroidApplication)

    fun inject(homeFragment: HomeFragment)
}