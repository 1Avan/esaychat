<template>
<div class="user-avatar" @click="showDetailHandler "
:style="{width:width+'px',height:width+'px','border-radius':borderRadius+'px'}"
>
    <ShowLocalImage :width="width" :fileId="userId" partType="avatar" :forceGet="true"></ShowLocalImage>
</div>
</template>
<script setup >
const props = defineProps({
  userId: {
    type: String,
  },
  width: {
    type: Number,
    default: 40
  },
  borderRadius: {
    type:Number,
    default:0
  },
  showDetail:{
    type:Boolean,
    default:false
  }
})
const showDetailHandler  = ()=>{
    if(props.showDetail){
        return;
    }
    //TODO 查看图片详情
}
</script>
<style scoped lang="scss">
.user-avatar {
    background: #d3d3d3;
    display: flex;
    overflow: hidden;
    cursor: pointer;
    align-items: center;
    justify-content: center;
}
</style>