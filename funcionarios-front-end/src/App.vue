<template>
  <div id="app">

    <cabecalho sistema="Sistema de cadastro de funcionarios" />

    <crud-component />

    <footer-component />
  </div>
</template>

<script>

import Header from './components/shared/header/Header.vue'
import Crud from './components/shared/crud/Crud.vue'
import Footer from './components/shared/footer/Footer.vue'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
export default {

  components: {
    'crud-component' : Crud,
    'cabecalho' : Header,
    'footer-component' : Footer
  }
}
</script>

<style>

</style>
