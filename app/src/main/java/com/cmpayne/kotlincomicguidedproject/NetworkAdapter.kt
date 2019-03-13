package com.cmpayne.kotlincomicguidedproject

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

object NetworkAdapter {
    interface NetworkCallback {
        fun returnResult(success: Boolean?, result: String)
    }

    fun httpGetRequest(urlString: String, callback: NetworkCallback) {
        Thread(Runnable {
            var result = ""
            var success = false
            var connection: HttpURLConnection? = null
            var stream: InputStream? = null
            try {
                val url = URL(urlString)
                connection = url.openConnection() as HttpURLConnection
                connection.connect()

                val responseCode = connection.responseCode
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    stream = connection.inputStream
                    if (stream != null) {
                        val reader = BufferedReader(InputStreamReader(stream))
                        val builder = StringBuilder()
                        var line: String? = reader.readLine()
                        while (line != null) {
                            builder.append(line)
                            line = reader.readLine()
                        }
                        result = builder.toString()
                        success = true
                    }
                } else {
                    result = responseCode.toString()
                }
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            } finally {
                connection?.disconnect()

                if (stream != null) {
                    try {
                        stream.close()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }

                }

                callback.returnResult(success, result)
            }
            //                return result;
        }).start()


    }
}