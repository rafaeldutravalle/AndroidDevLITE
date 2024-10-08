package com.example.matriculaalunonivel2.data

//Criando a Classe Aluno
enum class StatusAluno {
    APROVADO, REPROVADO
}

data class Aluno(
    val id: Int,
    var nome: String,
    var notas: MutableList<Float> = mutableListOf(),
    var turmaId: Int
) {
    val media: Float
        get() = if (notas.isNotEmpty()) notas.sum() / notas.size else 0.0f

    val status: StatusAluno
        get() = if (media >= 7.0) StatusAluno.APROVADO else StatusAluno.REPROVADO
}
