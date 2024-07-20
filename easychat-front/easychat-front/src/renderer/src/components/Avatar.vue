<template>
<div>
    <AvatarBase
    :userId = "userId"
    :width = "width"
    :borderRadius = "borderRadius"
    :showDetail = "false"
    v-if="userId=='Urobot'"
    ></AvatarBase>
      <el-popover
      v-else
    placement="right-start"
    :width="200"
    trigger="click"
    transition="none"
    :hide-after="0"
    @show="getContactInfo"
    ref="popoverRef"
  >
  <template #reference>
        <AvatarBase
    :userId = "userId"
    :width = "width"
    :borderRadius = "borderRadius"
    :showDetail = "false"
    ></AvatarBase>
  </template>
      <template #default>
      <div class="popover-user-panel">
        <UserBaseInfo :userInfo = "userInfo"></UserBaseInfo>
        <div class="op-btn" v-if="userId!==userInfoStore.getInfo().userId">
          <el-button v-if="userInfo.contactStatus == 1" type="primary" @click="sendMessage">发送消息</el-button>
          <el-button v-else type="primary" @click="addContact">加为好友</el-button>
        </div>
      </div>
    </template>
  </el-popover>

</div>
</template>
<script setup >
import { ref, reactive, getCurrentInstance, nextTick } from "vue"
const { proxy } = getCurrentInstance();
import AvatarBase from "@/components/AvatarBase.vue"
import UserBaseInfo from "@/components/UserBaseInfo.vue"
import {useUserInfoStore} from "@/stores/UserInfoStore.js"
const userInfoStore  =useUserInfoStorese()
const props = defineProps({
    userId:{
        type:String
    },
    width:{
        type:Number,
        default:40
    },
    borderRadius:{
        type:Number,
        default:0
    },
    groupId:{
        type:String 
    }

})
const userInfo = ref({})
const getContactInfo = async ()=>{
    //如果点击的是自己那么就直接在userInfoStore中找到信息并赋值
    if(userInfoStore.getInfo().userId == props.userId){
        userInfo.value = userInfoStore.getInfo()
    }else {
            let result = await proxy.Request({
       url:proxy.Api.getContactInfo,
       params:{
        contactId:props.userId
       },
       showLoading:false
    })
    if(!result){
      return;
    }
    userInfo.value = Object.assign({},result.data)
    }
}

//TODO 发送消息
const sendMessage = ()=>{}
//TODO 添加好友
const addContact = ()=>{}
</script>
<style scoped lang="scss">
.op-btn {
  text-align: center;
  border-top: 1px solid #eaeaea;
  padding-top:10px ;
}
</style>