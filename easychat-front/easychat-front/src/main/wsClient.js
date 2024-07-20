import WebSocket from "ws";
const NODE_ENV = process.env.NODE_ENV
import store from "./store"
let ws = null
let maxReConnectTimes = null    
let lockReconnect = false
let wsUrl =null
let sender = null
let needReconnect = null 
const initWs = (config,_sender)=>{
    wsUrl = `${NODE_ENV !== 'development'?store.getDate('prodWsDomain'):store.getDate('devWsDomain')}?token=${config.token}`
    sender = _sender
    needReconnect = true
    maxReConnectTimes = 5
    createWs()
}
const closeWs = ()=>{
    needReconnect = false
    ws.close()
}
const createWs = ()=>{
    if(wsUrl == null){
        return;
    }
    ws = new WebSocket(wsUrl)
    ws.onopen = function(){
        ws.send("heart beat")
        maxReConnectTimes = 5
    }
    //从服务器监听到信息的回调函数
    ws.onmessage = async function(e){
        console.log("收到服务器消息");
        // sender.send('reciveMessage',e.data)
    }
    ws.onclose = function(){
        console.log("关闭客户端连接");
    }
    ws.onerror = function(){
        console.log("连接失败准备重连");
        reconnect()
    }
    const reconnect = ()=>{
        if(!needReconnect){
            console.log("连接断开无需重连");
            return;
        }
        if(ws!=null){
            ws.close()
        }
        if(!lockReconnect){
            return 
        }
        lockReconnect = true
        if(maxReConnectTimes>0){
            console.log("准备重连,剩余重连次数"+maxReConnectTimes,new Date().getDate())
            maxReConnectTimes--
            setTimeout(() => {
                createWs()
                lockReconnect = false
            },5000);
        }else{
            console.log("连接超时");
        }

    }

    setInterval(()=>{
        if(ws!=null&&ws.readyState == 1){
            ws.send("heart beat")

        }
    },5000)

}

export {
    initWs,
    closeWs
}