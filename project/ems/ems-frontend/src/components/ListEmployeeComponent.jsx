import React, { useEffect, useState } from 'react'
import { listEmployees, deleteEmployee } from '../services/EmployeeService'
import { useNavigate } from 'react-router-dom'
import { Plus, Edit, Trash2, User } from 'lucide-react'
import toast from 'react-hot-toast'

const ListEmployeeComponent = () => {

    const [employees, setEmployees] = useState([])

    const navigator = useNavigate();

    useEffect(() => {
        getAllEmployees();
    }, [])

    function getAllEmployees() {
        listEmployees().then((response) => {
            setEmployees(response.data);
        }).catch(error => {
            console.error(error);
            toast.error("Failed to fetch employees");
        })
    }

    function addNewEmployee() {
        navigator('/add-employee')
    }

    function updateEmployee(id) {
        navigator(`/edit-employee/${id}`)
    }

    function removeEmployee(id) {
        if (window.confirm("Are you sure you want to delete this employee?")) {
            deleteEmployee(id).then((response) => {
                toast.success("Employee deleted successfully");
                getAllEmployees();
            }).catch(error => {
                console.error(error);
                toast.error("Error deleting employee");
            })
        }
    }

    return (
        <div className='container py-5'>
            <div className="d-flex justify-content-between align-items-center mb-4">
                <h2 className='text-primary fw-bold mb-0'>Employee List</h2>
                <button className='btn btn-primary d-flex align-items-center gap-2' onClick={addNewEmployee}>
                    <Plus size={18} /> Add Employee
                </button>
            </div>

            <div className="card border-0">
                <div className="table-responsive p-3">
                    <table className='table table-hover align-middle'>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Email</th>
                                <th className='text-center'>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                employees.length === 0 ? (
                                    <tr>
                                        <td colSpan="5" className="text-center py-5 text-muted">
                                            No employees found. Click "Add Employee" to get started.
                                        </td>
                                    </tr>
                                ) : (
                                    employees.map(employee =>
                                        <tr key={employee.id}>
                                            <td className='fw-semibold'>#{employee.id}</td>
                                            <td>{employee.firstName}</td>
                                            <td>{employee.lastName}</td>
                                            <td className='text-secondary'>{employee.email}</td>
                                            <td>
                                                <div className="d-flex justify-content-center gap-2">
                                                    <button className='btn btn-outline-info btn-sm rounded-pill px-3 shadow-none' onClick={() => updateEmployee(employee.id)}>
                                                        <Edit size={14} className="me-1" /> Update
                                                    </button>
                                                    <button className='btn btn-outline-danger btn-sm rounded-pill px-3 shadow-none' onClick={() => removeEmployee(employee.id)}>
                                                        <Trash2 size={14} className="me-1" /> Delete
                                                    </button>
                                                </div>
                                            </td>
                                        </tr>
                                    )
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    )
}

export default ListEmployeeComponent
