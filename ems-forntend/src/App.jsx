
import './App.css'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListComponent from './components/ListComponent'
import EmployeeComponent from './components/EmployeeComponent'
import { BrowserRouter,Route,Routes } from 'react-router-dom'



function App() {

  return (
    <>
    <BrowserRouter>
      <HeaderComponent/>
      <Routes>
       { /*//http://localhost:8081*/}
        <Route path="/" element={<ListComponent/>}>
        </Route>
        {/* //http://localhost:8081/employees */}
        <Route path="/employees" element={<ListComponent/>}></Route>
  {/* //http://localhost:8081/add-employee */}
        <Route path="/add-employee" element={<EmployeeComponent/>}></Route>

        {/* //http://localhost:8081/employees/1 */}
        <Route path="/employees/:id" element={<EmployeeComponent/>}></Route>


      </Routes>
           <FooterComponent/>
    </BrowserRouter>
    </>
  )
}

export default App
EmployeeComponent