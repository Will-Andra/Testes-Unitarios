package com.example.testeunitario_dummyapi.data.dto

import com.example.testeunitario_dummyapi.data.remote.dto.Address
import com.example.testeunitario_dummyapi.data.remote.dto.Bank
import com.example.testeunitario_dummyapi.data.remote.dto.Company
import com.example.testeunitario_dummyapi.data.remote.dto.Coordinates
import com.example.testeunitario_dummyapi.data.remote.dto.Hair
import com.example.testeunitario_dummyapi.data.remote.dto.UserDTO

class UserDTOTestHelper {

    fun criarUserDTOFake(
        firstName: String,
        lastName: String,
        age: Int
    ): UserDTO {

        // Instanciamos os objetos obrigatórios de forma totalmente vazia e zerada
        val hairFalso = Hair(
            color = "",
            type = ""
        )

        val addressFalso = Address(
            address = "",
            city = "",
            coordinates = Coordinates(0.0, 0.0),
            country = "",
            postalCode = "",
            state = "",
            stateCode = ""
        )

        val bankFalso = Bank(
            cardExpire = "",
            cardNumber = "",
            cardType = "",
            currency = "",
            iban = ""
        )

        val companyFalso = Company(
            address = addressFalso,
            department = "",
            name = "",
            title = ""
        )

        return UserDTO(
            id = 0,
            firstName = firstName, // Dado do teste
            lastName = lastName,   // Dado do teste
            age = age,             // Dado do teste
            hair = hairFalso,
            address = addressFalso,
            bank = bankFalso,
            company = companyFalso,
            birthDate = "",
            bloodGroup = "",
            ein = "",
            email = "",
            eyeColor = "",
            gender = "",
            height = 0.0,
            image = "",
            ip = "",
            macAddress = "",
            maidenName = "",
            password = "",
            phone = "",
            role = "",
            ssn = "",
            university = "",
            userAgent = "",
            username = "",
            weight = 0.0
        )
    }
}