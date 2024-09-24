package com.example.matriculaalunonivel1.data

// Classe Repositorio para controlar os alunos e turmas
class RepositorioAlunos {
    private val alunos: MutableList<Aluno> = mutableListOf()

    // Função para cadastrar um novo aluno
    fun cadastrarAluno(nome: String, turma: String) {
        if (nome.isBlank() || turma.isBlank()) {
            throw IllegalArgumentException("Nome do aluno ou turma não podem estar vazios!")
        }
        val aluno = Aluno(nome, turma)
        alunos.add(aluno)
    }

    // Função para adicionar nota a um aluno
    fun adicionarNota(nome: String, nota: Double) {
        val aluno = buscarAluno(nome)
        aluno?.let {
            if (nota < 0 || nota > 10) {
                throw IllegalArgumentException("Nota inválida! Deve estar entre 0 e 10.")
            }
            it.notas.add(nota)
        } ?: throw NoSuchElementException("com.example.matriculaalunonivel1.data.Aluno não encontrado!")
    }

    // Função para buscar aluno pelo nome
    fun buscarAluno(nome: String): Aluno? {
        return alunos.find { it.nome == nome }
    }

    // Função para consultar situação do aluno (aprovado/reprovado)
    fun consultarSituacaoAluno(nome: String): String {
        val aluno = buscarAluno(nome)
        return aluno?.let {
            val status = if (it.verificarAprovacao()) "aprovado" else "reprovado"
            "com.example.matriculaalunonivel1.data.Aluno: ${it.nome} | Média: ${it.calcularMedia()} | Situação: $status"
        } ?: "com.example.matriculaalunonivel1.data.Aluno não encontrado!"
    }
}
