package com.karenbarreto.domain.entities

import com.codesign.karenbarreto.getintouch.core.helpers.empty

data class Repository(val repositoryName:String,val description:String,val forks:String,val stars:String ) {

    companion object {
        fun empty() = Repository(String.empty(), String.empty(), String.empty(), String.empty())
    }
}