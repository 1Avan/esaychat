<template>
<div>
    <Dialog
      :show="dialogConfig.show"
      :title="dialogConfig.title"
      :buttons="dialogConfig.buttons"
      width="400px"
      :showCancel="false"
      @close="dialogConfig.show = false">
      <el-form
        :model="formData"
        :rules="rules"
        ref="formDataRef"
        @submit.prevent
      >
      <!--textarea输入-->
        <el-form-item label="" prop="">
          <el-input
            clearable
            placeholder="申请理由"
            type="textarea"
            :rows="5"
            :maxlength="150"
            resize="none"
            show-word-limit
            v-model.trim="formData.applyInfo"
        ></el-input>
        </el-form-item>
      </el-form>
    </Dialog>
</div>
</template>
<script setup >
import { ref, reactive, getCurrentInstance, nextTick } from "vue"
import {useUserInfoStore} from "@/stores/UserInfoStore.js"
const { proxy } = getCurrentInstance();
const userInfoStore = useUserInfoStore()

import {useContactStateStore} from '@/stores/ContactStateStore.js'
const contactStateStore = useContactStateStore()
const dialogConfig = ref({
  show: false,
  title: "提交申请",
  buttons: [
   {
    type: "primary",
    text: "确定",
    click: (e) => {
      submitForm();
    },
  },
 ],
});
const formData = ref({});
const formDataRef = ref();
const rules = {
  title: [{ required: true, message: "请输入内容" }],
};

const show = (data)=>{
    dialogConfig.value.show = true
    nextTick(()=>{
      formDataRef.value.resetFields();
      formData.value = Object.assign({},data)
      formData.value.applyInfo = `我是${userInfoStore.getInfo().nickName}`
    })
}

const emit = defineEmits(['reload'])
const submitForm = async (data)=>{
  console.log("我是提交方法")
  const {contactId,contactType,applyInfo} = formData.value
  let result = await proxy.Request({
     url:proxy.Api.applyAdd,
     params:{
      contactId,
      contactType,
      applyInfo
     }
  })
  if(!result){
    return;
  }
  //就是不需要审核
  if(result.data == 0){
    proxy.Message.success("加入成功")
    contactStateStore.contactReload(contactType)
  }else{
    proxy.Message.success("申请成功，等待对方同意")
  }
  dialogConfig.value.show = false
  emit("reload")
}
defineExpose({
    show
})
</script>
<style scoped lang="scss">
</style>