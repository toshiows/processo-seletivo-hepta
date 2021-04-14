<template>

<div class="alert alert-success" role="alert" id="msg">
    {{ mensagem }}
</div>
</template>

<script>
export default {

    props: ['mensagem']
}
</script>

<style scoped>
#msg {
  opacity: 0;
  margin-top: 10px;
}
</style>