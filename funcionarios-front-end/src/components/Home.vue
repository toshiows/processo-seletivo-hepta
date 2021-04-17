<template>
  <div id="app">
    <crud-component />
  </div>
</template>

<script>
import Crud from '@/components/shared/crud/Crud.vue'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
export default {

  components: {
    'crud-component' : Crud
  }
}
</script>

<style>

</style>
