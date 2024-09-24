package com.example.matriculaalunonivel1.ui

//Cadastro de Aluno
@Composable
fun TelaCadastroAluno(repositorio: RepositorioAlunos) {
    var nome by remember { mutableStateOf("") }
    var turma by remember { mutableStateOf("") }
    var mensagemErro by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Cadastro de Aluno")

        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome do Aluno") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = turma,
            onValueChange = { turma = it },
            label = { Text("Turma") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            try {
                repositorio.cadastrarAluno(nome, turma)
                mensagemErro = "Aluno cadastrado com sucesso!"
            } catch (e: Exception) {
                mensagemErro = e.message ?: "Erro ao cadastrar aluno"
            }
        }) {
            Text(text = "Cadastrar")
        }

        if (mensagemErro.isNotEmpty()) {
            Text(text = mensagemErro, color = Color.Red)
        }
    }
}