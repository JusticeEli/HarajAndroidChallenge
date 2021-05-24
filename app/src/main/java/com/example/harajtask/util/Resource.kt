package com.example.harajtask.util

data class Resource <out T>(val data:T?,val status:Status,val message:String?,val exception:Exception?){
    companion object{
        fun <T> success(data:T):Resource<T>{
            return Resource(data,Status.SUCCESS,"",null)
        }   fun <T> error(exception: Exception):Resource<T>{
            return Resource(null,Status.ERROR,null,exception)
        }   fun <T> loading(message:String):Resource<T>{
            return Resource(null,Status.LOADING,message,null)
        }
    }
}
enum class Status{
    SUCCESS,ERROR,LOADING
}