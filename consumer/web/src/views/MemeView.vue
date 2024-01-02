<template>
    <button @click="supprimer">Supprimer</button>
    <button @click="modifier(this.id)">Modifier</button>
    <h1>{{ meme.title }}</h1>
    <p style="color: #808080;"> {{ meme.tag }}</p>
    <img :src="meme.link" :alt="meme.title" >
    <p>{{ meme.description }}</p>
</template>
<script>
import MemeService from '@/service/MemeService'
export default {
    name: 'MemeView',
    data(){
        return {
            meme: {
                title: "",
                link: "",
                description: "",
                tag: ""
            }
        }
    },
    beforeMount(){
        this.id = this.$route.params.id;
        this.getMeme(this.id);
    },
    methods: {
        modifier(id){
            this.$router.push({name: 'update', params: {id}});
        },
        async getMeme(id){
            try{
                let response = await MemeService.getMeme(id);
                this.meme = response;
                //this.meme = response.data;
            }
            catch (error){
                console.log('Erreur');
            }
        },
        async supprimer(){
            alert("Suppression")
        }
    }
}
</script>
<style>
img{
    max-width: 600px;
    max-height: 400px;
    width: auto;
    height: auto;
}
</style>