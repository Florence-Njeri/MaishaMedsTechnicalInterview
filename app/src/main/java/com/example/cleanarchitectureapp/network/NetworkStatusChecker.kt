package com.example.cleanarchitectureapp.network

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi

class NetworkStatusChecker(private val connectivityManager: ConnectivityManager?) {

    @RequiresApi(Build.VERSION_CODES.M)
    inline fun performIfConnectedToTheInternet(action: () -> Unit) {
        if (hasInternetConnection()) {
            action()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun hasInternetConnection(): Boolean {
        val network = connectivityManager?.activeNetwork ?: return false
        //If there is a mobile network check if connected to Mobile,WIFI or a VPN
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false

        //If any is true then it has the capability to fetch data from the server
        return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN)
    }
}