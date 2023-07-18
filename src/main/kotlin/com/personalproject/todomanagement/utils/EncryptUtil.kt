package com.personalproject.todomanagement.utils

import java.security.MessageDigest
import javax.xml.bind.DatatypeConverter

object EncryptUtil {

    fun sha1(input: String): String = hashString("SHA-1", input)
    fun md5(input: String): String = hashString("MD5", input)

    fun compareHashSha1(input: String, hash: String): Boolean = hash == sha1(input)

    fun compareHashMd5(input: String, hash: String): Boolean = hash == md5(input)

    private fun hashString(type: String, input: String): String {
        val bytes = MessageDigest
            .getInstance(type)
            .digest(input.toByteArray())
        return DatatypeConverter.printHexBinary(bytes).toUpperCase()
    }
}
