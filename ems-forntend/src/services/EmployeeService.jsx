import axios from "axios";

const REST_API_URL="http://localhost:8083/employees";

//const REST_DELETE_URL="http://localhost:8083/employees/{id}"

export const listEmployees=() => axios.get(REST_API_URL);

export const createEmployee=(employee)=>axios.post(REST_API_URL,employee);

export const removeEmployee =(id) => axios.delete(REST_API_URL + '/' + id);