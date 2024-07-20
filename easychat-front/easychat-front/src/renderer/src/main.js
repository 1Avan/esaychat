import { createApp } from 'vue'
import App from './App.vue'
// 引入ElementPlus
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import '@/assets/cust-elementplus.scss'
import '@/assets/icon/iconfont.css'
import '@/assets/base.scss'
import * as Pinia from 'pinia'
import router from '@/router'

import Utils from '@/utils/Utils.js'

import Verify from "@/utils/Verify.js"

import Message from "@/utils/Message.js"

import Api from "@/utils/Api.js"
import Request from "@/utils/Request.js"

import Confirm from "@/utils/Confirm.js"

import Dialog from "@/components/Dialog.vue"
import WinOp from "@/components/WinOp.vue"
import Layout from "@/components/Layout.vue"
import ContentPanel from "@/components/ContentPanel.vue"
import ShowLocalImage from "@/components/ShowLocalImage.vue"
import AvatarUpload from "@/components/AvatarUpload.vue"
import Avatar from "@/components/Avatar.vue"




const app =  createApp(App)
app.use(Pinia.createPinia())
app.use(ElementPlus)
app.use(router)
app.component("Dialog",Dialog)
app.component("Layout",Layout)
app.component("WinOp",WinOp)
app.component("ContentPanel",ContentPanel)
app.component("ShowLocalImage",ShowLocalImage)
app.component("Avatar",Avatar)
app.component("AvatarUpload",AvatarUpload)
app.config.globalProperties.Utils = Utils   
app.config.globalProperties.Verify = Verify
app.config.globalProperties.Message = Message
app.config.globalProperties.Api = Api
app.config.globalProperties.Request = Request
app.config.globalProperties.Confirm = Confirm
app.mount('#app')