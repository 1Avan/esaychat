<template>
  <div class="main">
    <div class="left-sider">
      <div></div>
      <div class="menu-list">
        <template v-for="item in menuList">
          <div
            :class="['tab-item iconfont', item.icon, item.path == currentMenu.path ? 'active' : '']"
            v-if="item.position == 'top'"
            @click="changeMenu(item)"
          ></div>
        </template>
      </div>

      <div class="menu-list menu-bottom">
        <template v-for="item in menuList">
          <div
            :class="['tab-item iconfont', item.icon, item.path == currentMenu.path ? 'active' : '']"
            v-if="item.position == 'bottom'"
            @click="changeMenu(item)"
          ></div>
        </template>
      </div>
    </div>
    <div class="rigth-container">
      <router-view v-slot="{Component}">
        <keep-alive include="chat">
          <component :is="Component" ref="componentRef"></component>
        </keep-alive>

      </router-view>
    </div>
  </div>

  <win-op></win-op>
</template>

<script setup>
import { ref, reactive, getCurrentInstance, nextTick, onMounted } from 'vue'
import {useRouter} from "vue-router"
const router = useRouter()
const { proxy } = getCurrentInstance()

import {useUserInfoStore} from '@/stores/UserInfoStore'
const useInfoStore = useUserInfoStore()


const menuList = ref([
  {
    name: 'chat',
    icon: 'icon-chat',
    path: '/chat',
    countKey: 'chatCount',
    position: 'top'
  },
  {
    name: 'contact',
    icon: 'icon-user',
    path: '/contact',
    countKey: 'contactApplyCount',
    position: 'top'
  },
  {
    name: 'mysetting',
    icon: 'icon-more2',
    path: '/setting',
    position: 'bottom'
  }
])

const currentMenu = ref(menuList.value[0])
const changeMenu = (item)=>{
currentMenu.value = item
router.push(item.path)
}

const getLoginInfo =  async()=>{
  // console.log(localStorage.getItem('userInfo'));
  // userInfoStore.setInfo(JSON.parse(localStorage.getItem('userInfo')))
  let result = await proxy.Request({
     url:proxy.Api.getUserInfo,
     params:{
     }
  })
  if(!result){
    return;
  }
  useInfoStore.setInfo(result.data)
}
onMounted(()=>{
  getLoginInfo()
})
</script>

<style lang="scss" scoped>
.main {
  background-color: #ddd;
  display: flex;
  border-radius: 0px 3px 3px 0px;
  overflow: hidden;
  .left-sider {
    width: 55px;
    background-color: #2e2e2e;
    text-align: center;
    flex-direction: column;
    display: flex;
    align-items: center;
    padding-top: 35px;
    border-right: none;
    padding-bottom: 10px;
    .menu-list {
      width: 100%;
      flex: 1;
      .tab-item {
        color: #d3d3d3;
        font-size: 20px;
        height: 40px;
        display: flex;
        align-items: center;
        justify-content: center;
        margin-top: 10px;
        cursor: pointer;
        font-size: 22px;
        position: relative;
      }
      .active {
        color: #07a160;
      }
    }
    .menu-bottom {
      display: flex;
      flex-direction: column;
      justify-content: flex-end;
    }
  }
  .right-container {
    flex: 1;
    overflow: hidden;
    border: 1px solid #ddd;
    border-left: none;
  }
}

.popover-user-panel {
  padding: 10px;
  .popover-user {
    display: flex;
    border-bottom: 1px solid #ddd;
    padding-bottom: 20px;
  }
  .send-message {
    margin-top: 10px;
    text-align: center;
    padding: 20px 0px 0px 0px;
  }
}
</style>