class MemeService{
    getAllMeme(){
        return [
            {
                title: "Instalation Wizard",
                link: "https://i.imgur.com/qOetTi8.png",
                description: "Description",
                tag: "DANK",
                id: '1'
            },
            {
                title: "My Cat be Like",
                link: "https://i.imgur.com/6x9FlpB.jpeg",
                description: "Description",
                tag: "CAT",
                id: '2'
            },
            {
                title: "What ?",
                link: "https://i.imgur.com/yqqOG2E.jpeg",
                description: "Description",
                tag: "DANK",
                id: '3'
            },
        ]
    }
    getMeme(id){
        if (id === '1')
            return {
                title: "Instalation Wizard",
                link: "https://i.imgur.com/qOetTi8.png",
                description: "Description",
                tag: "DANK",
                id: '1'
            }
        if (id === '2')
            return {
                title: "My Cat be Like",
                link: "https://i.imgur.com/6x9FlpB.jpeg",
                description: "Description",
                tag: "CAT",
                id: '2'
            }
        if (id === '3')
            return {
                title: "What ?",
                link: "https://i.imgur.com/yqqOG2E.jpeg",
                description: "Description",
                tag: "DANK",
                id: '3'
            }
        return null;
    }
}

export default new MemeService();