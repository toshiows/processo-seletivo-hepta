<template>
  <div id="app">

    <cabecalho sistema="Sistema de cadastro de funcionarios" />

    <crud-component />

  </div>
</template>

<script>
import Crud from './components/shared/crud/Crud.vue'
import Header from './components/shared/header/Header.vue'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
export default {

  components: {
    'crud-component' : Crud,
    'cabecalho' : Header
  }
}
</script>

<style>

</style>
