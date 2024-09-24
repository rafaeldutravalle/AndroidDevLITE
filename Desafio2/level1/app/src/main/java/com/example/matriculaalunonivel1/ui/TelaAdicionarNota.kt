package com.example.matriculaalunonivel1.ui

//Adicionar nota
@Composable
fun TelaAdicionarNota(repositorio: RepositorioAlunos) {
    var nome by remember { mutableStateOf("") }
    var nota by remember { mutableStateOf("") }
    var mensagemErro by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Adicionar Nota")

        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome do Aluno") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = nota,
            onValueChange = { nota = it },
            label = { Text("Nota"),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number) },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            try {
                repositorio.adicionarNota(nome, nota.toDouble())
                mensagemErro = "Nota adicionada com sucesso!"
            } catch (e: Exception) {
                mensagemErro = e.message ?: "Erro ao adicionar nota"
            }
        }) {
            Text(text = "Adicionar Nota")
        }

        if (mensagemErro.isNotEmpty()) {
            Text(text = mensagemErro, color = Color.Red)
        }
    }
}