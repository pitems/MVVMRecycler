package com.pitems.recyclermvvm.network

import retrofit2.Response
import java.io.IOException
//Check whether the call was successfull or not
abstract class SafeApiRequest{
    suspend fun <T:Any> apiRequest(call: suspend  () -> Response<T>):T{
        val response = call.invoke()
        if(response.isSuccessful){
            return response.body()!!
        }else{
            //TODO handle api exception
            throw ApiException(
                response.code().toString()
            )
        }
    }
}

class ApiException(message:String): IOException(message)