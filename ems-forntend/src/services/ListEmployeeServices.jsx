import axios from "axios";

const REST_API_URL= "http://localhost:8083/employees";

export const listemployee= () =>  axios.get(REST_API_URL);
