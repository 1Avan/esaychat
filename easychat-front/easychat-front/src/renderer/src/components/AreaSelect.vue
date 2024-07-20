<template>
<div>
    <el-cascader
    :options="AreaData"
    v-model="modelValue.areaCode"
    @change="change"
    ref="areaSelectRef"
    clearable
    ></el-cascader>
</div>
</template>
<script setup >
import AreaData from './AreaData.js'
import { ref, reactive, getCurrentInstance, nextTick } from "vue"
import { useRoute, useRouter } from "vue-router";
const { proxy } = getCurrentInstance();
const route = useRoute()
const router = useRouter()

const props = defineProps({
    modelValue:{
        type:Object,
        default:{}
    }
})
const emit = defineEmits(['update:modelValue'])
const areaSelectRef = ref()
const change = (e)=>{
    console.log(e);
    const areaData = {
        areaName:[],
        areaCode:[]
    }
    const checkNodes = areaSelectRef.value.getCheckedNodes()[0]
    if(!checkNodes){
        emit('update:modelValue',areaData)
        return 
    }
    const pathValues = checkNodes.pathValues
    const pathLabels = checkNodes.pathLabels
    areaData.areaName = pathLabels
    areaData.areaCode = pathValues
    emit('update:modelValue',areaData)
}
</script>
<style scoped lang="scss">
</style>