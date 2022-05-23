import { loadBoard } from "@/api/board.js";

const boardStore = {
    namespaced: true,
    actions: {
        reloadBoard(articles) {
            loadBoard(articles,
                (response) => {
                    if (response.data === "success") {
                        articles = response.articles;
                    } else {
                        console.log("불러오기 오류");
                    }
                },
                () => {
                    console.log("error");
                },
            );
        },
    },
};

export default boardStore;