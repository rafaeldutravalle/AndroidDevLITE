package com.example.matriculaalunonivel2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.matriculadealunos.ui.theme.MatriculaDeAlunosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MatriculaDeAlunosTheme {
                val navController = rememberNavController()
                Scaffold(
                    content = {
                        NavigationHost(navController = navController)
                    }
                )
            }
        }
    }
}

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("cadastroAluno") {
            CadastroAlunoScreen(navController = navController)
        }
        composable("cadastroTurma") {
            CadastroTurmaScreen(navController = navController)
        }
        composable("consulta") {
            ConsultaScreen(navController = navController)
        }
    }
}

//Criando a Tela Inicial
@Composable
fun HomeScreen(navController: NavController) {
    Column {
        Button(onClick = { navController.navigate("cadastroAluno") }) {
            Text(text = "Cadastrar Aluno")
        }
        Button(onClick = { navController.navigate("cadastroTurma") }) {
            Text(text = "Cadastrar Turma")
        }
        Button(onClick = { navController.navigate("consulta") }) {
            Text(text = "Consultar/Excluir")
        }
    }
}

//Tela de Cadastro de Alunos
@Composable
fun CadastroAlunoScreen(navController: NavController) {
    var nome by remember { mutableStateOf("") }
    var turmaId by remember { mutableStateOf("") }
    var nota by remember { mutableStateOf("") }
    val notas = remember { mutableListOf<Float>() }

    Column {
        TextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome do Aluno") }
        )
        TextField(
            value = turmaId,
            onValueChange = { turmaId = it },
            label = { Text("ID da Turma") }
        )
        TextField(
            value = nota,
            onValueChange = {
                nota = it
                notas.add(nota.toFloat())
            },
            label = { Text("Nota do Aluno") }
        )
        Button(onClick = {
            val novoAluno = Aluno(
                id = AlunoRepository.obterTodosAlunos().size + 1,
                nome = nome,
                notas = notas,
                turmaId = turmaId.toInt()
            )
            AlunoRepository.adicionarAluno(novoAluno)
            navController.popBackStack()
        }) {
            Text("Cadastrar Aluno")
        }
    }
}

//Tela de Cadastro de Turmas
@Composable
fun CadastroTurmaScreen(navController: NavController) {
    var nome by remember { mutableStateOf("") }

    Column {
        TextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome da Turma") }
        )
        Button(onClick = {
            val novaTurma = Turma(
                id = TurmaRepository.obterTurmas().size + 1,
                nome = nome
            )
            TurmaRepository.adicionarTurma(novaTurma)
            navController.popBackStack()
        }) {
            Text("Cadastrar Turma")
        }
    }
}
