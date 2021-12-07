package com.example.myapplication


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest{
    @Test
    fun validatePassword_emptyPassword_returnsFalse(){
        val result = RegistrationUtil.validatePassword("","")
        //assertThat(actualValue).isEqual(desiredValue)
        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_passwordsDontMatch_returnsFalse(){
        val result = RegistrationUtil.validatePassword("hi","hello")
        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_lengthUnder8_returnsFalse(){
        val result = RegistrationUtil.validatePassword("1Abcdef", "1Abcdef")
        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_noCapitalLetters_returnsFalse(){
        val result = RegistrationUtil.validatePassword("1abcdefg", "1abcdefg")
    }

    @Test
    fun validatePassword_noSpecialChar_returnsFalse(){
        val result = RegistrationUtil.validatePassword("Abcdefgh", "Abcdefgh")
    }



    //min 8 char
    //at least 1 num
    // at least 1 special char
    //  at least 1 capital
    //a good matchint passowrd worksd
    //implement validate password function in the util class
}