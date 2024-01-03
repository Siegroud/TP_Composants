import InstanceAxios from 'axios';
const url = 'http://localhost:'
const port = '8080'

const path = `${url}${port}/memes`

class MemeService{
    getAllMeme(){
        return InstanceAxios.get(path);
    }
    getMeme(id){
        return InstanceAxios.get(`${path}/${id}`);
    }
    postMeme(meme){
        return InstanceAxios.post(path, meme)
    }
    putMeme(id, meme){
        return InstanceAxios.put(`${path}/${id}`, meme)
    }
    deleteMeme(id){
        return InstanceAxios.delete(`${path}/${id}`);
    }
}

export default new MemeService();