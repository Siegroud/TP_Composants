<template>
    <h1>
        Poster un moi-moi
    </h1>
    <div>
        <div>
            <label> Titre: </label>
            <input type="text" v-model="meme.title">
        </div>
        <div>
            <label>Lien: </label>
            <input type="text" v-model="meme.link" v-bind:disabled="isInputDisabled">
        </div>
        <div>
            <label>Description: </label>
            <input type="text" v-model="meme.description">
        </div>
        <div>
            <label>Tag: </label>
            <input type="radio" id="one" value="CAT" v-model="meme.tag" />
            <label for="one">Cat</label>
            <input type="radio" id="two" value="DOG" v-model="meme.tag" />
            <label for="two">Dog</label>
            <input type="radio" id="three" value="MLG" v-model="meme.tag" />
            <label for="three">MLG</label>
            <input type="radio" id="four" value="TRENDING" v-model="meme.tag" />
            <label for="four">Trending</label>
            <input type="radio" id="five" value="DANK" v-model="meme.tag" />
            <label for="five">Dank</label>
        </div>
        <button @click="confirmer">Confirmer</button>
    </div>
</template>
<script>
import MemeService from '@/service/MemeService'
export default{
    name: 'NewMemeView',
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
        this.name = this.$route.name
        this.isInputDisabled = false;
        if (this.name === 'update'){
            this.id = this.$route.params.id;
            this.getMeme(this.id);
            this.isInputDisabled = true;
        }
    },
    methods: {
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
        async confirmer(){
            //TODO
            //Changer Update / delete en fonction du truc
            alert("Confirmation")
        }
    }
}
</script>