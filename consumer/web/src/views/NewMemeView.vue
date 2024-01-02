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
            <input type="text" v-model="meme.lien">
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
    methods: {
        async confirmer(){
            alert("Confirmation")
        }
    }
}
</script>