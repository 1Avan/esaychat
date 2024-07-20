import { add_index, add_tables } from './table'


const fs = require('fs')
const sqlite3 = require('sqlite3').verbose()
const os = require('os')
const NODE_ENV = process.env.NODE_ENV
const userDir  = os.homedir();
const dbFolder = userDir+(NODE_ENV==="development"?"/.easychattest":"/.easychat")
if(!fs.existsSync(dbFolder)){
    fs.mkdirSync(dbFolder)
}
const db = new sqlite3.Database(dbFolder+'local.db')
console.log(db);
//创建数据库表和索引
const createTable = ()=>{
    return new Promise(async (resolve,reject)=>{
        for(const item of add_tables){
            await db.run(item)
        }
        for(const item of add_index){
            await db.run(item)
        }
    })
    
}

const queryAll = (sql,params)=>{
    return new Promise((resolve,reject)=>{
        const stmt = db.prepare(sql)
        stmt.all(params,function(err,row){
            if(err){
                resolve([])
            }
            row.forEach((item,index)=>{
                
            })
        })
    })

}

export {
    createTable
}