<template>
  <v-form v-model="valid" ref="myBrandForm">
    <v-text-field v-model="brand.name" :rules="nameRules" label="请输入品牌名称" required/>
    <v-text-field v-model="brand.letter" :rules="letterRules" label="请输入品牌首字母" required/>
    <v-cascader url="item/category/list" multiple required v-model="brand.categories" label="请选择商品分类"/>
    <v-layout row>
      <v-flex xs3>
        <span style="font-size: 16px; color: #444">品牌LOGO：</span>
      </v-flex>
      <v-flex>
        <v-upload
          v-model="brand.image"
          url="/upload"
          :multiple="false"
          :pic-width="250"
          :pic-height="90"
        />
      </v-flex>
    </v-layout>
    <v-layout class="my-4" row>
      <v-spacer/>
      <v-btn @click="submit" color="primary">提交</v-btn>
      <v-btn @click="clear">重置</v-btn>
    </v-layout>
  </v-form>
</template>

<script>
    export default {
        name: "MyBrandForm",
        data: () => ({
            valid: false,
            brand: {
                name: '',
                letter: '',
                image: '',
                categories: [],
            },
            nameRules: [
                v => !!v || "品牌名称不能为空",
                v => v.length > 1 || "品牌名称至少2位"
            ],
            letterRules: [
                v => !!v || "首字母不能为空",
                v => /^[A-Z]{1}$/.test(v) || "品牌字母只能是A~Z的大写字母"
            ]
        }),
        methods: {
            submit() {
                if (this.$refs.myBrandForm.validate()) {
                    const {categories, letter, ...params} = this.brand;
                    params.cids = categories.map(c => c.id).join(",");
                    params.letter = letter.toUpperCase();
                    console.log(params);
                    this.$http.post('item/brand', this.$qs.stringify(params)).then(() => {
                        this.$emit("close");
                        this.$message.success("保存成功");
                    }).catch(() => {
                        this.$message.error("保存失败");
                    })
                }
                console.log(this)
            },
            clear() {
                this.$refs.myBrandForm.reset();
                this.categories = {}
            },
            closeWindow(){
                //关闭窗口
                this.show = false;
                //重新加载数据
                this.getDataFormServer();
            }
        },
        created() {
            console.log(this.$qs);
        }
    }
</script>

<style scoped>

</style>
