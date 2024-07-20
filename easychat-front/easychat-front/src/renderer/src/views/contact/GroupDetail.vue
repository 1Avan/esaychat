<template>
  <ContentPanel>
    <div class="group-info-item">
      <div class="group-title">群封面：</div>
      <div class="group-value"><Avatar :userId="groupInfo.groupId"></Avatar></div>
      <el-dropdown placement="bottom-end" trigger="click">
        <span class="el-dropdown-link">
          <div class="iconfont icon-more"></div>
        </span>
      </el-dropdown>
      <template #dropdown>
        <el-dropdown-menu v-if="groupInfo.groupOwnerId == userInfo.getInfo().userId">
          <el-dropdown-item @click="editGroupInfo">修改群信息</el-dropdown-item>
          <el-dropdown-item @click="dissolutionGroup">解散该群</el-dropdown-item>
        </el-dropdown-menu>

        <el-dropdown-menu v-else>
          <el-dropdown-item @click="leaveGroup">退出该群</el-dropdown-item>
        </el-dropdown-menu>
      </template>
    </div>

    <div class="group-info-item">
      <div class="group-title">群ID：</div>
      <div class="group-value">{{ groupInfo.groupId }}</div>
    </div>
  </ContentPanel>
  <GroupEditDialog ref="groupEditDialogRef" @reloadGroupInfo="getGroupInfo"></GroupEditDialog>
</template>
<script setup >
import GroupEditDialog from "./GroupEditDialog.vue"
import { ref, reactive, getCurrentInstance, nextTick, watch } from 'vue'
import { useRoute, useRouter } from 'vue-router'
const { proxy } = getCurrentInstance()
const route = useRoute()
const groupInfo = ref({})
const groupId = ref()

const getGroupInfo = async () => {
  let result = await proxy.Request({
    url: proxy.Api.getGroupInfo,
    params: {
      groupId: groupId.value
    }
  })
  if (!result) {
    return
  }
  groupInfo.value = result.data
}
const groupEditDialogRef = ref()
const editGroupInfo = ()=>{
groupEditDialogRef.value.show(groupInfo.value)
}

//退出群组
const leaveGroup = ()=>{
    proxy.Confirm({
        message:'确定要退出群组？',
        okfun:async()=>{
            contactStateStore.setContactReload(null)
            let result = await proxy.Request({
               url:proxy.Api.leaveGroup,
               params:{
                groupId:groupInfo.value.groupId
               }
            })
            if(!result){
              return;
            }
            proxy.Message.success('退出成功')
            //刷新群聊列表
            contactStateStore.setContactReload('LEAVE_GROUP')
        }
    })
}

//解散群组
const dissolutionGroup = ()=>{
    proxy.Confirm({
        message:'确定要删除群组？',
        okfun:async()=>{
            contactStateStore.setContactReload(null)
            let result = await proxy.Request({
               url:proxy.Api.dissolutionGroup,
               params:{
                groupId:groupInfo.value.groupId
               }
            })
            if(!result){
              return;
            }
            proxy.Message.success('解散成功')
            //刷新群聊列表
            contactStateStore.setContactReload('DISSSOLUTION_GROUP')
        }
    })
}
// 发送消息
const sendMessage  = ()=>{
    route.push({
        path:'/chat',
        query:{chatId:groupInfo.value.groupId,timestamp:new Date().getTime()}
    })
}
watch(() => route.query.contactId,(newVal,oldVal)=>{
    if(newVal){
        groupId.value = newVal
        getGroupInfo()
    }
},{immediate:true,deep:true})
</script>
<style scoped lang="scss">
.group-info-item {
  display: flex;
  margin: 15px 0px;
  align-items: center;
  .group-title {
    width: 100px;
    text-align: right;
  }
  .group-value {
    flex: 1;
  }
  .notice {
    align-items: flex-start;
  }
}
</style>