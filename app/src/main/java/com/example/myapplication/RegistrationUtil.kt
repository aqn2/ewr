package com.example.myapplication

//object makes it so all functions are static
object RegistrationUtil {
    var existingUsers = listOf("erika1&poijhbjBHGVH", "ur mom", "bruh")
    var numberUsers = existingUsers.size
    var existingEmail = listOf("erikaxiyuwang@yourmoms.house")
    var numberEmail = existingEmail.size


    //curse word filter
    //already taken
    //minimum number of characters
    fun validateUsername(name : String) : Boolean {
        if(name.length < 8){
            return false
        }
        for(i in 0..(numberUsers-1)){
            if(name == existingUsers[i]){
                return false
            }
        }
        return true
    }
    //min 8 char
    //at least 1 num
    // at least 1 special char
    //  at least 1 capital
    //a good matchint passowrd worksd
    //implement validate password function in the util class
    fun validatePassword(password : String, confirmPassword : String) : Boolean{
        if(password != confirmPassword){
            return false
        }

        if(password.length < 8){
            return false
        }
        val numbers = listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
        var numInPass = 0
        for(i in 0..9){
            if(password.contains(numbers[i])) {
                numInPass++
            }
        }
        if(numInPass == 0){
            return false
        }

        val specialChar = listOf("!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "+", "=", "{", "}", "[", "]", "\\", "|")
        var charInPass = 0
        for(i in 0..19){
            if(password.contains(specialChar[i])) {
                charInPass++
            }
        }
        if(charInPass == 0){
            return false
        }

        val capitals = listOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J","K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")
        var capsInPass = 0
        for(i in 0..25){
            if(password.contains(capitals[i])) {
                capsInPass++
            }
        }
        if(capsInPass == 0){
            return false
        }


        return true
    }


    //email not used, proper format (user.@gomanin.tld)
    fun validateEmail(email : String) : Boolean {
        if(email == ""){
            return false
        }
        for(i in 0..(numberEmail-1)){
            if(email == existingEmail[i]){
                return false
            }
        }

        var atnum = -1
        var dotnum = -1
        for(i in 0..(email.length-1)){
            if(email.contains("@")){
                atnum = i
            }
            if(email.contains(".")){
                dotnum = i
            }
        }
        if(atnum == -1 || dotnum == -1){
            return false
        }
        if(atnum > email.lastIndexOf(".")){
            return false
        }

        return true

    }

    fun validateName(name : String) : Boolean {
        if(name == ""){
            return false
        }
        return true
    }

}