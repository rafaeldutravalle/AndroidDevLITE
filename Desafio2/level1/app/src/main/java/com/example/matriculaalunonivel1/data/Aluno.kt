package com.example.matriculaalunonivel1.data

// Classe com.example.matriculaalunonivel1.data.Aluno para armazenar informações do aluno
data class Aluno(
    val nome: String,
    val turma: String,
    var notas: MutableList<Double> = mutableListOf()
) {
    // Função para calcular a média das notas
    fun calcularMedia(): Double {
        return if (notas.isNotEmpty()) {
            notas.sum() / notas.size
        } else {
            0.0
        }
    }

    // Função para verificar se o aluno está aprovado
    fun verificarAprovacao(): Boolean {
        return calcularMedia() >= 7.0
    }
}
