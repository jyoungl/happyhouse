import { apiInstance } from "./index.js";

const api = apiInstance();
// const house = houseInstance();

function sidoList(success, fail) {
  api.get(`sido`).then(success).catch(fail);
}

function gugunList(params, success, fail) {
  api.get(`gugun`, { params: params }).then(success).catch(fail);
}

function dongList(params, success, fail) {
  api.get(`dong`, { params: params }).then(success).catch(fail);
}

function houseList(params, success, fail) {
  api.get(`apt`, { params: params }).then(success).catch(fail);
}

function houseListByYear(params, success, fail) {
  api.get(`aptByDate`, { params: params }).then(success).catch(fail);
}

export { sidoList, gugunList, houseList, dongList, houseListByYear };
