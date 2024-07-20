<template>
<Dialog
  :show="dialogConfig.show"
  :title="dialogConfig.title"
  :buttons="dialogConfig.buttons"
  width="400px"
  :showCancel="false"
  @close="dialogConfig.show = false">
  <GroupEidtForm ref="groupEidtRef" @editBack="editBack">
</Dialog>
</template>
<script setup >
import GroupEidtForm from './GroupEidtForm.vue'
import { ref, reactive, getCurrentInstance, nextTick } from "vue"
import { useRoute, useRouter } from 'vue-router';
const route = useRoute()
const router = useRouter()
const { proxy } = getCurrentInstance();
 const dialogConfig = reactive({
  show: false,
  title: "修改群组",
  buttons: [],
});
const groupEidtRef = ref()
const show = (data)=>{
    dialogConfig.value.show = true
    nextTick(()=>{
        groupEidtRef.value.show(data)
    })
}

const emit = defineEmits(['reloadGroupInfo'])
const editBack = ()=>{
    dialogConfig.value.show=false
    emit("reloadGroupInfo")
} 
defineExpose({
    show
})
</script>
<style scoped lang="scss">
</style>