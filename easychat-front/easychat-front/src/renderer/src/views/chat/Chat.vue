<template>
 <Layout>
    <template #left-content>
      <div class="drag-panel drag"></div>
      <div class="top-search">
          <el-input clearable placeholder="搜索" v-model="searchKey" size="small" @keyup="search">
            <template #suffix>
              <span class="iconfont icon-search"></span>
            </template>
          </el-input>
      </div>
    </template>
  </Layout>
</template>

<script setup name="chat">
import { ref, reactive, getCurrentInstance, nextTick,onMounted } from "vue"
const { proxy } = getCurrentInstance();
import {useRoute,useRouter} from 'vue-router'
const route = useRoute()
const router = useRouter()

const init = ()=>{
  window.ipcRenderer.send("setLocalStore",{key:'devWsDomain',value:proxy.Api.devWsDomain})
  window.ipcRenderer.send("getLocalStore","devWsDomain")
  window.ipcRenderer.on("getLocalStoreCallback",(e,data)=>{
    console.log(1111);
    console.log(data);
  })
}
onMounted(()=>{
  init()
})

</script>
<style lang="scss" scoped>
.drag-panel {
  height: 25px;
  background: #f7f7f7;
}
.top-search {
  padding: 0px 10px 9px 10px;
  background-color: #f7f7f7;
  display: flex;
  align-items: center;
  .iconfont {
    font-size: 12px;

  }
}
.chat-session-list {
  height: calc(100vh - 62px);
  overflow: hidden;
  border-top: 1px solid #ddd;
  &:hover {
    overflow: auto;
  }
}
.search-list {
  height: calc(100vh - 62px);
  background-color: #f7f7f7;
  overflow: hidden;
  &:hover {
    overflow: auto;
  }
}
.title-panel {
  display: flex;
  align-items: center;
  .title {
    height: 60px;
    line-height: 60px;
    padding-left: 10px;
    font-size: 18px;
    color: #000000;
    flex: 1;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
}
.icon-more {
  position: absolute;
  z-index: 1;
  top: 3px;
  right: 3px;
  width: 20px;
  font-size: 20px;
  margin-right: 5px;
  cursor: pointer;
}
.chat-panel {
  border-top: 1px solid #ddd;
  background-color: #f5f5f5;
  .message-panel {
    padding: 10px 30px 0px 30px;
    height: calc(100vh - 200px - 62px);
    overflow-y:auto ;
    .message-item {
      margin-bottom: 15px;
      text-align: center;
    }
  }
}
</style>