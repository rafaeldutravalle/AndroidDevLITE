package com.example.matriculaalunonivel1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.seuprojeto.data.RepositorioAlunos
import com.seuprojeto.ui.*

//class MainActivity : AppCompatActivity() {
    //override fun onCreate(savedInstanceState: Bundle?) {
        //super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
    //}
//}

class MainActivity : ComponentActivity() {
    private val repositorio = RepositorioAlunos()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.padding(16.dp)) {
                TelaCadastroAluno(repositorio)
                Spacer(modifier = Modifier.height(16.dp))
                TelaAdicionarNota(repositorio)
                Spacer(modifier = Modifier.height(16.dp))
                TelaConsultaAluno(repositorio)
            }
        }
    }
}