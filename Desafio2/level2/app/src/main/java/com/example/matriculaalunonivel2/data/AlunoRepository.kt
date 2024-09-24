package com.example.matriculaalunonivel2.data

//Criando o Repositório de Alunos
object AlunoRepository {
    private val alunos = mutableListOf<Aluno>()

    fun adicionarAluno(aluno: Aluno) {
        alunos.add(aluno)
    }

    fun excluirAluno(id: Int): Boolean {
        return alunos.removeIf { it.id == id }
    }

    fun consultarAlunoPorTurma(turmaId: Int): List<Aluno> {
        return alunos.filter { it.turmaId == turmaId }
    }

    fun consultarAlunoPorId(id: Int): Aluno? {
        return alunos.find { it.id == id }
    }

    fun obterTodosAlunos(): List<Aluno> {
        return alunos.toList()
    }
}
