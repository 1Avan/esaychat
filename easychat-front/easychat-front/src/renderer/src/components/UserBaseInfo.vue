<template>
<div class="user-panel">
    <AvatarBase :userId="userInfo.userId || userInfo.contactId"
    :width="60"
    :borderRadius="5"
    :showDetail="true"
    ></AvatarBase>
    <div class="user-info">
        <div class="nick-name">
            {{userInfo.nickName}}
            <span v-if="userInfo.sex==0" class="iconfont icon-woman"></span>
            <span v-if="userInfo.sex==1" class="iconfont icon-man"></span>
        </div>

        <div class="info">ID:{{userInfo.userId || userInfo.contactId}}</div>
        <div class="info" v-if="showArea">地区：{{proxy.Utils.getAreaInfo(userInfo.areaName)}}</div>
    </div>
</div>
</template>
<script setup >
import AvatarBase from "@/components/AvatarBase.vue"
import { ref, reactive, getCurrentInstance, nextTick } from "vue"
const { proxy } = getCurrentInstance();

const props = defineProps({
    userInfo:{
        type: Object,
        default:{}
    },
    showArea:{
        type:Boolean,
        default:true
    }
})
</script>
<style scoped lang="scss">
.user-panel {
    display: flex;
    padding-bottom: 20px;
    .user-info {
        flex: 1;
        margin-left: 10px;
        .nick-name {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            

        }
    }
}
</style>