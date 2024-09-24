package com.example.matriculaalunonivel2.data

//Criando a Classe Turma
data class Turma(
    val id: Int,
    var nome: String,
    val alunos: MutableList<Aluno> = mutableListOf()
)
