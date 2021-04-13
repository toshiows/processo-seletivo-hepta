<template>
  <div id="app">

    <nav>
      <div class="nav-wrapper green darken-1">
      <a href="#!" class="brand-logo"><i class="material-icons">badge</i></a>
        <a href="#" class="brand-logo center">Sistema de cadastro de funcionarios</a>
      </div>
    </nav>

    <div class="container">

      <form @submit.prevent="salvar">

          <label>Nome</label>
          <input type="text" placeholder="Nome" v-model="funcionario.nome">
          <label>Setor</label>
          <input type="text" placeholder="Setor" v-model="funcionario.setor.nome">
          <label>Salário</label>
          <input type="number" placeholder="Salario" v-model="funcionario.salario">
          <label>Email</label>
          <input type="text" placeholder="Email" v-model="funcionario.email">
          <label>Idade</label>
          <input type="number" placeholder="Idade" v-model="funcionario.idade">

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
              <button @click="editar(funcionario)" class="waves-effect btn-small blue darken-1"><i class="material-icons">create</i></button>
              <button @click="remover(funcionario.id)" class="waves-effect btn-small red darken-1"><i class="material-icons">delete_sweep</i></button>
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
      funcionario: {
        id: null,
        nome: null,
        setor: {
          nome: null
        },
        salario: null,
        email: null,
        idade: null
      },
      funcionarios:[]
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
    },

  async salvar() {
    if(this.funcionario.id == null) {
      this.listar()
      await Funcionario.salvar(this.funcionario)
      .then()
      .catch((err) => console.log(err))

      this.limpaCampo()
      this.listar()
    }
    else {
      this.atualizar()
    }
      },

     async atualizar() {
       await Funcionario.atualizar(this.funcionario)
        .then()
        .catch((err) => console.log(err))

        this.limpaCampo()
        this.listar()
      },

      editar(funcionario) {
        this.funcionario = funcionario;
      },

      async remover(id) {
        console.log(id)
 
        await Funcionario.deletar(id)
        .then()
        .catch((err) => console.log(err))
        
        this.listar()
      },

      limpaCampo() {
        this.funcionario.nome = null
        this.funcionario.setor.nome = null
        this.funcionario.salario = null
        this.funcionario.email = null
        this.funcionario.idade = null
      }

    }
  }

</script>

<style>

</style>
