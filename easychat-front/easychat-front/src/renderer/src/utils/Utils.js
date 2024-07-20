const isEmpty = (val) => {
    if (val == null || val == undefined || val == '') {
        return true
    }
    return false
}

const getAreaInfo = (data) => {
    if (isEmpty(data)) {
        return "-"
    }
    return data.replace(",", " ")

}

export default {
    isEmpty,
    getAreaInfo
}