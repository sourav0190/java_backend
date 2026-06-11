import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import HeaderComponent from './components/HeaderComponent'
import FooterComponent from './components/FooterComponent'
import EmployeeComponent from './components/EmployeeComponent'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import { Toaster } from 'react-hot-toast'

function App() {

  return (
    <>
      <BrowserRouter>
        <Toaster position="top-right" />
        <HeaderComponent />
        <main className="flex-grow-1">
          <Routes>
            {/* // http://localhost:5173 */}
            <Route path='/' element={<ListEmployeeComponent />}></Route>
            {/* // http://localhost:5173/employees */}
            <Route path='/employees' element={<ListEmployeeComponent />}></Route>
            {/* // http://localhost:5173/add-employee */}
            <Route path='/add-employee' element={<EmployeeComponent />}></Route>
            {/* // http://localhost:5173/edit-employee/1 */}
            <Route path='/edit-employee/:id' element={<EmployeeComponent />}></Route>
          </Routes>
        </main>
        <FooterComponent />
      </BrowserRouter>
    </>
  )
}

export default App
