import { apiInstance } from ".";

async function loadBoard(articles, success, fail) {
    await apiInstance.get(`/board`).then(success).catch(fail);
}