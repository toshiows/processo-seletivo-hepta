<template>
  <table class="striped">

        <thead class="table table-striped table-dark">

          <tr>
            <th scope="col">Nome</th>
            <th scope="col">Setor</th>
            <th scope="col">Salário</th>
            <th scope="col">Email</th>
            <th scope="col">Idade</th>
            <th scope="col">Ações</th>
          </tr>

        </thead>

        <tbody>

          <tr  v-for="funcionario of funcionarios" :key="funcionario.id">
            <td>{{ funcionario.nome }}</td>
            <td>{{ funcionario.setor.nome }}</td>
            <td>{{ funcionario.salario }}</td> 
            <td>{{ funcionario.email }}</td> 
            <td>{{ funcionario.idade }}</td>
            <td>
              <button @click="editar(funcionario)" class="waves-effect btn-small waves-light darken-1"><i class="material-icons">edit</i></button>
              <button @click="remover(funcionario.id)" class="waves-effect btn-small waves-light darken-1"><i class="material-icons">delete_forever</i></button>
            </td>

          </tr>

        </tbody>
      
      </table>
</template>

<script>
import Funcionario from '@/services/funcionarios'
  export default {
    data() {
      return {
        funcionarios: []
      }
    },
      mounted() {
        this.listar()
  },

  methods: {
    listar() {
        Funcionario.listar().then(resposta => {
        this.funcionarios = resposta.data;
     })
    }
  }
}
</script>