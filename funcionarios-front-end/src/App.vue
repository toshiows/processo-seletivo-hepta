<template>
  <div id="app">

    <cabecalho sistema="Sistema de cadastro de funcionarios"/>

    <div class="container">
      
      <mensagem-acao :mensagem="mensagem" />
      <furmulario />
      <form @submit.prevent="salvar">

          <label>Nome</label>
          <input type="text" placeholder="Nome" v-model="funcionario.nome" required>
          <label>Setor</label>
          <input type="text" placeholder="Setor" v-model="funcionario.setor.nome" required>
          <label>Salário</label>
          <input type="number" placeholder="Salario" v-model="funcionario.salario" required>
          <label>Email</label>
          <input type="text" placeholder="Email" v-model="funcionario.email" required>
          <label>Idade</label>
          <input type="number" placeholder="Idade" v-model="funcionario.idade" required>

          <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>

      </form>

      <table class="striped">

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
              <button @click="editar(funcionario)" class="waves-effect btn-small waves-light darken-1"><i class="material-icons">edit</i></button>
              <button @click="remover(funcionario.id)" class="waves-effect btn-small waves-light darken-1"><i class="material-icons">delete_forever</i></button>
            </td>

          </tr>

        </tbody>
      
      </table>

    </div>

  </div>
</template>

<script>
import Header from './components/shared/header/Header.vue'
import Mensagem from './components/shared/mensagem/Mensagem.vue'
import Form from './components/shared/form/Form.vue'
import Funcionario from './services/funcionarios'

export default {

  components: {
    'mensagem-acao' : Mensagem,
    'cabecalho' : Header,
    'furmulario' : Form
  },

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
      funcionarios:[],
      mensagem: ''
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

      this.msgBalao('Funcionario adicionado com sucesso!')
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
        this.msgBalao('Funcionario atualizado com sucesso!')
      },

      editar(funcionario) {
        this.funcionario = funcionario;
      },

      async remover(id) {
        if(confirm('Deseja realmente remover o funcionário?')) {
          await Funcionario.deletar(id)
          .then()
          .catch((err) => console.log(err))

          this.listar()
          
          this.msgBalao('Funcionario excluido com sucesso!')
        }

      },

      limpaCampo() {
        this.funcionario.id = null
        this.funcionario.nome = null
        this.funcionario.setor.nome = null
        this.funcionario.salario = null
        this.funcionario.email = null
        this.funcionario.idade = null
      },

      msgBalao(mensagem) {
        this.mensagem = mensagem
        var s = document.getElementById('msg').style;
        s.opacity = 3;
        (function fade(){(s.opacity-=.1)<0?s.display="":setTimeout(fade,100)})();
      }

    }
  }

</script>

<style>

</style>
