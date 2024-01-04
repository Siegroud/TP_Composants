<template>
<div>
  <div v-if="emptyList">
    <h1>No memes ?</h1>
  </div>
  <div v-else v-for="meme in listMeme" :key="meme.id" @click="goMeme(meme.id)" class="hover-div">
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
          //this.listMeme = response;
          this.listMeme = response.data.memes;
          if (this.listMeme.length == 0){
            this.emptyList = true;
          } else {
            this.emptyList = false;
          }
          console.log(this.listMeme.memes);
      }
      catch(error){
          console.log(error);
      }
  },
  goMeme(id){
      this.$router.push({name: 'memeView', params: {id}});
  },
}
}
</script>
<style>
.hover-div {
  padding: 20px;
  background-color: #f0f0f0;
  border: 1px solid #ccc;
  cursor: pointer;
  transition: background-color 0.3s ease-in-out;
}

.hover-div:hover {
  background-color: #d3d3d3;
}
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
