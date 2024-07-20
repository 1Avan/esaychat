<template>
  <div>
    <el-form :model="formData" :rules="rules" ref="formDataRef" label-width="80px" @submit.prevent>
      <!--input输入-->
      <el-form-item label="输入密码" prop="password">
        <el-input
          type="password"
          clearable
          placeholder="请输入新密码"
          v-model.trim="formData.password"
          show-password
        ></el-input>
      </el-form-item>

      <el-form-item label="确认密码" prop="rePassword">
        <el-input
          type="password"
          clearable
          placeholder="请输入密码"
          v-model.trim="formData.rePassword"
          show-password
        ></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="savaUserInfo">修改密码</el-button>
        <el-button link @click="cancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script setup >
import { ref, reactive, getCurrentInstance, nextTick } from 'vue'
const { proxy } = getCurrentInstance()
const formDataRef = ref()
const props = defineProps({
  data: {
    type: Object
  }
})
const formData = ref({})
const validateRePass = (rule, value, callback) => {
  if (value !== formData.value.password) {
    callback(new Error(rule.message))
  } else {
    callback()
  }
}
const rules = {
  password: [
    { required: true, message: '请输入新密码' },
    { validator: proxy.Verify.password, message: '密码只能数字、字母、特殊字符8~18位' }
  ],
  rePassword: [
    { required: true, message: '请再次输入密码' },
    { rePassword: [{ validator: validateRePass, message: '两次输入密码不一致' }] }
  ]
}

const saveCover = ({ avatarFile, coverFile }) => {
  formData.value.avatarFile = avatarFile
  formData.value.coverFile = coverFile
}
const saveUserInfo = () => {
  formDataRef.value.validate(async (valid) => {
    if (!valid) {
      return
    }
    proxy.Confirm({
      message: '修改成功后需重新登录是否确认修改？',
      okfun: async () => {
        let params = {}
        Object.assign(params, formData.value)
        let result = await proxy.Request({
          url: proxy.Api.updatePassword,
          params: {}
        })
        if (!result) {
          return
        }
        proxy.Message.success('修改成功请重新登录', () => {
          //TODO 重新登录
          window.ipcRenderer.send('reLogin')
        })
        userInfoStore.setInfo(result.data)
        //TODO 强制刷新头像
        emit('editBack')
      }
    })
  })
}

const emit = defineEmits(['editBack'])
const cancel = () => {
  emit('editBack')
}
</script>
<style scoped lang="scss">
</style>