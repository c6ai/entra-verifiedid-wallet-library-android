package com.microsoft.walletlibrary.util.http

import java.io.Serializable
import java.net.URLEncoder

/**
 *
 */
object URLFormEncoding {
    const val mimeType = "application/x-www-form-urlencoded"

    /***
     * Encodes a map of string to  string, string?, or List<string> to URL Form Encoded payload
     * @throws InvalidURLEncodeData if any other type is in the Map
     */
    fun encode(data: Map<String, Any?>): ByteArray {
        val builder = StringBuilder()
        var firstKeyPair = true
        data.forEach { (key, value) ->
            val encodedKey = URLEncoder.encode(key, "UTF-8")
            when (value) {
                is String -> {
                    if (!firstKeyPair) {
                        builder.append("&")
                    }
                    builder.append("${encodedKey}=${URLEncoder.encode(value, "UTF-8")}")
                    if (firstKeyPair)
                    {
                        firstKeyPair = false
                    }
                }
                is Array<*> -> {
                    value.iterator().forEach { arrayValue ->
                        when (arrayValue) {
                            is String -> {
                                if (!firstKeyPair) {
                                    builder.append("&")
                                }
                                builder.append("${encodedKey}=${URLEncoder.encode(arrayValue, "UTF-8")}")
                                if (firstKeyPair)
                                {
                                    firstKeyPair = false
                                }
                            }
                            null -> {
                                // skip this value
                            }
                            else -> {
                                throw InvalidURLEncodeData(key)
                            }
                        }
                    }
                }
                else -> {
                    throw InvalidURLEncodeData(key)
                }
            }
        }
        return builder.toString().toByteArray()
    }

    class InvalidURLEncodeData(val keyName: String) : Error()
}
