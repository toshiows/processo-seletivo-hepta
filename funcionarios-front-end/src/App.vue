<template>
  <div id="app">
    <cabecalho sistema="Sistema de cadastro de funcionarios" />
    <transition name="slide-fade">
      <router-view></router-view>
    </transition>
    <footer-component />
  </div>
</template>

<script>
import Header from '@/components/shared/header/Header.vue'
import Footer from '@/components/shared/footer/Footer.vue'

export default {
  components: {
    'cabecalho' : Header,
    'footer-component' : Footer
  }
}
</script>

<style>
 
 .slide-fade-enter-active {
  transition: all .3s ease;
}
.slide-fade-leave-active {
  transition: all .8s cubic-bezier(1.0, 0.5, 0.8, 1.0);
}
.slide-fade-enter, .slide-fade-leave-to
/* .slide-fade-leave-active below version 2.1.8 */ {
  transform: translateX(10px);
  opacity: 0;
}
</style>
