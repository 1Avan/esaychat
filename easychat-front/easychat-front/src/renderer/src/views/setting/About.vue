<template>
  <ContentPanel v-loading="copying" element-loading-text="正在复制文件">
    <div class="about">
    <div style="margin-bottom:32px">关于IvanChat&nbsp;&nbsp;&nbsp;&nbsp;版本信息：{{config.version}}</div>
    <el-button @click="checkUpdate">检查更新</el-button>
    </div>

  </ContentPanel>
</template>
<script setup >
import config from '../../../../../package.json'
import { ref, reactive, getCurrentInstance, nextTick } from "vue"
const { proxy } = getCurrentInstance();
import {useRoute,useRouter} from 'vue-router'
const route = useRoute();
const router = useRouter()
//TODO 检测更新
const checkUpdate = ()=>{}
</script>
<style scoped lang="scss">
.about {
  text-align: center;
}
</style>