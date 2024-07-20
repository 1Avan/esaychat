<template>
  <content-panel>
    <div class="search-form">
      <!--input输入-->
      <el-input
        clearable
        placeholder="请输入用户ID或者群聊ID"
        v-model="contactId"
        size="large"
        @keydown.enter="search"
      >
      </el-input>
      <div class="search-btn iconfont icon-search" @click="search"></div>
    </div>
    <div
      v-if="searchResult && Object.keys(searchResult).length > 0"
      class="search-result-panel"
    >
    <div class="search-result">
      <span class="contact-type">{{contactTypeName}}</span>
      <UserBaseInfo :userInfo="searchResult" :showArea="searchResult.contactType=='USER'"></UserBaseInfo>
    </div>
    <div class="op-btn" v-if="searchResult.contactId!=userInfoStore.getInfo().userId">
      <el-button
      type="primary"
      v-if="searchResult.status == null||searchResult.status == 0||searchResult.status == 2||searchResult.status == 3||searchResult.status == 4"
      @click="applyContact"
      >
      {{searchResult.contactType == "USER"?"添加联系人":"申请加入群聊"}}
      </el-button>

      <el-button type="primary" v-if="searchResult.status == 1" @click="sendMessage">
        发信息
      </el-button>

      <span v-if="searchResult.status == 5 ||searchResult.status==6">对方拉黑了你</span>
    </div>


    </div>
    <div v-if="!searchResult" class="no-data">没有搜索到任何结果</div>
  </content-panel>

  <SearchAdd ref="SearchAddRef" @reload="resetForm"></SearchAdd>
</template>
<script setup >
import SearchAdd from "@/views/contact/SearchAdd.vue"
import { ref, reactive, getCurrentInstance, nextTick, computed } from 'vue'
import {useUserInfoStore} from '@/stores/UserInfoStore'
import UserBaseInfo from "@/components/UserBaseInfo.vue"
const userInfoStore = useUserInfoStore()
const { proxy } = getCurrentInstance()
const contactId = ref()
const searchResult = ref({})

const contactTypeName = computed(()=>{
  if(userInfoStore.getInfo().userId == searchResult.value.contactId){
    return "自己"
  }
  if(searchResult.value.contactType == 'USER'){
    return "用户"
  }
    if(searchResult.value.contactType == 'GROUP'){
    return "群聊"
  }
})
const search = () => {
  console.log(contactId.value)
  searchResult.value = {
    status:2,
    sex:0,
    contactId:"1",
    contactType:"USER",
    nickName:'test',
    areaName:'中国,台湾'
  }
  console.log(searchResult.value);
}
const SearchAddRef = ref()
 //申请加好友弹框调用SearchAdd中暴露的submitForm方法
const applyContact = ()=>{
  SearchAddRef.value.show()
}


const resetForm = ()=>{
  searchResult.value = {}
  contactId.value = undefined
}

</script>
<style scoped lang="scss">
.search-form {
  padding-top: 50px;
  display: flex;
  align-items: center;
  :deep(.el-input_wrapper) {
    border-radius: 4px 0px 0px 0px;
    border-right: none;
  }
  .search-btn {
    background: #07c160;
    color: #fff;
    line-height: 40px;
    width: 80px;
    text-align: center;
    border-radius: 0px 5px 5px 0px;
    cursor: pointer;
    &:hover {
      background-color: #0dd36c;
    }
  }
}
.no-data {
  padding: 30px 0px;
}

.search-result-panel {
  .search-result {
    padding: 30px 20px 20px 20px;
    background: #fff;
    border-radius: 5px;
    margin-top: 10px;
    position: relative;
    .contact-type {
      position: absolute;
      left: 0px;
      top: 0px;
      background: #2cb6fe;
      padding: 2px 5px;
      color: #fff;
      border-radius: 5px 0px 0px 0px;
      font-size: 12px;
    }
  }
  .op-btn {
    border-radius: 5px;
    margin-top: 10px;
    padding: 10px;
    background-color: #fff;
    text-align: center;
  }
}
</style>