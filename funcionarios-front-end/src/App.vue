<template>
  <div id="app">

    <nav>
      <div class="nav-wrapper green darken-1">
      <a href="#!" class="brand-logo"><i class="material-icons">badge</i></a>
        <a href="#" class="brand-logo center">Sistema de cadastro de funcionarios</a>
      </div>
    </nav>

    <div class="container">

      <form>

          <label>Nome</label>
          <input type="text" placeholder="Nome">
          <label>Setor</label>
          <input type="text" placeholder="Setor">
          <label>Salário</label>
          <input type="number" placeholder="QTD">
          <label>Email</label>
          <input type="text" placeholder="Valor">
          <label>Idade</label>
          <input type="number" placeholder="QTD">

          <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>

      </form>

      <table>

        <thead>

          <tr>
            <th>Nome</th>
            <th>Setor</th>
            <th>Salário</th>
            <th>Email</th>
            <th>Idade</th>
            <th>Ações</th>
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
              <button class="waves-effect btn-small blue darken-1"><i class="material-icons">create</i></button>
              <button class="waves-effect btn-small red darken-1"><i class="material-icons">delete_sweep</i></button>
            </td>

          </tr>

        </tbody>
      
      </table>

    </div>

  </div>
</template>

<script>
import Funcionario from './services/funcionarios'

export default {

  data() {
    return {
      funcionarios:[]
    }
  },

  mounted() {
    Funcionario.listar().then(resposta => {
      this.funcionarios = resposta.data;
    })
  }
}

</script>

<style>

</style>
