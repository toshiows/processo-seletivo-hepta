<template>
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
</template>

<script>
//import Funcionario from './services/funcionarios'
export default {

}
</script>

<style scoped>

</style>