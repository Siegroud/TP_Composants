<template>
  <nav>
    <router-link to="/new">Créer</router-link> |
    <router-link to="/about">About</router-link>
  </nav>
  <div>
    <div v-for="meme in listMeme">
      <h3>{{ meme.title }}</h3>
      <p style="color: #808080;"> {{ meme.tag }}</p>
      <img :src="meme.link" :alt="meme.title" >
      <div class="line-container">
        <hr>
      </div>
    </div>
  </div>
</template>
<script>
import MemeService from '@/service/MemeService'
export default{
  name: 'App',
  data(){
    return {
      listMeme: []
    }
  },
  beforeMount(){
    this.getMemeList();
  },
  methods: {
    async getMemeList(){
        try{
            let response = await MemeService.getAllMeme();
            this.listMeme = response;
            //this.listMeme = response.data;
        }
        catch(error){
            console.log(error);
        }
    },
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
hr {
  width: 600px;
  border: 1px solid #000000; /* Optional: Set border color for better visibility */
  margin: 20px 0; /* Optional: Add margin for spacing */
}
.line-container {
      display: flex;
      justify-content: center;
      align-items: center;
    }
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
