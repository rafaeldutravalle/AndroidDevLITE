package com.example.matriculaalunonivel2.data

//Criando o Repositório de Turmas
object TurmaRepository {
    private val turmas = mutableListOf<Turma>()

    fun adicionarTurma(turma: Turma) {
        turmas.add(turma)
    }

    fun excluirTurma(id: Int): Boolean {
        return turmas.removeIf { it.id == id }
    }

    fun obterTurmas(): List<Turma> {
        return turmas.toList()
    }

    fun consultarTurmaPorId(id: Int): Turma? {
        return turmas.find { it.id == id }
    }
}
