package com.example.matriculaalunonivel1.ui

//Consultar Situação do Aluno
@Composable
fun TelaConsultaAluno(repositorio: RepositorioAlunos) {
    var nome by remember { mutableStateOf("") }
    var resultadoConsulta by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Consulta de Aluno")

        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome do Aluno") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            resultadoConsulta = repositorio.consultarSituacaoAluno(nome)
        }) {
            Text(text = "Consultar")
        }

        if (resultadoConsulta.isNotEmpty()) {
            Text(text = resultadoConsulta, color = Color.Blue)
        }
    }
}

