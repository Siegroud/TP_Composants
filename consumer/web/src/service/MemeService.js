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
}

export default new MemeService();