const regs = {
    email :/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
    number:/^\d+$/,
    password:/^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!])(.{8,18})$/,
    version:/^[0,9]\.]+$/

}
const verfiy = (value,rule,reg,callback)=>{
    if(value){
        if(reg.test(value)){
            callback()
        }else{
            callback(new Error(rule.message))
        }
    }else{
        callback()
    }
}

const checkPassword = (value)=>{
    return regs.password.test(value)
}
const checkEmail = (value)=>{
    return regs.email.test(value)
}


const password = (value,rule,callback)=>{
    return verfiy(rule,value,regs.password,callback)
}

const number = (value,rule,callback)=>{
    return verfiy(rule,value,regs.number,callback)
}

export default {
    checkPassword,
    checkEmail,
    password,
    number
}