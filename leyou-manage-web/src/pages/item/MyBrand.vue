<template>
  <div>
    <v-card-title>
    <v-btn color="primary">新增</v-btn>
      <v-spacer/>
      <v-text-field label="请输入关键字搜索" v-model="search" append-icon="search" hide-details></v-text-field>
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
  </div>
</template>
<script>
    export default {
        name: 'my-brand',
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
            ]
        }),
        methods: {
            getDataFormServer() {
                const brands = [
                    {
                        "id": 2032,
                        "name": "OPPO",
                        "image": "http://img10.360buyimg.com/popshop/jfs/t2119/133/2264148064/4303/b8ab3755/56b2f385N8e4eb051.jpg",
                        "letter": "O",
                        "categories": null
                    },
                    {
                        "id": 2033,
                        "name": "飞利浦（PHILIPS）",
                        "image": "http://img12.360buyimg.com/popshop/jfs/t18361/122/1318410299/1870/36fe70c9/5ac43a4dNa44a0ce0.jpg",
                        "letter": "F",
                        "categories": null
                    },
                    {
                        "id": 2034,
                        "name": "华为（HUAWEI）",
                        "image": "http://img10.360buyimg.com/popshop/jfs/t5662/36/8888655583/7806/1c629c01/598033b4Nd6055897.jpg",
                        "letter": "H",
                        "categories": null
                    },
                    {
                        "id": 2036,
                        "name": "酷派（Coolpad）",
                        "image": "http://img10.360buyimg.com/popshop/jfs/t2521/347/883897149/3732/91c917ec/5670cf96Ncffa2ae6.jpg",
                        "letter": "K",
                        "categories": null
                    },
                    {
                        "id": 2037,
                        "name": "魅族（MEIZU）",
                        "image": "http://img13.360buyimg.com/popshop/jfs/t3511/131/31887105/4943/48f83fa9/57fdf4b8N6e95624d.jpg",
                        "letter": "M",
                        "categories": null
                    }];
                setTimeout(() => {
                    this.brands = brands;
                    this.totalBrands = brands.length;
                    this.loading = false;
                }, 400)
            }
        },
        mounted() {
            this.getDataFormServer();
        }
    }
</script>
<style scoped>

</style>
