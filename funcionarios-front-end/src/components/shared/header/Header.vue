<template>
<div>
  <b-navbar toggleable type="dark" variant="dark">
    
    <b-navbar-brand>{{ sistema }}</b-navbar-brand>
    <b-navbar-toggle target="navbar-toggle-collapse">
      <template #default="{ expanded }">
        <b-icon v-if="expanded" icon="chevron-bar-up"></b-icon>
        <b-icon v-else icon="chevron-bar-down"></b-icon>
      </template>
    </b-navbar-toggle>
    <b-collapse id="navbar-toggle-collapse" is-nav>
      <b-navbar-nav class="ml-auto">

        <b-nav-item v-for="route in routes" :key="route">
          <router-link :to="route.path ? route.path : '/'" class="cor-link"> {{ route.titulo }}</router-link>
        </b-nav-item>

      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
 </div> 
</template>
<script>

import { routes } from '@/routes'

export default {
  data() {
    return {
      routes
    }
  },
  props: ['sistema']

}
</script>

<style scoped>
.cor-link {
  color: white;
}
</style>