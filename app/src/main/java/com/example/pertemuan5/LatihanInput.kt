package com.example.pertemuan5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LatihanInput(modifier: Modifier) {

    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var notelepon by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    var dataGender = listOf("Laki-laki", "Perempuan")

    var confirmnama by remember { mutableStateOf("") }
    var confirmemail by remember { mutableStateOf("") }
    var confirmalamat by remember { mutableStateOf("") }
    var confirmnotelepon by remember { mutableStateOf("") }
    var confirmGender by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = nama,
            onValueChange = {nama = it},
            label = {
                Text(text = "nama")
            },
            placeholder = {
                Text(text = "Isi Nama Anda")
            },
            modifier = Modifier.fillMaxWidth()
                .padding(5.dp)
        )

        Row (
            modifier = Modifier.fillMaxWidth()) {
            dataGender.forEach{selectedGender ->
                Row (verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = gender == selectedGender,
                        onClick = {
                            gender = selectedGender
                        })
                }
                Text(text = selectedGender) }
        }

        TextField(
            value = email,
            onValueChange = {email = it},
            label = {
                Text(text = "Email")
            },
            placeholder = {
                Text(text = "Isi Email Anda")
            },
            modifier = Modifier.fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        TextField(
            value = alamat,
            onValueChange = {alamat = it},
            label = {
                Text(text = "Alamat")
            },
            placeholder = {
                Text(text = "Isi Alamat Anda")
            },
            modifier = Modifier.fillMaxWidth()
                .padding(5.dp)
        )

        TextField(
            value = notelepon,
            onValueChange = {notelepon = it},
            label = {
                Text(text = "No Telepon")
            },
            placeholder = {
                Text(text = "Isi No Telepon Anda")
            },
            modifier = Modifier.fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick = {
            confirmnama = nama
            confirmemail = email
            confirmalamat = alamat
            confirmnotelepon = notelepon
            confirmGender = gender
        } ) {
            Text(text = "Simpan")
        }

        TampilData(
            param = "Nama",
            argu = confirmnama
        )

        TampilData(
            param = "Email",
            argu = confirmemail
        )

        TampilData(
            param = "Alamat",
            argu = confirmalamat
        )

        TampilData(
            param = "No Telepon",
            argu = confirmnotelepon
        )

        TampilData(
            param = "Gender",
            argu = confirmGender
        )
    }
}

@Composable
fun TampilData(
    param: String, argu: String
){
    Column (
        modifier = Modifier.padding(16.dp)
    ){
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ){
            Text(text = param,
                modifier = Modifier.weight(0.8f))
            Text(text = ": ",
                modifier = Modifier.weight(0.2f))
            Text(text = argu,
                modifier = Modifier.weight(2f))
        }
    }

}