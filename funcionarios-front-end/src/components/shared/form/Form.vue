<template>
  <div id="app">
    <div v-if="showModal">
      <transition name="modal">
        <div class="modal-mask">
          <div class="modal-wrapper">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title">Cadastro de funcionario</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true" @click="showModal = false">&times;</span>
                  </button>
                    </div>
                      <div class="modal-body">
                        <div class="form-group">
                          <form @submit.prevent="salvar">
                            <label for="Nome">Nome</label>
                            <input class="form-control form-control-sm" type="text" placeholder="Nome" v-model="funcionario.nome" required>
                            <label for="Setor">Setor</label>
                            <input class="form-control form-control-sm" type="text" placeholder="Setor" v-model="funcionario.setor.nome" required>
                            <label for="Salario">Salário</label>
                            <input class="form-control form-control-sm" type="number" placeholder="Salario" v-model="funcionario.salario" required>
                            <label for="Email">Email</label>
                            <input class="form-control form-control-sm" type="text" placeholder="Email" v-model="funcionario.email" required>
                            <label for="Idade">Idade</label>
                            <input class="form-control form-control-sm" type="number" placeholder="Idade" v-model="funcionario.idade" required>
                            <div class="modal-footer">
                              <button class="btn btn-primary">Salvar</button>
                              <button type="button" class="btn btn-secondary" @click="showModal = false">Cancelar</button>
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
    <button @click="showModal = true" class="btn btn-info"><i class="material-icons">person_outline</i>Add Funcionario</button>
  </div>
</template>

<script>
import Funcionario from '@/services/funcionarios'
  export default {
    data() {
      return {
        showModal: false,
        funcionario: {
        id: null,
        nome: null,
        setor: {
          nome: null
        },
        salario: null,
        email: null,
        idade: null
      }
      }
    },
     methods: {
        async salvar() {
            await Funcionario.salvar(this.funcionario)
            .then()
            .catch((err) => console.log(err))
            
            this.showModal = false;
        }
  }
}
</script>

<style scoped>
.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, .5);
  display: table;
  transition: opacity .3s ease;
}

.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
}
</style>