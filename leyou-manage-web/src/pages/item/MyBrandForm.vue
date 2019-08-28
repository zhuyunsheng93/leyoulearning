<template>
  <v-form v-model="valid">
    <v-text-field v-model="brand.name" label="请输入品牌名称" required/>
    <v-text-field v-model="brand.letter" label="请输入品牌首字母" required/>
  </v-form>
</template>

<script>
  export default {
    name: "MyBrandForm",
    return: () => ({
      valid: false,
      brand: {
        name: '',
        letter: '',
        image: '',
        categories: [],
      }
    })
  }
</script>

<style scoped>

</style>
