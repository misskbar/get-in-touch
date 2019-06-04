package com.codesign.karenbarreto.getintouch

import android.view.View
import java.net.Authenticator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator
@Inject constructor(private val authenticator: Authenticator) {

    class Extras(val transitionSharedElement: View)
}