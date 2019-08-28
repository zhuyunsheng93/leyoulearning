<template>
  <div>
    <v-card-title>
      <v-btn color="primary" @click="addBrand">新增</v-btn>
      <v-spacer/>
      <v-text-field label="请输入关键字搜索" v-model="search" append-icon="search"
                    hide-details></v-text-field>
    </v-card-title>
    <v-divider/>
    <v-data-table
      :headers="headers"
      :items="brands"
      :search="search"
      :pagination.sync="pagination"
      :total-items="totalBrands"
      :loading="loading"
      class="elevation-1"
    >
      <template slot="items" slot-scope="props">
        <td>{{ props.item.id }}</td>
        <td class="text-xs-center">{{ props.item.name }}</td>
        <td class="text-xs-center">
          <img v-if="props.item.image" :src="props.item.image" width="130" height="40">
          <span v-else>无</span>
        </td>
        <td class="text-xs-center">{{ props.item.letter }}</td>
        <td class="justify-center layout">
          <v-btn color="info">编辑</v-btn>
          <v-btn color="warning">删除</v-btn>
        </td>
      </template>
    </v-data-table>
    <v-dialog max-width="500" v-model="show" persistent>
      <v-card>
        <!--对话框的标题-->
        <v-toolbar dense dark color="primary">
          <v-toolbar-title>新增品牌</v-toolbar-title>
          <v-spacer/>
          <v-btn icon @click="closeWindow">
            <v-icon>close</v-icon>
          </v-btn>
        </v-toolbar>
        <!--对话框的内容，表单-->
        <v-card-text class="px-5">
          <my-brand-form></my-brand-form>
        </v-card-text>

      </v-card>
    </v-dialog>
  </div>
</template>
<script>
  import MyBrandForm from './MyBrandForm'
  export default {
    name: 'my-brand',
    components:{
      MyBrandForm
    },
    data: () => ({
      search: '',
      totalBrands: 0,
      brands: [],
      loading: true,
      pagination: {},
      headers: [
        {text: 'id', align: 'center', value: 'id'},
        {text: '名称', align: 'center', sortable: false, value: 'name'},
        {text: 'LOGO', align: 'center', sortable: false, value: 'image'},
        {text: '首字母', align: 'center', value: 'letter', sortable: true,},
        {text: '操作', align: 'center', sortable: false}
      ],
      show: false
    }),
    methods: {
      getDataFormServer() {
        this.$http.get('item/brand/page', {
          params: {
            key: this.key,
            page: this.pagination.page,
            rows: this.pagination.rowsPerPage,
            sortBy: this.pagination.sortBy,
            desc: this.pagination.descending
          }
        }).then(resp => {
          console.log(resp);
          this.brands = resp.data.items;
          this.totalBrands = resp.data.total;
          this.loading = false;//完成赋值后将加载状态关闭。
        })
      },
      addBrand() {
        this.show = true;
      },
      closeWindow() {
        this.show = false;
      }
    },
    watch: {
      pagination: {
        deep: true,
        handler() {
          this.getDataFormServer();
        }
      },
      search: {
        handler() {
          this.getDataFormServer();
        }

      }
    },
    mounted() {
      this.getDataFormServer();
    }
  }
</script>
<style scoped>

</style>
