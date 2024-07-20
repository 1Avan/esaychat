<template>
  <el-form :model="formData" :rules="rules" ref="formDataRef" label-width="80px" @submit.prevent>
    <!--input输入-->
    <el-form-item label="群名称" prop="groupName">
      <el-input clearable placeholder="请输入群名称" v-model="formData.groupName"></el-input>
    </el-form-item>
    <!--input输入-->
    <el-form-item label="封面" prop="avatarFile">
      <AvatarUpload v-model="formData.avatarFile" ref="avatarUploadRef" @coverFile="savaCover">
      </AvatarUpload>
    </el-form-item>
    <!-- 单选 -->
    <el-form-item label="加入权限" prop="joinType">
      <el-radio-group v-model="formData.joinType">
        <el-radio :label="1">管理员同意后加入</el-radio>
        <el-radio :label="0">直接加入</el-radio>
      </el-radio-group>
    </el-form-item>

    <!--input输入-->
    <el-form-item label="公告" prop="groupNotice">
      <el-input
        clearable
        placeholder="请输入群公告"
        v-model="formData.groupNotice"
        type="textarea"
        rows="5"
        maxlength="300"
        :show-word-limit="true"
        resize="none"
      ></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submit"
        >{{ formData.groupId ? '修改群组' : '创建群组' }}
      </el-button>
    </el-form-item>
  </el-form>
</template>
<script setup >
import { ref, reactive, getCurrentInstance, nextTick } from 'vue'
const { proxy } = getCurrentInstance()
import { useContactStateStore } from '@/stores/ContactStateStore.js'
const contactStateStore = useContactStateStore()

import AvatarUpload from '@/components/AvatarUpload.vue'

const formData = ref({})
const formDataRef = ref()
const rules = {
  avatarFile: [{ required: true, message: '请选择头像' }],
  groupName: [{ required: true, message: '请输入群名称' }],
  joinType: [{ required: true, message: '请选择加入权限' }]
}

const emit = defineEmits(['editBack'])
const submit = async () => {
  formDataRef.value.validate(async (valid) => {
    if (!valid) {
      return
    }
    let params = {}
    //TODO  重新加载头像
    Object.assign(params, formData.value)
    let result = await proxy.Request({
      url: proxy.Api.savaGroup,
      params
    })
    if (!result) {
      return
    }
    if (params.groupId) {
      proxy.Message.success('群组修改成功')
      emit('editBack')
    } else {
      proxy.Message.success('群组创建成功')
    }
    formDataRef.value.resetFields()
    contactStateStore.setContactReload('MY')
    //TODO 重新加载头像
  })
}

const show = (data) => {
  formDataRef.value.resetFields()
  formData.value = Object.assign({}, data)
  formData.value.avatarFile = data.groupId
}
defineExpose({
  show
})
</script>
<style scoped lang="scss">
</style>