<template>
    <nav>
      <div class="nav-wrapper orange darken-1">
        <a href="#!" class="brand-logo"><img src="@/assets/logo_01.png"></a>
        <a href="#" class="brand-logo center">{{ sistema }}</a>
      </div>
    </nav>
</template>

<script>
export default {

    props: ['sistema']
}
</script>

<style scoped>
img {
  width: 60px;
  height: 60px;
  margin-left: 10px;
  margin-top: 2px;
}
</style>