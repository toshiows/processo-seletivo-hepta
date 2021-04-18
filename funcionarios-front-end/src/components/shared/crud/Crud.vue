<template>
  <div class="container">
    <mensagem-acao :mensagem="mensagem" />

    <div v-if="showModal">
      <transition name="modal">
        <div class="modal-mask">
          <div class="modal-wrapper">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title">{{ operacao }}</h5>
                  <button
                    type="button"
                    class="close"
                    data-dismiss="modal"
                    aria-label="Close"
                  >
                    <span aria-hidden="true" @click="showModal = false"
                      >&times;</span
                    >
                  </button>
                </div>
                <div class="modal-body">
                  <div class="form-group">
                    <form @submit.prevent="salvar">
                      <label for="Nome">Nome</label>
                      <input
                        class="form-control form-control-sm"
                        type="text"
                        placeholder="Nome"
                        v-model="funcionario.nome"
                        required
                      />
                      <label for="Setor">Setor</label>
                      <input
                        class="form-control form-control-sm"
                        type="text"
                        placeholder="Setor"
                        v-model="funcionario.setor.nome"
                        required
                      />
                      <label for="Salario">Salário</label>
                      <input
                        class="form-control form-control-sm"
                        type="number"
                        placeholder="Salario"
                        v-model="funcionario.salario"
                        required
                      />
                      <label for="Email">Email</label>
                      <input
                        class="form-control form-control-sm"
                        type="email"
                        placeholder="Email"
                        v-model="funcionario.email"
                        required
                      />
                      <label for="Idade">Idade</label>
                      <input
                        class="form-control form-control-sm"
                        type="number"
                        placeholder="Idade"
                        v-model="funcionario.idade"
                        required
                      />
                      <div class="modal-footer">
                        <button class="btn btn-primary">Salvar</button>
                        <button
                          type="button"
                          class="btn btn-secondary"
                          @click="showModal = false"
                        >
                          Cancelar
                        </button>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </transition>
    </div>
    <div class="form-row align-items-center">
      <button @click="cadastro()" class="btn btn-info">
        <i class="material-icons">person_outline</i>Add Funcionario
      </button>

      <div class="col-auto busca">
        <input
          v-on:input="filtro = $event.target.value"
          class="form-control"
          type="search"
          placeholder="Buscar na tabela"
          v-model="filter"
        />
      </div>
    </div>

    <hr />

    <table class="table table-striped table-hover" style="text-align: center;">
      <thead class="bg-info">
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
        <tr v-for="funcionario of tabelaComFiltro" :key="funcionario.id">
          <td>{{ funcionario.nome }}</td>
          <td>{{ funcionario.setor.nome }}</td>
          <td>{{ funcionario.salario }}</td>
          <td>{{ funcionario.email }}</td>
          <td>{{ funcionario.idade }}</td>
          <td>
            <button
              @click="editar(funcionario)"
              type="button"
              class="btn btn-success"
            >
              <i class="material-icons">edit</i>
            </button>
            <button
              @click="remover(funcionario.id)"
              type="button"
              class="btn btn-danger"
              style="margin-left: 3px;"
            >
              <i class="material-icons">delete_forever</i>
            </button>
          </td>
        </tr>
      </tbody>
    </table>
    <div class="lds-ring" v-show="load"><div></div><div></div><div></div><div></div></div>
  </div>
</template>

<script>
import Funcionario from "@/services/funcionarios";
import Mensagem from "@/components/shared/mensagem/Mensagem.vue";

