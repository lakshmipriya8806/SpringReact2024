import React from 'react'
import { useState } from 'react'
import { createEmployee } from '../services/EmployeeService'
import { useNavigate ,useParams} from 'react-router-dom'

const EmployeeComponent = () => {
    
    const[firstname,setFirstName]=useState('')
    const[lastname,setLastName]=useState('')
    const[email,setEmail]=useState('')

   const{id}= useParams();

   const[errors,setError] = useState({
        firstname:'',
        lastname:'',
        email:''
    })

    const navigator= useNavigate();


    function handleFirstName(e){
        setFirstName(e.target.value);  

    }

    
    function handleLastName(e){
        setLastName(e.target.value);  
    }

    
    function handleEmail(e){
        setEmail(e.target.value);  

    }

    function saveEmployee(e){
        e.preventDefault();

        if(validateForm()){

        const employee={firstname,lastname,email}
        console.log(employee)

        createEmployee(employee).then((response) => {
                console.log(response.data);
                navigator("/employees");
        })
        }
    }

    // function pageTitle(){
    //     if(id){
    //         return<h2 className='text-center'>Delete Employee</h2>
    //     }else{
    //         return<h2 className='text-center'>Add Employee</h2>
    //     }
    // }

        

        function validateForm(){
            let valid=true;
            const errorsCopy={... errors}

            if(firstname.trim()){
                errorsCopy.firstname='';
            }else{
                errorsCopy.firstname='First Name is required';
                valid=false;
            }

            if(lastname.trim()){
                errorsCopy.lastname='';
            }else{
                errorsCopy.lastname='Last Name is required';
                valid=false;
            }

            if(email.trim()){
                errorsCopy.email='';
            }else{
                errorsCopy.email='Email is required';
                valid=false;
            }

            setError(errorsCopy);
            return valid;
        }
    

  return (
    <div className='container'>
        <div className='row'>
            <div className='card col-md-12'>
                <h2 className='text-center'>Add Employee</h2>
                <div className='card-body'>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'> First Name:</label>
                            <input
                            type="text"
                            placeholder="Enter Employee FirstName"
                            name='firstname'
                            value={firstname}
                            className={'form-control'}
                            onChange={handleFirstName}
                                >
                                </input>                           
                
                        </div>
                        <div className='form-group mb-2'>
                            <label className='form-label'> Last Name:</label>
                            <input
                            type="text"
                            placeholder="Enter Employee LastName"
                            name='lastname'
                            value={lastname}
                            className='form-control'
                            onChange={handleLastName}
                                >
                                </input>                           
                
                        </div>
                        <div className='form-group mb-2'>
                            <label className='form-label'> Email:</label>
                            <input
                            type="text"
                            placeholder="Enter Employee Email"
                            name='email'
                            value={email}
                            className='form-control'
                            onChange={handleEmail}
                                >
                                </input>                           
                
                        </div>

                        <button className='btn btn-success' onClick={saveEmployee}> Submit</button>
                    </form>
                </div>
            </div>
        </div>

    </div>
  )
}


export default EmployeeComponent