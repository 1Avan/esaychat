<template>
  <div class="image-panel" @click="showImageHandler">
    <el-image :src="serverUrl" fit="scale-down" :width="width"> </el-image>
  </div>
</template>
<script setup >
import { ref, reactive, getCurrentInstance, nextTick, computed ,defineProps} from 'vue'
const { proxy } = getCurrentInstance()
const props = defineProps({
  width: {
    type: Number,
    default: 170
  },
  showPlay: {
    type: Boolean,
    default: false
  },
  fileId: {
    type: [String,Number]
  },
  partType: {
    type: String,
    default: 'avatar'
  },
  fileType: {
    type: Number,
    default: 0
  },
  forceGet: {
    type: Boolean,
    default: false
  }
})

const serverUrl = computed(()=>{
    if(!props.fileId){
        return ''
    }
    return ""
    //TODO 获取本地服务的图片URL
})
</script>
<style scoped lang="scss">
.image-panel {
  position: relative;
  display: flex;
  overflow: hidden;
  cursor: pointer;
  max-width: 170px;
  max-height: 170px;
  background-color: #ddd;
  .icon-image-error {
    margin: 0px auto;
    font-size: 30px;
    color: #838383;
  }
  .play-panel {
    z-index: 2;
    position: absolute;
    top: 0px;
    left: 0px;
    width: 100%;
    height: 100%;
  }
}
</style>