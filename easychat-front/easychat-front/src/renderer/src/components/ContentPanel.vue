<template>
<div class="content-panel" :style="{'border-top':showTopBorder?'1px solid #ddd':'none'}">
    <div class="content-innel">
        <slot></slot>
    </div>
</div>
</template>
<script setup >
const props = defineProps({
    showTopBorder:{
        type:Boolean,
        default:false
    }
})
</script>
<style scoped lang="scss">
.content-panel {
    overflow: hidden;
    height: calc(100vh - 62px);
    .content-innel {
        margin: 0 auto;
        width: 400px;
    }
}
</style>