import { ref } from "vue"
import Request from "@/utils/Request.js"
import Api from "@/utils/Api.js"

export const userInfo = () => {
    //获取验证码
    const checkCodeUrl = ref(null)
    // changeCheckCode()//函数表达式（Function Expression）定义的函数则不具有变量提升的特性
    const changeCheckCode = async () => {
        let result = await Request({
            url: Api.checkCode
        })
        if (!result) {
            return
        }
        checkCodeUrl.value = result.data.checkCode
        localStorage.setItem('checkCodeKey', result.data.checkCodeKey)
    }
    changeCheckCode()
    return {
        changeCheckCode,
        checkCodeUrl
    }
}