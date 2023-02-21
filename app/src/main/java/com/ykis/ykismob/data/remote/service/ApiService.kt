package com.ykis.ykismob.data.remote.service

import com.ykis.ykismob.data.remote.address.GetAddressResponse
import com.ykis.ykismob.data.remote.appartment.GetAppartmentsResponse
import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    companion object{
        //        const val SERVER_URL = "https://is.yuzhny.com/YkisMobileRest"
//        const val SERVER_URL = "http://10.0.2.2/YkisMobileRest"
//        const val SERVER_URL = "http://192.168.88.243/YkisMobileRest"
        const val SERVER_URL = "http://192.168.0.177/YkisMobileRest"

        const val BASE_URL = "$SERVER_URL/rest_api/"
        const val GET_APPARTMENTS = "getAppartmentsById.php"
        const val GET_MY_FLAT="getAppartmentsByUser.php"
        const val DELETE_APPARTMENT = "deleteAppartment.php"
        const val GET_BLOCKS="getBlocks.php"
        const val GET_STREETS="getStreetsFromBlock.php"
        const val GET_HOUSE="getHouses.php"
        const val PARAM_ADDRESS_ID = "address_id"
        const val PARAM_USER_ID = "user_id"
        const val BLOCK_ID = "block_id"
        const val PARAM_TOKEN = "token"

    }

    //appartment

    @FormUrlEncoded
    @POST(GET_MY_FLAT)
    fun getAppartmentsByUser(@FieldMap params :Map<String , String> ): Call<GetAppartmentsResponse>
    @FormUrlEncoded
    @POST(GET_BLOCKS)
    fun getBlocks(@FieldMap params :Map<String , String> ): Call<GetAddressResponse>
    @FormUrlEncoded
    @POST(GET_STREETS)
    fun getStreetsFromBlock(@FieldMap params :Map<String , String> ): Call<GetAddressResponse>
}