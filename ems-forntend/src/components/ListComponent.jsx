import React,{useState,useEffect} from 'react'
import { listemployee } from '../services/ListEmployeeServices'
import { useNavigate } from 'react-router-dom'
import { removeEmployee } from '../services/EmployeeService'

function ListComponent(){
    const[employees,setEmployees]=useState([])

    const navigator=useNavigate();

    useEffect(() =>{

        getAllEmployees();
    },[])

    function getAllEmployees(){

        
        listemployee().then((response)=>{
            setEmployees(response.data);
        }).catch(error =>{

        })
    }

    function addNewEmployee(){
        navigator("/add-employee")
    }

    function deleteEmployee(id){

        console.log(id);
        removeEmployee(id).then((response) =>{
            getAllEmployees();
        }).catch(error =>{
            console.error(error);
        })
    }
   



  return (

    <div className='container'>
        <h2 className='text-center'>List of Employees</h2>
        <button className='btn btn-primary mb-3' onClick= {addNewEmployee}>Add Employee</button>
        <table className='table table-striped table-bordered' >
            <thead>
                <tr>
                    <th>Employee Id</th>
                    <th>Employee FirstName</th>
                    <th>Employee LastName</th>
                    <th>Employee Email</th>
                    <th>Actions</th>
                </tr>
            </thead>

            <tbody>
                {
                employees.map(employee =>
                 <tr key={employee.id}>
                    <td>{employee.id}</td>
                    <td>{employee.firstname}</td>
                    <td>{employee.lastname}</td>
                    <td>{employee.email}</td>
                    <td>
                        <button className='btn btn-info' onClick={() => deleteEmployee(employee.id)}>Delete</button>

                    </td>

                 </tr>)
}
            </tbody>
        </table>

    </div>
  )
}

export default ListComponent