import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
export default {
  components: {
    "mensagem-acao": Mensagem,
  },
  data() {
    return {
      funcionario: {
        id: null,
        nome: null,
        setor: {
          nome: null,
        },
        salario: null,
        email: null,
        idade: null,
      },
      funcionarios: [],
      mensagem: "",
      showModal: false,
      operacao: "",
      filtro: "",
      load: false
    };
  },

  computed: {
    tabelaComFiltro() {
      if (this.filtro) {
        let expr = new RegExp(this.filtro.trim(), "i");

        return this.funcionarios.filter(
          (item) =>
            expr.test(item.nome) ||
            expr.test(item.setor.nome) ||
            expr.test(item.salario.toString()) ||
            expr.test(item.email) ||
            expr.test(item.idade.toString())
        );
      } else {
        return this.funcionarios;
      }
    },
  },

  mounted() {
    this.listar();
  },

  methods: {
    listar() {
      Funcionario.listar().then((resposta) => {
        this.funcionarios = resposta.data;
      });
    },

    async salvar() {
      this.load = true;
      if (this.funcionario.id == null) {
        this.listar();
        await Funcionario.salvar(this.funcionario)
          .then()
          .catch((err) => console.log(err));

        this.limpaCampo();
        this.listar();

        this.msgBalao("Funcionario adicionado com sucesso!");
      } else {
        this.atualizar();
      }
      this.showModal = false;
      this.load = false;
    },

    cadastro() {
      this.limpaCampo();
      this.listar();
      this.showModal = true;
      this.operacao = "Cadastro de funcionario";
    },

    async atualizar() {
      this.load = true;
      await Funcionario.atualizar(this.funcionario.id, this.funcionario)
        .then()
        .catch((err) => console.log(err));

      this.limpaCampo();
      this.listar();
      this.msgBalao("Funcionario atualizado com sucesso!");
      this.load = false;
    },

    editar(funcionario) {
      this.funcionario = funcionario;
      this.showModal = true;
      this.operacao = "Editar funcionario";
    },

    async remover(id) {
      if (confirm("Deseja realmente remover o funcionário?")) {
        this.load = true;
        await Funcionario.deletar(id)
          .then()
          .catch((err) => console.log(err));

        this.listar();

        this.msgBalao("Funcionario excluido com sucesso!");
        this.load = false;
      }
    },

    limpaCampo() {
      this.funcionario.id = null;
      this.funcionario.nome = null;
      this.funcionario.setor.id = null;
      this.funcionario.setor.nome = null;
      this.funcionario.salario = null;
      this.funcionario.email = null;
      this.funcionario.idade = null;
    },

    msgBalao(mensagem) {
      this.mensagem = mensagem;
      var s = document.getElementById("msg").style;
      s.opacity = 5;
      (function fade() {
        (s.opacity -= 0.1) < 0 ? (s.opacity = "0") : setTimeout(fade, 100);
      })();
    },
  },
};
</script>

<style>
.busca {
  margin-left: auto;
}

.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: table;
  transition: opacity 0.3s ease;
}

.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
}

hr {
  -moz-border-bottom-colors: none;
  -moz-border-left-colors: none;
  -moz-border-right-colors: none;
  -moz-border-top-colors: none;
  border-color: #eeeeee -moz-use-text-color #ffffff;
  border-style: solid none;
  border-width: 1px 0;
  margin: 18px 0;
}

.material-icons {
  font-size: 15px;
}

/* Loading */
.lds-ring {
  display: inline-block;
  width: 80px;
  height: 80px;
  padding-left: 500px;
}
.lds-ring div {
  box-sizing: border-box;
  display: block;
  position: absolute;
  width: 64px;
  height: 64px;
  margin: 8px;
  border: 8px solid rgb(19, 109, 112);
  border-radius: 50%;
  animation: lds-ring 1.2s cubic-bezier(0.5, 0, 0.5, 1) infinite;
  border-color: rgb(27, 146, 155) transparent transparent transparent;
}
.lds-ring div:nth-child(1) {
  animation-delay: -0.45s;
}
.lds-ring div:nth-child(2) {
  animation-delay: -0.3s;
}
.lds-ring div:nth-child(3) {
  animation-delay: -0.15s;
}
@keyframes lds-ring {
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
}

</style>
